package be.weve.testgenerator.frontend.controller;

import be.weve.testgenerator.frontend.RootLayout;
import be.weve.testgenerator.service.manager.DomainClassManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Controller
public class FileListController implements PropertyChangeListener {

    @FXML
    private Pane pane;

    private RootLayout rootLayout;
    private DomainClassManager manager;

    public FileListController(RootLayout rootLayout, DomainClassManager domainClassManager) {
        this.rootLayout = rootLayout;
        this.manager = domainClassManager;

        init();
    }

    private void init() {
        manager.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("addList")) {
            clearPane();
            updateList();
        }
    }

    private void clearPane() {
        pane.getChildren().clear();
    }

    private void updateList() {

        for (int i = 0; i < 5; i++) {
            pane.getChildren().add(new Label("Ok"));
        }

    }
}
