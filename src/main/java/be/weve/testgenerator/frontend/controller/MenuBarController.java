package be.weve.testgenerator.frontend.controller;

import be.weve.testgenerator.config.Icons;
import be.weve.testgenerator.frontend.RootLayout;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import org.springframework.stereotype.Component;

@Component
public class MenuBarController {

    private RootLayout root;

    private double xOffset;
    private double yOffset;

    private Image image;
    private Image imageLarge;
    private Image imageRestore;

    private FileChooser chooser;

    @FXML
    HBox menuPane;

    @FXML
    ImageView btnMaximize;

    //Constructor for DI from Spring
    public MenuBarController(RootLayout rootLayout) {
        this.root = rootLayout;

        init();
    }

    private void init() {
        imageLarge = new Image(Icons.ICON_MAXIMIZE_SCREEN);
        imageRestore = new Image(Icons.ICON_RESTORE_SCREEN);
    }

    @FXML
    private void initialize() {
        moveScreen();
        setMaximizeButtonImage(root.getStage().isMaximized());

        // Set listener to screen maximized property to change image on button
        root.getStage().maximizedProperty().addListener((observable, oldValue, newValue) -> setMaximizeButtonImage(newValue));
    }

    @FXML
    private void openFiles() {
        chooser = new FileChooser();

        chooser.showOpenDialog(root.getStage());
    }

    @FXML
    private void openPage2() {
        //root.showPage2();
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
}
