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
                    gameIsRunning = snakeIsAlive(x - 1, y);
                    break;
                case DOWN:
                    gameIsRunning = snakeIsAlive(x + 1, y);
                    break;
                case LEFT:
                    gameIsRunning = snakeIsAlive(x, y - 1);
                    break;
                case RIGHT:
                    gameIsRunning = snakeIsAlive(x, y + 1);
                    break;
            }

            // если змея съела еду,то генерируем новую еду
            if (snake.getState() == Snake.State.GROW) {
                generateFood();
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

    private boolean snakeIsAlive(int x, int y) {
        // выход за пределы массива поля равнозначен столкновению со стеной
        if (x > BORDER_COORDINATE || x < 0 ||
                y > BORDER_COORDINATE || y < 0) {
            snake.setState(Snake.State.BUMP_INTO_WALL);
            System.out.println("Дурында врезалась в стену :(");
            return false;
        }

        snake.move(field.getCell(x, y));

        if (snake.getState() == Snake.State.BYTE_ITSELF) {
            System.out.println("Балда укусила себя за хвост :(");
            return false;
        }
        // если змея осталась жива
        return true;
    }

    private void sleep() {
        try {
            Thread.sleep(gameSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
