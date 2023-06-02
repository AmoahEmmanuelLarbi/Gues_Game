package casino_game;

// importing packages
import java.util.Random;
import java.util.Scanner;

public class guessGame_App {

    public static void main(String[] args) {
        // Instance of Random
        Random rand = new Random();
        // Instance of Scanner
        Scanner input = new Scanner(System.in);

        // variables
        String name;
        double deposit;
        int userGuess;
        double balance;
        double userStake;
        char quitGame;


        // call method gameInstruction
        gameInstruction();

        System.out.println("Enter your name: ");
        System.out.print(">>> ");
        name = input.nextLine(); // get input from user

        System.out.println("Enter your initial deposit: ");
        System.out.print(">>> ");
        deposit = input.nextDouble();


        // Instance of class guessGame
        guessGame game = new guessGame(name, deposit);

        // assigning value to balance
        balance = deposit;


        do {
            // generating random number between 1 - 10
            int correctNum = 1 + rand.nextInt(10);

            // let user guess a number
            // validate userGuess, so they enter numbers between 1 - 10
            System.out.println("Enter your secret number \"(Number must be (1 - 10)\": ");
            System.out.print(">>> ");

            // validation for the number user should guess


            do {
                userGuess = input.nextInt();
                if (userGuess < 1 || userGuess > 10) {
                    System.out.print("Invalid Input: \n \"(Number must be (1 - 10)\":\n");
                    System.out.println("Re-Enter secret number: ");
                    System.out.print(">>> ");
                }
            } while (!(userGuess >= 1 && userGuess <= 10));
            // end of validation for the number user should guess

            System.out.println();

            // validation for stake
            System.out.println("Enter the amount you want to stake : ");
            System.out.print(">>> ");

            do {
                userStake = input.nextDouble();
                if (userStake <= 0 || userStake > balance) {
                    System.out.println("Transaction Failed\n Insufficient Funds !!!");
                    System.out.println("Your Stake can't be greater than your balance\n");

                    System.out.println("Re-Enter the amount you want to stake: ");
                    System.out.print(">>> ");
                }


            } while (userStake <= 0 || userStake > balance);

            // code to double balance if guess is correct
            if (userGuess == correctNum) {
                System.out.println("Great !!! \n Your guess was correct !!");
                balance = balance - userStake; // subtract stake from balance
                balance += (userStake * 2);
            } else {
                System.out.println("Ooh you missed (^_-)");
                System.out.println("The correct number was " + correctNum);
                balance -= userStake;
            }

            // code to quit game
            System.out.println("Do you want to continue \"( Y | N ) \"");
            quitGame = input.next().charAt(0);

            // convert input of quitGame to uppercase
            quitGame = Character.toUpperCase(quitGame);

            System.out.printf("Current Balance = %.2f%n%n", balance);

            if (balance == 0){
                break;
            }


        } while(quitGame == 'Y');

        game.displayInfo();
        System.out.printf("%nBalance = %.2f%n", balance);


    }

    public static void gameInstruction(){
        System.out.println("""
                THIS APPLICATION IS A GUESS GAME
                ***** \tINSTRUCTION \t*****
                1. PLAYER GUESS A NUMBER
                2. PLAYER WINS AND GET 2x OF STAKE IF GUESS IS CORRECT
                3. PLAYER LOSE IF GUESS IS INCORRECT
                 \s""");
    }

}
