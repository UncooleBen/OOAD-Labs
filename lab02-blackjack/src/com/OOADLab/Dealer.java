package com.OOADLab;

/**
 * This class is used in lab02-blackjack as a part of OOAD-Labs.
 *
 * <p>This class represents a dealer during the game. The class extends Player because dealer is a
 * special player logically.
 *
 * @author Shangzhen Li
 */
public class Dealer extends Player {
  public void dealDealer(Deck d) {
    addCard(d.GetAndRemoveFirstCard(), 0);
  }

  public void dealPlayer(Player p, Deck d) {
    p.addCard(d.GetAndRemoveFirstCard(), 0);
  }
}
