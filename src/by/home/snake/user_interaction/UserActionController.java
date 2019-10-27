package by.home.snake.user_interaction;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class UserActionController {

    private EnumSnakeDirection enumSnakeDirection;

    public UserActionController(Scene scene) {
        //используется созданная в window сцена
        setEventHandler(scene);
        this.enumSnakeDirection = EnumSnakeDirection.UP;
    }

    private void setEnumSnakeDirection(KeyCode inputCode) {
        // устанавливаем направление, заданное с клавиатуры
        switch (inputCode) {
            case UP:
                enumSnakeDirection = EnumSnakeDirection.UP;
                break;
            case DOWN:
                enumSnakeDirection = EnumSnakeDirection.DOWN;
                break;
            case LEFT:
                enumSnakeDirection = EnumSnakeDirection.LEFT;
                break;
            case RIGHT:
                enumSnakeDirection = EnumSnakeDirection.RIGHT;
                break;
        }
    }

    public EnumSnakeDirection getEnumSnakeDirection() {
        return enumSnakeDirection;
    }

    // получаем команды с клавиатуры
    private void setEventHandler(Scene scene) {
        // задали сцене EventHandler и переопределили метод handle который
        // отрабатывает на нажатие клавиши (см. анонимный класс)
        scene.setOnKeyPressed(event -> setEnumSnakeDirection(event.getCode()));
    }
}
