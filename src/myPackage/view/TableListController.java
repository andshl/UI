package myPackage.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import myPackage.Main;
import myPackage.model.SceneBuilder;
import myPackage.model.Table;
import myPackage.model.Tables;

import java.io.IOException;

/**
 * Класс-контроллер для вывода списка таблиц выбранной базы.
 */
public class TableListController {
    private Tables tables = new Tables();
    private TableListController child;
    private TableListController parent;


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
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private int selectedIndex() {
        return tableView.getSelectionModel().getSelectedIndex();
    }

    //Обработчик нажатия кнопки Open
    @FXML
    private void handleOpenTable() {
        if (selectedIndex() >= 0) {
            //Переход на сцену, где отображается выбранная таблица
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No selected items!");
            alert.setContentText("Please, select the item.");
            alert.showAndWait();
        }

    }

    //Обработчик нажатия кнопки New Table
    @FXML
    public void handleCreateNewTable() throws IOException {
        CreateNewTableController child = (CreateNewTableController) SceneBuilder.getController(1);
        child.setParent(this);
        Main.showNextScene(1);

    }

    Tables getTables() {
        return tables;
    }

    //В этом методе мы будем делать запрос, получать список таблиц и добавлять их к нашему списку таблиц
    private void init() {
        tables.addTable(new Table("First table"));
        tables.addTable(new Table("Second table"));
        tables.addTable(new Table("Third table"));
    }

}
