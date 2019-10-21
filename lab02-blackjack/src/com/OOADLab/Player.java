package com.OOADLab;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used in lab02-blackjack as a part of OOAD-Labs.
 *
 * <p>
 * This class represents a player during the game.
 *
 * @author Shangzhen Li
 */
public class Player {
	private List<Hand> hands;
	private int chipBalance;
	private int currentBet;

	/**
	 * Constructor
	 */
	Player() {
		hands = new ArrayList<>();
		addHand(); // Player has 1 hand by default.
		chipBalance = 0;
		currentBet = 0;
	}

	/**
	 * Create and add a new hand to player
	 */
	public void addHand() {
		hands.add(new Hand());
	}

	/**
	 * Add a card to a hand of player specified by number
	 * 
	 * @param c       A Card object to add
	 * @param handNum The number of hand in hands list
	 */
	protected void addCard(Card c, int handNum) {
		hands.get(handNum).addCard(c);
	}

	/**
	 * Add an amount of chip to the player
	 * 
	 * @param amount The amount of chip to add
	 */
	public void addChipBalance(int amount) {
		chipBalance += amount;
	}

	/**
	 * Apply the game reward (positive or negative) to player's chipBalance
	 * 
	 * @param reward The game reward (positive or negative)
	 */
	public void applyReward(int reward) {
		chipBalance += reward;
	}

	/**
	 * Getter for handValue
	 * 
	 * @return The hand value
	 */
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
