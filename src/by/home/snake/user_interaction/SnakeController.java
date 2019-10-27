package by.home.snake.user_interaction;

import by.home.snake.cells_abstraction.Snake;
import javafx.scene.Scene;

public class SnakeController extends UserActionController {

    private Snake snake;

    public SnakeController(Scene scene, Snake snake) {
        super(scene);
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
    }
}
