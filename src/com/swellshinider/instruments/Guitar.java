package com.swellshinider.instruments;

import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Type;
import com.swellshinider.instruments.enumerators.Wood;
import com.swellshinider.instruments.specs.StringInstruments;

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
        return (getInstrumentType().equals(Type.Eletrico) ? "Guitarra " : "Violão ") + tradeMark +
                ", " + getStringQuantity() +
                " cordas, materiais: " + getTopWood() + " e " + getBackWood() +
                " (R$"+formatter.format(price)+")";
    }
}
