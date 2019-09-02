
public class GameField  {

    public static final int SIDE_CELLS_QUANTITY = 10;

    //!!!!Don't know how to implement it in this class
    public Cell getCell(int x,int y){
        return 
    }

    // creates a Game Field
    public GameField(){
        Cell[][] cellField = initField();
    }

    // adds cells in the Game Field
    private Cell[][] initField(){
        Cell[][] cells = new Cell[SIDE_CELLS_QUANTITY][SIDE_CELLS_QUANTITY];
        int x = 0;
        int y = 0;
        for (Cell[] lineOfCells : cells){
            for (Cell cell : lineOfCells){
                cell = new Cell(x,y);
                x+=Cell.CELL_SIZE;
            }
            y+=Cell.CELL_SIZE;
            x=0;
        }
        return cells;
    }







    }




