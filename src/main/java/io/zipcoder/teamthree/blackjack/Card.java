package io.zipcoder.teamthree.blackjack;

public class Card
{
    private Suit suit;
    private Integer value;

    private Card(){
    }

    public Card(Suit passedSuit, Integer passedValue){
        suit=passedSuit;
        value=passedValue;
    }

    public Integer getValue(){
        return value;
    }

    public Suit getSuit(){
        return suit;
    }
}
