package by.home.snake;

import by.home.snake.cells_abstraction.Cell;
import by.home.snake.cells_abstraction.GameField;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    public void start(Stage primaryStage) {
        Group rootGroup = new Group();
        Scene rootScene = new Scene(rootGroup, windowSize, windowSize);
        gameField = new GameField();

        fillGroup(rootGroup);

        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(rootScene);
        primaryStage.show();

        //  ---
    }

    private void fillGroup(Group group) {
        for (int i = 0; i < gameField.SIDE_SIZE; i++) {
            for (int j = 0; j < gameField.SIDE_SIZE; j++) {
                group.getChildren().addAll(gameField.getCell(i,j));
            }
        }
    }
}
