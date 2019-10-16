package com.OOADLab;

import java.util.LinkedList;
import java.util.List;

public class Dealer 
{
	private List<Card> cardinhand;
	
	public Dealer()
	{
		cardinhand=new LinkedList<Card>();
	}
	
	
	
	
	
	public void DealCard(Deck deck,Player player)
	{
		Card card=deck.GetAndRemoveFirstCard();
		player.AddCard(card);
	}
	
	public void DrawCardStart(Deck deck)
	{
		cardinhand.add(deck.GetAndRemoveFirstCard());
		cardinhand.add(deck.GetAndRemoveFirstCard());
	}
	
	public int GetCardValue()
	{
		int value=0;
		//TODO
		return value;
	}
	
	public void DrawCardTO17(Deck deck)
	{
	      while(this.GetCardValue()<17)
	      {
	    	  this.cardinhand.add(deck.GetAndRemoveFirstCard());
	      }
	      
	}
}
