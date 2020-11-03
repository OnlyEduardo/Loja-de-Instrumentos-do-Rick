package com.swellshinider.instruments;

import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Type;
import com.swellshinider.enumerators.Wood;
import com.swellshinider.specs.StringInstruments;

public class Violin extends StringInstruments {

    public Violin(long serial, float price, TradeMark tradeMark, Wood backWood, Wood topWood, Type instrumentType) {
        super(serial, price, tradeMark, backWood, topWood, instrumentType);
    }

    public int getStringQuantity() { return 6; }

    @Override
    public String toString() {
        return "Violino " + tradeMark +
                ""+ (getInstrumentType().equals(Type.Electric) ? "(Eletrico)" : "") +", " + getStringQuantity() +
                " cordas, materiais: " + getTopWood() + " e " + getBackWood() +
                " (R$"+formatter.format(price)+")";
    }
}
