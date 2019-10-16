package com.OOADLab;

import java.util.LinkedList;
import java.util.List;

public class Player 
{
	private List<Card> cardinhand;
	
	public Player()
	{
		cardinhand=new LinkedList<Card>();
	}
	
	
	public void DrawCardFirst(Deck deck)
	{
		cardinhand.add(deck.GetAndRemoveFirstCard());
		cardinhand.add(deck.GetAndRemoveFirstCard());
	}
	
	
	public void AddCard(Card card)
	{
		this.cardinhand.add(card);
	}
	
	public int GetcardinhandCount()
	{
		return this.cardinhand.size();
	}
	
	public int GetcardinhandValue()
	{
		int value=0;
		//TODO
		return value;
	}
}
