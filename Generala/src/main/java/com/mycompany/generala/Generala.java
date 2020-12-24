/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

/**
 *
 * @author Marcelo
 */
public class Generala {
    
    private int[] dice = new int[5];
    
    public Generala(int... dice){
        this.dice = dice;
    }
    
    public static int chance(int... dice){
        int total = 0;
        for (int die : dice)
            total += die;
        return total;
    }

    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    public static int generala(int... dice){
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }
    
    private static int diceEquals(int number,int...dice){
        int total = 0;
        for (int die : dice)
            if(die == number) total += number;
        
        return total;
    }
    
    public static int ones(int...dice) {
        int total = diceEquals(1, dice);

        return total;
    }

    public static int twos(int...dice) {
        int total = diceEquals(2, dice);

        return total;
    }

    public static int threes(int...dice) {
        int total = diceEquals(3, dice);

        return total;
    }

    public int fours(){
        int total = diceEquals(4, dice);

        return total;
    }

    public int fives(){
        int total = diceEquals(5, dice);

        return total;
    }

    public int sixes(){
        int total = diceEquals(6, dice);

        return total;
    }
    
    private static int[] getCounts(int... dice){
        int[] counts = new int[6];
        for(int die :dice)
            counts[die-1]++;
        
        return counts;
    }

    public static int score_pair(int... dice){
        int[] counts = getCounts(dice);
        for (int i = 0; i < 6; i++)
            if (counts[5-i] >= 2)
                return (6-i)*2;
        return 0;
    }

    public static int two_pair(int... dice)
    {
        int[] counts = getCounts(dice);
        int pairs = 0, score = 0;
        for (int i = 0; i < 6; i++)
            if (counts[5-i] >= 2) {
                pairs++;
                score += (6-i);
            }        
        if (pairs == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int... dice){
        int[] counts = getCounts(dice);
        for (int i = 0; i < 6; i++)
            if (counts[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int... dice){
        int[] counts = getCounts(dice);
        for (int i = 0; i < 6; i++)
            if (counts[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int... dice){
        int[] counts = getCounts(dice);
        if (counts[0] == 1 &&
            counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int... dice){
        int[] counts = getCounts(dice);
        if (counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1 &&
            counts[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int... dice){
        boolean pairExist = false,trioExist = false;
        int pair_of = 0;
        int trio_of = 0;

        int[] counts = getCounts(dice);

        for (int i = 0; i < 6; i += 1)
            if (counts[i] == 2) {
                pairExist = true;
                pair_of = i+1;
            }

        for (int i = 0; i < 6; i += 1)
            if (counts[i] == 3) {
                trioExist = true;
                trio_of = i+1;
            }

        if (pairExist && trioExist)
            return pair_of * 2 + trio_of * 3;
        else
            return 0;
    }
}

