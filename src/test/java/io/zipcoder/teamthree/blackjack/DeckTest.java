package io.zipcoder.teamthree.blackjack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckTest {

    Deck deck;

    @Before
    public void setup() {
        deck = new Deck();
    }

    @Test
    public void getCard(){
        Assert.assertTrue(deck.getCard(0) instanceof Card);
    }

    @Test
    public void populate() {
        Integer expectedCount = 52;
        Integer actualCount = deck.getAllCards().size();

        Assert.assertEquals( expectedCount, actualCount);
        Assert.assertTrue(deck.getCard(1) instanceof Card);
    }

    @Test
    public void shuffle(){
        Card[] cardArray1 = new Card[52];
        Card[] cardArray2 = new Card[52];

        Card[] initialArray = deck.getAllCards().toArray(cardArray1);
        deck.shuffle();

        Card[] shuffledArray = deck.getAllCards().toArray(cardArray2);

        Assert.assertFalse(Arrays.equals(initialArray, shuffledArray));
    }


}
