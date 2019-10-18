package by.home.snake;

import by.home.snake.cells_abstraction.Cell;
import by.home.snake.cells_abstraction.Field;
import by.home.snake.cells_abstraction.Snake;
import by.home.snake.user_interaction.SnakeDirection;
import by.home.snake.user_interaction.UserActionController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;


//TODO please split this class to double another classes:
//first for extends of Application. It contains:
// 1 - main
// 2 - start
// 3 - field
public class Window extends Application {

    private static final String WINDOW_TITLE = "DOBRA-KOBRA!";
    private double windowSize = Field.SIDE_SIZE * Cell.CELL_SIZE;

    public Field field;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Group rootGroup = new Group();
        Scene rootScene = new Scene(rootGroup, windowSize, windowSize);

        UserActionController controller = new UserActionController(rootScene);
        controller.setEventHandler();

        field = new Field();
        fillGroup(rootGroup);

        Snake snake = new Snake(field.getCell(5, 5));
        // создать еду

        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(rootScene);
        primaryStage.show();

        TheGame game = new TheGame(controller, snake, field);

        Thread actions = new Thread(game);
        // когда все основные потоки завершат свою работу, потоки демоны будут закрыты.
        actions.setDaemon(true);
        actions.start();
    }

    private void fillGroup(Group group) {
        for (int i = 0; i < field.SIDE_SIZE; i++) {
            for (int j = 0; j < field.SIDE_SIZE; j++) {
                group.getChildren().addAll(field.getCell(i, j));
            }
        }
    }

}
