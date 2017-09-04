import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
//        forView view = new View();
//        fxmlLoader.setController(view);
//        root = fxmlLoader.load();
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    Parent getRootNode() throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
