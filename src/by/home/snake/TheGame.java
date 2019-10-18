package by.home.snake;

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
        boolean gameIsRunning = true;
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
