package com.swellshinider.instruments;

import com.swellshinider.enumerators.Metal;
import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Type;
import com.swellshinider.enumerators.Wood;
import com.swellshinider.specs.PercussionInstruments;

public class Battery extends PercussionInstruments {

    public Battery(long serial, float price, TradeMark tradeMark, Metal metalPart, Wood bodyWood, Type instruementsType) {
        super(serial, price, tradeMark, metalPart, bodyWood, instruementsType);
    }

    @Override
    public String toString() {
        return "Bateria " + tradeMark +
                ""+ (getInstrumentsType().equals(Type.Electric) ? "(Elétrica)" : "") +", materiais: " + getBodyWood() + " e " + getMetalPart() +
                " (R$"+formatter.format(price)+")";
    }
}
