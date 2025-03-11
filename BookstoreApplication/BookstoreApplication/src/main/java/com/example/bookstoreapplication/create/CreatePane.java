package com.example.bookstoreapplication.create;

import javafx.scene.layout.BorderPane;

public class CreatePane extends BorderPane {
    private CreateInputPane createInputPane = null;
    private CreateBottomPane createBottomPane = null;



    public CreatePane(){
        init();
    }
    private void init(){
        setCenter(getCreateInputPane());
        setBottom(getCreateBottomPane());
        setPrefWidth(800);
        setPrefHeight(600);
    }


    public CreateInputPane getCreateInputPane() {
        if (createInputPane == null) {
            createInputPane = new CreateInputPane();
        }

        return createInputPane;
    }

    public CreateBottomPane getCreateBottomPane() {
        if (createBottomPane == null) {
            createBottomPane = new CreateBottomPane(getCreateInputPane());
        }

        return createBottomPane;
    }
}
