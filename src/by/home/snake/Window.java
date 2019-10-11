package by.home.snake;

import by.home.snake.cells_abstraction.Cell;
import by.home.snake.cells_abstraction.GameField;
import by.home.snake.cells_abstraction.Snake;
import by.home.snake.user_interaction.Direction;
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
    private double windowSize = GameField.SIDE_SIZE * Cell.CELL_SIZE;

    public GameField gameField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Group rootGroup = new Group();
        Scene rootScene = new Scene(rootGroup, windowSize, windowSize);

        UserActionController controller = new UserActionController(rootScene);
        controller.setEventHandler();

        gameField = new GameField();
        fillGroup(rootGroup);

        Snake snake = new Snake(gameField.getCell(5, 5));
        // создать еду

        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(rootScene);
        primaryStage.show();

        // --- --- ---

        Thread actions = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean gameIsRunning = true;
                while (gameIsRunning) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Direction direction = controller.getDirection();

                    Cell head = snake.getSnakeHead();
                    Pair<Integer, Integer> coordinate = head.getCoordinate();
                    int x = coordinate.getKey();
                    int y = coordinate.getValue();

                    try {
                        switch (direction) {
                            case UP:
                                gameIsRunning = snake.move(gameField.getCell(x - 1, y));
                                break;
                            case DOWN:
                                gameIsRunning = snake.move(gameField.getCell(x + 1, y));
                                break;
                            case LEFT:
                                gameIsRunning = snake.move(gameField.getCell(x, y - 1));
                                break;
                            case RIGHT:
                                gameIsRunning = snake.move(gameField.getCell(x, y + 1));
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Ну что ж..");
                        gameIsRunning = false;
                    }
                }
            }
        });

        actions.start();
    }

    private void fillGroup(Group group) {
        for (int i = 0; i < gameField.SIDE_SIZE; i++) {
            for (int j = 0; j < gameField.SIDE_SIZE; j++) {
                group.getChildren().addAll(gameField.getCell(i, j));
            }
        }
    }

}
