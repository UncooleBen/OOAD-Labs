package com.OOADLab;

/**
 * This class is used in lab02-blackjack as a part of OOAD-Labs.
 *
 * <p>
 * This class represents a single card in the game. The class is an enum as it
 * is horrible to define 54 separate classes.
 *
 * @author Yuanjie Guo, Juntao Peng
 */
public enum Card {
	SPADE_A("A"), SPADE_2("2"), SPADE_3("3"), SPADE_4("4"), SPADE_5("5"), SPADE_6("6"), SPADE_7("7"), SPADE_8("8"),
	SPADE_9("9"), SPADE_10("10"), SPADE_J("10"), SPADE_Q("10"), SPADE_K("10"), HEART_A("A"), HEART_2("2"), HEART_3("3"),
	HEART_4("4"), HEART_5("5"), HEART_6("6"), HEART_7("7"), HEART_8("8"), HEART_9("9"), HEART_10("10"), HEART_J("10"),
	HEART_Q("10"), HEART_K("10"), CLUB_A("A"), CLUB_2("2"), CLUB_3("3"), CLUB_4("4"), CLUB_5("5"), CLUB_6("6"),
	CLUB_7("7"), CLUB_8("8"), CLUB_9("9"), CLUB_10("10"), CLUB_J("10"), CLUB_Q("10"), CLUB_K("10"), DIAMOND_A("A"),
	DIAMOND_2("2"), DIAMOND_3("3"), DIAMOND_4("4"), DIAMOND_5("5"), DIAMOND_6("6"), DIAMOND_7("7"), DIAMOND_8("8"),
	DIAMOND_9("9"), DIAMOND_10("10"), DIAMOND_J("10"), DIAMOND_Q("10"), DIAMOND_K("10");

	private String value;

	Card(String value) {
		this.value = value;
	}

	public String GetValue() {
		return this.value;
	}
}
