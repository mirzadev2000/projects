package com.example.bookstoreapplication;

import com.example.bookstoreapplication.create.CreateScene;
import com.example.bookstoreapplication.model.BooksStorage;
import com.example.bookstoreapplication.overview.OverviewScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class BookstoreApplication extends Application {

    private OverviewScene overviewScene = null;
    private CreateScene createScene = null;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        primaryStage.setTitle("Bookstore application");
        primaryStage.setScene(getOverviewScene());
        primaryStage.show();
    }

    public OverviewScene getOverviewScene() {
        if (overviewScene == null) {
            overviewScene = new OverviewScene();
            overviewScene.addEventFilter(BookstoreEvent.createScene, (e) -> {
                stage.setScene(getCreateScene());
            });
        }

        return overviewScene;
    }

    public CreateScene getCreateScene() {
        if (createScene == null) {
            createScene = new CreateScene();
            createScene.addEventFilter(BookstoreEvent.overviewScene, (e) -> {
                overviewScene.refreshData();
                stage.setScene(getOverviewScene());
            });
        }

        return createScene;
    }

    public static void main(String[] args) {
        launch();
    }
}
