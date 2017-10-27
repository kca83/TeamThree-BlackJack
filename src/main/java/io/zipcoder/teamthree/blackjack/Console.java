package io.zipcoder.teamthree.blackjack;

import java.util.Scanner;

public class Console {

    private static Game game = new Game();
    private static Scanner scanner = new Scanner (System.in);

    public static void run(){

        Player userPlayer = game.getPlayer();

        System.out.println("Welcome to the <BlackJack> table, "+userPlayer.getName()+"!");
        System.out.println("You have $"+userPlayer.getMoney());

        do {
            game.start();
            playerBets(userPlayer);
            displayPlayerHandAndScore(userPlayer);
            displayDealerCardShowing();
            playerHitsOrStays(userPlayer);
            game.dealerHitUntilFinished();
            determineWinOrLoss(userPlayer);
        } while (playerStaysForAnotherRound(userPlayer));

        System.out.println("Thanks for playing! Goodbye!");
    }

    //private static boolean playerStaysForAnotherRound(Player userPlayer) {//production
    public static boolean playerStaysForAnotherRound(Player userPlayer) {//testing
        String input;
        System.out.println("You have $" + userPlayer.getMoney());
        if (userPlayer.getMoney() >= 0.01) {
            do {
                System.out.print("Stay for another round? [Yes/No]  ");
                input = getInput();
                if (isInputYesOrNo(input))
                {
                    return ("yes".equalsIgnoreCase(input));
                }
            } while (!isInputYesOrNo(input));

        }
        else {
            System.out.println("You are out of money.");
        }
        return false;
    }

    //private static void determineWinOrLoss(Player userPlayer){//production
    public static void determineWinOrLoss(Player userPlayer){//testing
        if (game.playerWins()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("House wins!");
        }
        System.out.println("House has score: " + game.getDealer().getScore());
        resetPotAndDiscardHands(userPlayer);
    }

    private static void resetPotAndDiscardHands(Player userPlayer){
        game.returnBet();
        userPlayer.getHand().clear();
        game.getDealer().getHand().clear();
    }

    private static void playerHitsOrStays(Player userPlayer){
        String input;
        do {
            input=forceHitOrStay();
            if ("hit".equalsIgnoreCase(input)) {
                game.dealCard(userPlayer);
            }
            displayPlayerHandAndScore(userPlayer);
        } while ("hit".equalsIgnoreCase(input) && (userPlayer.calculateScore() <= 21));
    }

    private static String forceHitOrStay(){
        String input;
        do {
            System.out.print("Hit or stay? ");
            input = getInput();
        } while (!isInputStayOrHit(input));
        return input;
    }

    private static void displayDealerCardShowing(){
        System.out.println("Dealer is showing: "+game.getDealer().getHand().get(0).getValue());
    }

    private static void displayPlayerHandAndScore(Player userPlayer){
        for (Card card : userPlayer.getHand()) {
            System.out.println(card.toString());
        }
        System.out.println("Your current score is: " + userPlayer.calculateScore());
    }

    private static void playerBets(Player userPlayer){
        Double betAmount;
        String input;
        input=forcePlayerBet(userPlayer);
        betAmount=Double.valueOf(input);
        userPlayer.makeBet(betAmount);
        game.addToPot(betAmount);
    }

    private static String forcePlayerBet(Player userPlayer){
        String input;
        do {
            input=forceDoubleInput();
        }
        while (!userPlayer.hasMoneyToMakeBet(Double.valueOf(input)));
        return (input);
    }

    private static String forceDoubleInput() {
        String input;
        do {
            System.out.print("How much do you want to bet?  ");
            input = getInput();
        } while (!isInputDouble(input) || !isInputPositive(input));
        return input;
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
        try {
            Double output = Double.valueOf(passedString);
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
