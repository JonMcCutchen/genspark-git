package com.company;

import java.util.Scanner;

public class Main {
    public static void guessingGame() {
        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        String name = input.next();

        int num = (int) Math.floor(Math.random()*(20-1+1)+1);

        System.out.println("Well " + name + ", I am thinking of a number between 1 and 20. Take a guess. If you don't guess the number in 6 tries, you lose.");

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
    }

    public static void main(String[] args) {
	// write your code here
    guessingGame();
    System.out.println("Would you like to play again? (y or n)");
    Scanner input = new Scanner(System.in);
    String playAgain = input.next();
    if (playAgain.equals("y")) {
        guessingGame();
    } else {
        System.out.println("See you next time!");
    }

    }
}
