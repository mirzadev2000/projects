package com.example.bookstoreapplication.create;

import com.example.bookstoreapplication.model.Book;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class CreateInputPane extends GridPane {
    private Text textTile;
    private TextField title;
    private Text textAuthor;
    private TextField author;
    private Text textPrice;
    private TextField price;


    public CreateInputPane(){
        init();
    }
    private void init() {
        getChildren().addAll(getTextTile(), getTitle(),
                getTextAuthor(), getAuthor(),
                getTextPrice(), getPrice());

        ColumnConstraints constraints1 = new ColumnConstraints(300);
        ColumnConstraints constraints2 = new ColumnConstraints(300);

        constraints2.setHgrow(Priority.ALWAYS);

        getColumnConstraints().addAll(constraints1, constraints2);

        int row = 0;
        int column = 0;

        setRowIndex(getTextTile(), row);
        setRowIndex(getTitle(), row++);
        setColumnIndex(getTextTile(), column++);
        setColumnIndex(getTitle(), column);
        column = 0;
        setRowIndex(getTextAuthor(), row);
        setRowIndex(getAuthor(), row++);
        setColumnIndex(getTextAuthor(), column++);
        setColumnIndex(getAuthor(), column);
        column = 0;
        setRowIndex(getTextPrice(), row);
        setRowIndex(getPrice(), row++);
        setColumnIndex(getTextPrice(), column++);
        setColumnIndex(getPrice(), column);
    }

    public Text getTextTile() {
        if (textTile == null) {
            textTile = new Text("Text");
        }

        return textTile;
    }

    public TextField getTitle() {
        if (title == null) {
            title = new TextField("Not set");
        }

        return title;
    }

    public Text getTextAuthor() {
        if (textAuthor == null) {
            textAuthor = new Text("Author");
        }

        return textAuthor;
    }

    public TextField getAuthor() {
        if (author == null) {
            author = new TextField("Not set");
        }

        return author;
    }

    public Text getTextPrice() {
        if (textPrice == null) {
            textPrice = new Text("Price");
        }

        return textPrice;
    }

    public TextField getPrice() {
        if (price == null) {
            price = new TextField("Not set");
        }

        return price;
    }

    public Book newBook() {
        return new Book(getTitle().getText(),
                getAuthor().getText(),
                Double.parseDouble(getPrice().getText()));
    }
}
