package ConwaysGameOfLife;

import javax.swing.*;

/**
 * The main class to run Conway's Game of Life.
 */
public class Main {
    /**
     * The main method to set up and start the game.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args){
        int rows = 50;
        int cols = 50;

        // Create the grid with the specified number of rows and columns
        Grid grid = new Grid(rows, cols);
        // Create the panel to display the grid
        GridPanel gridPanel = new GridPanel(grid);

        // Set up the main application window
        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gridPanel);
        frame.pack();
        frame.setVisible(true);

        // Set up a timer to update the grid and repaint the panel every 500 milliseconds
        new Timer(500, e -> {
            grid.update();
            gridPanel.repaint();
        }).start();
    }
}