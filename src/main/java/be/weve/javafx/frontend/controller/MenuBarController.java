package be.weve.javafx.frontend.controller;

import be.weve.javafx.frontend.RootLayout;
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
}
