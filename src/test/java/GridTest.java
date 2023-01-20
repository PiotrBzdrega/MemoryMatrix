import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void amountSelectedElementsAndRandomnessCheck() {
        Grid grid =new Grid(10);
        grid.changeCoveredElements(10);
        for (int i = 0; i<1000;i++){

            grid.createPuzzle();
            assertEquals(10, grid.getCoveredCells().size());
            grid.deselectAllSelected();
        }

    }

}