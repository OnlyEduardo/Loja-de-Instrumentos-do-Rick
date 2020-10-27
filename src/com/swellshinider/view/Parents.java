package com.swellshinider.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public abstract class Parents {

    public static Parent mainParent;

    static {
        try {
            mainParent = FXMLLoader.load(Parents.class.getResource("fxml/mainScreen.fxml"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
