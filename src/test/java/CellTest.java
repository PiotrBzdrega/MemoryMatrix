import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void IsCellSelected() {
        Cell cell = new Cell();
        assertFalse(cell.isSelected());
        cell.select();
        assertTrue(cell.isSelected());
        cell.deselect();
        assertFalse(cell.isSelected());

    }

    @Test
    void cellState() {
        Cell cell = new Cell();
        assertFalse(cell.isState());
        cell.lightUp();
        assertTrue(cell.isState());
        cell.fadeOut();
        assertFalse(cell.isState());
    }
}