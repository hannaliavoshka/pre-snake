package by.home.snake.user_interaction;
import java.util.HashMap;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    //isTODO adde field InpSrtreReader or use JavaFX libs
    private Scene scene;
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();

    // конструктор, используется созданная в window сцена
    public Controller (Scene scene){
        this.scene = scene;
    }
    // возвращает направление, заданное с клавиатуры
    public Direction getDirection(){
        //isTODO get direction from UI
        Direction direction = null;
        if(isPressed(KeyCode.UP)){
            direction = Direction.UP;
        } else if(isPressed(KeyCode.DOWN)){
            direction = Direction.DOWN;
        } else if(isPressed(KeyCode.LEFT)){
            direction = Direction.LEFT;
        } else if(isPressed(KeyCode.RIGHT)){
            direction = Direction.RIGHT;
        }
        return direction;
    }
    // получаем команды с клавиатуры
    private void getKeyCode (){
        scene.setOnKeyPressed(event -> {
            keys.put(event.getCode(), true);
        });

        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
        });
    }
    //проверяет, была ли нажата заданная клавиша
    private boolean isPressed(KeyCode key){
        return keys.getOrDefault(key, false);
    }




}
