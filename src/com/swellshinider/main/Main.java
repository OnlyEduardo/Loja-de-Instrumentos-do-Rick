package com.swellshinider.main;

import com.swellshinider.util.Stages;
import com.swellshinider.util.Titles;
import com.swellshinider.view.Scenes;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    public static Main instance;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        instance = this;
        stage = primaryStage;
        setStage(Stages.GEN_STAGE);

        primaryStage.getIcons().add(new ImageView(
                        new Image(getClass().getResource("icon.png").toExternalForm())).getImage());
    }

    public void setStage(Stages stageKey) {

        switch (stageKey){
            case MAIN_STAGE:
                stage.setScene(Scenes.MAIN_SCENE);
                stage.setTitle(Titles.MAIN_SCENE);
                break;
            case GEN_STAGE:
                stage.setScene(Scenes.GEN_SCENE);
                stage.setTitle(Titles.GEN_SCENE);
                break;
        }

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
