package com.danielcarrera;

public class CrapsDie {

    //
    // Displays the faces of two die rolls side by side
    // expects two roll values as ints
    //
    public static void displayRoll(int roll1, int roll2) {
        String topDice = " _______ ";
        String topDiceSides = "|       |";
        String[] faces = {"|       |",
                "|   *   |",
                "|       |",

                "|     * |",
                "|       |",
                "| *     |",

                "|     * |",
                "|   *   |",
                "| *     |",

                "| *   * |",
                "|       |",
                "| *   * |",

                "| *   * |",
                "|   *   |",
                "| *   * |",

                "| *   * |",
                "| *   * |",
                "| *   * |"};
        String bottomDice = "|_______|";

        // print top of die
        System.out.println(topDice + " " + topDice);
        System.out.println(topDiceSides + " " + topDiceSides);

        // print content of die
        for (int i = 0; i < 3; i++){
            int face1 = (roll1 - 1) * 3 + i;
            int face2 = (roll2 - 1) * 3 + i;
            System.out.println(faces[face1] + " " + faces[face2]);
        }

        // print bottom of die
        System.out.println(bottomDice + " " + bottomDice);
    }

    //
    // rolls two die
    // displays their values and returns their sum
    //
    public static int rollSum(){

        // create two random numbers from [1, 6]
        int roll1 = (int)Math.abs((Math.random() * 6) + 1);
        int roll2 = (int)Math.abs((Math.random() * 6) + 1);

        displayRoll(roll1, roll2);

        return roll1 + roll2;
    }

}
