package com.company;

import com.company.controller.MainController;
import com.company.model.Notebook;
import com.company.view.View;

public class Main {

    public static void main(String[] args) {

        MainController controller = new MainController(new Notebook (), new View());

        controller.startController();
    }
}
