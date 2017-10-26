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
        String input = "";

        System.out.println("Welcome to the <BlackJack> table, player1!");
        System.out.println("You have $" /* + monay*/);
        do {

            do {
                System.out.println("How much do you want to bet?");
                input = getInput();
            }
            while (!(isInputDouble(input) && isInputPositive(input)));
            Double betField = Double.valueOf(input);
        }
        while (!game.getPlayer().hasMoneyToMakeBet(betfield));

        // this is the bet double -> makeABet(input);
        // bet logic

        do {
            do {
                System.out.println("Do you hit or stay?");
                input = getInput();
            } while (!isInputStayOrHit(input));

            //do a hit

        } while ("hit".equals(input));


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
}
