package io.zipcoder.teamthree.blackjack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckTest {

    Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void getCardTest(){
        Assert.assertTrue(deck.getCard() instanceof Card);
    }

    @Test
    public void populateTest() {
        Integer expectedCount = 52;
        Integer actualCount = deck.getAllCards().size();

        Assert.assertEquals( expectedCount, actualCount);
        Assert.assertTrue(deck.getCard() instanceof Card);
    }
    
    @Test
    public void shuffleTest(){
        Card[] cardArray1 = new Card[52];
        Card[] cardArray2 = new Card[52];

        Card[] initialArray = deck.getAllCards().toArray(cardArray1);
        deck.shuffle();

        Card[] shuffledArray = deck.getAllCards().toArray(cardArray2);

        Assert.assertFalse(Arrays.equals(initialArray, shuffledArray));
    }


}
