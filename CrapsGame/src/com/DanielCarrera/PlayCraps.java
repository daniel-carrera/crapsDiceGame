package com.danielcarrera;

import java.util.Scanner;

// TODO:
// Integrate the Dice class into craps die
// Make it so the player's wallet carries on when switching between pass and don't pass game modes, might need
// to create a player instance in the second while loop and edit the current BetMode class methods


public class PlayCraps {

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        while (true) {

            System.out.println("Enter 1 to play Craps, enter 2 to view Monte Carlo probabilities, enter 3 to exit...\n");

            int mainMode = stdin.nextInt();

            // play craps
            if (mainMode == 1) {
                while (true) {

                    System.out.println("You are playing Craps!\n\nEnter 1 to make a Pass bet, enter 2 to make a Don't Pass bet " +
                                        "enter 3 to exit to main menu...\n");
                    int betMode = stdin.nextInt();

                    // play a pass bet
                    if (betMode == 1){
                        BetMode pass = new BetMode();
                        pass.passBet();

                        // play a don't pass bet
                    } else if (betMode == 2) {
                        BetMode dontPass = new BetMode();
                        dontPass.dontPassBet();

                        // exit to main menu
                    } else if (betMode == 3){
                        System.out.println("Exiting to main menu...\n");
                        break;

                    } else {
                        System.out.println("Entered an invalid option, try again!\n");
                    }
                }

               // display probabilities
            } else if (mainMode == 2){
                MonteCarloStats stats = new MonteCarloStats();
                System.out.printf("Monte Carlo Probability of winning a pass bet: %.4f%%\n\n", stats.passBet());
                System.out.printf("Monte Carlo Probability of winning a don't pass bet: %.4f%%\n\n", stats.dontPassBet());

            // exit the program
            } else if (mainMode == 3){
                System.out.println("Ending program...");
                break;

            } else {
                System.out.println("Entered an invalid option, try again!\n");
            }

        }

    }
}
