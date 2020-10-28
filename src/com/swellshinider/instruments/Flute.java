package com.swellshinider.instruments;

import com.swellshinider.instruments.enumerators.Metal;
import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Wood;
import com.swellshinider.instruments.specs.WindInstruments;

public class Flute extends WindInstruments {

    private final int roleQuantity;

    public Flute(long serial, float price, TradeMark tradeMark, Wood woodPart, Metal metalPart, int roleQuantity) {
        super(serial, price, tradeMark, woodPart, metalPart);
        this.roleQuantity = roleQuantity;
    }

    public int getRoleQuantity() {
        return roleQuantity;
    }

    public boolean matchParts(Wood wood, Metal metal){
        return getWoodPart().equals(wood) || getMetalPart().equals(metal);
    }

    @Override
    public String toString() {
        return "Flauta " + tradeMark + ", " +
                getRoleQuantity() + " buracos, material: " +
                (getWoodPart().equals(Wood.NONE) ? getMetalPart() : getWoodPart()) +
                " (R$" + formatter.format(price) + ")";
    }
}
