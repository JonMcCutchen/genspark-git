

import java.util.Scanner;

public class Main {
    public static String start() {
        String startStatement = "You are in a land full of dragons. \nIn front of you, you see two caves. \nIn one cave, the dragon is friendly and will share his treasure with you. \nThe other dragon is greedy and hungry and will eat you on sight!";
        System.out.println(startStatement);
        return startStatement;
    }

     public static String whichCave() {
        String caveQuestion = "Which cave will you go into? (1 or 2)";
        System.out.println(caveQuestion);
        return caveQuestion;
    }

    public static String userInteraction(int userInput) {
        String outcomeStatement = null;
        try{
            if (userInput == 1) {
                outcomeStatement = "You approach the cave... \nIt is dark and spooky... \nA large dragon jumps out in front of you! \nHe opens his jaws and... \nGobbles you down in one bite!";
                System.out.println(outcomeStatement);

            } else if (userInput == 2) {
                outcomeStatement = "You approach the cave... \nYou see gold sparkling in the distance... \nA large dragon jumps out in front of you! \nHe opens his jaws and... \nhe says 'Hey friend come share my gold with me!'";
                System.out.println(outcomeStatement);
            } else {
                outcomeStatement = "You must input a 1 or 2.";
                System.out.println(outcomeStatement);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return outcomeStatement;
    }

    public static void main(String[] args) {
	// write your code here
        start();

        whichCave();

        Scanner myObj = new Scanner(System.in);
        int input = myObj.nextInt();

        userInteraction(input);

    }
}
