package com.company.Controller;

import com.company.ConsoleImport;
import com.company.Model.Game;
import com.company.View.View;

import java.util.InputMismatchException;

public class Controller {

    private Game game;

    public Controller(Game game){
        this.game = game;
    }

    private final int getPlayerNum(){

        boolean incorrectValue = true;
        int playerNum = 0;

        while (incorrectValue){
            View.printMessage("Please input number from " + this.game.getminNumber() + " to " + this.game.getMaxNumber());
            try {
                playerNum = ConsoleImport.insertNumber();
            } catch (InputMismatchException e) {
                View.printMessage("Was entered not int value");
                continue;
            }
            if ( playerNum < this.game.getMaxNumber() + 1 && playerNum > this.game.getminNumber() - 1){
                incorrectValue = false;
            }
            else {
                View.printMessage("Your number is out of range");
            }
        }

        return playerNum;

    }

    public final void startGame(){

        View.printMessage("The game was started!");

        while(this.game.getMaxNumber() != this.game.getminNumber()){
            int playerNum = this.getPlayerNum();
            View.printMessage("You tried " + playerNum);
            this.game.comparePlayerNum(playerNum);
            this.game.increaseNumberOfTries();
            this.game.addTry(playerNum);
            View.printMessage("The previous tries :");
            for (int i = 0; i < this.game.getNumberOfTries(); i++){
                View.printArrayElem(this.game.getEnteredNumbers()[i]);
            }
            View.printMessage("\n");
        }

        View.printMessage("You won the game!" + "\n" + "Number of tries = " + this.game.getNumberOfTries() + "\n" +
                "All your tries: ");
        for (int i = 0; i < this.game.getNumberOfTries(); i++){
            View.printArrayElem(this.game.getEnteredNumbers()[i]);
        }

    }
}
