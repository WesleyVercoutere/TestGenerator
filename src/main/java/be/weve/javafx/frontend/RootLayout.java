package be.weve.javafx.frontend;

import be.weve.javafx.frontend.loader.CustomFXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class RootLayout {

    private Stage stage;
    private BorderPane layout;
    private CustomFXMLLoader loader;

    public RootLayout(CustomFXMLLoader customFXMLLoader) {
        this.loader = customFXMLLoader;
    }

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public void init() {
        createPrimaryStage();
        createRootLayout();
        createMenuBar();
        showStart();
    }

    private void createPrimaryStage() {
        stage.setTitle("Test generator");
        stage.setMaximized(true);
    }

    private void createRootLayout() {
        layout = new BorderPane();
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    private void createMenuBar() {
        layout.setTop(loader.loadView("FXML/MenuBar.fxml"));
    }

    public void showStart() {
        Pane pane = new Pane();
        Label label = new Label("Start");
        pane.getChildren().add(label);
        layout.setCenter(pane);
    }

    public void showPage2() {
        Pane pane = new Pane();
        Label label = new Label("Page 2");
        pane.getChildren().add(label);
        layout.setCenter(pane);
    }

}
