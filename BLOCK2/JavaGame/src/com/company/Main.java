package com.company;

import com.company.controller.Controller;
import com.company.model.Game;
import com.company.view.View;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        View view  = new View();
        Controller controller = new Controller(game,view);

        controller.startGame();


    }
}
