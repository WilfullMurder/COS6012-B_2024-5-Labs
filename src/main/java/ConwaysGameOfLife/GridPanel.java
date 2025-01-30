package ConwaysGameOfLife;

import javax.swing.*;
import java.awt.*;

/**
 * A panel that displays the grid for Conway's Game of Life.
 */
public class GridPanel extends JPanel {
    private final Grid grid;
    private static final int CELL_SIZE = 20;

    /**
     * Constructs a GridPanel with the specified grid.
     *
     * @param grid the grid to be displayed
     */
    public GridPanel(Grid grid) {
        this.grid = grid;
        setPreferredSize(new Dimension(grid.getGrid()[0].length * CELL_SIZE, grid.getGrid().length * CELL_SIZE));
        setBackground(Color.BLACK);
    }

    /**
     * Paints the grid on the panel.
     *
     * @param g the Graphics object used for painting
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Cell[][] cells = grid.getGrid();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isAlive()) {
                    g.setColor(Color.DARK_GRAY);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.GRAY);
                g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}