package io.zipcoder.teamthree.blackjack;

import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand = new ArrayList<Card>(2);
    String name;
    Double money = Double.valueOf(500);
    Integer score = Integer.valueOf(0);
    boolean aceBonus = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public Integer getScore() {
        return score;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addHand(Card card) {
        hand.add(card);
    }

    public boolean hasMoneyToMakeBet(Double amount) {
        return (amount <= money);
    }

    public void makeBet(Double amount) {
        money -= amount;
    }

    
}
