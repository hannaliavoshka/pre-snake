import javafx.scene.shape.Rectangle;

public class Cell {

    private double cellSize = 100; // cell side size
    private double x; // X cell coordinate
    private double y; // Y cell coordinate
    private boolean state; // active/passive cell state (passive (false) = empty cell, active (true) = snake or food)

    // getters
    public double getCellSize() {
        return cellSize;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean getState() {
        return state;
    }

    // setters
    public void setCellSize(double cellSize) {
        this.cellSize = cellSize;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    // cell constructor
    public Cell(double x, double y) {
        this.x = x;
        this.y = y;
        state = false;
        Rectangle rectangle = new Rectangle(x,y,cellSize,cellSize);
    }


}
