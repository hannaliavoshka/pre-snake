package by.home.snake.user_interaction;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class UserActionController {

    private EnumSnakeDirection enumSnakeDirection;
    private EnumGamepadVersion gamepad;

    public UserActionController(EnumGamepadVersion gamepadVersion, Scene scene) {
        //используется созданная в window сцена
        setEventHandler(scene);

        this.gamepad = gamepadVersion;
        this.enumSnakeDirection = EnumSnakeDirection.UP;
    }

    private void setEnumSnakeDirection(KeyCode inputCode) {
        // устанавливаем направление, заданное с клавиатуры
        if (inputCode == gamepad.up()) {
            enumSnakeDirection = EnumSnakeDirection.UP;
        } else if (inputCode == gamepad.down()) {
            enumSnakeDirection = EnumSnakeDirection.DOWN;
        } else if (inputCode == gamepad.left()) {
            enumSnakeDirection = EnumSnakeDirection.LEFT;
        } else if (inputCode == gamepad.right()) {
            enumSnakeDirection = EnumSnakeDirection.RIGHT;
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
