package ConwaysGameOfLife;

/**
 * Represents a cell in the game of life.
 */
public class Cell {
    private boolean alive;

    /**
     * Constructs a Cell with the specified initial state.
     *
     * @param alive true if the cell is alive, false otherwise
     */
    public Cell(boolean alive) {
        this.alive = alive;
    }

    /**
     * Returns whether the cell is alive.
     *
     * @return true if the cell is alive, false otherwise
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Sets the state of the cell.
     *
     * @param alive true to set the cell as alive, false to set it as dead
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}