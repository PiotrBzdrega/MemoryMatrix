import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class Game {
    private Grid grid;
    private Gui gui;

    public Game(Grid grid, Gui gui) {
        this.grid = grid;
        this.gui = gui;
    }

    public void startChapter() {
        grid.createPuzzle();
        grid.changeState(true);
        gui.refreshInterface();
        //gui.freezeGrid()
    }

    public void startGuessing() {
        grid.changeState(false);
        gui.refreshInterface();
    }

    public void freezeGrid() {

    }

    public static void main(String[] args) {

        Grid grid = new Grid(5);
        Gui gui = new Gui(grid.getGrid(), grid.getxRows());
        Game game = new Game(grid, gui);
        grid.changeCoveredElements(2);
        game.startChapter();
        //   grid.createPuzzle();
    }
}
