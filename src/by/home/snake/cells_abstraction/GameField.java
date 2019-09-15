package by.home.snake.cells_abstraction;

/**
 * Game Field is a net that consists of cells. A by.home.snake.cells_abstraction.Cell is an elementary unit of the game.
 */
//TODO: переименовать в просто FIELD
public class GameField {

    public static final int SIDE_SIZE = 10;
    private Cell[][] cellNet;

    public GameField() {
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
                cellNet[i][j] = new Cell(x,y);
                x += Cell.CELL_SIZE;
            }
            y += Cell.CELL_SIZE;
            x = 0;
        }
    }

}




