package myPackage.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import myPackage.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneBuilder {
    public static Integer currentScene = 0;

    private static List<Scene> scenes;

    public SceneBuilder() {
        scenes = new ArrayList<>();
    }
    private void addScene(String path) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(path));
            scenes.add(new Scene(loader.load()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Scene getScene(Integer index) {
        return scenes.get(index);
    }

    public void initialize() throws IOException {
        addScene("view/TableList.fxml");
        addScene("view/CreateNewTable.fxml");

    }

}
