import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void askName() {
        assertEquals("What is your name?", main.askName(), "Wrong output for askName()");
    }

    @Test
    void replay() {
        assertEquals("Would you like to play again? (y or n)", main.replay(), "Wrong output for replay()");
    }

    @Test
    void restartn() {
        assertEquals("See you next time", main.restart("n"), "Wrong output for restart()");
    }

    @AfterEach
    void tearDown() {
    }
}