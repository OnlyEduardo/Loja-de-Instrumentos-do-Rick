package com.swellshinider.instruments;

import com.swellshinider.enumerators.Metal;
import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Type;
import com.swellshinider.enumerators.Wood;
import com.swellshinider.specs.PercussionInstruments;

public class Tambourine extends PercussionInstruments {

    private final int sizeRadio;

    public Tambourine(long serial, float price, TradeMark tradeMark, Wood bodyWood, int sizeRadio) {
        super(serial, price, tradeMark, Metal.NONE, bodyWood, Type.Acoustic);
        this.sizeRadio = sizeRadio;
    }

    public int getSizeRadio() {
        return sizeRadio;
    }

    @Override
    public String toString() {
        return "Pandeiro " + getTradeMark() +
                ", raio: " + getSizeRadio() +
                ", material: " + getBodyWood() +
                " (R$" + formatter.format(price) + ")";
    }
}
