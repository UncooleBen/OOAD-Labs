package com.OOADLab;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * This class is used in lab02-blackjack as a part of OOAD-Labs.
 *
 * <p>
 * This class represents a card deck in the game.
 *
 * @author Yuanjie Guo, Juntao Peng
 */
public class Deck {
	private List<Card> cardList;

	/**
	 * Constructor of Deck.
	 * 
	 * @param size The size of deck in suit number
	 */
	public Deck(int size) {
		List<Card> listOfCard = new LinkedList<Card>();
		for (int i = 1; i <= size; i++) {
			for (Card card : Card.values()) {
				listOfCard.add(card);
			}
		}
		cardList = listOfCard;
		this.ShuffleCard();
	}

	/**
	 * Shuffles the cards in the deck.
	 */
	public void ShuffleCard() {
		int size = cardList.size();
		Random ran = new Random();
		while (size >= 1) {
			int radint = ran.nextInt(size);
			cardList.add(cardList.get(radint));
			cardList.remove(radint);
			size--;
		}
	}

	public Card GetFirstCard() {
		return cardList.get(0);
	}

	public void RemoveFirstCard() {
		cardList.remove(0);
	}

	public Card GetAndRemoveFirstCard() {
		Card card = cardList.get(0);
		cardList.remove(0);
		return card;
	}

	public int CountCardRemain() {
		return this.cardList.size();
	}
}
