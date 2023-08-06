package newlife;

import java.lang.Math;
import newlife.patterns.Pattern;

public class LifeSim {
    private boolean[][] world;

    public LifeSim(int sizeX, int sizeY) {
        this.world = new boolean[sizeX][sizeY];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < this.world[i].length; j++) {
                this.world[i][j] = false;
            }
        }
    }

    public void setRandomState() {
        setRandomState(0.33);
    }

    public void setRandomState(double liveChance) {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < this.world[i].length; j++) {
                if (Math.random() < liveChance) {
                    this.world[i][j] = true;
                }
            }
        }
    }

    public int getSizeX() {
        return this.world.length;
    }

    public int getSizeY() {
        return this.world[0].length;
    }

    public boolean getCell(int x, int y) {
        if (x > -1 && x < this.world.length && y > -1 && y < this.world[x].length) {
            return this.world[x][y];
        }
        return false;
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        for (int i = 0; i < pattern.getSizeX(); i++) {
            for (int j = 0; j < pattern.getSizeY(); j++) {
                if (pattern.getCell(i, j)) {
                    this.world[i + startX][j + startY] = true;
                }
            }
        }
    }

    private int checkNeighbors(int x, int y) {
        int count = 0;

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i == x && j == y)
                    continue;
                if (this.getCell(i, j))
                    count++;
            }
        }

        return count;
    }

    public void update() {
        boolean[][] nextWorld = new boolean[this.getSizeY()][this.getSizeX()]; // create a new grid
        for (int i = 0; i < this.world.length; i++) {
            for (int j = 0; j < this.world[i].length; j++) {
                int count = checkNeighbors(i, j);

                if (this.getCell(i, j) && ((count == 2) || (count == 3))) {
                    nextWorld[i][j] = true;
                } else if (!this.getCell(i, j) && count == 3) {
                    nextWorld[i][j] = true;
                } else {
                    nextWorld[i][j] = false;
                }
            }
        }
        for (int i = 0; i < nextWorld.length; i++) {
            for (int j = 0; j < nextWorld[i].length; j++) {
                this.world[i][j] = nextWorld[i][j];
            }
        }
    }
}
