
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static String askName() {
            String question = "What is your name?";
            System.out.println(question);
            return question;
    }
    static void guessingGame() {
        try {
            String name = input.next();
            System.out.println("Alright " + name + "...");
            int num = (int) Math.floor(Math.random()*(20-1+1)+1);
            System.out.println("I am thinking of a number between 1 and 20. Take a guess. If you don't guess the number in 6 tries, you lose.");
            Boolean playing = true;
            int count = 0;
            do {
                int guess = input.nextInt();
                if (guess == num) {
                    count++;
                    System.out.println("Congratulations! You won on try #" + count + "!");
                    playing = false;
                } else if (guess > num && guess <= 20 && count < 5) {
                    System.out.println("Your guess is too high. Guess again.");
                    count++;
                } else if (guess < num && guess >= 1 && count < 5) {
                    System.out.println("Your guess is too low. Guess again.");
                    count++;
                } else if(guess != num && count == 5){
                    count++;
                    System.out.println("Sorry, you lost.");
                    playing = false;
                } else {
                    System.out.println("You must input a number between 1 and 20. Guess again.");
                }

            } while (playing == true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String replay() {
        String output = "Would you like to play again? (y or n)";
        System.out.println(output);
        return output;
    }

    public static String restart(String userInput) {
        String response = null;
        try{
            if (userInput.equals("y")) {
                askName();
                guessingGame();
                response = "restarting";
                return response;
            } else {
                System.out.println("See you next time!");
                response = "See you next time";
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }



    public static void main(String[] args) {
	// write your code here

    askName();

    guessingGame();

    int restartTimes = 0;
    do {
        restartTimes ++;
        replay();
        Scanner input = new Scanner(System.in);
        String playAgain = input.next();
        restart(playAgain);
    } while (restartTimes < 100);



    }
}
