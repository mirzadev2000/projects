package com.example.bookstoreapplication.overview;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class OverviewScene extends Scene {

    private OverviewPane overviewPane;

    public OverviewScene() {
        super(new OverviewPane());
        overviewPane = (OverviewPane) getRoot();
    }

    public void refreshData() {
        overviewPane.refreshData();
    }
}
