package Dice;

import java.util.Random;

public class Die {

    private DieValue value;
    private Random random;

    public Die() {
        random = new Random();
        roll();
    }

    public DieValue getValue() {
        return value;
    }

    public DieValue roll() {
        int random = getRandom();
        value = switch (random) {
            case 1 -> DieValue.ONE;
            case 2 -> DieValue.TWO;
            case 3 -> DieValue.THREE;
            case 4 -> DieValue.FOUR;
            case 5 -> DieValue.FIVE;
            default -> DieValue.SIX;
        };
        return value;
    }

    public int getRandom() {
        return random.nextInt(1, 7);
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

}
