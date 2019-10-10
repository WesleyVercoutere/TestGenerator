package be.weve.testgenerator.frontend.controller;

import be.weve.testgenerator.frontend.RootLayout;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Component;

@Component
public class MenuBarController {

    private RootLayout root;

    private double xOffset;
    private double yOffset;

    @FXML
    HBox menuPane;

    @FXML
    Image btnMaximize;

    //Constructor for DI from Spring
    public MenuBarController(RootLayout rootLayout) {
        this.root = rootLayout;
    }

    @FXML
    private void initialize() {
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

    @FXML
    private void openHomePage() {
        root.showStart();
    }

    @FXML
    private void openPage2() {
        root.showPage2();
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

}
