package be.weve.javafx.frontend.loader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomFXMLLoader {

    ApplicationContext context;

    public CustomFXMLLoader(ApplicationContext context) {
        this.context = context;
    }

    public Parent loadView(String path) {

        Parent pane = null;

        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean);
        loader.setLocation(getClass().getClassLoader().getResource(path));

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pane;

    }
}
