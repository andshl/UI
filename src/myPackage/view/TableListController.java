package myPackage.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import myPackage.Main;
import myPackage.model.Table;
import myPackage.model.Tables;

import java.io.IOException;

public class TableListController {
    private Tables tables = new Tables();

    @FXML
    private TableView<Table> tableView;

    @FXML
    private TableColumn<Table, String> tableColumn;

    @FXML
    private void initialize() {
        try {
            init();
            tableColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
            tableView.setItems(tables.getTableObservableList());
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private int selectedIndex() {
        return tableView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void handleOpenTable() {
        if (selectedIndex() >= 0) {
            //...
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No selected items!");
            alert.setContentText("Please, select an item.");
            alert.showAndWait();
        }

    }

    @FXML
    public void handleCreateNewTable() throws IOException {
        Main.showNextScene(1);

    }

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    private void init() {
        tables.addTable(new Table("First table"));
        tables.addTable(new Table("Second table"));
        tables.addTable(new Table("Third table"));
    }

}
