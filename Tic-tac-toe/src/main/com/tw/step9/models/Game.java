package com.tw.step9.models;

public class Game {
  private final Players players;
  private final int maxMoves;
  private boolean hasDrawn;
  private boolean hasWon;

  public Game(Players players) {
    this.players = players;
    this.hasDrawn = false;
    this.hasWon = false;
    this.maxMoves = 9;
  }

  private boolean isInvalid(int move) {
    return move < 1 || move > 9;
  }

  public void recordMove(int move) throws PositionAlreadyOccupiedException, InvalidMoveException {
    if (this.isInvalid(move)) {
      throw new InvalidMoveException();
    }

    this.players.recordMove(move);

    if (this.players.hasWon()) {
      this.hasWon = true;
      return;
    }

    if (this.players.totalNumberOfMoves() == this.maxMoves) {
      this.hasDrawn = true;
      return;
    }

    this.players.changeTurn();
  }

  public GameState state() {
    return new GameState(
        this.hasWon,
        this.hasDrawn,
        this.players.getCurrentPlayer(),
        this.players.getTotalMoves()
    );
  }
}
