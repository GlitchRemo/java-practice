package com.tw.step9.models;

import com.tw.step.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tw.step9.models.SIGN.O;
import static com.tw.step9.models.SIGN.X;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
  Players players;
  Player riya = new Player("riya", SIGN.X);
  Player raj = new Player("raj", SIGN.O);

  @BeforeEach
  void setUp() {
    this.players = new Players(this.riya, this.raj);

    this.riya.recordMove(1);
    this.riya.recordMove(4);

    this.raj.recordMove(2);
    this.raj.recordMove(5);
  }

  @Test
  void shouldGetTheCurrentPlayer() {
    assertEquals(this.players.getCurrentPlayer(), this.riya);
  }

  @Test
  void shouldGetAllTheMovesPlayersPlayed() {
    MyArrayList<Move> moves = new MyArrayList<>();

    moves.add(new Move(1, X));
    moves.add(new Move(4, X));
    moves.add(new Move(2, O));
    moves.add(new Move(5, O));

    assertEquals(this.players.getTotalMoves(), moves);
  }

  @Test
  void shouldGiveTotalNumberOfMovesPlayersPlayed() {
    assertEquals(this.players.totalNumberOfMoves(), 4);
  }

  @Test
  void shouldThrowExceptionIfPlayerMadeMoveInAlreadyOccupiedPosition() {
    PositionAlreadyOccupiedException e = Assertions.assertThrows(PositionAlreadyOccupiedException.class, () -> this.players.recordMove(1));
    assertEquals(e.getMessage(), "Position Already Occupied");
  }

  @Test
  void shouldRecordMoveIfPlayerMadeMoveInAnUnoccupiedPosition() throws PositionAlreadyOccupiedException {
    MyArrayList<Move> moves = new MyArrayList<>();

    moves.add(new Move(1, X));
    moves.add(new Move(4, X));
    moves.add(new Move(6, X));
    moves.add(new Move(2, O));
    moves.add(new Move(5, O));

    this.players.recordMove(6);
    assertEquals(moves, this.players.getTotalMoves());
  }

  @Test
  void shouldGiveFalseIfNoPlayerHasWon() {
    assertFalse(this.players.hasWon());
  }

  @Test
  void shouldGiveTrueIfAnyPlayerHasWon() throws PositionAlreadyOccupiedException {
    this.players.recordMove(7);
    assertTrue(this.players.hasWon());
  }
}