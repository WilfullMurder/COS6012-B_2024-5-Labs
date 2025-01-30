# Conway's Game of Life

Conway's Game of Life is a cellular automaton devised by the British mathematician John Horton Conway in 1970. It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. The game consists of a grid of cells that can live, die, or multiply based on a few mathematical rules.

## Rules
1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

## Files
- `Main.java` – The entry point that sets up and starts the game.
- `Grid.java` – Represents the grid for Conway's Game of Life.
- `GridPanel.java` – A panel that displays the grid.
- `Cell.java` – Represents a cell in the game.
- `Worker.java` – A worker that updates a specific row of the grid.

## How it Works
The program runs Conway's Game of Life by following these steps:  
1. **Initialization:**  
   - The grid is initialized with a specified number of rows and columns.
   - Each cell in the grid is randomly set to be alive or dead.
2. **Display:**
   - The grid is displayed on a JPanel using GridPanel.
3. **Update:**  
   - The grid is updated based on the rules of Conway's Game of Life:
     - Any live cell with fewer than two live neighbors dies (underpopulation).
     - Any live cell with two or three live neighbors lives on to the next generation.
     - Any live cell with more than three live neighbors dies (overpopulation).
     - Any dead cell with exactly three live neighbors becomes a live cell (reproduction).
   - The update is performed using concurrency to improve performance.
4. **Repaint:**  
   - The grid is repainted every 500 milliseconds to reflect the changes.

## Why it Works
The program uses a combination of `Java Swing` for the graphical user interface (**GUI**) and **concurrency** for efficient grid updates. 
The `Grid` class manages the state of the cells, while the `Worker` class updates each row of the grid concurrently. 
The `GridPanel` class handles the rendering of the grid on the screen.

### Concurrency
Concurrency is used to improve the performance of the grid updates. 
By dividing the grid into rows and updating each row concurrently using multiple threads, 
the program can take advantage of multi-core processors to perform updates faster. 
This approach reduces the time required to update the entire grid, 
making the game run more smoothly and efficiently.

### Domain Decomposition
Domain decomposition is a concurrency technique used in this program. 
The grid is divided into smaller subdomains (rows), 
and each subdomain is processed independently by a separate thread. 
This allows multiple threads to work on different parts of the grid simultaneously, 
leading to faster updates and better performance.

Below is an example of how the rows could be assigned to threads on a dual-core processor.

![Domain Decomposition Flowchart](https://github.com/user-attachments/assets/530e8ade-6e24-4f1c-89e0-df3de95dd50d)


### Benefits of Concurrency
- **Improved Performance:** By updating multiple rows of the grid concurrently, 
the program can complete the update process faster, 
leading to a more responsive and fluid game experience.
- **Efficient Resource Utilization:** Utilizing multiple threads allows the program to make better use of the available CPU cores,
distributing the workload and preventing any single core from becoming a bottleneck.
- **Scalability:** The concurrent update approach can easily scale with the number of available CPU cores, 
making it suitable for running on both single-core and multi-core systems.


Overall, the use of concurrency in updating the grid ensures that the game runs efficiently, providing a smooth and optimal experience for the user.

## Usage
To run the program, execute the `Main` class. 
The program will create a window displaying the grid and will start updating the grid every 500 milliseconds.

## Notes
- The grid size and update interval can be adjusted in the Main class.
- The initial state of the grid is randomly generated, so each run may produce different results.
- The program uses Java Swing for the graphical user interface and Java concurrency utilities for efficient grid updates.
