package com.swellshinider.instruments.specs;

import com.swellshinider.instruments.enumerators.Metal;
import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Wood;

public class WindInstruments extends Instruments {

    private final Wood woodPart;
    private final Metal metalPart;

    public WindInstruments(long serial, float price, TradeMark tradeMark, Wood woodPart, Metal metalPart) {
        super(serial, price, tradeMark, "Sopro");
        this.woodPart = woodPart;
        this.metalPart = metalPart;
    }

    public boolean matchParts(Wood wood, Metal metal){
        return getWoodPart().equals(wood) || getMetalPart().equals(metal);
    }


    public Wood getWoodPart() {
        return woodPart;
    }

    public Metal getMetalPart() {
        return metalPart;
    }
}
