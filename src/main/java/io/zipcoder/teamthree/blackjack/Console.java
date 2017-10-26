package io.zipcoder.teamthree.blackjack;

import java.util.Scanner;

public class Console {

    public static void run(){

        Game game = new Game();

       
        //game.start();

        System.out.println("Welcome to the <BlackJack> table, player1!");
        System.out.println("You have $" /* + monay*/);

        //make a bet

        //Console.makeABet(stringInput());

        //do
        //prompt
        //take input = input
        //while(!isInputDouble(input)){
    }

    Scanner scanner = new Scanner (System.in);

    public static Double makeABet(String input) {
        Double betDouble;
        System.out.println("Make a bet!");

        betDouble = Double.valueOf(input);

        return betDouble;

    }

    private String getInput()
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



}
