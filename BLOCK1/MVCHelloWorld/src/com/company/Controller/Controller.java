package com.company.Controller;

import com.company.ConsoleImport;
import com.company.Model.Model;
import com.company.View.View;

public class Controller {

    private static final String HELLO = "Hello";
    private static final String WORLD = "world!";


    private final String checkStringInput(String correctString){

        String stringInput = "";
        boolean isInputIcorrect = true;

        while(isInputIcorrect){
            View.printMessage("Enter" + " \"" + correctString + "\"");
            stringInput = ConsoleImport.insertString();
            if (stringInput.equals(correctString)){
                isInputIcorrect = false;
            }
            else {
                View.printMessage(View.WRONG_INPUT);
            }
        }
        return stringInput;
    }

    public final void startController(){

        String firstStr;
        String secondStr;

        firstStr = checkStringInput(HELLO);
        secondStr = checkStringInput(WORLD);

        View.printMessage(Model.connect(firstStr,secondStr));


    }

}
