package com.swellshinider.instruments;

import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Type;
import com.swellshinider.enumerators.Wood;
import com.swellshinider.specs.StringInstruments;

public class Guitar extends StringInstruments {

    private final int stringQuantity;

    public Guitar(long serial, float price, TradeMark tradeMark, Wood backWood, Wood topWood, Type instrumentType, int stringQuantity) {
        super(serial, price, tradeMark, backWood, topWood, instrumentType);
        this.stringQuantity = stringQuantity;
    }

    public int getStringQuantity() {
        return stringQuantity;
    }

    @Override
    public String toString() {
        return (getInstrumentType().equals(Type.Electric) ? "Guitarra " : "Violão ") + tradeMark +
                ", " + getStringQuantity() +
                " cordas, materiais: " + getTopWood() + " e " + getBackWood() +
                " (R$"+formatter.format(price)+")";
    }
}
