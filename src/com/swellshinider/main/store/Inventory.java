package com.swellshinider.main.store;

import com.swellshinider.instruments.Flute;
import com.swellshinider.instruments.Guitar;
import com.swellshinider.instruments.Mandolin;
import com.swellshinider.instruments.enumerators.Metal;
import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Type;
import com.swellshinider.instruments.enumerators.Wood;
import com.swellshinider.instruments.specs.Instruments;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public static List<Instruments> allInstruments;

    static {
        allInstruments = new ArrayList<>();
        allInstruments.add(new Flute(1L, 125f, TradeMark.Yamaha, Wood.NONE, Metal.Bronze, 7));
        allInstruments.add(new Flute(2L, 150f,TradeMark.Casio, Wood.Abeto, Metal.NONE, 6));
        allInstruments.add(new Guitar(3L, 950f, TradeMark.Stratocaster, Wood.Basswood, Wood.Softwood, Type.ELECTRIC, 7));
        allInstruments.add(new Guitar(4L, 650f, TradeMark.Fender, Wood.Hardwood, Wood.Ash, Type.ACOUSTIC, 6));
        allInstruments.add(new Mandolin(5L, 500f, TradeMark.Takamine, Wood.Cedro, Wood.Marfim, Type.ACOUSTIC));
    }
}
