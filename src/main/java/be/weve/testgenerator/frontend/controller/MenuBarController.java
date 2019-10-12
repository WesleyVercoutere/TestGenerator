package be.weve.testgenerator.frontend.controller;

import be.weve.testgenerator.config.Icons;
import be.weve.testgenerator.frontend.RootLayout;
import be.weve.testgenerator.service.dto.DomainClassDto;
import be.weve.testgenerator.service.manager.DomainClassManager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuBarController {

    private RootLayout root;

    private double xOffset;
    private double yOffset;

    private Image image;
    private Image imageLarge;
    private Image imageRestore;

    private FileChooser chooser;

    //Spring beans
    private DomainClassManager domainClassManager;

    @FXML
    HBox menuPane;

    @FXML
    ImageView btnMaximize;

    //Constructor for DI from Spring
    public MenuBarController(RootLayout rootLayout,
                             DomainClassManager domainClassManager) {
        this.root = rootLayout;
        this.domainClassManager = domainClassManager;

        init();
    }

    private void init() {
        imageLarge = new Image(Icons.ICON_MAXIMIZE_SCREEN);
        imageRestore = new Image(Icons.ICON_RESTORE_SCREEN);
    }

    @FXML
    private void initialize() {
        setupChooser();
        moveScreen();
        setMaximizeButtonImage(root.getStage().isMaximized());

        // Set listener to screen maximized property to change image on button
        root.getStage().maximizedProperty().addListener((observable, oldValue, newValue) -> setMaximizeButtonImage(newValue));
    }

    @FXML
    private void openFiles() {
        List<File> files = chooser.showOpenMultipleDialog(root.getStage());

        if (files != null) {
            List<DomainClassDto> dtos = files.stream().map(this::mapFile).collect(Collectors.toList());
            domainClassManager.openFiles(dtos);
        }
    }

    @FXML
    private void createTestFiles() throws ClassNotFoundException {
        domainClassManager.createTests();
    }

    @FXML
    private void onMinimizeButtonClicked() {
        root.minimize();
    }

    @FXML
    private void onMaximizeButtonClicked() {
        root.maximize();
    }

    @FXML
    private void onCloseButtonClicked() {
        root.close();
    }

    private void moveScreen() {
        xOffset = 0;
        xOffset = 0;

        menuPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = root.getStage().getX() - event.getScreenX();
                yOffset = root.getStage().getY() - event.getScreenY();
            }
        });

        menuPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.getStage().setX(event.getScreenX() + xOffset);
                root.getStage().setY(event.getScreenY() + yOffset);
            }
        });
    }

    private void setMaximizeButtonImage(boolean max) {
        if (max) {
            image = imageRestore;
        } else {
            image = imageLarge;
        }

        btnMaximize.setImage(image);
    }

    private void setupChooser() {
        chooser = new FileChooser();
        chooser.setTitle("Open domain classes");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JAVA", "*.java"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
    }

    private DomainClassDto mapFile(File file) {
        DomainClassDto dto = new DomainClassDto();
        dto.setPath(file.getPath());
        dto.setFileName(file.getName());

        return dto;
    }
}
