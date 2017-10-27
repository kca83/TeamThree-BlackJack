package io.zipcoder.teamthree.blackjack;

public class Card
{
    private Suit suit;
    private Integer value;

    private Card(){
    }

    @Override
    public String toString(){
        return ""+this.value;
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
