package game;

import Dice.Dice;

import java.util.Scanner;

public class Game {

    private Scanner scanner;
    private Dice dice;
    private GameState gameState;
    private int roll;
    private int goal;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        dice = new Dice();
        gameState = GameState.START;
    }

    public void play() {
        System.out.println("Craps");
        while (true) {
            System.out.println("\nSelect an Option");
            System.out.println("1 - Play");
            System.out.println("2 - See Rules");
            System.out.println("3 - Exit");
            System.out.print("Enter Choice: ");

            int menuChoice = Integer.valueOf(scanner.nextLine());

            // Ensure game starts with state set to START
            // required if a game is started after returning
            // to the main menu
            gameState = GameState.START;

            if (menuChoice == 1) {
                while (true) {
                    // START -> GET_GOAL
                    gameState = gameState.nextState(0, 0);
                    System.out.println("\n1 - Roll Dice");
                    System.out.println("2 - Quit");

                    System.out.print("Enter Choice: ");
                    int gameChoice = Integer.valueOf(scanner.nextLine());

                    if (gameChoice == 1) {
                        rollDice();

                        if (gameState.equals(GameState.WIN)) {
                            System.out.println("You win!!\n");
                        }

                        if (gameState.equals(GameState.LOSE)) {
                            System.out.println("You Lose!!\n");
                        }

                        if (gameState.equals(GameState.SEEK_GOAL)) {
                            setGoal();
                        }

                        while (gameState.equals(GameState.SEEK_GOAL)) {
                            rollDice();

                            if (gameState.equals(GameState.WIN)) {
                                System.out.println("You win!!\n");
                                break;
                            }

                            if (gameState.equals(GameState.LOSE)) {
                                System.out.println("You Lose!!\n");
                                break;
                            }
                            if (gameState.equals(GameState.SEEK_GOAL)) {
                                System.out.println("Roll again.");
                            }
                        }
                        // WIN | LOSE -> END
                        gameState = gameState.nextState(roll, 0);
                        System.out.println("Would you like to play again?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - Go to Main Menu");
                        System.out.print("Enter Choice: ");
                        gameChoice = Integer.valueOf(scanner.nextLine());

                        if (gameChoice == 1) {
                            // END -> START
                            gameState = gameState.nextState(0, 0);
                            continue;
                        }
                        if (gameChoice == 2) {
                            break;
                        }
                    }

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

    private void rollDice() {
        dice.rollDice();
        roll = dice.getSum();
        // GET_GOAL -> SEEK_GOAL
        gameState = gameState.nextState(roll, goal);
        System.out.printf("\nYou rolled %d.\n", roll);
    }

    private void setGoal() {
        goal = roll;
        System.out.printf("The goal is %d.\n", goal);
    }

}
