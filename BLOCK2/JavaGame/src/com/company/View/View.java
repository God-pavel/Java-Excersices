package com.company.View;

public class View {


    public final static String NUMBER_FROM = "Please input number from ";
    public final static String TO =" to ";
    public final static String NOT_INT_VAL = "Was entered not int value";
    public final static String OUT_OF_RANGE = "Your number is out of range";
    public final static String GAME_STARTED = "The game was started!";
    public final static String YOU_TRIED = "You tried ";
    public final static String PREVIOUS_TRIES = "The previous tries :";
    public final static String WON_GMAE = "You won the game!" + "\n" + "Number of tries = ";
    public final static String ALL_TRIES = "\n" + "All your tries: ";



    public final void printMessage(String msg){
        System.out.println(msg);
    }
    public final void printArrayElem(int elem){
        System.out.print(elem + " ");
    }


}