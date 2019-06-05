package com.company.model;

public class Game {

    private int gameNumber;
    private int maxNumber;
    private int minNumber;
    private int [] enteredNumbers;
    private int numberOfTries;

    public final int getGameNumber() {return this.gameNumber;}
    public final int getMaxNumber() {return this.maxNumber;}
    public final int getminNumber() {return this.minNumber;}
    public final int[] getEnteredNumbers() {return this.enteredNumbers;}
    public final int getNumberOfTries() {return this.numberOfTries;}

    public final void increaseNumberOfTries() {this.numberOfTries++;}
    public final void addTry(int num){
        this.enteredNumbers[this.numberOfTries-1] = num;
    }


    public Game(){
        this.gameNumber = (int)(Math.random()*99) + 1;
        this.maxNumber = 100;
        this.minNumber = 0;
        this.enteredNumbers = new int[100];
        this.numberOfTries = 0;
    }

    public final void comparePlayerNum (int playerNum){

        if (playerNum - this.gameNumber > 0){
            this.maxNumber = playerNum;
        }
        else if (playerNum - this.gameNumber < 0){
            this.minNumber = playerNum;
        }
        else {
            this.minNumber = this.maxNumber = playerNum;
        }

    }

}
