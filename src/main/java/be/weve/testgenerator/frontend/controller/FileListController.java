package be.weve.testgenerator.frontend.controller;

import be.weve.testgenerator.frontend.RootLayout;
import be.weve.testgenerator.service.dto.DomainClassDto;
import be.weve.testgenerator.service.manager.DomainClassManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

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
            updateView();
        }
    }

    private void clearPane() {
        pane.getChildren().clear();
    }

    private void updateView() {
        List<DomainClassDto> dtos = manager.getAll();
        dtos.forEach(e -> pane.getChildren().add(new Label(e.getFileName())));
    }
}
