package com.swellshinider.enumerators;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Metal {
    NONE,
    Brass,
    Bronze,
    Silver,
    Gold,
    ;

    @Override
    public String toString() {
        switch (this){
            case Brass: return "Latão";
            case Silver: return "Prata";
            case Gold: return "Ouro";
        }

        return super.toString();
    }

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
