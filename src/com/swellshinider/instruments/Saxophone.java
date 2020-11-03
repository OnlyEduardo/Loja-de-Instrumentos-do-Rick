package com.swellshinider.instruments;

import com.swellshinider.enumerators.Metal;
import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Wood;
import com.swellshinider.specs.WindInstruments;

public class Saxophone extends WindInstruments {

    public Saxophone(long serial, float price, TradeMark tradeMark, Metal metal){
        super(serial, price, tradeMark, Wood.NONE, metal);
    }

    @Override
    public String toString() {
        return "Saxofone " + getTradeMark() +
                " , material: " +  getMetalPart() +
                " (R$" + formatter.format(price) + ")";
    }
}
