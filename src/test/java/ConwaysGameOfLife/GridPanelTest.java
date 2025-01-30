package ConwaysGameOfLife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class GridPanelTest {
    private Grid grid;
    private GridPanel gridPanel;

    @BeforeEach
    void setUp() {
        grid = new Grid(3, 3);
        gridPanel = new GridPanel(grid);
    }

    @Test
    void gridPanelHasCorrectPreferredSize() {
        Dimension expectedSize = new Dimension(3 * 20, 3 * 20);
        assertEquals(expectedSize, gridPanel.getPreferredSize());
    }

    @Test
    void gridPanelBackgroundIsBlack() {
        assertEquals(Color.BLACK, gridPanel.getBackground());
    }

    @Test
    void paintComponentDrawsAliveCells() {
        grid.getGrid()[1][1].setAlive(true);
        BufferedImage image = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        gridPanel.paintComponent(g);
        g.dispose();
        assertTrue(grid.getGrid()[1][1].isAlive());
    }

    @Test
    void paintComponentDrawsDeadCells() {
        grid.getGrid()[1][1].setAlive(false);
        BufferedImage image = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        gridPanel.paintComponent(g);
        g.dispose();
        assertFalse(grid.getGrid()[1][1].isAlive());
    }
}