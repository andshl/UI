package myPackage.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tables {
    private ObservableList<Table> tableObservableList = FXCollections.observableArrayList();

    public void addTable(Table table) {
        tableObservableList.add(table);
    }

    public ObservableList<Table> getTableObservableList() {
        return this.tableObservableList;
    }
}
