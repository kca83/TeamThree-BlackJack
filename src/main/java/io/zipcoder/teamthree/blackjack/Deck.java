package io.zipcoder.teamthree.blackjack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        populate();
    }

    public Card getCard(){
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public ArrayList<Card> getAllCards(){
        return cards;
    }


    private void populate() {
        cards = new ArrayList<Card>();
        for (Suit suit: Suit.values()) {
            for (int value = 1; value <= 13; value++) {
                if (value < 10){
                    cards.add(new Card(suit, value));
                } else {
                    cards.add(new Card(suit, 10));
                }
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

}
