package com.tw.step9.models;

import com.tw.step.MyArrayList;

public record GameState(boolean isWon, boolean isOver, Player currentPlayer, MyArrayList<Move> moves) {
}

