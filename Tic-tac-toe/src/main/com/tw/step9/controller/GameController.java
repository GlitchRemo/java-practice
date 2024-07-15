package com.tw.step9.controller;

import com.tw.step9.models.Game;
import com.tw.step9.models.InvalidMoveException;
import com.tw.step9.models.PositionAlreadyOccupiedException;
import com.tw.step9.view.View;

import java.util.InputMismatchException;

public class GameController {
  private final Game game;
  private final View view;
  private final InputController inputController;

  public GameController(Game game, View view, InputController inputController) {
    this.game = game;
    this.view = view;
    this.inputController = inputController;
  }

  public void start() {
    this.view.render(this.game.state());

    while (!this.game.state().isOver() && !this.game.state().isWon()) {
      try {
        int move = this.inputController.nextInput();
        this.game.recordMove(move);
        this.view.render(this.game.state());
      } catch (PositionAlreadyOccupiedException | InvalidMoveException e) {
        System.out.println(e.getMessage());
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number between 1-9");
        this.inputController.consumeInput();
      }
    }
  }
}
