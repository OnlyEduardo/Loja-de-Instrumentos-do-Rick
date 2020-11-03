package com.swellshinider.main.store;

import com.swellshinider.instruments.*;
import com.swellshinider.instruments.enumerators.Metal;
import com.swellshinider.instruments.enumerators.TradeMark;
import com.swellshinider.instruments.enumerators.Type;
import com.swellshinider.instruments.enumerators.Wood;
import com.swellshinider.instruments.specs.Instruments;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inventory {

    public static int instrumentsToGenerate;
    private static final List<Class<? extends Instruments>> instrumentsType = new ArrayList<>();

    public static List<Instruments> allInstruments = new ArrayList<>();

    static {
        populateInstrumentsType();
    }

    private static void populateInstrumentsType() {
        instrumentsType.add(Flute.class);
        instrumentsType.add(Battery.class);
        instrumentsType.add(Guitar.class);
        instrumentsType.add(Mandolin.class);
        instrumentsType.add(Violin.class);
    }

    public static void generateInstruments() {

        long serial = 1L;
        float price = generateNewPrice();

        for (int i = 0; i < instrumentsToGenerate / instrumentsType.size(); i++) {
            for(Class<? extends Instruments> insClass: instrumentsType){

                switch (insClass.getSimpleName()){
                    case "Flute":
                        {
                            if(new Random().nextFloat() > 0.5f)
                                allInstruments.add(new Flute(serial, price, TradeMark.getRandom(),
                                        Wood.getRandom(), Metal.NONE, 6));
                            else
                                allInstruments.add(new Flute(serial, price, TradeMark.getRandom(),
                                        Wood.NONE, Metal.getRandom(), 7));
                        }
                        break;
                    case "Guitar":
                        {
                            allInstruments.add(new Guitar(serial, price, TradeMark.getRandom(),
                                    Wood.getRandom(), Wood.getRandom(), Type.getRandom(),
                                    (new Random().nextFloat() >= 0.5f) ? 6 : 7));
                        }
                        break;
                    case "Mandolin":
                        {
                            allInstruments.add(new Mandolin(serial, price, TradeMark.getRandom(),
                                    Wood.getRandom(), Wood.getRandom(), Type.getRandom()));
                        }
                        break;
                    case "Battery":
                        {
                            allInstruments.add(new Battery(serial, price, TradeMark.getRandom(),
                                    Metal.getRandom(), Wood.getRandom(), Type.getRandom()));
                        }
                        break;
                    case "Violin":
                        {
                            allInstruments.add(new Violin(serial, price, TradeMark.getRandom(),
                                    Wood.getRandom(), Wood.getRandom(), Type.getRandom()));
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + insClass.getSimpleName());
                }

                serial += 1L;
                price = generateNewPrice();
            }
        }
    }

    private static float generateNewPrice(){
        return (float)((Math.random() * (5000 - 500)) + 500);
    }
}
