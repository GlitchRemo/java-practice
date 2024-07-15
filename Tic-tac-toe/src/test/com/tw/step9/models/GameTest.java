package com.tw.step9.models;

import com.tw.step.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tw.step9.models.SIGN.O;
import static com.tw.step9.models.SIGN.X;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
  Game game;
  Player riya = new Player("riya", SIGN.X);
  Player raj = new Player("raj", SIGN.O);

  @BeforeEach
  void setUp() {
    Players players = new Players(this.riya, this.raj);
    this.game = new Game(players);
  }

  private MyArrayList<Move> getGameWonMoves() {
    MyArrayList<Move> moves = new MyArrayList<>();

    moves.add(new Move(1, X));
    moves.add(new Move(5, X));
    moves.add(new Move(9, X));
    moves.add(new Move(2, O));
    moves.add(new Move(3, O));

    return moves;
  }

  private MyArrayList<Move> getGameDrawMoves() {
    MyArrayList<Move> moves = new MyArrayList<>();

    moves.add(new Move(1, X));
    moves.add(new Move(2, X));
    moves.add(new Move(7, X));
    moves.add(new Move(6, X));
    moves.add(new Move(8, X));
    moves.add(new Move(5, O));
    moves.add(new Move(3, O));
    moves.add(new Move(4, O));
    moves.add(new Move(9, O));

    return moves;
  }

  private void recordGameWonMoves() throws PositionAlreadyOccupiedException, InvalidMoveException {
    this.game.recordMove(1);
    this.game.recordMove(2);
    this.game.recordMove(5);
    this.game.recordMove(3);
    this.game.recordMove(9);
  }

  private void recordGameDrawnMoves() throws PositionAlreadyOccupiedException, InvalidMoveException {
    this.game.recordMove(1);
    this.game.recordMove(5);
    this.game.recordMove(2);
    this.game.recordMove(3);
    this.game.recordMove(7);
    this.game.recordMove(4);
    this.game.recordMove(6);
    this.game.recordMove(9);
    this.game.recordMove(8);
  }

  @Test
  void shouldWinTheGameIfAnyPlayerHasWon() throws PositionAlreadyOccupiedException, InvalidMoveException {
    MyArrayList<Move> moves = this.getGameWonMoves();
    this.recordGameWonMoves();

    GameState state = new GameState(true, false, this.riya, moves);
    assertEquals(this.game.state(), state);
  }

  @Test
  void shouldDrawTheGameIfAllPositionsAreOccupied() throws PositionAlreadyOccupiedException, InvalidMoveException {
    MyArrayList<Move> moves = this.getGameDrawMoves();
    this.recordGameDrawnMoves();

    GameState state = new GameState(false, true, this.riya, moves);
    assertEquals(this.game.state(), state);
  }

  @Test
  void shouldThrowInvalidMoveExceptionIfPlayerEnterInvalidMove() {
    InvalidMoveException e = assertThrows(InvalidMoveException.class, () -> this.game.recordMove(10));
    assertEquals(e.getMessage(), "Invalid input. Please enter a number between 1-9");
  }
}