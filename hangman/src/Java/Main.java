

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

        String secretWord = words.get(rand.nextInt(words.size()));

        System.out.println(secretWord);

        List<Character> playerGuesses = new ArrayList<>();

        runGame(secretWord, playerGuesses, input);

        System.out.println("Would you like to play again? (y or n)");

        if(input.nextLine().equals("y")) {
            runGame(secretWord, playerGuesses, input);
        } else {
            System.out.println("Okay thanks for playing!");
        }

    }

    public static boolean gameState(String secretWord, List<Character> playerGuesses) {
        return (secretWord.equals(wordState(secretWord, playerGuesses)));
    }


    public static String wordState(String secretWord, List<Character> playerGuesses) {
        String retstr = "";
        for(int i = 0; i < secretWord.length(); i++) {
            if(playerGuesses.contains(secretWord.charAt(i))) {
                retstr+=(secretWord.charAt(i));
            } else {
                retstr+=("_");
            }
        }
        System.out.println(retstr);
        return retstr;
    }

    public static boolean isGuessRight(Scanner input, String secretWord, List<Character> playerGuesses) {
        System.out.println("\nPlease enter a letter:");
        String letterGuess = input.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return secretWord.contains(letterGuess);
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

    public static void runGame (String secretWord, List<Character> playerGuesses,Scanner input ) {
        int wrongCount = 0;
        while(true) {

            printHangedMan(wrongCount);

            if(wrongCount >=6) {
                System.out.println("Sorry, you lost.");
                break;
            }
            wordState(secretWord,playerGuesses);
            if(!isGuessRight(input, secretWord, playerGuesses)) {
                wrongCount++;
            }
            if (gameState(secretWord, playerGuesses)) {
                System.out.println("\nYou win!");
                break;
            }

        }
    }


}
