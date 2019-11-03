package by.home.snake.user_interaction;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class UserActionController {

    private EnumSnakeDirection enumSnakeDirection;
    private EnumGamepadVersion gamepad;

    public UserActionController(EnumGamepadVersion gamepadVersion, Scene scene) {
        addEventHandler(scene);

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
    private void addEventHandler(Scene scene) {
        scene.addEventHandler(
                KeyEvent.KEY_PRESSED,
                keyEvent -> setEnumSnakeDirection(keyEvent.getCode())
        );
    }
}
