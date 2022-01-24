import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        pickWord();
    }
    private static int score = 0;

    public static int getScore() {
        return score;
    }

    public static String pickWord() throws IOException {
        System.out.println("Score: "+getScore());
        String word = "";
        File file = new File("src/Java/words.txt");
        List<String> list = new ArrayList<>(Files.readAllLines(Paths.get("src/Java/words.txt"))).stream().map(Object::toString).collect(Collectors.toList());
        int max = list.size() - 1;
        int min = 0;
        word = list.get((int)(Math.random()*(max - min)) + min);
        if(!word.isEmpty()){
            start(word);
        }else{
            System.out.println("file does not exist");
        }
        return word;
    }

    public static int structure(int count) throws FileNotFoundException {
        File fileOne = new File("src/Java/stateOne.txt");
        File fileTwo = new File("src/Java/stateTwo.txt");
        File fileThree = new File("src/Java/stateThree.txt");
        File fileFour = new File("src/Java/stateFour.txt");
        File fileFive = new File("src/Java/stateFive.txt");
        File fileSix = new File("src/Java/stateSix.txt");
        File fileSeven = new File("src/Java/stateSeven.txt");

        Scanner scannerOne = new Scanner(fileOne);
        Scanner scannerTwo = new Scanner(fileTwo);
        Scanner scannerThree = new Scanner(fileThree);
        Scanner scannerFour = new Scanner(fileFour);
        Scanner scannerFive = new Scanner(fileFive);
        Scanner scannerSix = new Scanner(fileSix);
        Scanner scannerSeven = new Scanner(fileSeven);
        switch(count){
            case 1:
                while(scannerOne.hasNextLine()){
                    String data = scannerOne.nextLine();
                    System.out.println(data);
                }
                break;
            case 2:
                while(scannerTwo.hasNextLine()){
                    String data = scannerTwo.nextLine();
                    System.out.println(data);
                }
                break;

            case 3:
                while(scannerThree.hasNextLine()){
                    String data = scannerThree.nextLine();
                    System.out.println(data);
                }
                break;
            case 4:
                while(scannerFour.hasNextLine()){
                    String data = scannerFour.nextLine();
                    System.out.println(data);
                }
                break;
            case 5:
                while(scannerFive.hasNextLine()) {
                    String data = scannerFive.nextLine();
                    System.out.println(data);
                }
                break;
            case 6:
                while(scannerSix.hasNextLine()) {
                    String data = scannerSix.nextLine();
                    System.out.println(data);
                }
                break;
            case 7:
                while(scannerSeven.hasNextLine()) {
                    String data = scannerSeven.nextLine();
                    System.out.println(data);
                }
                break;
        }return count;

    }

    public static void start(String word) throws IOException {
        System.out.println("HANGMAN");
        File startFile = new File("src/Java/stateOne.txt");
        Scanner startScanner = new Scanner(startFile);
        while(startScanner.hasNextLine()) {
            System.out.println(startScanner.nextLine());
        }
        System.out.println("Missed letters: \n" +
                "Guess a letter");
        getInput(word);
    }

    public static void getInput(String word) throws IOException {

        Scanner getInput = new Scanner(System.in);
        String input = getInput.nextLine();
        guesses(input, word);
    }

    public static void guesses(String input, String word) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        Boolean play = true;

        String[] arrOfWord = word.split("");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> badGuesses = new ArrayList<>();
        ArrayList<String> spaceHolders = new ArrayList<>();
        Arrays.stream(arrOfWord).forEach(a -> list.add(a));
        list.stream().forEach(a -> spaceHolders.add("_"));

        while (play) {

            if (badGuesses.contains(input) || spaceHolders.contains(input)) {
                System.out.println("You have already guessed that letter, choose again");
                structure(count);
                System.out.println("Missed letters " + badGuesses);
                System.out.println(spaceHolders);
                input = scanner.nextLine();

            } else if (list.contains(input)) {
                spaceHolders.set(list.indexOf(input), input);
                structure(count);
                System.out.println("Missed letters " + badGuesses);
                System.out.println(spaceHolders);
                if (spaceHolders.contains("_")){
                    input = scanner.nextLine();
                } else {
                    System.out.println("You made it to the next round.. Press enter to move on.. or any other key to exit");
                    input = scanner.nextLine();
                    if (input.isEmpty()) {
                        score+=1;
                        pickWord();
                    }else{
                        System.exit(0);
                    }
                }
            } else {
                //area for bad guesses
                badGuesses.add(input);
                structure(count += 1);
                System.out.println("Missed letters " + badGuesses);
                System.out.println(spaceHolders);
                if (count <= 6) {
                    input = scanner.nextLine();
                } else {
                    checkHighScore();
                    if(checkHighScore() > score){
                        System.out.println("Good job! Your score is: "+score+", enter a name over 2 characters to save your score");
                    }else{
                        System.out.println("CONGRATULATIONS!!! YOU HAVE THE NEW HIGHEST SCORE.. enter a name to save your score");
                    }
                    input = scanner.nextLine();
                    if(!input.isEmpty()){
                        storeScore(input);
                        playAgain();
                    }else{
                        System.out.println("your name wasn't the correct length.. your score won't be saved\n");
                        playAgain();
                    }
                }
            }
        }
    }

    public static int checkHighScore() throws IOException {
        List<String>scoresList = new ArrayList<>(Files.readAllLines(Paths.get("src/Java/scores.txt")));
        String joinedList = String.join(",", scoresList);
        String[] scores = joinedList.split(",");
        List<String> onlyScores = IntStream.range(0, scores.length).filter(i -> i % 2 == 1).mapToObj(i -> scores[i]).collect(Collectors.toList());
        List<Integer> intList = onlyScores.stream().map(Integer::valueOf).collect(Collectors.toList());
        Integer maxScore = intList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        return maxScore;
    }

    public static void playAgain() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to play again (y or n)");
        String input = scanner.nextLine();
        if (input.equals("y")) {
            score = 0;
            pickWord();
        }else{
            System.exit(0);
        }
    }

    public static void storeScore(String input) throws IOException {
        String storingScore = input+","+ score;
        Files.write(Paths.get("src/Java/scores.txt"), Collections.singleton(storingScore), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }



}
