package newlife.patterns;

public abstract class Pattern {
    protected boolean[][] pattern;
    public int getSizeX() {
        return this.pattern.length;
    }
    public int getSizeY() {
        return this.pattern[0].length;
    }
    public boolean getCell(int x, int y) {
        if (x > -1 && x < this.pattern.length && y > -1 && y < this.pattern[x].length){
            return this.pattern[x][y];
        }
        return false;
    }
}

