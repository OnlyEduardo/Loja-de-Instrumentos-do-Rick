package com.swellshinider.controller;

import com.swellshinider.main.Main;
import com.swellshinider.main.store.Inventory;
import com.swellshinider.util.Stages;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneratorController implements Initializable {

    private final int minimumGen = 10;
    private final int maximumGen = 100000;

    public TextField textLabel;
    public Text warningText;

    private int valueToGenerate = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textLabel.setPromptText(".min " + minimumGen + " - .max " + maximumGen);
    }

    public void generate() {
        Inventory.instrumentsToGenerate = valueToGenerate;
        Inventory.generateInstruments();
        MainController.instance.createFilters();
        MainController.instance.searchInstruments();
        Main.instance.setStage(Stages.MAIN_STAGE);
    }

    // Add
    public void addK() {
        if(valueToGenerate + 1000 > maximumGen){
            exceptMaximum();
            return;
        }
        valueToGenerate += 1000;
        textLabel.setText(valueToGenerate + "");
    }

    public void addHundred() {
        if(valueToGenerate + 100 > maximumGen){
            exceptMaximum();
            return;
        }
        valueToGenerate += 100;
        textLabel.setText(valueToGenerate + "");
    }

    public void addTen() {
        if(valueToGenerate + 10 > maximumGen){
            exceptMaximum();
            return;
        }
        valueToGenerate += 10;
        textLabel.setText(valueToGenerate + "");
    }

    public void addOne() {
        if(valueToGenerate + 1 > maximumGen){
            exceptMaximum();
            return;
        }
        valueToGenerate += 1;
        textLabel.setText(valueToGenerate + "");
    }

    // Remove
    public void removeOne() {
        if(valueToGenerate - 1 < minimumGen){
            exceptMinimun();
            return;
        }
        valueToGenerate -= 1;
        textLabel.setText(valueToGenerate + "");
    }

    public void removeTen() {
        if(valueToGenerate - 10 < minimumGen){
            exceptMinimun();
            return;
        }
        valueToGenerate -= 10;
        textLabel.setText(valueToGenerate + "");
    }

    public void removeHundred() {
        if(valueToGenerate - 100 < minimumGen){
            exceptMinimun();
            return;
        }
        valueToGenerate -= 100;
        textLabel.setText(valueToGenerate + "");
    }

    public void removeK() {
        if(valueToGenerate - 1000 < minimumGen){
            exceptMinimun();
            return;
        }

        valueToGenerate -= 1000;
        textLabel.setText(valueToGenerate + "");
    }

    // Excepts
    private void exceptMinimun() {
        warningText.setText("O valor minímo de geração é " + minimumGen);
    }

    private void exceptMaximum(){
        warningText.setText("O valor máximo de geração é " + maximumGen);
    }

}
