package ConwaysGameOfLife;

/**
 * Represents a worker that updates a specific row of the grid in Conway's Game of Life.
 */
public class Worker implements Runnable {
    private final Cell[][] grid;
    private final int row;
    private final int columns;

    /**
     * Constructs a Worker with the specified grid, row, and number of columns.
     *
     * @param grid the grid of cells
     * @param row the row to be updated
     * @param columns the number of columns in the grid
     */
    public Worker(Cell[][] grid, int row, int columns) {
        this.grid = grid;
        this.row = row;
        this.columns = columns;
    }

    /**
     * Runs the worker to update the specified row of the grid based on the rules of Conway's Game of Life.
     */
    @Override
    public void run() {
        if (grid.length == 0 || columns == 0) {
            return;
        }

        Cell[] newRow = new Cell[columns];
        for (int i = 0; i < columns; i++) {
            int aliveNeighbors = countAliveNeighbors(row, i);
            boolean isAlive = grid[row][i].isAlive();

            if (isAlive && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
                newRow[i] = new Cell(false);
            } else if (!isAlive && aliveNeighbors == 3) {
                newRow[i] = new Cell(true);
            } else {
                newRow[i] = new Cell(isAlive);
            }
        }
        System.arraycopy(newRow, 0, grid[row], 0, columns);
    }

    /**
     * Counts the number of alive neighbors for a cell at the specified row and column.
     *
     * @param row the row of the cell
     * @param col the column of the cell
     * @return the number of alive neighbors
     */
    private int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < grid.length && c >= 0 && c < columns) {
                    if (grid[r][c].isAlive()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}