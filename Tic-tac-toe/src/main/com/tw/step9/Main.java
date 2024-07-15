package com.tw.step9;

import com.tw.step9.controller.GameController;
import com.tw.step9.controller.InputController;
import com.tw.step9.controller.KeyboardController;
import com.tw.step9.models.Game;
import com.tw.step9.models.Player;
import com.tw.step9.models.Players;
import com.tw.step9.models.SIGN;
import com.tw.step9.view.View;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Player riya = new Player("riya", SIGN.X);
    Player raj = new Player("raj", SIGN.O);

    Players players = new Players(riya, raj);
    Game game = new Game(players);
    View view = new View();

    Scanner scanner = new Scanner(System.in);
    InputController keyboardController = new KeyboardController(scanner);

    GameController gameController = new GameController(game, view, keyboardController);
    gameController.start();
  }
}
