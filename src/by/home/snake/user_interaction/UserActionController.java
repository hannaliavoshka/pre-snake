package by.home.snake.user_interaction;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class UserActionController {

    private Scene scene;
    private Direction direction;

    public UserActionController(Scene scene) {
        //используется созданная в window сцена
        this.scene = scene;
        this.direction = Direction.UP;
    }

    private void setDirection(KeyCode inputCode) {
        // устанавливаем направление, заданное с клавиатуры
        switch (inputCode) {
            case UP:
                direction = Direction.UP;
                break;
            case DOWN:
                direction = Direction.DOWN;
                break;
            case LEFT:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.RIGHT;
                break;
        }
    }

    // получаем команды с клавиатуры
    public void setEventHandler() {
        // задали сцене EventHandler и переопределили метод handle который
        // отрабатывает на нажатие клавиши (см. анонимный класс)
        scene.setOnKeyPressed(event -> setDirection(event.getCode()));
    }

    public Direction getDirection() {
        return direction;
    }
}
