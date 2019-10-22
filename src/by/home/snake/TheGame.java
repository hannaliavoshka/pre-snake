package by.home.snake;

import by.home.snake.cells_abstraction.Cell;
import by.home.snake.cells_abstraction.Field;
import by.home.snake.cells_abstraction.Snake;
import by.home.snake.user_interaction.UserActionController;
import by.home.snake.utils.Coordinate;


public class TheGame implements Runnable {

    private static final int BORDER_COORDINATE = Field.SIDE_SIZE - 1;

    private UserActionController controller;
    private Snake snake;
    private Field field;

    private long gameSpeed = 500;

    public TheGame(UserActionController controller, Snake snake, Field field) {
        this.controller = controller;
        this.snake = snake;
        this.field = field;
    }

    @Override
    public void run() {

        //TODO - включить проверку, жива ли змея (не съела ли себя)
        boolean gameIsRunning = true;
        //стартовая генерация еды
        generateFood();

        while (gameIsRunning) {

            // задержка между фреймами игры
            sleep();

            Coordinate coordinate = snake.getSnakeHead().getCoordinate();
            int x = coordinate.getX();
            int y = coordinate.getY();

            switch (controller.getSnakeDirection()) {
                case UP:
                    gameIsRunning = snakeIsMoving(x - 1, y);
                    break;
                case DOWN:
                    gameIsRunning = snakeIsMoving(x + 1, y);
                    break;
                case LEFT:
                    gameIsRunning = snakeIsMoving(x, y - 1);
                    break;
                case RIGHT:
                    gameIsRunning = snakeIsMoving(x, y + 1);
                    break;
            }
            // спрашиваем у змеи, нужна ли ей еда, если да - генерируем ее, меняем флаг на отрицательный
            if (snake.needFood) {
                generateFood();
                snake.needFood = false;
            }
        }
    }

    private void generateFood() {
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

    private boolean snakeIsMoving(int x, int y) {
        // выход за пределы массива поля равнозначен столкновению со стеной
        if (x > BORDER_COORDINATE || x < 0 ||
                y > BORDER_COORDINATE || y < 0) {

            System.out.println("Новый ну что ж.. = )");
            return false;
        }

        return snake.move(field.getCell(x, y));
    }

    private void sleep() {
        try {
            Thread.sleep(gameSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
