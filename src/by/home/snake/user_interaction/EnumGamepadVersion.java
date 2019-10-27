package by.home.snake.user_interaction;

import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public enum EnumGamepadVersion {
    VERSION_WASD(KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D),
    VERSION_ULDR(KeyCode.UP, KeyCode.LEFT, KeyCode.DOWN, KeyCode.RIGHT);

    private Map<String, KeyCode> codes;

    EnumGamepadVersion(KeyCode up, KeyCode left, KeyCode down, KeyCode right) {
        this.codes = new HashMap<>();

        this.codes.put("UP", up);
        this.codes.put("LEFT", left);
        this.codes.put("DOWN", down);
        this.codes.put("RIGHT", right);
    }

    public KeyCode up(){
        return codes.get("UP");
    }

    public KeyCode left(){
        return codes.get("LEFT");
    }

    public KeyCode down(){
        return codes.get("DOWN");
    }

    public KeyCode right(){
        return codes.get("RIGHT");
    }
}
