package com.tw.step9.models;

import com.tw.step.MyArrayList;

public class Player {
  public final String name;
  public final SIGN sign;
  private final MyArrayList<Move> moves = new MyArrayList<>();

  public Player(String name, SIGN sign) {
    this.name = name;
    this.sign = sign;
  }

  public void recordMove(int position) {
    Move move = new Move(position, this.sign);
    this.moves.add(move);
  }

  public MyArrayList<Move> getMoves() {
    return new MyArrayList<>(this.moves);
  }
}
