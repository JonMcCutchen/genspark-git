import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MainTest {

    Main main;


    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void start() {
        assertEquals("You are in a land full of dragons. \nIn front of you, you see two caves. \nIn one cave, the dragon is friendly and will share his treasure with you. \nThe other dragon is greedy and hungry and will eat you on sight!", main.start(), "Wrong output for start()");
    }

    @Test
    void whichCave() {
        assertEquals("Which cave will you go into? (1 or 2)", main.whichCave(), "wrong output for whichCave()");
    }

    @Test
    void userInteraction1() {
        assertEquals("You approach the cave... \nIt is dark and spooky... \nA large dragon jumps out in front of you! \nHe opens his jaws and... \nGobbles you down in one bite!", main.userInteraction(1), "Wrong output");
    }

    @Test
    void userInteraction2() {
        assertEquals("You approach the cave... \nYou see gold sparkling in the distance... \nA large dragon jumps out in front of you! \nHe opens his jaws and... \nhe says 'Hey friend come share my gold with me!'", main.userInteraction(2), "Wrong output" );
    }

    @Test
    void userInteraction3() {
        assertEquals("You must input a 1 or 2.", main.userInteraction(3), "Wrong output");
    }

    @AfterEach
    void tearDown() {
    }
}