package io.zipcoder.teamthree.blackjack;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void getNameTest() {
        //: Given
        Player testPlayer = new Player("Gabriela");
        String expected = "Gabriela";

        //: When
        String actual = testPlayer.getName();

        //: Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMoneyTest() throws Exception {
        Player testPlayer = new Player("Claude");
        Double expected = Double.valueOf(500);

        Double actual = testPlayer.getMoney();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreTest() throws Exception {
        Player testPlayer = new Player("Zan");
        Integer expected = Integer.valueOf(0);

        Integer actual = testPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest() throws Exception {
        Player testPlayer = new Player ("Aaron");
        testPlayer.addHand(new Card());
        testPlayer.addHand(new Card());
        int expected = 2;

        int actual = testPlayer.getHand().size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addCardTest() throws Exception {
        Player testPlayer = new Player ("Pavel");
        Card card = new Card();
        testPlayer.addHand(card);
        Card expected = card;

        Card actual = testPlayer.getHand().get(0);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hasMoneyToMakeBetTest() {
        Player testPlayer = new Player("Leon");
        boolean expected = true;

        boolean actual = testPlayer.hasMoneyToMakeBet(Double.valueOf(100));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeBetTest() {
        Player testPlayer = new Player("Tim");
        Double expected = Double.valueOf(400);

        testPlayer.makeBet(Double.valueOf(100));
        Double actual = testPlayer.getMoney();

        Assert.assertEquals(expected, actual);
    }

}
