import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Land land = new Land();
        ArrayList<Object> gridArrayList = new ArrayList<>();
        int humanStartPos = (int)(Math.random() * 19);
        Human human = new Human(humanStartPos,100,100);
        int goblinStartPos = (int)(Math.random() * 19);
        Goblin goblin = new Goblin(goblinStartPos,75,50);

        try{
            System.out.println(land);
            System.out.println();

            for(int i = 0; i < 20; i++) {
                gridArrayList.add("Safe ");
            }

            if(humanStartPos == goblinStartPos) {
                gridArrayList.set(0, human);
                gridArrayList.set(19, goblin);
            }

            gridArrayList.set(goblin.getPosition(), goblin);
            gridArrayList.set(human.getPosition(), human);
            land.updateGame(gridArrayList);


            while(gridArrayList.contains(human) && gridArrayList.contains(goblin))   {


                System.out.println();
                System.out.println("Human's turn. Choose N, S, E, W. \nPress any other button to attack.");
                String firstInput = sc.nextLine();
                String firstLetter = firstInput.charAt(0) + "";
                String userInput = firstLetter.toLowerCase();

                switch (userInput) {
                    case "n": {
                        gridArrayList.set(land.moveNorth(human), human);
                        gridArrayList.set(gridArrayList.lastIndexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        land.humanCombat(human, goblin);
                        land.removeFromGame(gridArrayList, human, goblin);
                        break;
                    }
                    case "s": {
                        gridArrayList.set(land.moveSouth(human), human);
                        gridArrayList.set(gridArrayList.indexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        land.humanCombat(human, goblin);
                        land.removeFromGame(gridArrayList, human, goblin);
                        break;
                    }
                    case "e": {
                        gridArrayList.set(land.moveEast(human), human);
                        gridArrayList.set(gridArrayList.indexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        land.humanCombat(human, goblin);
                        land.removeFromGame(gridArrayList, human, goblin);
                        break;
                    }
                    case "w": {
                        gridArrayList.set(land.moveWest(human), human);
                        gridArrayList.set(gridArrayList.lastIndexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        land.humanCombat(human, goblin);
                        land.removeFromGame(gridArrayList, human, goblin);
                        break;
                    }
                    default: {
                        System.out.println("Human Attack");
                        land.updateGame(gridArrayList);
                        land.humanCombat(human, goblin);
                        land.removeFromGame(gridArrayList, human, goblin);
                        break;
                    }
                }


                if(goblin.getHealth() == 0) {
                    System.out.println("Human Wins");
                }




                if(gridArrayList.contains(goblin)) {
                    System.out.println();
                    System.out.println("Goblin's turn. Choose N, S, E, W \nPress any other button to attack.");
                    firstInput = sc.nextLine();
                    firstLetter = firstInput.charAt(0) + "";
                    userInput = firstLetter.toLowerCase();

                    switch (userInput) {
                        case "n": {
                            gridArrayList.set(land.moveGoblinNorth(goblin), goblin);
                            gridArrayList.set(gridArrayList.lastIndexOf(goblin), "Safe ");
                            land.updateGame(gridArrayList);
                            land.goblinCombat(goblin, human);
                            land.removeFromGame(gridArrayList, human, goblin);
                            break;
                        }
                        case "s": {
                            gridArrayList.set(land.moveGoblinSouth(goblin), goblin);
                            gridArrayList.set(gridArrayList.indexOf(goblin), "Safe ");
                            land.updateGame(gridArrayList);
                            land.goblinCombat(goblin, human);
                            land.removeFromGame(gridArrayList, human, goblin);
                            break;
                        }
                        case "e": {
                            gridArrayList.set(land.moveGoblinEast(goblin), goblin);
                            gridArrayList.set(gridArrayList.indexOf(goblin), "Safe ");
                            land.updateGame(gridArrayList);
                            land.goblinCombat(goblin, human);
                            land.removeFromGame(gridArrayList, human, goblin);
                            break;
                        }
                        case "w": {
                            gridArrayList.set(land.moveGoblinWest(goblin), goblin);
                            gridArrayList.set(gridArrayList.lastIndexOf(goblin), "Safe ");
                            land.updateGame(gridArrayList);
                            land.goblinCombat(goblin, human);
                            land.removeFromGame(gridArrayList, human, goblin);
                            break;
                        }
                        default: {
                            System.out.println("Goblin Attack");
                            land.goblinCombat(goblin, human);
                            land.removeFromGame(gridArrayList, human, goblin);
                            break;
                        }

                    }
                    land.updateGame(gridArrayList);

                    if(human.getHealth() == 0) {
                        System.out.println("Goblin Wins");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
