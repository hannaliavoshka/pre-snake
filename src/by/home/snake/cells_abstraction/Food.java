package by.home.snake.cells_abstraction;

import static by.home.snake.TheGame.BORDER_COORDINATE;

public class Food {

    private Cell food;

    public Food(Field field) {
        generateIn(field);
    }

    public void generateIn(Field field) {
        Cell food = null;
        while (food == null) {
            int x = (int) (Math.random() * BORDER_COORDINATE);
            int y = (int) (Math.random() * BORDER_COORDINATE);
            Cell potentialFood = field.getCell(x, y);
            if (potentialFood.getState() == Cell.State.DEFAULT) {
                food = potentialFood;
                food.setState(Cell.State.FOOD);
            }
        }
    }

}
