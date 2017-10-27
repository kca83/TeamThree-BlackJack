package io.zipcoder.teamthree.blackjack;

import java.util.Scanner;

public class Console {

    public static void run(){
        //start a game: player, dealer, deck
        //player bets
        //deal cards
        //player hit or stay
        //dealer hits or stays
        //winner deterimined
        //pot emptied
        //end round
        //if lose, quit
        //if quit, quit, show monay
        //if not quit -> make a bet

        Game game = new Game();
        Player userPlayer = game.getPlayer();
        String input;

        
        Double betField;

        System.out.println("Welcome to the <BlackJack> table, player1!");


        System.out.println("You have $"+userPlayer.getMoney());

        do {
            game.start();
            do {

                do {
                    System.out.println("How much do you want to bet?");
                    input = getInput();
                }
                while (!isInputDouble(input) || !isInputPositive(input));
                betField = Double.valueOf(input);
            }
            while (!userPlayer.hasMoneyToMakeBet(betField));

            userPlayer.makeBet(betField);
            game.addToPot(betField);

            for (Card card : userPlayer.getHand()) {
                System.out.println(card.toString());
            }
            System.out.println("Your current score is: " + userPlayer.calculateScore());

            do {


                do {
                    System.out.print("Hit or stay? ");
                    input = getInput();
                } while (!isInputStayOrHit(input));

                if ("hit".equalsIgnoreCase(input)) {
                    game.dealCard(userPlayer);
                }
                System.out.println("Your current score is: " + userPlayer.calculateScore());
                for (Card card : userPlayer.getHand()) {
                    System.out.println(card.toString());
                }

            } while ("hit".equalsIgnoreCase(input) && (userPlayer.calculateScore() <= 21));

            game.dealerHitUntilFinished();

            if (game.playerWins()) {
                System.out.println("Player wins!");
            } else {
                System.out.println("House wins!");
            }
            System.out.println("House has score: " + game.getDealer().getScore());

            game.returnBet();
            userPlayer.getHand().clear();
            game.getDealer().getHand().clear();

            System.out.println("You have $" + userPlayer.getMoney());
            do {
                System.out.println("Wanna go another round, cowboy?");
                input = getInput();
             }while (!isInputYesOrNo(input));
        } while ("yes".equalsIgnoreCase(input) && userPlayer.getMoney()>=0.01);
        if(userPlayer.getMoney() < 0.01d){
            System.out.println("You outta monay");
        }

        System.out.println("Goodbye!");

        


/*
        // this is the bet double -> makeABet(input);
        // bet logic

        do {
            do {
                System.out.println("Do you hit or stay?");
                input = getInput();
            } while (!isInputStayOrHit(input));

            //do a hit

        } while ("hit".equals(input));
*/

    }

    private static Scanner scanner = new Scanner (System.in);

    public static Double makeABet(String input) {
        Double betDouble;
        System.out.println("Make a bet!");

        betDouble = Double.valueOf(input);

        return betDouble;
    }

    private static String getInput()
    {
        return scanner.nextLine();
    }

    public static boolean isInputPositive(String passedString){
        return Double.valueOf(passedString)>0;
    }

    public static boolean isInputDouble(String passedString)
    {
        Double output = null;
        try {
            output = Double.valueOf(passedString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Not a valid input");
            return false;
        }
        return (true);
    }

    public static boolean isInputStayOrHit(String passedString)
    {
        return ("hit".equalsIgnoreCase(passedString) ||
                "stay".equalsIgnoreCase(passedString));
    }

    public static boolean isInputYesOrNo(String passedString)
    {
        return ("yes".equalsIgnoreCase(passedString) ||
                "no".equalsIgnoreCase(passedString));
    }
}
