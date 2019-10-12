package be.weve.testgenerator.frontend;

import be.weve.testgenerator.frontend.loader.CustomFXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;

@Component
public class RootLayout {

    private Stage stage;
    private BorderPane layout;
    private Scene scene;

    //Spring dependencies
    private CustomFXMLLoader loader;

    //Constructor for Spring di
    public RootLayout(CustomFXMLLoader customFXMLLoader) {
        this.loader = customFXMLLoader;
    }


    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public Stage getStage() {
        return this.stage;
    }

    public void init() {
        createPrimaryStage();
        createRootLayout();
        createMenuBar();
        createFooter();
    }

    private void createPrimaryStage() {
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Test generator");
        setSize();
    }

    private void setSize() {
        if (!stage.isMaximized()) {
            stage.setWidth(800);
            stage.setHeight(500);
        }
    }

    private void createRootLayout() {
        layout = new BorderPane();
        layout.getStyleClass().clear();
        layout.getStyleClass().add("borderPane");

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("css/app.css");

        stage.setScene(scene);
        stage.show();
    }


    //Show header and footer
    private void createMenuBar() {
        layout.setTop(loader.loadView("FXML/MenuBar.fxml"));
    }

    private void createFooter() {
        layout.setBottom(loader.loadView("FXML/Footer.fxml"));
    }


    //Main window methods
    public void minimize() {
        stage.setIconified(true);
    }

    public void maximize() {
        stage.setMaximized(!stage.isMaximized());
        setSize();
    }

    public void close() {
        stage.close();
    }


    //Show different windows in layout

}
