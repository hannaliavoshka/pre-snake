package by.home.snake.cells_abstraction;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    public static final double CELL_SIZE = 50; // cell side size

    private State state; // cell state

    // cell constructor
    public Cell(double x, double y) {
        super(x, y, CELL_SIZE, CELL_SIZE);
        this.setState(State.DEFAULT);
        this.setStroke(Color.LIGHTGRAY);
    }

    // sets cell state and color
    public void setState(State state) {
        this.state = state;
        this.setFill(this.getState().getColor());
    }

    // returns cell state
    public State getState() {
        return state;
    }

    // cell state options
    public static enum State {

        DEFAULT {
            public Color getColor() {
                return Color.WHITE;
            }
        },
        SNAKE {
            public Color getColor() {
                return Color.GRAY;
            }
        },
        FOOD {
            public Color getColor() {
                return Color.TOMATO;
            }
        };

        public abstract Color getColor();

    }

}
