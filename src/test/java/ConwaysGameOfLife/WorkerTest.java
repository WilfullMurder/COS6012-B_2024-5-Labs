package ConwaysGameOfLife;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void runUpdatesRowCorrectly() {
        Cell[][] grid = {
                {new Cell(false), new Cell(true), new Cell(false)},
                {new Cell(true), new Cell(true), new Cell(true)},
                {new Cell(false), new Cell(true), new Cell(false)}
        };
        Worker worker = new Worker(grid, 1, 3);
        worker.run();
        assertTrue(grid[1][0].isAlive());
        assertFalse(grid[1][1].isAlive());
        assertTrue(grid[1][2].isAlive());
    }

    @Test
    void runHandlesEdgeRowCorrectly() {
        Cell[][] grid = {
                {new Cell(false), new Cell(true), new Cell(false)},
                {new Cell(true), new Cell(true), new Cell(true)},
                {new Cell(false), new Cell(true), new Cell(false)}
        };
        Worker worker = new Worker(grid, 0, 3);
        worker.run();
        assertTrue(grid[0][0].isAlive());
        assertTrue(grid[0][1].isAlive());
        assertTrue(grid[0][2].isAlive());
    }

    @Test
    void runHandlesSingleCellRow() {
        Cell[][] grid = {
                {new Cell(true)}
        };
        Worker worker = new Worker(grid, 0, 1);
        worker.run();
        assertFalse(grid[0][0].isAlive());
    }

    @Test
    void runHandlesEmptyGrid() {
        Cell[][] grid = new Cell[0][0];
        Worker worker = new Worker(grid, 0, 0);
        assertDoesNotThrow(worker::run);
    }
}