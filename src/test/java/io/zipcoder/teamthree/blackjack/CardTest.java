package io.zipcoder.teamthree.blackjack;


import org.junit.Test;
import org.junit.Assert;

public class CardTest
{

    @Test
    public void testCardGetValue(){
        Card card = new Card(Suit.HEARTS, 2);

        Integer expected=2;
        Integer actual=card.getValue();

        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void testCardGetSuit(){
        Card card = new Card(Suit.HEARTS, 2);

        Suit expected = Suit.HEARTS;
        Suit actual = card.getSuit();

        Assert.assertTrue(expected.equals(actual));
    }

}
