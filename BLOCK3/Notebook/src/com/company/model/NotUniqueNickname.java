package com.company.model;

public class NotUniqueNickname extends Exception {
    private String login;

    public NotUniqueNickname (String login){
        this.login = login;
    }
    public final String getLogin(){
        return login;
    }

}
