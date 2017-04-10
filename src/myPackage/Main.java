package myPackage;

import javafx.application.Application;
import javafx.stage.Stage;
import myPackage.model.SceneBuilder;

import java.io.IOException;

public class Main extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("SuperDataBaseApp");

        SceneBuilder sceneBuilder = new SceneBuilder();
        sceneBuilder.initialize();

        showNextScene(0);
    }

    //view/CreateNewTable.fxml
    //view/TableList.fxml

    public static void showNextScene(Integer index) {
        primaryStage.setScene(SceneBuilder.getScene(index));
        primaryStage.show();
    }

}
