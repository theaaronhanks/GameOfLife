package newlife;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import newlife.patterns.Blinker;
import newlife.patterns.Glider;
import newlife.patterns.Pattern;

public class LifeSimTest {

    @Test
    void TestConstructor() {
        final int x = 40;
        final int y = 50;

        LifeSim sim = new LifeSim(x, y);
        assertEquals(40, sim.getSizeX(), "X is wrong");
        assertEquals(50, sim.getSizeY(), "X is wrong");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                assertFalse(sim.getCell(i, j), "Incorrect default state");
            }
        }
    }

    @Test
    void TestRandomizer() {
        final int x = 10;
        final int y = 10;

        LifeSim sim = new LifeSim(x, y);
        sim.setRandomState(1);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                assertTrue(sim.getCell(i, j), "Random does not work");
            }
        }
    }

    @Test
    void TestInsertPatterns() {
        final int x = 10;
        final int y = 10;
        final int startx = 0;
        final int starty = 2;
        final int startx2 = 5;
        final int starty2 = 4;

        final TestPattern1 pattern = new TestPattern1();
        final TestPattern2 pattern2 = new TestPattern2();

        LifeSim sim = new LifeSim(x, y);
        sim.insertPattern(pattern, startx, starty);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                assertEquals(sim.getCell(i, j), data1[i][j], "Wrong pattern in cell");
            }
        }

        LifeSim sim2 = new LifeSim(x, y);
        sim2.insertPattern(pattern2, startx2, starty2);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                assertEquals(sim2.getCell(i, j), data2[i][j], "Wrong pattern in cell");
            }
        }
    }

    @Test
    void TestUpdate() {
        final int x = 10;
        final int y = 10;
        final int startx = 0;
        final int starty = 0;
        final int startx2 = 7;
        final int starty2 = 7;

        LifeSim sim = new LifeSim(x, y);
        sim.insertPattern(new Glider(), startx, starty);
        sim.insertPattern(new Blinker(), startx2, starty2);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                assertEquals(sim.getCell(i, j), data3[i][j], "Wrong value in cell");
            }
        }
        sim.update();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                assertEquals(sim.getCell(i, j), update1[i][j], "Wrong value in cell");
            }
        }
        sim.update();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                assertEquals(sim.getCell(i, j), update2[i][j], "Wrong value in cell");
            }
        }

    }

    boolean data1[][] = {
            { false, false, true, true, true, true, false, false, false, false },
            { false, false, true, true, true, true, false, false, false, false },
            { false, false, true, true, true, true, false, false, false, false },
            { false, false, true, true, true, true, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false }
    };

    boolean data2[][] = {
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, true, false, true, false, false, false },
            { false, false, false, false, false, true, false, true, false, false },
            { false, false, false, false, true, false, true, false, false, false },
            { false, false, false, false, false, true, false, true, false, false },
            { false, false, false, false, false, false, false, false, false, false }
    };

    boolean data3[][] = {
            { false, false, true, false, false, false, false, false, false, false },
            { true, false, true, false, false, false, false, false, false, false },
            { false, true, true, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, true, true, true },
            { false, false, false, false, false, false, false, false, false, false }
    };

    boolean update1[][] = {
            { false, true, false, false, false, false, false, false, false, false },
            { false, false, true, true, false, false, false, false, false, false },
            { false, true, true, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, true, false },
            { false, false, false, false, false, false, false, false, true, false },
            { false, false, false, false, false, false, false, false, true, false }
    };

    boolean update2[][] = {
            { false, false, true, false, false, false, false, false, false, false },
            { false, false, false, true, false, false, false, false, false, false },
            { false, true, true, true, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, true, true, true },
            { false, false, false, false, false, false, false, false, false, false }
    };

    private class TestPattern1 extends Pattern {
        public TestPattern1() {
            this.pattern = new boolean[][] {
                    { true, true, true, true, },
                    { true, true, true, true, },
                    { true, true, true, true, },
                    { true, true, true, true, }
            };
        }
    }

    private class TestPattern2 extends Pattern {
        public TestPattern2() {
            this.pattern = new boolean[][] {
                    { true, false, true, false, },
                    { false, true, false, true, },
                    { true, false, true, false, },
                    { false, true, false, true, }
            };
        }
    }
}
