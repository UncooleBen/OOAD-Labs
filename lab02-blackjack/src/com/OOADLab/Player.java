package com.OOADLab;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used in lab02-blackjack as a part of OOAD-Labs.
 *
 * <p>This class represents a player during the game.
 *
 * @author Shangzhen Li
 */
public class Player {
  private List<Hand> hands;
  private int chipBalance;
  private int currentBet;

  Player() {
    hands = new ArrayList<>();
    addHand(); // Player has 1 hand by default.
    chipBalance = 0;
    currentBet = 0;
  }

  public void addHand() {
    hands.add(new Hand());
  }

  protected void addCard(Card c, int handNum) {
    hands.get(handNum).addCard(c);
  }

  public void addChipBalance(int amount) {
    chipBalance += amount;
  }

  public void applyReward(int reward) {
    chipBalance += reward;
  }

  public int getHandValue(int handNum) {
    return hands.get(handNum).calculateValue();
  }

  public void payBet(int amount) {
    currentBet = amount;
    chipBalance -= amount;
  }

  public int getChipBalance() {
    return chipBalance;
  }

  public int getCurrentBet() {
    return currentBet;
  }

  public Hand getHand(int handNum) {
    return hands.get(handNum);
  }

  public void resetHand() {
    hands.clear();
    hands.add(new Hand());
  }
}
