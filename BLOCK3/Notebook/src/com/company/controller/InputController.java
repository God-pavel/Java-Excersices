package com.company.controller;
import java.util.Scanner;

public class InputController {
    public static String inputString(){
        Scanner in = new Scanner(System.in);
        String  str = in.nextLine();
        return str;
    }
}
