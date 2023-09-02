package newlife;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import newlife.patterns.*;

public class App {
    public static void main(String[] args) {
        boolean block = false;
        boolean blinker = false;
        boolean glider = false;
        boolean acorn = false;
        int patternCount = 0;
        for (String arg : args) {
            if (arg.equals("block")) {
                block = true;
                patternCount++;
            } else if (arg.equals("blinker")) {
                blinker = true;
                patternCount++;
            } else if (arg.equals("glider")) {
                glider = true;
                patternCount++;
            } else if (arg.equals("acorn")) {
                acorn = true;
                patternCount++;
            } else if (arg.equals("all")) {
                block = true;
                blinker = true;
                glider = true;
                acorn = true;
                patternCount = 4;
            } else {
                System.out.println("Invalid argument: " + arg);
                System.out.println();
                System.out.println("Usage: java -jar newlife.jar [block] [blinker] [glider] [acorn] [all]");
                System.exit(1);
            }
        }

        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();

            TerminalSize size = screen.getTerminalSize();
            if (size.getColumns() == 0 || size.getRows() == 0)
                System.exit(1);
            LifeSim simulation = new LifeSim(size.getColumns(), size.getRows());

            if (!block && !blinker && !glider && !acorn) {
                simulation.setRandomState();
            }

            if (block) {
                for (int i = 0; i < 4 / patternCount; i++) {
                    simulation.insertPattern(new Block(), (int) (Math.random() * (size.getColumns() - 2)),
                            (int) (Math.random() * (size.getRows() - 2)));
                }
            }
            if (blinker) {
                for (int i = 0; i < 4 / patternCount; i++) {
                    simulation.insertPattern(new Blinker(), (int) (Math.random() * (size.getColumns() - 3)),
                            (int) (Math.random() * (size.getRows() - 3)));
                }
            }
            if (glider) {
                for (int i = 0; i < 4 / patternCount; i++) {
                    simulation.insertPattern(new Glider(), (int) (Math.random() * (size.getColumns() - 3)),
                            (int) (Math.random() * (size.getRows() - 3)));
                }
            }
            if (acorn) {
                for (int i = 0; i < 4 / patternCount; i++) {
                    simulation.insertPattern(new Acorn(), (int) (Math.random() * (size.getColumns() - 3)),
                            (int) (Math.random() * (size.getRows() - 7)));
                }
            }

            screen.startScreen();
            screen.setCursorPosition(null);

            for (int i = 0; i < 200; i++) {
                render(simulation, screen, graphics); // Render the current state of the simulation
                Thread.yield(); // Let the JVM have some time to update other things
                Thread.sleep(500); // Sleep for a bit to make for a nicer paced animation
                simulation.update(); // Tell the simulation to update
            }

            screen.stopScreen();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
            System.exit(1);
        }
    }

    public static void render(LifeSim simulation, Screen screen, TextGraphics graphics) {
        screen.clear();
        for (int i = 0; i < simulation.getSizeX(); i++) {
            for (int j = 0; j < simulation.getSizeY(); j++) {
                if (simulation.getCell(i, j)) {
                    graphics.setCharacter(i, j, 'X');
                }
            }
        }
        try {
            screen.refresh();
        } catch (Exception ex) {
        }
    }
}
