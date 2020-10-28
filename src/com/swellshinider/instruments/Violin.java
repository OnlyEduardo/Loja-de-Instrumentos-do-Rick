package com.swellshinider.instruments;

import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Type;
import com.swellshinider.instruments.enumerators.Wood;
import com.swellshinider.instruments.specs.StringInstruments;

public class Violin extends StringInstruments {

    public Violin(long serial, float price, TradeMark tradeMark, Wood backWood, Wood topWood, Type instrumentType) {
        super(serial, price, tradeMark, backWood, topWood, instrumentType);
    }

    public int getStringQuantity() { return 6; }

    @Override
    public String toString() {
        return "Violino " + tradeMark +
                ""+ (getInstrumentType().equals(Type.ELECTRIC) ? "(Eletrico)" : "") +", " + getStringQuantity() +
                " cordas, materiais: " + getTopWood() + " e " + getBackWood() +
                " (R$"+formatter.format(price)+")";
    }
}
