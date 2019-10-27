package by.home.snake;

import by.home.snake.cells_abstraction.Snake;
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

        // список игроков, управленцев змей
        List<SnakeController> snakeRiders = new ArrayList<>();

        // создали персонажа - кобру
        Snake snake = new Snake(window.getCentralCell());
        // создали контроллер для кобры
        SnakeController controller = new SnakeController(window.getRootScene(), snake);
        snakeRiders.add(controller);

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
