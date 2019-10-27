package by.home.snake;

import by.home.snake.cells_abstraction.Field;
import by.home.snake.cells_abstraction.Food;
import by.home.snake.cells_abstraction.Snake;
import by.home.snake.user_interaction.SnakeController;
import by.home.snake.utils.Coordinate;

import java.util.List;


public class TheGame implements Runnable {

    public static final int BORDER_COORDINATE = Field.SIDE_SIZE - 1;

    private List<SnakeController> controllers;
    private Field field;
    private Food food;

    // TODO хотелось бы чтобы была прямая зависимость
    private long gameSpeed = 500;

    public TheGame(List<SnakeController> controllers, Field field) {
        this.controllers = controllers;
        this.field = field;
    }

    @Override
    public void run() {
        //стартовая генерация еды
        food = new Food(field);

        // проверяем не умерли ли все змеи в начале каждой итерации
        while (!isGameOver()) {
            // задержка между фреймами игры
            sleep();

            // совершаем необходимый набор действий для каждой змейки
            for (SnakeController controller : controllers) {
                snakeInAction(controller);
            }
        }
    }

    private void snakeInAction(SnakeController controller) {
        Snake snake = controller.getSnake();
        Coordinate coordinate = snake.getSnakeHead().getCoordinate();
        int x = coordinate.getX();
        int y = coordinate.getY();

        switch (controller.getEnumSnakeDirection()) {
            case UP:
                //TODO должен ли метод снейкИзМувиг принадлежать ЗеГейму ?
                snakeIsMoving(snake,x - 1, y);
                break;
            case DOWN:
                snakeIsMoving(snake,x + 1, y);
                break;
            case LEFT:
                snakeIsMoving(snake,x, y - 1);
                break;
            case RIGHT:
                snakeIsMoving(snake,x, y + 1);
                break;
        }

        // если змея съела еду,то генерируем новую еду
        if (snake.getState() == Snake.State.GROW) {
            food.generateIn(field);
        }
    }

    private boolean isGameOver() {
        // количество мертвых змей
        int deadSnakes = 0;

        // идем по контроллера и проверяем сколько змей мертво
        for (SnakeController controller : controllers) {
            Snake snake = controller.getSnake();
            Snake.State state = snake.getState();

            // если змея укусила себя за хвост (или кусанула кого ещё) или ударилась в стену, - она мертва
            if(state == Snake.State.BYTE_ITSELF || state == Snake.State.BUMP_INTO_WALL) {
                deadSnakes++;
            }

            // если количество мертвых змей равно количеству контроллеров - все змеи умерли и значит игра завершена
            if(controllers.size() == deadSnakes){
                return true;
            }
        }
        return false;
    }

    private void snakeIsMoving(Snake snake, int x, int y) {
        // выход за пределы массива поля равнозначен столкновению со стеной
        if (x > BORDER_COORDINATE || x < 0 ||
                y > BORDER_COORDINATE || y < 0) {
            snake.setState(Snake.State.BUMP_INTO_WALL);
            System.out.println("Дурында врезалась в стену :(");
            // возвращаемся из метода, дальнейшее продвижение невозможно, - врезались в стену - змея мертва
            return;
        }

        snake.move(field.getCell(x, y));

        if (snake.getState() == Snake.State.BYTE_ITSELF) {
            System.out.println("Балда укусила себя за хвост :(");
        }
    }

    private void sleep() {
        try {
            Thread.sleep(gameSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
