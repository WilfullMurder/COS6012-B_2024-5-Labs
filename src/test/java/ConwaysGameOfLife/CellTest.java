package ConwaysGameOfLife;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void isAliveReturnsTrueWhenCellIsAlive() {
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

    @Test
    void isAliveReturnsFalseWhenCellIsDead() {
        Cell cell = new Cell(false);
        assertFalse(cell.isAlive());
    }

    @Test
    void setAliveChangesCellStateToAlive() {
        Cell cell = new Cell(false);
        cell.setAlive(true);
        assertTrue(cell.isAlive());
    }

    @Test
    void setAliveChangesCellStateToDead() {
        Cell cell = new Cell(true);
        cell.setAlive(false);
        assertFalse(cell.isAlive());
    }
}