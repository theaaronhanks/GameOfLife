package newlife.patterns;

public class Blinker extends Pattern {
    public Blinker() {
        this.pattern = new boolean[][] {
                { false, false, false },
                { true, true, true },
                { false, false, false }
        };
    }
}
