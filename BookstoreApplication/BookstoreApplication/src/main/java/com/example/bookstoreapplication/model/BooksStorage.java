package com.example.bookstoreapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public enum BooksStorage {
    INSTANCE;

    private ArrayList<Book> books = null;

    private ArrayList<Book> getBooks() {
        if (books == null) {
            books = new ArrayList<>();
            books.add(new Book("Prokleta avlija", "Ivo Andric", 25.50));
            books.add(new Book("Ana Karenjina", "Tolstoj", 40));
            books.add(new Book("Crveno i crno", "Stendal", 150));
            books.add(new Book("Ponornica", "Skender Kulenovic", 100.80));
        }

        return books;
    }

    public ObservableList<Book> observableListOfBooks() {
        ObservableList<Book> obsList = FXCollections.observableList(getBooks());
        return  obsList;
    }

    public void createBook(Book book) {
        getBooks().add(book);
    }

    public void deleteBook(Book book) {
        getBooks().remove(book);
    }
}
