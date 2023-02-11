import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class GridTest {


    @Test
    void gridSizeCheck() {
        Grid grid = new Grid(10);
        assertEquals(10, grid.getxRows());
        //assertEquals(100, grid.getGrid().size());
    }

    @Test
    void randomnessCheckAndQueryFromDB() {
        Grid grid = new Grid(10);
        //Gui gui = new Gui(grid.getGrid(), grid.getxRows());
        //Game game = new Game(grid, gui);

        int elem = 1000;
        MySQLTest sql = new MySQLTest("jdbc:mysql://localhost:3306/junit", "root", "admin");

        sql.deleteTable("randtest");
        grid.changeCoveredElements(10);
        ArrayList<ArrayList<Integer>> dataBaseArray = new ArrayList<>();
        for (int i = 0; i < elem; i++) {
            grid.createPuzzle();
            //System.out.println("inserted " + i);
            sql.insertArr("randtest", i, "idx", "cell", grid.getCoveredCells());
            grid.deselectAllSelected();
        }

        for (int i = 0; i < elem; i++) {
            dataBaseArray.add(sql.selectArr("randtest", i, "idx", "cell"));
        }

        for (int i = 0; i < elem; i++) {
            if (i > 0) {
                //System.out.println("compared " + i);
                for (int j = i - 1; j > 0; j--) {
                    assertNotEquals(dataBaseArray.get(i), dataBaseArray.get(j), "Random function created same sample after " + i + " draw");
                }
            }


        }


        sql.close();
    }

}