package com.swellshinider.enumerators;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum TradeMark {
    NONE,
    Takamine,
    Stratocaster,
    Fender,
    Yamaha,
    Casio,
    Tagima
    ;
    private static final List<TradeMark> VALUES = Arrays.asList(Takamine,
            Stratocaster,
            Fender,
            Yamaha,
            Casio,
            Tagima);

    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static TradeMark getRandom()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
