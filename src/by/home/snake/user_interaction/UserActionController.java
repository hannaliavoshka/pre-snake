package by.home.snake.user_interaction;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class UserActionController {

    private Scene scene;
    private SnakeDirection snakeDirection;

    public UserActionController(Scene scene) {
        //используется созданная в window сцена
        this.scene = scene;
        this.snakeDirection = SnakeDirection.UP;
    }

    private void setSnakeDirection(KeyCode inputCode) {
        // устанавливаем направление, заданное с клавиатуры
        switch (inputCode) {
            case UP:
                snakeDirection = SnakeDirection.UP;
                break;
            case DOWN:
                snakeDirection = SnakeDirection.DOWN;
                break;
            case LEFT:
                snakeDirection = SnakeDirection.LEFT;
                break;
            case RIGHT:
                snakeDirection = SnakeDirection.RIGHT;
                break;
        }
    }

    // получаем команды с клавиатуры
    public void setEventHandler() {
        // задали сцене EventHandler и переопределили метод handle который
        // отрабатывает на нажатие клавиши (см. анонимный класс)
        scene.setOnKeyPressed(event -> setSnakeDirection(event.getCode()));
    }

    public SnakeDirection getSnakeDirection() {
        return snakeDirection;
    }
}
