package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleImport {

    public final static int insertNumber() throws InputMismatchException {
        Scanner in = new Scanner(System.in);
        int  number = in.nextInt();
        return number;
    }
}
