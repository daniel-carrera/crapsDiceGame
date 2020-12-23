package com.danielcarrera;

public class MonteCarloStats {

    private int repetitions;
    private double totalWins;
    private double totalLosses;

    //
    // constructor for MonteCarloStats object.
    // sets the number of total games to 10^6.
    //
    public MonteCarloStats(){
        repetitions = (int)Math.pow(10, 6);
    }

    //
    // rolls two die.
    // returns their sum as an int.
    // only used by passBet and dontPassBet methods.
    //
    private int monteCarloRoll(){

        // generate two random numbers [1,6]
        int roll1 = (int)Math.abs((Math.random() * 6) + 1);
        int roll2 = (int)Math.abs((Math.random() * 6) + 1);

        // return their sum
        return roll1 + roll2;
    }

    //
    // plays for a repetition amount pass bet games, counts wins and losses.
    // returns a double for the probability of winning.
    //
    public double passBet(){

        // each iteration counts as one game of a pass bet
        for (int i = 0; i < repetitions; i++){

            // roll the die
            int diceSum = monteCarloRoll();

            // game won
            if (diceSum == 11 || diceSum == 7){
                totalWins += 1;

              // game lost
            } else if (diceSum == 2 || diceSum == 3 || diceSum == 12){
                totalLosses += 1;

                // play for point
            } else {
                while (true){

                    // roll again
                    int newDiceSum = monteCarloRoll();

                    // game lost
                    if (newDiceSum == 7){
                        totalLosses += 1;
                        break;

                       // game won
                    } else if (newDiceSum == diceSum){
                        totalWins += 1;
                        break;
                    }
                }
            }
        }
        // return probability of winning
        return totalWins / (totalLosses + totalWins);
    }

    //
    // plays for a repetition amount of don't pass bet games, counts wins and losses.
    // returns a double for the probability of winning.
    //
    public double dontPassBet(){

        // each iteration counts as one game of a don't pass bet
        for (int i = 0; i < repetitions; i++){

            int diceSum = monteCarloRoll();

            if (diceSum == 11 || diceSum == 7){
                totalLosses += 1;

            } else if (diceSum == 2 || diceSum == 3) {
                totalWins += 1;

            }else if (diceSum == 12){
                continue;

            } else {

                while (true){

                    int newDiceSum = monteCarloRoll();

                    if (newDiceSum == 7){
                        totalWins += 1;
                        break;

                    } else if (newDiceSum == diceSum){
                        totalLosses += 1;
                        break;
                    }
                }
            }
        }
        return totalWins / (totalLosses + totalWins);
    }
}
