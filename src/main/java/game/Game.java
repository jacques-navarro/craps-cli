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

    public void play() {
        System.out.println("Craps\n");
        while (true) {
            System.out.println("Select an Option");
            System.out.println("1 - Play");
            System.out.println("2 - See Rules");
            System.out.println("3 - Exit");
            System.out.print("Enter Choice: ");

            int menuChoice = Integer.valueOf(scanner.nextLine());

            if (menuChoice == 1) {
                while (true) {
                    System.out.println("1 - Roll Dice");
                    System.out.println("2 - Quit");

                    int gameChoice = Integer.valueOf(scanner.nextLine());

                    if (gameChoice == 2) {
                        break;
                    }
                }
                continue;
            }

            if (menuChoice == 2) {
                continue;
            }

            if (menuChoice == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

}
