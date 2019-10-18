package com.OOADLab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import jdk.jfr.Unsigned;

public class Player 
{
	private List<Hand> hands;
  private int chipBalance;
  private int currentBet;
  Player()
  {
    hands=new ArrayList<>();
    chipBalance=0;
    currentBet=0;
  }
  public void addCard(Card c, int handNum)
  {
    hands.get(handNum).addCard(c);
  }
  public void addChipBalance(int amount)
  {
    chipBalance+=amount;
  }
  public void applyReward(int reward)
  {
    currentBet+=reward;
  }
  public int getHandValue(int handNum)
  {
    return hands.get(handNum).calculateValue();
  }

  public int getChipBalance() {
    return chipBalance;
  }
}
