package Dice;

import java.util.Random;

public class Die {

    private int value;
    private Random random;

    public Die() {
        random = new Random();
        roll();
    }

    public int getValue() {
        return value;
    }

    public int roll() {
        value = getRandom();
        return getValue();
    }

    public int getRandom() {
        return random.nextInt(1, 7);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
