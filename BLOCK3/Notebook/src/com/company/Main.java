package com.company;

import com.company.controller.MainController;
import com.company.model.Notebook;
import com.company.view.View;

public class Main {

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        View view  = new View();
        MainController controller = new MainController(notebook,view);

        controller.startController();
    }
}
