package com.swellshinider.instruments.specs;

import com.swellshinider.instruments.enumerators.Metal;
import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Type;
import com.swellshinider.instruments.enumerators.Wood;

public class PercussionInstruments extends Instruments {

    private final Metal metalPart;
    private final Wood bodyWood;
    private final Type instrumentsType;

    public PercussionInstruments(long serial, float price, TradeMark tradeMark, Metal metalPart, Wood bodyWood, Type instruementsType) {
        super(serial, price, tradeMark, "Percurssão");
        this.metalPart = metalPart;
        this.bodyWood = bodyWood;
        this.instrumentsType = instruementsType;
    }

    public Type getInstrumentsType(){
        return instrumentsType;
    }

    public Metal getMetalPart() {
        return metalPart;
    }

    public Wood getBodyWood() {
        return bodyWood;
    }
}
