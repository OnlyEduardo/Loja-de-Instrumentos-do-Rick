package com.swellshinider.instruments.specs;

import com.swellshinider.instruments.enumerators.TradeMark;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Instruments {

    protected final NumberFormat formatter = new DecimalFormat("###,###,###.##");

    protected final long serial;
    protected final float price;
    protected final TradeMark tradeMark;
    protected final String family;

    public Instruments(long serial, float price, TradeMark tradeMark, String family) {
        this.serial = serial;
        this.price = price;
        this.tradeMark = tradeMark;
        this.family = family;
    }

    public long getSerial() {
        return serial;
    }

    public float getPrice() {
        return price;
    }

    public TradeMark getTradeMark() {
        return tradeMark;
    }

    public String getFamily() {
        return family;
    }

    public boolean matchValue(float minimum, float maximum){
        return price >= minimum && price <= maximum;
    }

    public boolean matchFamily(String family){
        return this.family.equals(family);
    }

    public boolean matchTradeMark(TradeMark tradeMark){
        return this.tradeMark.equals(tradeMark);
    }
}
