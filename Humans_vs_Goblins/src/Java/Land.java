import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Land {
    public Land() {

    }

    public void updateGame(ArrayList<Object> grid) {
        try {
            for(int i = 0; i < 5; i++) {
                System.out.print(grid.get(i));
            }
            System.out.println();
            for(int i = 5; i < 10; i++) {
                System.out.print(grid.get(i));
            }
            System.out.println();
            for(int i = 10; i < 15; i++) {
                System.out.print(grid.get(i));
            }
            System.out.println();
            for(int i = 15; i < 20; i++) {
                System.out.print(grid.get(i));
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int moveNorth(Human human) {
        try {
            human.setPosition(human.getPosition() - 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return human.getPosition();
    }

    public int moveSouth(Human human) {
        try {
            human.setPosition(human.getPosition() + 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return human.getPosition();
    }

    public int moveEast(Human human) {
        try {
            human.setPosition(human.getPosition() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return human.getPosition();
    }

    public int moveWest(Human human) {
        try {
            human.setPosition(human.getPosition() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return human.getPosition();
    }

    public int moveGoblinNorth(Goblin goblin) {
        try {
            goblin.setPosition(goblin.getPosition() - 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goblin.getPosition();
    }

    public int moveGoblinSouth(Goblin goblin) {
        try {
            goblin.setPosition(goblin.getPosition() + 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goblin.getPosition();
    }

    public int moveGoblinEast(Goblin goblin) {
        try {
            goblin.setPosition(goblin.getPosition() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goblin.getPosition();
    }

    public int moveGoblinWest(Goblin goblin) {
        try {
            goblin.setPosition(goblin.getPosition() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goblin.getPosition();
    }

    public void humanCombat(Human human, Goblin goblin) {
        try {
            if (human.getPosition() == goblin.getPosition() + 1 ||
                    human.getPosition() == goblin.getPosition() - 1 ||
                    human.getPosition() == goblin.getPosition() + 5 ||
                    human.getPosition() == goblin.getPosition() - 5)
            {
                System.out.println();
                System.out.println("Human power: " + human.getStrength());
                System.out.println("Goblin health: " + goblin.getHealth());
                human.attackGoblin(goblin);
                System.out.println("Human health: " + human.getHealth());
                System.out.println("Goblin health: " + goblin.getHealth());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void goblinCombat(Goblin goblin, Human human) {
        try {
            if (goblin.getPosition() == human.getPosition() + 1 ||
                    goblin.getPosition() == human.getPosition() - 1 ||
                    goblin.getPosition() == human.getPosition() + 5 ||
                    goblin.getPosition() == human.getPosition() - 5)
            {
                System.out.println();
                System.out.println("Goblin power: " + goblin.getStrength());
                System.out.println("Human health: " + human.getHealth());
                goblin.attackHuman(human);
                System.out.println("Goblin health: " + goblin.getHealth());
                System.out.println("Human health: " + human.getHealth());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeFromGame(ArrayList<Object> gridArrayList, Human human, Goblin goblin) {
        try {
            if (human.getHealth() == 0) {
                gridArrayList.set(human.getPosition(), "Safe ");
            }
            else if (goblin.getHealth() == 0) {
                gridArrayList.set(goblin.getPosition(), "Safe ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public String toString() {
        String landString = "War between Humans and Goblins";
        byte[] bytes = landString.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        return utf8EncodedString + " ";
//        return "War between Humans and Goblins";
    }
}
