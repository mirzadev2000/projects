package com.example.bookstoreapplication.create;

import com.example.bookstoreapplication.BookstoreEvent;
import com.example.bookstoreapplication.model.BooksStorage;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CreateBottomPane extends HBox {
    private Button ok = null;
    private Button cancel = null;
    private CreateInputPane createInputPane;

    public CreateBottomPane(CreateInputPane createInputPane) {
        this.createInputPane = createInputPane;
        init();
    }

    private void init() {
        getChildren().addAll(getOkButton(), getCancelButton());
    }

    public Button getOkButton() {
        if (ok == null) {
            ok = new Button("OK");
            ok.setOnAction((e) -> {
                BooksStorage.INSTANCE.createBook(this.createInputPane.newBook());
                fireEvent(new BookstoreEvent(BookstoreEvent.overviewScene));
            });
        }

        return ok;
    }

    public Button getCancelButton() {
        if (cancel == null) {
            cancel = new Button("Cancel");
            cancel.setOnAction((e) -> {
                fireEvent(new BookstoreEvent(BookstoreEvent.overviewScene));
            });
        }

        return cancel;
    }
}
