package com.danielcarrera;

public class Player {

    private int wallet = 0;
    private int point;

    // win and loss variables are used by statistics module
    private int numWins = 0;
    private int numLosses = 0;

    //
    // Default constructor for player
    // sets wallet amount to 10
    //
    public Player(){
        wallet = 10;
    }

    //
    // 2nd constructor for player
    // sets the wallet amount to
    //
    public Player(int money){
        wallet = money;
    }

    //
    // if player wins, add money to wallet
    //
    public void won(int money){
        wallet += money;
    }

    //
    // if player loses, remove money from wallet
    //
    public void lost(int money){
        wallet -= money;
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
    // returns number of wins.
    //
    public int getWins(){
        return numWins;
    }

    //
    // returns number of losses.
    //
    public int getLosses(){
        return numLosses;
    }

    //
    // increments total wins by 1.
    //
    public void addWin(){
        numWins+= 1;
    }

    //
    // increments total losses by 1.
    //
    public void addLoss(){
        numLosses += 1;
    }


}
