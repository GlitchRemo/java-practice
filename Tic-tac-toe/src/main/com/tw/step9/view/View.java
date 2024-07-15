package com.tw.step9.view;

import com.tw.step9.models.GameState;
import com.tw.step9.models.Move;
import com.tw.step9.models.Player;

import java.util.Objects;

public class View {
  private final String[] board = new String[9];

  private void renderBoard() {
    for (int row = 1; row < 10; row++) {
      String sign = this.board[row - 1];

      System.out.print(Objects.requireNonNullElse(sign, " "));
      System.out.print(" | ");

      if (row % 3 == 0) {
        System.out.println();
      }
    }
  }

  public void render(GameState state) {
    Player currentPlayer = state.currentPlayer();

    for (Move move : state.moves()) {
      this.board[move.position() - 1] = move.sign().name();
    }

    this.renderBoard();

    if (state.isWon()) {
      System.out.println(currentPlayer.name + " won");
      return;
    }

    if (state.isOver()) {
      System.out.println("Game Draw");
      return;
    }

    System.out.println(currentPlayer.name + "[" + currentPlayer.sign + "]" + "'s turn");
  }
}

