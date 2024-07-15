package com.tw.step9.models;

import com.tw.step.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tw.step9.models.SIGN.X;

class PlayerTest {
  private Player riya;

  @BeforeEach
  void setUp() {
    this.riya = new Player("riya", X);

    this.riya.recordMove(1);
    this.riya.recordMove(2);
    this.riya.recordMove(3);
  }

  @Test
  void shouldGiveAllTheMovesPlayerPlayed() {
    MyArrayList<Move> moves = new MyArrayList<>();
    moves.add(new Move(1, X));
    moves.add(new Move(2, X));
    moves.add(new Move(3, X));

    Assertions.assertEquals(moves, this.riya.getMoves());
  }
}