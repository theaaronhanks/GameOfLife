package newlife.patterns;

public class Glider extends Pattern {
    public Glider() {
        this.pattern = new boolean[][] {
                { false, false, true },
                { true, false, true },
                { false, true, true }
        };
    }

}
