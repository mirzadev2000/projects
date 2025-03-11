module com.example.bookstoreapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.bookstoreapplication to javafx.fxml;
    opens com.example.bookstoreapplication.model to javafx.fxml;

    exports com.example.bookstoreapplication;
    exports com.example.bookstoreapplication.model;
}