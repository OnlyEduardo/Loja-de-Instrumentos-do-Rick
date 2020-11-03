package com.swellshinider.instruments;

import com.swellshinider.instruments.enumerators.Metal;
import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Type;
import com.swellshinider.instruments.enumerators.Wood;
import com.swellshinider.instruments.specs.PercussionInstruments;

public class Battery extends PercussionInstruments {

    public Battery(long serial, float price, TradeMark tradeMark, Metal metalPart, Wood bodyWood, Type instruementsType) {
        super(serial, price, tradeMark, metalPart, bodyWood, instruementsType);
    }

    @Override
    public String toString() {
        return "Bateria " + tradeMark +
                ""+ (getInstrumentsType().equals(Type.Eletrico) ? "(Elétrica)" : "") +", materiais: " + getBodyWood() + " e " + getMetalPart() +
                " (R$"+formatter.format(price)+")";
    }
}
