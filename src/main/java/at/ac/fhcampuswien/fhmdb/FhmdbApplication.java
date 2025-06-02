package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.controllers.ControllerFactory;
import at.ac.fhcampuswien.fhmdb.enums.UIComponent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class FhmdbApplication extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource("/fxml/home.fxml"));
            fxmlLoader.setControllerFactory(new ControllerFactory());
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root, 890, 620);
            scene.getStylesheets().add(
                    Objects.requireNonNull(FhmdbApplication.class.getResource("/styles/styles.css")).toExternalForm()
            );

            stage.setTitle("FHMDb!");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.err.println("Cannot load scene from /fxml/home.fxml");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();  // Starte JavaFX-Anwendung
    }
}
