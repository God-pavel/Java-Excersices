package com.company.controller;

import com.company.model.NotUniqueNickname;
import com.company.model.Notebook;
import com.company.model.Record;
import com.company.view.View;
import java.util.Locale;

public class MainController {

    private Notebook notebook;
    private View view;


    private boolean checkFirstName(String name){
        return name.matches(view.getUIManager().getString(view.FIRST_NAME_PATTERN));
    }
    private boolean checkLastName(String name){
        return name.matches(view.getUIManager().getString(view.LAST_NAME_PATTERN));
    }
    private boolean checkNickname(String name){
        return name.matches(view.getUIManager().getString(view.NICKNAME_PATTERN));
    }

    private boolean checkEmail(String name){
        return name.matches(view.getUIManager().getString(view.EMAIL_PATTERN));
    }

    private String getFirstName(){
        boolean check = false;
        String name = "";
        while (!check){
            view.printMessage(view.getUIManager().getString(view.INPUT_FIRST_NAME));
            name = InputController.inputString();
            check = checkFirstName(name);
        }
        return name;
    }
    private String getLastName(){
        boolean check = false;
        String name = "";
        while (!check){
            view.printMessage(view.getUIManager().getString(view.INPUT_LAST_NAME));
            name = InputController.inputString();
            check = checkLastName(name);
        }
        return name;
    }
    private String getNickname(){
        boolean check = false;
        String name = "";
        while (!check){
            view.printMessage(view.getUIManager().getString(view.INPUT_NICKNAME));
            name = InputController.inputString();
            check = checkNickname(name);
        }
        return name;
    }
    private String getEmail(){
        boolean check = false;
        String name = "";
        while (!check){
            view.printMessage(view.getUIManager().getString(view.INPUT_EMAIL));
            name = InputController.inputString();
            check = checkEmail(name);
        }
        return name;
    }

    public MainController(Notebook notebook, View view){
        this.notebook = notebook;
        this.view = view;
    }

    private void chooseLanguage(){
        boolean onMenu = true;
        while (onMenu) {
            view.printMessage(view.getUIManager().getString(view.MENU_LANGUAGE));
            String menuNum = InputController.inputString();
            Locale locale;
            switch (menuNum){
                case "1":
                    locale = Locale.getDefault();
                    view.getUIManager().changeResource(locale);
                    onMenu = false;
                    break;
                case "2":
                    locale = new Locale("uk","UA");
                    view.getUIManager().changeResource(locale);
                    onMenu = false;
                    break;
                case "3":
                    locale = new Locale("ru","RU");
                    view.getUIManager().changeResource(locale);
                    onMenu = false;
                    break;
                default:
                    view.printMessage(view.getUIManager().getString(view.INPUT_NUMBER));
            }
        }
    }


    public final void startController(){
        view.printMessage(view.getUIManager().getString(view.PROGRAM_STARTED));
        chooseLanguage();
        boolean onMenu = true;
        while (onMenu){
            view.printMessage(view.getUIManager().getString(view.MENU));
            String menuNum = InputController.inputString();
            switch (menuNum){
                case "1":
                    Record rec = new Record();
                    rec.setFirstName(getFirstName());
                    rec.setLastName(getLastName());
                    rec.setNickName(getNickname());
                    rec.setEmail(getEmail());
                    boolean isNicknameUnique = false;
                    while(!isNicknameUnique) {
                        try {
                            notebook.addRecord(rec);
                            isNicknameUnique = true;
                        } catch (NotUniqueNickname e) {
                            view.printMessage(view.getUIManager().getString(view.NOT_UNIQUE) + e.getLogin());
                            rec.setNickName(getNickname());
                        }
                    }
                    view.printMessage(view.getUIManager().getString(view.RECORD_ADDED));
                    break;
                case "2":
                    view.printNotebook(this.notebook);
                    break;
                case "3":
                    onMenu = false;
                    break;
                default:
                    view.printMessage(view.getUIManager().getString(view.INPUT_NUMBER));
            }
        }

    }
}
