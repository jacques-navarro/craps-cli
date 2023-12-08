package game;

import Dice.Dice;

import java.util.Scanner;

public class Game {

    private Scanner scanner;
    private Dice dice;
    private GameState gameState;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        dice = new Dice();
        gameState = GameState.START;
    }

}
