package by.home.snake.cells_abstraction;

import by.home.snake.utils.Coordinate;
import javafx.util.Pair;

/**
 * Game Field is a net that consists of cells. A by.home.snake.cells_abstraction.Cell is an elementary unit of the game.
 */
public class Field {

    public static final int SIDE_SIZE = 10;
    private Cell[][] cellNet;

    public Field() {
        cellNet = new Cell[SIDE_SIZE][SIDE_SIZE];
        fillCellNet();
    }

    public Cell getCell(int x, int y) {
        return cellNet[x][y];
    }

    private void fillCellNet() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < cellNet.length; i++) {
            for (int j = 0; j < cellNet.length; j++) {

                Cell cell = new Cell(x,y);
                cell.setCoordinate(new Coordinate(i,j));

                cellNet[i][j] = cell;
                x += Cell.CELL_SIZE;
            }
            y += Cell.CELL_SIZE;
            x = 0;
        }
    }

}




