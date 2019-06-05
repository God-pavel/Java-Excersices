package com.company.view;

import com.company.model.Notebook;
import com.company.model.Record;

public class View {
    public final String FIRST_NAME_PATTERN_UA = "^[А-ЩЮЯІЇЄҐ][а-щьюяїієґ]{2,20}$";
    public final String LAST_NAME_PATTERN_UA = "^[А-ЩЮЯІЇЄҐ][а-щьюяїієґ-]{2,20}$";
    public final String FIRST_NAME_PATTERN_EN = "^[A-Z][a-z]{2,20}$";
    public final String LAST_NAME_PATTERN_EN = "^[A-Z][a-z-]{2,20}$";
    public final String NICKNAME_PATTERN = "^[A_Za-zА-ЩЮЯІЇЄҐа-щьюяїієґ0-9_-]{3,16}$";
    public final String EMAIL_PATTERN = "^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$";
    public final String PROGRAM_STARTED = "Program was started!";
    public final String RECORD_ADDED = "Your record was added!";
    public final String INPUT_NUMBER = "Please input number from 1 to 3";
    public final String INPUT_FIRST_NAME = "Please enter first name";
    public final String INPUT_LAST_NAME = "Please enter last name";
    public final String INPUT_NICKNAME = "Please enter nickname";
    public final String INPUT_EMAIL = "Please enter email";
    public final String MENU = "Enter 1 to make a record; \nEnter 2 to show notebook; \nEnter 3 to exit;";

    public final void printMessage(String mes) {
        System.out.println(mes);
    }

    public final void printRecord(Record record){
        System.out.println("First name: " + record.getFirstName() + "; Last name: " + record.getLastName() +
                "; Nickname: " + record.getNickName() + "; Email: " + record.getEmail() + ";");
    }

    public final void printNotebook(Notebook notebook){
        if (notebook.getRecords().size() == 0){
            System.out.println("Notebook is empty.");
        } else {
            for (Record rec : notebook.getRecords()) {
                printRecord(rec);
            }
        }
    }
}
