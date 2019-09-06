
public class GameField {

    public static final int SIDE_CELLS_QUANTITY = 10;
    public Cell[][] cells;


    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    // creates a Game Field
    public GameField() {
        initField();
    }

    // adds cells in the Game Field
    private void initField() {
        cells = new Cell[SIDE_CELLS_QUANTITY][SIDE_CELLS_QUANTITY];
        int x = 0;
        int y = 0;
        for (Cell[] lineOfCells : cells) {
            for (Cell cell : lineOfCells) {
                cell = new Cell(x, y);
                // проверка, удалить потом. Выводит данные клетки, то есть на данном этапе объект клетки существует.
                System.out.println(cell);
                x += Cell.CELL_SIZE;
            }
            y += Cell.CELL_SIZE;
            x = 0;
        }
    }

}




