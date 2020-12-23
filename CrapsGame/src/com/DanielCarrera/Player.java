package com.danielcarrera;

public class Player {

    private int wallet;
    private int point;
    private int moneyWon;
    private int moneyLost;

    //
    // Default constructor for player
    // sets wallet amount to 10
    //
    public Player(){
        wallet = 10;
    }

    //
    // 2nd constructor for player
    // sets custom wallet amount
    //
    public Player(int money){
        wallet = money;
    }

    //
    // sets a point by the player
    //
    public void setPoint(int point){
        this.point = point;
    }

    //
    // returns current point set by player
    //
    public int getPoint(){
        return point;
    }

    //
    // returns current money in wallet.
    //
    public int getWallet(){
        return wallet;
    }

    //
    // if player wins, add money to wallet and total money won
    // print win message and current bank roll
    //
    public void won(int money, int diceSum){
        wallet += money;
        moneyWon += money;
        System.out.println("Sum is: " + diceSum + ". You have won!");
        System.out.println("Your new bank roll is: " + getWallet() + "$\n");
    }

    //
    // if player loses, remove money from wallet and add to total money lost
    // print loss message and current bank roll
    //
    public void lost(int money, int diceSum){
        wallet -= money;
        moneyLost += money;
        System.out.println("Sum is: " + diceSum + ". You have lost!");
        System.out.println("Your new bank roll is: " + getWallet() + "$\n");
    }

    //
    // return a player's profit
    //
    public void getProfit(){
        System.out.println("Your profit is: " + (moneyWon - moneyLost) + "$!");
    }

}
