package by.home.snake.user_interaction;

import by.home.snake.cells_abstraction.Snake;
import javafx.scene.Scene;

public class SnakeController extends UserActionController {

    private Snake snake;

    public SnakeController(EnumGamepadVersion gamepadVersion, Scene scene, Snake snake) {
        super(gamepadVersion, scene);
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
    }
}
