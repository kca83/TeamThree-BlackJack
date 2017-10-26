package io.zipcoder.teamthree.blackjack;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void getPot() {
        Game game = new Game();
        Double expectedPot = 50.0;
        Double actualPot = game.getPot();
        Assert.assertEquals(expectedPot, actualPot);
    }

    @Test
    public void startTest() {
        Game game = new Game();
        game.start();
        int expectedNumberOfPlayerCards = 2;
        int expectedNumberOfDealerCards = 2;

        Player player = game.getPlayer();
        Player dealer = game.getDealer();


        int actualNumberOfPlayerCards = player.getHandSize();
        int actualNumberOfDealerCards = dealer.getHandSize();

        Assert.assertEquals(expectedNumberOfPlayerCards, actualNumberOfPlayerCards);
        Assert.assertEquals(expectedNumberOfDealerCards, actualNumberOfDealerCards);
    }

    @Test
    public void playerWinsTest() {
        Game game = new Game();

        Player player = game.getPlayer();
        Player dealer = game.getDealer();

        boolean expected = true;
        boolean expected2 = false;
        boolean expected3 = true;

        player.setScore();
        player.getScore();
        dealer.setScore();
        dealer.getScore();

        boolean actual = game.playerWins();

        player.setScore();
        dealer.setScore();
        player.getScore();
        dealer.getScore();

        boolean actual2 = game.playerWins();

        player.setScore();
        dealer.setScore();
        player.getScore();
        dealer.getScore();

        boolean actual3 = game.playerWins();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void dealCardTest() {
        //Calls on methods in other Class Deck and Player.
    }

    @Test
    public void askPlayerForHitTest() {
        Game game = new Game();
        Player player = game.getPlayer();
        int expectedHandSize = 1;
        game.askPlayerForHit(player);
        int actualHandSize = player.getHandSize();
        Assert.assertEquals(expectedHandSize, actualHandSize);

    }

    @Test
    public void askDealerForHit() {
//        Game game = new Game();
//        Player dealer = game.getDealer();
//        int expectedHandSize = 1;
//        dealer.setScore(16);
//        game.askDealerForHit();
//        int actualHandSize = dealer.getHandSize();
//
//        int expectedHandSize2 = 0;
//        dealer.setScore(17);
//        game.askDealerForHit();
//        int actualHandSize2 = dealer.getHandSize();
//
//        Assert.assertEquals(expectedHandSize, actualHandSize);
//        Assert.assertEquals(expectedHandSize2, actualHandSize2);

    }

    @Test
    public void returnBet() {
        Game game = new Game();
        Double expected = 50.0;
        Double actual = game.getPot();
        Assert.assertEquals(expected, actual, .001);
    }
}
