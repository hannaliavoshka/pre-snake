package by.home.snake;

import by.home.snake.cells_abstraction.Snake;
import by.home.snake.user_interaction.UserActionController;
import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // создали окно, включающее игровое поле
        Window window = new Window(primaryStage);

        // создали контроллер реагирующий на действия пользователя
        UserActionController controller = new UserActionController(window.getRootScene());
        controller.setEventHandler();

        // создали персонажа - кобру
        Snake snake = new Snake(window.getCentralCell());
        // создали игровую задачу
        TheGame game = new TheGame(controller, snake, window.getField());

        // создали процесс под игру
        Thread actions = new Thread(game);
        // когда все основные потоки завершат свою работу, потоки демоны будут закрыты.
        actions.setDaemon(true);
        // запускаем процесс игры
        actions.start();
    }
}
