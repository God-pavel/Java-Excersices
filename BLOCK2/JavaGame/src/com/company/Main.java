package com.company;

import com.company.Controller.Controller;
import com.company.Model.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Controller controller = new Controller(game);

        controller.startGame();

    }
}
