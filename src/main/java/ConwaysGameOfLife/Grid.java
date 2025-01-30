package ConwaysGameOfLife;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Represents the grid for Conway's Game of Life.
 */
public class Grid {
    private final int rows;
    private final int columns;
    private final Cell[][] grid;

    /**
     * Constructs a Grid with the specified number of rows and columns.
     *
     * @param rows the number of rows in the grid
     * @param columns the number of columns in the grid
     */
    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Cell[this.rows][this.columns];
        initializeGrid();
    }

    /**
     * Initializes the grid with cells, randomly setting some cells to be alive.
     */
    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(Math.random() < 0.2);
            }
        }
    }

    /**
     * Updates the grid by applying the rules of Conway's Game of Life.
     * This method uses concurrency to update the grid.
     */
    public void update() {

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < rows; i++) {
            executor.execute(new Worker(grid, i, columns));
        }
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the grid of cells.
     *
     * @return a 2D array of cells representing the grid
     */
    public Cell[][] getGrid() {
        return grid;
    }
}