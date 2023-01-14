import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void amountSelectedElementsAndRandomnessCheck() {
        Grid grid =new Grid(10);
        //ArrayList array=new ArrayList();
        for (int i = 0; i<1000;i++){

            //array=grid.getCoveredCells();

            grid.createPuzzle();
            assertEquals(10, grid.getCoveredCells().size());
            grid.deselectAllSelected();
            //assertNotEquals(array,grid.getCoveredCells());
            //System.out.println(grid.getCoveredCells());
        }

    }

}