package com.swellshinider.specs;

import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Type;
import com.swellshinider.enumerators.Wood;

public abstract class StringInstruments extends Instruments {

    private final Wood backWood;
    private final Wood topWood;
    private final Type instrumentType;

    public StringInstruments(long serial, float price, TradeMark tradeMark, Wood backWood, Wood topWood, Type instrumentType) {
        super(serial, price, tradeMark, "Cordas");
        this.backWood = backWood;
        this.topWood = topWood;
        this.instrumentType = instrumentType;
    }

    public boolean matchWood(Wood wood){
        return getBackWood().equals(wood) || getTopWood().equals(wood);
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public Type getInstrumentType() {
        return instrumentType;
    }
}
