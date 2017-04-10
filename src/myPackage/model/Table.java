package myPackage.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Table {
    private StringProperty name;

    public Table(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public StringProperty getName() {
        return this.name;
    }
}
