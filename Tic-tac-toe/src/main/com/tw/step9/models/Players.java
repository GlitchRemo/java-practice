package com.tw.step9.models;

import com.tw.step.MyArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Players {
  private final int[][] WINNING_SEQUENCES = {
      { 1, 2, 3 },
      { 4, 5, 6 },
      { 7, 8, 9 },
      { 1, 4, 7 },
      { 3, 6, 9 },
      { 2, 5, 8 },
      { 1, 5, 9 },
      { 3, 5, 7 }
  };
  private final List<Player> players;

  public Players(Player player1, Player player2) {
    this.players = Arrays.asList(player1, player2);
  }

  public Player getCurrentPlayer() {
    return this.players.get(0);
  }

  public MyArrayList<Move> getTotalMoves() {
    MyArrayList<Move> moves = new MyArrayList<>();

    for (Player player : this.players) {
      moves.addAll(player.getMoves());
    }

    return moves;
  }

  public int totalNumberOfMoves() {
    return this.getTotalMoves().size();
  }

  private boolean isPositionAlreadyOccupied(int position) {
    return this.getTotalMoves().some(move -> move.position() == position);
  }

  public void recordMove(int move) throws PositionAlreadyOccupiedException {
    if (this.isPositionAlreadyOccupied(move)) throw new PositionAlreadyOccupiedException();
    this.getCurrentPlayer().recordMove(move);
  }

  public void changeTurn() {
    Collections.reverse(this.players);
  }

  public boolean hasWon() {
    MyArrayList<Move> moves = this.getCurrentPlayer().getMoves();
    List<Integer> positions = moves.map(Move::position);

    return Arrays.stream(this.WINNING_SEQUENCES)
        .anyMatch(winningSequence -> Arrays.stream(winningSequence)
            .allMatch(positions::contains));
  }
}


