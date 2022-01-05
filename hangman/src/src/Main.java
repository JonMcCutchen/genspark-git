package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Scanner scanner = new Scanner(new File("C:/genspark-git/hangman/words.txt"));
        Scanner input = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size()));

        List<Character> playerGuesses = new ArrayList<>();

        runGame(word, playerGuesses, input);

        System.out.println("Would you like to play again? (y or n)");

        if(input.nextLine().equals("y")) {
            runGame(word, playerGuesses, input);
        } else {
            System.out.println("Okay thanks for playing!");
        }

    }

    public static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for(int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("_");
            }
        }
        return (word.length() == correctCount);
    }

    public static boolean getPlayerGuess(Scanner input, String word, List<Character> playerGuesses) {
        System.out.println("\nPlease enter a letter:");
        String letterGuess = input.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
        return word.contains(letterGuess);
    }

    public static void printHangedMan(Integer wrongCount) {
        System.out.println("\n +--------+");
        System.out.println("  |       |");
        if(wrongCount >= 1) {
            System.out.println("  O");
        }
        if(wrongCount >= 2) {
            System.out.print(" \\ ");
            if(wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println(" ");
            }
        }
        if(wrongCount >=  4) {
            System.out.println("  |");
        }
        if(wrongCount >= 5) {
            System.out.print(" / ");
            if(wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println(" ");
            }
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void runGame (String word, List<Character> playerGuesses,Scanner input ) {
        int wrongCount = 0;
        while(true) {

            printHangedMan(wrongCount);

            if(wrongCount >=6) {
                System.out.println("Sorry, you lost.");
                break;
            }

            printWordState(word, playerGuesses);
            if(!getPlayerGuess(input, word, playerGuesses)) {
                wrongCount++;
            }
            if (printWordState(word, playerGuesses)) {
                System.out.println("\nYou win!");
                break;
            }

        }
    }
}
