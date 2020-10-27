package com.swellshinider.main;

import com.swellshinider.util.Titles;
import com.swellshinider.view.Scenes;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        setStage();

        primaryStage.getIcons().add(new ImageView(
                        new Image(getClass().getResource("icon.png").toExternalForm())).getImage());
    }

    private void setStage() {
        stage.setScene(Scenes.MAIN_SCENE);
        stage.setTitle(Titles.MAIN_SCENE);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
