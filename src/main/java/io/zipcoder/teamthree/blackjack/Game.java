package io.zipcoder.teamthree.blackjack;

import org.junit.Test;

import java.util.ArrayList;

public class Game {
    private Player player;
    private Deck deck;
    private Player dealer;
    private Double pot;

    public Game (){
        player = new Player();
        deck = new Deck();
        dealer = new Player();
        deck.shuffle();
        pot = player.bet(50.0);
    }

    public Double getPot() {
        return pot;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    public void start() {

        //Deal two cards to the player and the dealer
        for (int i = 0; i < 2; i++)
        {
            dealCard(player);
            dealCard(dealer);
        }

    }

    public boolean playerWins() {
        // if both player and dealer scores are = to 21 dealer wins
        // if both player and dealer score are over 21 then dealer wins
        // if player's score is <= 21 and players score is greater than dealers score then player wins.
        //if dealer's score is > 21 and player's score is <= 21 then players wins.

        if((player.getScore().equals(21) && !dealer.getScore().equals(21)) ||
                (player.getScore()<21 && dealer.getScore() < player.getScore()) ||
                (player.getScore() < 21 && dealer.getScore() > 21)) {
            //Player wins
            return true;
        }
        //Dealer wins
        return false;


    }

    public void dealCard(Player playerToReceiveCard){
        Card card = deck.getCard();
        playerToReceiveCard.addCardToHand(card);
    }

    public void askPlayerForHit(Player player) {
        if (player.getHit() == true) {
            dealCard(player);
        }
    }

//    public void askDealerForHit() {
//        while (dealer.getScore() <= 17)
//        {
//            dealCard(dealer);
//        }
//    }

    public void returnBet() {
        if (playerWins()) {
            player.addMoney(pot * 2);
        }
    }
}
