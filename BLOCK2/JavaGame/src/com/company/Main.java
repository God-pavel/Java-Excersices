package com.company;

import com.company.Controller.Controller;
import com.company.Model.Game;
import com.company.View.View;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        View view  = new View();
        Controller controller = new Controller(game,view);

        controller.startGame();


    }
}
