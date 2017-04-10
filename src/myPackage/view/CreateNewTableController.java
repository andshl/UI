package myPackage.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import myPackage.Main;
import myPackage.model.SceneBuilder;
import myPackage.model.Table;

public class CreateNewTableController {
    @FXML
    private TextArea textArea;

    @FXML
    private void initialize() {
        textArea.setText("");
    }

    @FXML
    private void handleCreateTable() {
        String text = textArea.getText();

        if (!"".equals(text)) {

        TableListController tableListController = new TableListController();
        tableListController.getTables().addTable(new Table(text));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Table created");
        alert.setContentText("The table " + text + " was successfully created!");
        alert.showAndWait();

        Main.showNextScene(0);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No text");
            alert.setHeaderText("No text");
            alert.setContentText("Please set the name of the table.");
            alert.showAndWait();
        }


    }

    @FXML
    private void handleBack() {
        //TODO add refreshing
        SceneBuilder.getScene(0);
        Main.showNextScene(0);
    }


}
