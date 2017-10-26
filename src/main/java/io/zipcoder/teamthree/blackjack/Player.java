package io.zipcoder.teamthree.blackjack;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>(2);
    private String name;
    private Double money = Double.valueOf(500);
    private Integer score = Integer.valueOf(0);

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

    // blackjack hit
    public void addToHand(Card card) {
        hand.add(card);
    }

    public boolean hasMoneyToMakeBet(Double amount) {
        return (amount <= money);
    }

    public void makeBet(Double amount) {
        money -= amount;
    }

    public boolean isAceInHand() {
        for(Card card: hand) {
            if(card.getValue() == 1) {
                return true;
            }
        }
        return false;
    }

    public Integer calculateScore() {
        int sum = 0;
        for(Card card: hand) {
            sum += card.getValue();
        }

        if(isAceInHand() && sum <= 11) {
            sum += 10;
        }
        score = sum;

        return sum;
    }

    public void receiveWinnings(Double amount) {
        money += amount;
    }
}
