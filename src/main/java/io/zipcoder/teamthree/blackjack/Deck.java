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

    public Card getCard(Integer index){
        return cards.get(index);
    }

    public ArrayList<Card> getAllCards(){
        return cards;
    }


    private void populate() {
        cards = new ArrayList<Card>();
        for (Suit suit: EnumSet.allOf(Suit.class)) {
            for (int value = 0; value < 13; value++) {
                if (value < 11){
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
