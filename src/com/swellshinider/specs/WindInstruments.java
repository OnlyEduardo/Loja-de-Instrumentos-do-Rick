package com.swellshinider.specs;

import com.swellshinider.enumerators.Metal;
import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Wood;

public class WindInstruments extends Instruments {

    private final Wood woodPart;
    private final Metal metalPart;

    public WindInstruments(long serial, float price, TradeMark tradeMark, Wood woodPart, Metal metalPart) {
        super(serial, price, tradeMark, "Sopro");
        this.woodPart = woodPart;
        this.metalPart = metalPart;
    }

    public boolean matchParts(Wood wood, Metal metal){
        if(getMetalPart().equals(Metal.NONE))
            return getWoodPart().equals(wood);
        else if(getWoodPart().equals(Wood.NONE))
            return getMetalPart().equals(metal);
        else
            return false;
    }


    public Wood getWoodPart() {
        return woodPart;
    }

    public Metal getMetalPart() {
        return metalPart;
    }
}
