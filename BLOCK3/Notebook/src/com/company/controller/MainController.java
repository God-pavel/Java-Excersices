package com.company.controller;

import com.company.model.Notebook;
import com.company.model.Record;
import com.company.view.View;

public class MainController {

    private Notebook notebook;
    private View view;


    private boolean checkFirstName(String name){
        return name.matches(view.FIRST_NAME_PATTERN_EN) || name.matches(view.FIRST_NAME_PATTERN_UA);
    }
    private boolean checkLastName(String name){
        return name.matches(view.LAST_NAME_PATTERN_EN) || name.matches(view.LAST_NAME_PATTERN_UA);
    }
    private boolean checkNickname(String name){
        return name.matches(view.NICKNAME_PATTERN);
    }
    private boolean checkEmail(String name){
        return name.matches(view.EMAIL_PATTERN);
    }
    private String getFirstName(){
        boolean check = false;
        String name = "";
        while (!check){
            view.printMessage(view.INPUT_FIRST_NAME);
            name = InputController.inputString();
            check = checkFirstName(name);
        }
        return name;
    }
    private String getLastName(){
        boolean check = false;
        String name = "";
        while (!check){
            view.printMessage(view.INPUT_LAST_NAME);
            name = InputController.inputString();
            check = checkLastName(name);
        }
        return name;
    }
    private String getNickname(){
        boolean check = false;
        String name = "";
        while (!check){
            view.printMessage(view.INPUT_NICKNAME);
            name = InputController.inputString();
            check = checkNickname(name);
        }
        return name;
    }
    private String getEmail(){
        boolean check = false;
        String name = "";
        while (!check){
            view.printMessage(view.INPUT_EMAIL);
            name = InputController.inputString();
            check = checkEmail(name);
        }
        return name;
    }

    public MainController(Notebook notebook, View view){
        this.notebook = notebook;
        this.view = view;
    }



    public final void startController(){
        view.printMessage(view.PROGRAM_STARTED);
        boolean onMenu = true;
        while (onMenu){
            view.printMessage(view.MENU);
            String menuNum = InputController.inputString();
            switch (menuNum){
                case "1":
                    Record rec = new Record();
                    rec.setFirstName(getFirstName());
                    rec.setLastName(getLastName());
                    rec.setNickName(getNickname());
                    rec.setEmail(getEmail());
                    notebook.addRecord(rec);
                    view.printMessage(view.RECORD_ADDED);
                    break;
                case "2":
                    view.printNotebook(this.notebook);
                    break;
                case "3":
                    onMenu = false;
                    break;
                default:
                    view.printMessage(view.INPUT_NUMBER);
            }
        }

    }
}
