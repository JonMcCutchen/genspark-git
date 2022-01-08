
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void gameState() {
        assertTrue(Main.gameState("cat", List.of('c', 'a', 't')));
        assertTrue(Main.gameState("cat",List.of('c','t','a')));
        assertFalse(Main.gameState("cat",List.of('c')));
        assertFalse(Main.gameState("cat",List.of('c','a')));
    }

    @Test
    void wordState() {
        assertEquals("_a_", Main.wordState("cat", List.of('a')));
        assertEquals("___", Main.wordState("cat", List.of()));
        assertEquals("___", Main.wordState("cat", List.of('z')));
        assertEquals("cat", Main.wordState("cat", List.of('c','a','t')));
        assertEquals("cat", Main.wordState("cat", List.of('a','t','c')));
    }

    @Test
    void isGuessRight() {
    }

    @Test
    void printHangedMan() {
    }

    @Test
    void runGame() {
    }
}