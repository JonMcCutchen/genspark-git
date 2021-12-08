package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("You are in a land fool of dragons. In front of you, you see two caves. In one cave, the dragon is friendly and will share his treasure with you. The other dragon is greedy and hungry and will eat you on sight!");

        Scanner myObj = new Scanner(System.in);

        System.out.println("Which cave will you go into? (1 or 2)");

        int userInput = myObj.nextInt();

        if (userInput == 1) {
            System.out.println("You approach the cave... It is dark and spooky... A large dragon jumps out in front of you! He opens his jaws and... Gobbles you down in one bite!");
        } else if (userInput == 2) {
            System.out.println("You approach the cave... You see gold sparkling in the distance... A large dragon jumps out in front of you! He opens his jaws and... he says 'Hey friend come share my gold with me!'");
        } else {
            System.out.println("You must input a 1 or 2.");
        }

    }
}
