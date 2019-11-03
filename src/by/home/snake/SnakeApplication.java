package by.home.snake;

import by.home.snake.cells_abstraction.Snake;
import by.home.snake.user_interaction.EnumGamepadVersion;
import by.home.snake.user_interaction.SnakeController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SnakeApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // создали окно, включающее игровое поле
        Window window = new Window(primaryStage);

        // создали персонажей - кобру и питона
        Snake cobra = new Snake(window.getField().getCell(7,7));
        Snake python = new Snake(window.getField().getCell(4,4));

        // создали контроллеры для змей
        SnakeController cobraController = new SnakeController(EnumGamepadVersion.VERSION_ULDR, window.getRootScene(), cobra);
        SnakeController pythonController = new SnakeController(EnumGamepadVersion.VERSION_WASD, window.getRootScene(), python);

        // список игроков, управленцев змей
        List<SnakeController> snakeRiders = new ArrayList<>();
        snakeRiders.add(cobraController);
        snakeRiders.add(pythonController);

        // создали игровую задачу
        TheGame game = new TheGame(snakeRiders, window.getField());

        // создали процесс под игру
        Thread actions = new Thread(game);
        // когда все основные потоки завершат свою работу, потоки демоны будут закрыты.
        actions.setDaemon(true);
        // запускаем процесс игры
        actions.start();
    }
}
