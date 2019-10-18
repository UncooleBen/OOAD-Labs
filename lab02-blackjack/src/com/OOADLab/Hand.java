package com.OOADLab;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used in lab02-blackjack as a part of OOAD-Labs.
 *
 * <p>This class represents a hand during the game.
 *
 * @author Shangzhen Li
 */
public class Hand {
  private List<Card> cards;

  Hand() {
    cards = new ArrayList<>();
  }

  public void addCard(Card c) {
    cards.add(c);
  }
  /**
   * This function calculate the total value of the current hand.
   *
   * <p>If the current hand has 'A's, the value of 'A' is calculated according to the following
   * rule:
   *
   * <p>If 'A' representing 11 leads to the sum value greater than 21, this 'A' will be considered
   * as 1.
   *
   * <p>Otherwise, 'A' will be considered as 11 to make the sum value as closer to 21 as possible.
   */
  public int calculateValue() {
    int result = 0, countA = 0;
    String faceValue;
    for (Card c : cards) {
      faceValue = c.GetValue();
      if (!faceValue.equals("A")) {
        result += Integer.parseInt(faceValue);
      } else {
        countA++; // Value of 'A' should be decided at the last.
      }
    }
    for (int i = 0; i < countA; i++) {
      result += (result + 11 <= 21) ? 11 : 1;
    }
    return result;
  }

  public List<Card> getCards() {
    return cards;
  }
}
