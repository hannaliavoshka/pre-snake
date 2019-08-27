import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    private static double cellSize = 100; // cell side size
    private boolean state = false; // active/passive cell state (passive (false) = empty cell, active (true) = snake or food)

    // getters
    public double getCellSize() {
        return cellSize;
    }

    public boolean getState() {
        return state;
    }

    // setters
    public void setCellSize(double size) {
        cellSize = size;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    // cell constructor
    public Cell(double x, double y) {
        this.setX(x);
        this.setY(y);
        this.switchState();
    }

    // switch active/passive cell state
    public void switchState(){
        if(this.getState() == false){
            this.setFill(Color.WHITE);
        } else{
            this.setFill(Color.GRAY);
        }

    }


}
