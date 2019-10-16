package com.OOADLab;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck 
{
	private List<Card> cardlist;
	
	public Deck(int size)
	{
		List<Card> listofcard=new LinkedList<Card>();
		for(int i=1;i<=size;i++)
		{
		for(Card card:Card.values())
		{
			 listofcard.add(card);
		}
		}
		cardlist=listofcard;
		this.ShuffleCard();
	}
	
	public void ShuffleCard()
	{
		int size=cardlist.size();
		Random ran = new Random();
		while(size>=1)
		{
		   int radint=ran.nextInt(size);
		   cardlist.add(cardlist.get(radint));
		   cardlist.remove(radint);
		   size--;
		}
	}
	
	public Card GetFirstCard()
	{
		return cardlist.get(0);
	}
	
	public void RemoveFirstCard()
	{
		cardlist.remove(0);
	}
	
	public Card GetAndRemoveFirstCard()
	{
		Card card=cardlist.get(0);
		cardlist.remove(0);
		return card;
	}
	
	
	public int CountCardRemain()
	{
		return this.cardlist.size();
	}
}
