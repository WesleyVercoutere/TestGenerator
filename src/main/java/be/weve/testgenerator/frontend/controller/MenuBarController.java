package be.weve.testgenerator.frontend.controller;

import be.weve.testgenerator.frontend.RootLayout;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

@Component
public class MenuBarController {

    RootLayout root;

    public MenuBarController(RootLayout rootLayout) {
        this.root = rootLayout;
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
    private void onCloseButton() {
        root.close();
    }
}
