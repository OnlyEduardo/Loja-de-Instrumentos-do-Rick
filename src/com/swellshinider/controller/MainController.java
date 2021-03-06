package com.swellshinider.controller;

import com.swellshinider.enumerators.Metal;
import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Type;
import com.swellshinider.enumerators.Wood;
import com.swellshinider.specs.Instruments;
import com.swellshinider.specs.PercussionInstruments;
import com.swellshinider.specs.StringInstruments;
import com.swellshinider.specs.WindInstruments;
import com.swellshinider.main.store.BagShop;
import com.swellshinider.main.store.Inventory;
import com.swellshinider.util.ProgramInfos;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    // Side panel
    public Text numberInCars;
    public Text programInfosText;

    // PANELS
    public Pane instrumentsPane;
    public Pane bagPanel;
    // END PANELS

    // INSTRUMENTS PANEL
    public ListView<Instruments> listView;

    public Text numberInsDisponiveis;

    public TextField minPrice;
    public TextField maxPrice;

    public ChoiceBox<String> orderChoiceBox = new ChoiceBox<>();
    public ChoiceBox<Type> typeChoiceBox = new ChoiceBox<>();
    public ChoiceBox<TradeMark> tradeMarkChoiceBox = new ChoiceBox<>();
    public ChoiceBox<String> familyChoiceBox = new ChoiceBox<>();
    public ChoiceBox<Wood> woodChoiceBox = new ChoiceBox<>();
    public ChoiceBox<Metal> metalChoiceBox = new ChoiceBox<>();
    // END INSTRUMENTS PANEL

    // SHOP PANEL
    public ListView<Instruments> listViewCompras;
    public Text showBuyInfo;
    public Text subTotalText;
    public TextField cupomBox;
    public Text totalText;
    // END SHOP PANEL

    public static MainController instance;

    private final BagShop carrinhoDeCompra = new BagShop();
    private boolean haveCupom = false;
    private final NumberFormat formatter = new DecimalFormat("###,###,###.##");
    private Comparator<Instruments> comp = Comparator.comparingLong(Instruments::getSerial);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instance = this;

        programInfosText.setText(ProgramInfos.ABOUT);
        listView.getItems().addAll(Inventory.allInstruments);
        listView.getItems().sort(comp);
        numberInsDisponiveis.setText("Há "+ listView.getItems().size() +" instrumentos disponíveis");
    }

    public void createFilters() {
        // Set layout and position
        orderChoiceBox.setLayoutX(230);
        orderChoiceBox.setLayoutY(66);
        orderChoiceBox.setPrefSize(100, 25);

        typeChoiceBox.setLayoutX(441);
        typeChoiceBox.setLayoutY(66);
        typeChoiceBox.setPrefSize(100, 25);

        tradeMarkChoiceBox.setLayoutX(551);
        tradeMarkChoiceBox.setLayoutY(66);
        tradeMarkChoiceBox.setPrefSize(100, 25);

        familyChoiceBox.setLayoutX(661);
        familyChoiceBox.setLayoutY(66);
        familyChoiceBox.setPrefSize(100, 25);

        woodChoiceBox.setLayoutX(771);
        woodChoiceBox.setLayoutY(66);
        woodChoiceBox.setPrefSize(100, 25);

        metalChoiceBox.setLayoutX(881);
        metalChoiceBox.setLayoutY(66);
        metalChoiceBox.setPrefSize(100, 25);

        // Getting Values
        orderChoiceBox.getItems().addAll("NONE", "Maior Preço",
                "Menor Preço", "Nome", "Familia");
        typeChoiceBox.getItems().addAll(Type.values());
        tradeMarkChoiceBox.getItems().addAll(TradeMark.values());
        familyChoiceBox.getItems().add("NONE");
        woodChoiceBox.getItems().addAll(Wood.values());
        metalChoiceBox.getItems().addAll(Metal.values());

        for(Instruments ins: Inventory.allInstruments){
            if(!familyChoiceBox.getItems().contains(ins.getFamily()))
                familyChoiceBox.getItems().add(ins.getFamily());
        }

        System.out.println(Arrays.toString(familyChoiceBox.getItems().toArray()));

        // add to panel
        orderChoiceBox.setValue(orderChoiceBox.getItems().get(0));
        typeChoiceBox.setValue(typeChoiceBox.getItems().get(0));
        tradeMarkChoiceBox.setValue(tradeMarkChoiceBox.getItems().get(0));
        familyChoiceBox.setValue(familyChoiceBox.getItems().get(0));
        woodChoiceBox.setValue(woodChoiceBox.getItems().get(0));
        metalChoiceBox.setValue(metalChoiceBox.getItems().get(0));

        instrumentsPane.getChildren().add(orderChoiceBox);
        instrumentsPane.getChildren().add(typeChoiceBox);
        instrumentsPane.getChildren().add(tradeMarkChoiceBox);
        instrumentsPane.getChildren().add(familyChoiceBox);
        instrumentsPane.getChildren().add(woodChoiceBox);
        instrumentsPane.getChildren().add(metalChoiceBox);
    }

    public void searchInstruments() {
        listView.getItems().clear();

        float minimum = Float.MIN_VALUE;
        float maximum = Float.MAX_VALUE;

        try {
             minimum = Float.parseFloat(minPrice.getText());
        } catch (Exception ignored) {}

        try {
            maximum = Float.parseFloat(maxPrice.getText());
        } catch (Exception ignored) {}

        Type searchableType = typeChoiceBox.getValue();
        TradeMark searchableTradeMark = tradeMarkChoiceBox.getValue();
        String searchableFamily = familyChoiceBox.getValue();
        Wood searchableWood = woodChoiceBox.getValue();
        Metal searchableMetal = metalChoiceBox.getValue();

        if(searchableType.equals(Type.NONE) &&
                searchableTradeMark.equals(TradeMark.NONE) &&
                searchableFamily.equals("NONE") &&
                searchableWood.equals(Wood.NONE) &&
                searchableMetal.equals(Metal.NONE) &&
                minimum == Float.MIN_VALUE &&
                maximum == Float.MAX_VALUE) {
            listView.getItems().addAll(Inventory.allInstruments);
            listView.getItems().sort(comp);
            numberInsDisponiveis.setText("Há "+ listView.getItems().size() +" instrumentos disponíveis");
            return;
        }

        for(Instruments in: Inventory.allInstruments){
            int score = 0;

            // Type search
            if(searchableType.equals(Type.NONE)){
                score++;
            }
            else if(in instanceof PercussionInstruments){
                if(((PercussionInstruments) in).getInstrumentsType().equals(searchableType))
                    score++;
            }
            else if(in instanceof StringInstruments) {
                if (((StringInstruments) in).getInstrumentType().equals(searchableType))
                    score++;
            }

            // TradeMark search
            if (searchableTradeMark.equals(TradeMark.NONE) || in.matchTradeMark(searchableTradeMark)){
                score++;
            }

            // Family search
            if (searchableFamily.equals("NONE") || in.matchFamily(searchableFamily)){ score++; }

            // Wood and Metal search
            if(in instanceof WindInstruments){
                if(((WindInstruments)in).matchParts(searchableWood, searchableMetal)){
                    score++;
                }
            } else if(in instanceof StringInstruments){
                if((((StringInstruments) in).matchWood(searchableWood) || searchableWood.equals(Wood.NONE)) && searchableMetal.equals(Metal.NONE)){
                    score++;
                }
            } else if(in instanceof PercussionInstruments){
                if((((PercussionInstruments) in).matchParts(searchableWood, searchableMetal) && searchableMetal.equals(Metal.NONE))){
                    score++;
                }
            }

            // Price search
            if(in.matchValue(minimum, maximum))
                score++;

            // Valid by score
            if (score == 5)
                listView.getItems().add(in);
        }

        listView.getItems().sort(comp);
        numberInsDisponiveis.setText("Há "+ listView.getItems().size() +" instrumentos disponíveis");
    }

    public void clickedInInstrument(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() != 2 || listView.getSelectionModel().getSelectedItem() == null)
            return;

        SelectionModel<Instruments> instrumentsSelectionModel = listView.getSelectionModel();

        String message = "Você deseja adicionar o instrumento '" +
                instrumentsSelectionModel.getSelectedItem().toString() +
                "' ao seu carrinho de compras ?";

        int dialogButton = JOptionPane.showConfirmDialog(null,
                message,"Confirmação",
                JOptionPane.YES_NO_OPTION);

        if(dialogButton != 0)
            return;

        carrinhoDeCompra.addToCar(instrumentsSelectionModel.getSelectedItem());
        Inventory.allInstruments.remove(instrumentsSelectionModel.getSelectedItem());
        numberInCars.setText(carrinhoDeCompra.getInstrumentsQuantityInList() + "");
        searchInstruments();
        updateListaCompras();
        updateSubTotal();
        updateTotal();
    }

    public void clickToRemoveCompra(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() != 2 || listViewCompras.getSelectionModel().getSelectedItem() == null)
            return;

        SelectionModel<Instruments> instrumentsSelectionModel = listViewCompras.getSelectionModel();

        String message = "Você deseja remover o instrumento '"+
                instrumentsSelectionModel.getSelectedItem().toString() +" do seu carrinho de compras ?";

        int dialogButton = JOptionPane.showConfirmDialog(null,
                message,"Confirmação",
                JOptionPane.YES_NO_OPTION);

        if(dialogButton != 0)
            return;

        carrinhoDeCompra.removeToCar(instrumentsSelectionModel.getSelectedItem());
        Inventory.allInstruments.add(instrumentsSelectionModel.getSelectedItem());
        numberInCars.setText(carrinhoDeCompra.getInstrumentsQuantityInList() + "");
        searchInstruments();
        updateListaCompras();
        updateSubTotal();
        updateTotal();
    }

    public void aaplyCuppom(ActionEvent actionEvent) {
        if(!actionEvent.getEventType().equals(ActionEvent.ACTION) && !haveCupom)
            return;
        if(cupomBox.getText().equals("LEAL"))
            haveCupom = true;
        updateTotal();
    }

    public void finalizeShop(ActionEvent actionEvent) {
        if(!actionEvent.getEventType().equals(ActionEvent.ACTION))
            return;

        carrinhoDeCompra.clear();
        updateListaCompras();
        updateSubTotal();
        updateTotal();
        haveCupom = false;
    }

    public void ordenButton(ActionEvent actionEvent) {
        if(!actionEvent.getEventType().equals(ActionEvent.ACTION))
            return;

        switch (orderChoiceBox.getValue()){
            case "Maior Preço":
                comp = Comparator.comparingDouble(Instruments::getPrice).reversed();
                break;
            case "Menor Preço":
                comp = Comparator.comparingDouble(Instruments::getPrice);
                break;
            case "Nome":
                comp = Comparator.comparing(Instruments::toString);
                break;
            case "Familia":
                comp = Comparator.comparing(Instruments::getFamily);
                break;
            default:
                comp = Comparator.comparingLong(Instruments::getSerial);
                break;
        }

        searchInstruments();
    }

    public void resetFilter(ActionEvent actionEvent) {
        if(!actionEvent.getEventType().equals(ActionEvent.ACTION))
            return;

        typeChoiceBox.setValue(typeChoiceBox.getItems().get(0));
        tradeMarkChoiceBox.setValue(tradeMarkChoiceBox.getItems().get(0));
        familyChoiceBox.setValue(familyChoiceBox.getItems().get(0));
        woodChoiceBox.setValue(woodChoiceBox.getItems().get(0));
        metalChoiceBox.setValue(metalChoiceBox.getItems().get(0));
        searchInstruments();
    }

    // Side Panel
    public void setAllPanesInvisible(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() != 1)
            return;

        setAllPanesInvisible();
    }

    public void clickedInstrumentsButton(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() != 1)
            return;

        setAllPanesInvisible();
        instrumentsPane.setVisible(true);
        updateListaCompras();
        updateSubTotal();
        updateTotal();
    }
    
    public void clickedInBagButton(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() != 1)
            return;

        setAllPanesInvisible();
        bagPanel.setVisible(true);
        updateListaCompras();
        updateSubTotal();
        updateTotal();
    }
    
    public void AccessSite(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        if(mouseEvent.getClickCount() != 1)
            return;

        java.awt.Desktop.getDesktop().browse(new java.net.URI( ProgramInfos.SITE));
    }

    // Private Methods
    private void setAllPanesInvisible(){
        instrumentsPane.setVisible(false);
        bagPanel.setVisible(false);
    }

    private void updateListaCompras() {
        listViewCompras.getItems().clear();
        listViewCompras.getItems().addAll(carrinhoDeCompra.getBuyList());
        showBuyInfo.setText("Você está comprando " + listViewCompras.getItems().size() + " instrumentos");
        numberInCars.setText(carrinhoDeCompra.getInstrumentsQuantityInList() + "");

    }

    private void updateSubTotal() {
        subTotalText.setText("Sub total: R$" + formatter.format(carrinhoDeCompra.getTotalPrice()));
    }

    private void updateTotal(){
        if(!haveCupom)
            totalText.setText("Subtotal: R$" + formatter.format(carrinhoDeCompra.getTotalPrice()));
        else{
            float total = carrinhoDeCompra.getTotalPrice() * 0.8f;
            totalText.setText("Total: R$" + formatter.format(total));
        }
    }


}
