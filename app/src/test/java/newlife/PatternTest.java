package newlife;

import org.junit.jupiter.api.Test;

import newlife.patterns.Acorn;
import newlife.patterns.Blinker;
import newlife.patterns.Block;
import newlife.patterns.Glider;

import static org.junit.jupiter.api.Assertions.*;

class PatternTest {

    @Test
    void TestAcornPattern() {
        Acorn acorn = new Acorn();
        int x = acorn.getSizeX();
        int y = acorn.getSizeY();

        // Pattern is correct shape
        assertEquals(3, x, "Acorn shape has an incorrect number of rows.");
        assertEquals(7, y, "Acorn shape has an incorrect number of columns.");

        // Pattern values are correct
        assertTrue(acorn.getCell(0, 1), "Acorn values are incorrect");
        assertTrue(acorn.getCell(1, 3), "Acorn values are incorrect");
        assertTrue(acorn.getCell(2, 0), "Acorn values are incorrect");

        // Outside of pattern returns false
        assertFalse(acorn.getCell(x, y));
        assertFalse(acorn.getCell(-1, -1));
    }

    @Test
    void TestBlinkerPattern() {
        Blinker blinker = new Blinker();
        int x = blinker.getSizeX();
        int y = blinker.getSizeY();

        // Pattern is correct shape
        assertEquals(3, x, "Blinker shape has an incorrect number of rows.");
        assertEquals(3, y, "Blinker shape has an incorrect number of columns.");

        // Pattern values are correct
        assertFalse(blinker.getCell(0, 1), "Blinker values are incorrect");
        assertTrue(blinker.getCell(1, 2), "Blinker values are incorrect");
        assertFalse(blinker.getCell(2, 0), "Blinker values are incorrect");

        // Outside of pattern returns false
        assertFalse(blinker.getCell(x, y));
        assertFalse(blinker.getCell(-1, -1));
    }

    @Test
    void TestBlockPattern() {
        Block block = new Block();
        int x = block.getSizeX();
        int y = block.getSizeY();

        // Pattern is correct shape
        assertEquals(2, x, "Block shape has an incorrect number of rows.");
        assertEquals(2, y, "Block shape has an incorrect number of columns.");

        // Pattern values are correct
        assertTrue(block.getCell(0, 0), "Block values are incorrect");
        assertTrue(block.getCell(1, 0), "Block values are incorrect");
        assertTrue(block.getCell(1, 1), "Block values are incorrect");

        // Outside of pattern returns false
        assertFalse(block.getCell(x, y));
        assertFalse(block.getCell(-1, -1));
    }

    @Test
    void TestGliderPattern() {
        Glider glider = new Glider();
        int x = glider.getSizeX();
        int y = glider.getSizeY();

        // Pattern is correct shape
        assertEquals(3, x, "Glider shape has an incorrect number of rows.");
        assertEquals(3, y, "Glider shape has an incorrect number of columns.");

        // Pattern values are correct
        assertTrue(glider.getCell(0, 2), "Glider values are incorrect");
        assertFalse(glider.getCell(1, 1), "Glider values are incorrect");
        assertTrue(glider.getCell(2, 1), "Glider values are incorrect");

        // Outside of pattern returns false
        assertFalse(glider.getCell(x, y));
        assertFalse(glider.getCell(-1, -1));
    }
}