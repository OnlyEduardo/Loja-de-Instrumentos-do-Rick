package com.swellshinider.instruments.enumerators;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Metal {
    Brass,
    Bronze,
    Silver,
    Gold,
    NONE

    ;
    private static final List<Metal> VALUES = Arrays.asList(Brass,
            Bronze,
            Silver,
            Gold);
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Metal getRandom()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
