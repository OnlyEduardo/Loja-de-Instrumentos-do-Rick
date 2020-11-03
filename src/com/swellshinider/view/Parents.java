package com.swellshinider.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public abstract class Parents {

    public static Parent mainParent;
    public static Parent generatorParent;

    static {
        try {
            mainParent = FXMLLoader.load(Parents.class.getResource("fxml/mainScreen.fxml"));
            generatorParent = FXMLLoader.load(Parents.class.getResource("fxml/chooseGeneration.fxml"));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
