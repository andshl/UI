package myPackage.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import myPackage.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneBuilder {
    public static Integer currentScene = 0;

    private static List<Scene> scenes;
    private static List<Object> controllers;

    public SceneBuilder() {
        scenes = new ArrayList<>();
        controllers = new ArrayList<>();
    }

    private void addScene(String path) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(path));
            Parent root = loader.load();
            Object object = loader.getController();
            controllers.add(object);
            scenes.add(new Scene(root));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Scene getScene(Integer index) {
        return scenes.get(index);
    }

    public static Object getController(Integer index) {
        return controllers.get(index);
    }

    //В методе должны быть добавлены в общий список все сцены в нашей программе
    public void initialize() throws IOException {
        addScene("view/TableList.fxml");
        addScene("view/CreateNewTable.fxml");

    }

}
