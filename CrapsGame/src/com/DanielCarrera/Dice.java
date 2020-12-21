package com.danielcarrera;

public class Dice {

    // number of faces in dice.
    private int faces;

    //
    // default constructor if no faces are given.
    //
    public Dice(){

        // default faces is 6.
        this.faces = 6;
    }

    //
    // 2nd constructor if faces argument is given.
    // faces represents the number of dice faces
    //
    public Dice(int faces){
        this.faces = faces;
    }

    //
    // performs a random dice roll.
    // returns an int between [1,faces].
    //
    public int roll(){
        return (int)Math.abs((Math.random() * faces) + 1);
    }




}
