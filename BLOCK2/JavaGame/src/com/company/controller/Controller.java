package com.company.controller;

import com.company.ConsoleImport;
import com.company.model.Game;
import com.company.view.View;

import java.util.InputMismatchException;

public class Controller {

    private Game game;
    private View view;

    public Controller(Game game, View view){
        this.game = game;
        this.view = view;
    }

    private final int getPlayerNum(){

        boolean incorrectValue = true;
        int playerNum = 0;

        while (incorrectValue){
            this.view.printMessage(View.NUMBER_FROM + this.game.getminNumber() + View.TO + this.game.getMaxNumber());
            try {
                playerNum = ConsoleImport.insertNumber();
            } catch (InputMismatchException e) {
                this.view.printMessage(View.NOT_INT_VAL);
                continue;
            }
            if ( playerNum < this.game.getMaxNumber() && playerNum > this.game.getminNumber() ){
                incorrectValue = false;
            }
            else {
                this.view.printMessage(View.OUT_OF_RANGE);
            }
        }

        return playerNum;

    }

    public final void startGame(){

        this.view.printMessage(View.GAME_STARTED);

        while(this.game.getMaxNumber() != this.game.getminNumber()){
            int playerNum = this.getPlayerNum();
            this.view.printMessage(View.YOU_TRIED + playerNum);
            this.game.comparePlayerNum(playerNum);
            this.game.increaseNumberOfTries();
            this.game.addTry(playerNum);
            this.view.printMessage(View.PREVIOUS_TRIES);
            for (int i = 0; i < this.game.getNumberOfTries(); i++){
                this.view.printArrayElem(this.game.getEnteredNumbers()[i]);
            }
            this.view.printMessage("\n");
        }

        this.view.printMessage(View.WON_GMAE + this.game.getNumberOfTries() + View.ALL_TRIES);
        for (int i = 0; i < this.game.getNumberOfTries(); i++){
            this.view.printArrayElem(this.game.getEnteredNumbers()[i]);
        }

    }
}
