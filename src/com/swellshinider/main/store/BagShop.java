package com.swellshinider.main.store;

import com.swellshinider.specs.Instruments;

import java.util.ArrayList;
import java.util.List;

public class BagShop {

    private final List<Instruments> buyList = new ArrayList<>();
    private float totalPrice = 0f;

    public List<Instruments> getBuyList(){
        return buyList;
    }

    public void clear(){
        buyList.clear();
        totalPrice = 0f;
    }

    public int getInstrumentsQuantityInList(){
        return buyList.size();
    }

    public float getTotalPrice(){
        return totalPrice;
    }

    public void addToCar(Instruments newInstrument){
        totalPrice += newInstrument.getPrice();
        buyList.add(newInstrument);
    }

    public void removeToCar(Instruments oldInstrument){
        totalPrice -= oldInstrument.getPrice();
        buyList.remove(oldInstrument);
    }
}
