package newlife.patterns;

public class Acorn extends Pattern {
    public Acorn() {
        this.pattern = new boolean[][] {
                { false, true, false, false, false, false, false },
                { false, false, false, true, false, false, false },
                { true, true, false, false, true, true, true }
        };
    }
}
