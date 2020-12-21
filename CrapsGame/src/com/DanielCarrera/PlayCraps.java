package com.danielcarrera;
import java.util.Scanner;

// TODO:
// When entering bet amount, after pressing enter, it triggers the press enter to roll dice, fix that
// add a way to exit the game when won or lost
// make rolling a specific key, such as space bar, make exit backspace when won or lost
// simplify printing when winning, losing, bankroll etc, make a separate class maybe


public class PlayCraps {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Player player = new Player();

        int betPlaced;

        while (true){
            System.out.println("How many chips would you like to bet?");

            // bet set by player
            betPlaced = input.nextInt();

            // scan for empty new line

            System.out.println("Press enter to roll the dice");

            String enter = input.nextLine();
            if (enter.equals("")){

                // roll the die
                int dice_sum = CrapsDie.rollSum();

                // check if won
                if (dice_sum == 7 || dice_sum == 11){
                    player.won(betPlaced);

                    System.out.println("Sum is: " + dice_sum + " you have won!");
                    System.out.println("Your new bank roll is: " + player.getWallet());

                  // check if lost
                } else if (dice_sum == 2 || dice_sum == 3 || dice_sum == 12){
                    player.lost(betPlaced);

                    System.out.println("Sum is: " + dice_sum + " you have lost!");
                    System.out.println("Your new bank roll is: " + player.getWallet());

                // play for point
                } else {
                    System.out.println("The point is " + dice_sum);

                    // prompt user to roll again
                    System.out.println("Trying for: " + dice_sum + " press enter to roll again");
                    enter = input.nextLine();

                    if (enter.equals("")){

                        while (true){

                            // set the point & roll the die
                            player.setPoint(dice_sum);
                            int newDiceSum = CrapsDie.rollSum();

                            // if new roll is 7, player loses
                            if (newDiceSum == 7){
                                player.lost(betPlaced);

                                System.out.println("You have lost!");
                                System.out.println("Your new bank roll is: " + player.getWallet());
                                break;

                              // if new roll is point, player wins
                            } else if (newDiceSum == player.getPoint()){
                                player.won(betPlaced);

                                System.out.println("You have won!");
                                System.out.println("Your new bank roll is: " + player.getWallet());
                                break;
                            }
                        }
                    }
                }

            } else {
                System.out.println("User did not press enter");
                break;
            }
        }
        System.out.println("GAME ENDED");
    }
}
