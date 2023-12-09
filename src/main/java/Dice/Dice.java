package Dice;

public class Dice {

    private Die die1;
    private Die die2;

    public Dice() {
        die1 = new Die();
        die2 = new Die();
    }

    public void rollDice() {
        die1.roll();
        die2.roll();
    }

    public int getDie1Value() {
        return die1.getValue();
    }

    public int getDie2Value() {
        return die2.getValue();
    }

    public int getSum() {
        return getDie1Value() + getDie2Value();
    }

    @Override
    public String toString() {
        return String.format("%s %s = %d", getDie1Value(), getDie2Value(), getSum());
    }

}
