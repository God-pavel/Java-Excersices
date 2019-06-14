package com.company.view;

import com.company.controller.ResourceController;
import com.company.model.Notebook;
import com.company.model.Record;

public class View {
    private ResourceController uiManager;

    public final String FIRST_NAME_PATTERN = "regexp.firstname";
    public final String LAST_NAME_PATTERN = "regexp.lastname";
    public final String NICKNAME_PATTERN = "regexp.nickname";
    public final String EMAIL_PATTERN = "regexp.email";
    public final String COMMENT_PATTERN = "regexp.comment";
    public final String GROUP_PATTERN = "regexp.group";
    public final String HOME_PHONE_NUMBER_PATTERN = "regexp.phone.home";
    public final String PHONE_NUMBER_PATTERN = "regexp.phone";
    public final String SKYPE_PATTETN = "regexp.skype";
    public final String ADRES_PATTERN = "regexp.adres";
    public final String DATE_PATTERN = "regexp.date";

    public final String NOT_UNIQUE = "notUnique";
    public final String PROGRAM_STARTED = "menu.start";
    public final String RECORD_ADDED = "record.added";
    public final String INPUT_NUMBER = "input.number";
    public final String INPUT_FIRST_NAME = "input.firstname";
    public final String INPUT_LAST_NAME = "input.lastname";
    public final String INPUT_NICKNAME = "input.nickname";
    public final String INPUT_EMAIL = "input.email";
    public final String MENU = "menu";
    public final String MENU_LANGUAGE = "menu.language";
    public final String EMPTY = "empty";

    public View(){
        this.uiManager = ResourceController.USER_INTERFACE;
    }
    public final ResourceController getUIManager(){
        return this.uiManager;
    }

    public final void printMessage(String mes) {
        System.out.println(mes);
    }

    public final void printRecord(Record record){
        System.out.println(record.getFirstName() + "; " + record.getLastName() +
                "; " + record.getNickName() + "; " + record.getEmail() + ";");
    }

    public final void printNotebook(Notebook notebook){
        if (notebook.getRecords().size() == 0){
            System.out.println(uiManager.getString(EMPTY));
        } else {
            for (Record rec : notebook.getRecords()) {
                printRecord(rec);
            }
        }
        System.out.println();
    }
}
