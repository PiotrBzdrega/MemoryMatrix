public class Game {
    private Grid grid;
    private Gui gui;

    public Game(Grid grid, Gui gui) {
        this.grid = grid;
        this.gui = gui;
    }

    private void initializeCanvas (){



    }

    public static void main(String[] args) {

        Grid grid =new Grid(10);
        Gui gui=new Gui(grid.getGrid(),grid.getxRows());
        Game game=new Game(grid,gui);
   //     grid.createPuzzle();
    }
}
