package com.example.bookstoreapplication.overview;

import com.example.bookstoreapplication.model.BooksStorage;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class OverviewPane extends BorderPane {

    // Properties
    private OverviewLeftPane overviewLeftPane = null;
    private OverviewTableView overviewTableView = null;

    // Constructors
    public OverviewPane() {
        initS();
    }

    // Private methods
    private void initS() {
        this.setTop(new Text("This table contains books for sale!"));
        this.setLeft(getOverviewLeftPane());
        this.setCenter(getOverviewTableView());
        setPrefWidth(800);
        setPrefHeight(600);
    }

    // Public methods
    public OverviewLeftPane getOverviewLeftPane() {
        if (overviewLeftPane == null) {
            overviewLeftPane = new OverviewLeftPane(getOverviewTableView());
        }

        return overviewLeftPane;
    }

    public OverviewTableView getOverviewTableView() {
        if (overviewTableView == null) {
            overviewTableView = new OverviewTableView(BooksStorage.INSTANCE.observableListOfBooks());
        }

        return overviewTableView;
    }

    public void refreshData() {
        getOverviewTableView().setItems(BooksStorage.INSTANCE.observableListOfBooks());
    }
}
