package com.swellshinider.instruments;

import com.swellshinider.enumerators.Metal;
import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Wood;
import com.swellshinider.specs.WindInstruments;

public class Flute extends WindInstruments {

    public Flute(long serial, float price, TradeMark tradeMark, Wood woodPart, Metal metalPart) {
        super(serial, price, tradeMark, woodPart, metalPart);
    }

    @Override
    public String toString() {
        return "Flauta " + (getWoodPart().equals(Wood.NONE) ? "transversal " : "") + tradeMark +
                ", material: " +
                (getWoodPart().equals(Wood.NONE) ? getMetalPart() : getWoodPart()) +
                " (R$" + formatter.format(price) + ")";
    }
}
