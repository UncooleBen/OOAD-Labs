package com.OOADLab;

import java.io.IOException;

public class Main {


	  
	public static void main(String[] args) throws IOException 
	{
		Deck deck=new Deck(2);
		int length=deck.CountCardRemain();
		for(int i=0;i<length;i++)
		{
			System.out.println(deck.GetAndRemoveFirstCard());
		}
	
	}

}
