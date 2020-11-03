package com.swellshinider.enumerators;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Type {
    NONE,
    Acoustic,
    Electric

    ;

    @Override
    public String toString() {
        switch (this){
            case Acoustic: return "Acustico";
            case Electric: return "Elétric";
        }

        return super.toString();
    }

    private static final List<Type> VALUES = Arrays.asList(Acoustic,
            Electric);
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Type getRandom()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
