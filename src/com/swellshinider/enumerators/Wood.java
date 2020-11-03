package com.swellshinider.enumerators;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Wood {
    NONE,
    Softwood,
    Abeto,
    Ash,
    Cedro,
    Basswood,
    Pinho,
    Marfim,
    Ebano,
    Hardwood,
    Mogno,
    Jacaranda

    ;
    private static final List<Wood> VALUES = Arrays.asList(Softwood,
            Abeto,
            Ash,
            Cedro,
            Basswood,
            Pinho,
            Marfim,
            Ebano,
            Hardwood,
            Mogno,
            Jacaranda);
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Wood getRandom()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
