package com.danielcarrera;

import java.util.Scanner;

public class BetMode {

    private Player player;
    private Scanner input;
    private int betPlaced;
    private int diceSum;


    //
    // constructor for GameMode object.
    // initializes a player object.
    // initializes a scanner object for user input.
    //
    public BetMode(){
        player = new Player();
        input = new Scanner(System.in);
    }

    //
    // displays profit and end game message.
    //
    private void gameEnded(){
        player.getProfit();
        System.out.println("GAME ENDED\n");
    }

    //
    // plays the pass bet game mode.
    //
    public void passBet(){

        while (true) {

            System.out.println("Playing for a pass bet!\n");

            // prompting bet amount and optional exit
            System.out.println("How many chips would you like to bet? Enter 0 to exit.");

            // bet set by player
            betPlaced = input.nextInt();

            // exit the game if bet is 0
            if (betPlaced == 0) {
                break;
            }

            // ready scanner for new input
            input.nextLine();

            // scan for empty new line
            System.out.println("Press enter to roll the die");
            input.nextLine();

            // roll the die
            diceSum = CrapsDie.rollSum();

            // check if won
            if (diceSum == 7 || diceSum == 11) {
                player.won(betPlaced, diceSum);

                // check if lost
            } else if (diceSum == 2 || diceSum == 3 || diceSum == 12) {
                player.lost(betPlaced, diceSum);

                // play for point
            } else {

                // set the point
                player.setPoint(diceSum);
                System.out.println("The point is " + diceSum);

                while (true) {

                    // prompt user to roll again
                    System.out.println("Trying for: " + diceSum + ". Press enter to roll again");
                    input.nextLine();

                    int newDiceSum = CrapsDie.rollSum();

                    // if new roll is 7, player loses
                    if (newDiceSum == 7) {

                        player.lost(betPlaced, newDiceSum);

                        break;

                        // if new roll is the point, player wins
                    } else if (newDiceSum == player.getPoint()) {

                        player.won(betPlaced, newDiceSum);

                        break;
                    }

                    // else keep rolling
                    System.out.println("You rolled: " + newDiceSum + "!");
                }
            }
        }

        // print end game message
        gameEnded();
    }

    //
    // plays the don't pass bet game mode.
    //
    public void dontPassBet(){

        while (true) {

            System.out.println("Playing for a don't pass bet!\n");

            // prompting bet amount and optional exit
            System.out.println("How many chips would you like to bet? Enter 0 to exit.");

            // bet set by player
            betPlaced = input.nextInt();

            // exit the game if bet is 0
            if (betPlaced == 0) {
                break;
            }

            // ready scanner for new input
            input.nextLine();

            // scan for empty new line
            System.out.println("Press enter to roll the die");
            input.nextLine();

            // roll the die
            diceSum = CrapsDie.rollSum();

            // check if won
            if (diceSum == 12){
                System.out.println("Tie! You rolled: " + diceSum + "!");
                continue;
            }
            else if (diceSum == 2 || diceSum == 3) {
                player.won(betPlaced, diceSum);

                // check if lost
            } else if (diceSum == 7 || diceSum == 11) {
                player.lost(betPlaced, diceSum);

               // bet is a tie, play again
            } else {

                // set the point
                player.setPoint(diceSum);
                System.out.println("The point is " + diceSum);

                while (true) {

                    // prompt user to roll again
                    System.out.println("Trying for: " + diceSum + ". Press enter to roll again");
                    input.nextLine();

                    int newDiceSum = CrapsDie.rollSum();

                    // if new roll is the point, player loses
                    if (newDiceSum == player.getPoint()) {

                        player.lost(betPlaced, newDiceSum);

                        break;

                        // if new roll is 7, player wins
                    } else if (newDiceSum == 7) {

                        player.won(betPlaced, newDiceSum);

                        break;
                    }

                    // else keep rolling
                    System.out.println("You rolled: " + newDiceSum + "!");
                }
            }
        }

        // print end game message
        gameEnded();
    }

}
