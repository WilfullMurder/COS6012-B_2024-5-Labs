package ConwaysGameOfLife;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void gridInitializationSetsCorrectDimensions() {
        Grid grid = new Grid(5, 10);
        assertEquals(5, grid.getGrid().length);
        assertEquals(10, grid.getGrid()[0].length);
    }

    @Test
    void gridInitializationSetsSomeCellsAlive() {
        Grid grid = new Grid(5, 10);
        boolean hasAliveCells = false;
        for (Cell[] row : grid.getGrid()) {
            for (Cell cell : row) {
                if (cell.isAlive()) {
                    hasAliveCells = true;
                    break;
                }
            }
        }
        assertTrue(hasAliveCells);
    }

    @Test
    void updateDoesNotThrowException() {
        Grid grid = new Grid(5, 10);
        assertDoesNotThrow(grid::update);
    }
}