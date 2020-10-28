package com.swellshinider.main.store;

import com.swellshinider.instruments.*;
import com.swellshinider.instruments.enumerators.Metal;
import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Type;
import com.swellshinider.instruments.enumerators.Wood;
import com.swellshinider.instruments.specs.Instruments;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public static List<Instruments> allInstruments = new ArrayList<>();

    static {
        // Flautas adicionadas
        allInstruments.add(new Flute(1L, 350f, TradeMark.Yamaha, Wood.NONE, Metal.Bronze, 7));
        allInstruments.add(new Flute(2L, 300f,TradeMark.Tagima, Wood.Abeto, Metal.NONE, 6));
        allInstruments.add(new Flute(3L, 220f, TradeMark.Yamaha, Wood.Ebano, Metal.NONE, 7));
        allInstruments.add(new Flute(4L, 185.99f,TradeMark.Casio, Wood.Ash, Metal.NONE, 6));

        // Guitarras adicionadas
        allInstruments.add(new Guitar(5L, 1250f, TradeMark.Stratocaster, Wood.Basswood, Wood.Softwood, Type.Eletrico, 7));
        allInstruments.add(new Guitar(6L, 845.50f, TradeMark.Yamaha, Wood.Hardwood, Wood.Ash, Type.Acustico, 6));
        allInstruments.add(new Guitar(7L, 950f, TradeMark.Tagima, Wood.Abeto, Wood.Softwood, Type.Eletrico, 7));
        allInstruments.add(new Guitar(8L, 650f, TradeMark.Fender, Wood.Jacaranda, Wood.Marfim, Type.Acustico, 6));

        // Mandolins adicionados
        allInstruments.add(new Mandolin(9L, 500f, TradeMark.Takamine, Wood.Ash, Wood.Marfim, Type.Acustico));
        allInstruments.add(new Mandolin(10L, 500f, TradeMark.Tagima, Wood.Cedro, Wood.Hardwood, Type.Eletrico));

        // Baterias adicionadas
        allInstruments.add(new Battery(11L, 1600f, TradeMark.Casio, Metal.Silver, Wood.Ebano, Type.Acustico));
        allInstruments.add(new Battery(12L, 1050f, TradeMark.Yamaha, Metal.Silver, Wood.Basswood, Type.Acustico));
        allInstruments.add(new Battery(13L, 1420f, TradeMark.Stratocaster, Metal.Silver, Wood.Hardwood, Type.Eletrico));
        allInstruments.add(new Battery(14L, 1300f, TradeMark.Tagima, Metal.Silver, Wood.Ash, Type.Eletrico));

        // Violinos adicionados
        allInstruments.add(new Violin(15L, 1750f, TradeMark.Yamaha, Wood.Softwood, Wood.Jacaranda, Type.Acustico));
        allInstruments.add(new Violin(16L, 1230f, TradeMark.Stratocaster, Wood.Abeto, Wood.Ebano, Type.Acustico));
        allInstruments.add(new Violin(17L, 1412f, TradeMark.Tagima, Wood.Marfim, Wood.Ash, Type.Eletrico));
        allInstruments.add(new Violin(18L, 1120f, TradeMark.Takamine, Wood.Jacaranda, Wood.Ebano, Type.Eletrico));
    }
}
