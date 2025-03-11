package com.example.bookstoreapplication.overview;

import com.example.bookstoreapplication.model.Book;
import com.example.bookstoreapplication.model.BooksStorage;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;

public class OverviewTableView extends TableView {
    public OverviewTableView(ObservableList<Book> obsList) {
        super(obsList);
        init();
    }

    private void init() {
        TableColumn<String, Book> title = new TableColumn<>("Title");
        title.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<String, Book> author = new TableColumn<>("Author");
        author.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Double, Book> price = new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        this.getColumns().addAll(title, author, price);
    }
}
