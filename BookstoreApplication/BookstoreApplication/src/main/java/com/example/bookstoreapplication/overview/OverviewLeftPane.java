package com.example.bookstoreapplication.overview;

import com.example.bookstoreapplication.BookstoreEvent;
import com.example.bookstoreapplication.model.Book;
import com.example.bookstoreapplication.model.BooksStorage;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class OverviewLeftPane extends VBox {

    // Properties
    private Button buttonCreateBook = null;
    private Button buttonDeleteBook = null;
    private OverviewTableView overviewTableView;

    // Constructors
    public OverviewLeftPane(OverviewTableView overviewTableView) {
        this.overviewTableView = overviewTableView;
        initS();
    }

    // Private methods
    private void initS() {
        this.setSpacing(10);
        this.setPadding(new Insets(5));
        getChildren().add(getButtonCreateBook());
        getChildren().add(getButtonDeleteBook());

    }

    // Public methods
    public Button getButtonCreateBook() {
        if (buttonCreateBook == null) {
            buttonCreateBook = new Button("Create book");
            buttonCreateBook.setOnAction((e) -> {
                fireEvent(new BookstoreEvent(BookstoreEvent.createScene));
            });
        }
        return buttonCreateBook;
    }

    public Button getButtonDeleteBook() {
        if (buttonDeleteBook == null) {
            buttonDeleteBook = new Button("Delete book");
            buttonDeleteBook.setOnAction((e) -> {
                Book selectedBook = (Book) overviewTableView.getSelectionModel().getSelectedItem();

                if (selectedBook == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Book is not selected.");
                    alert.showAndWait();
                    return;
                }

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete book");
                alert.setContentText("Are you sure you want to delete this book?");
                alert.setHeaderText(selectedBook.getTitle());

                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.OK) {
                    BooksStorage.INSTANCE.deleteBook(selectedBook);
                    overviewTableView.setItems(BooksStorage.INSTANCE.observableListOfBooks());
                }
            });
        }

        return buttonDeleteBook;
    }
}
