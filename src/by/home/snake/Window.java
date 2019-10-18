package by.home.snake;

import by.home.snake.cells_abstraction.Cell;
import by.home.snake.cells_abstraction.Field;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window {

    private static final int FIELD_CENTER = Field.SIDE_SIZE/2;
    private static final String WINDOW_TITLE = "DOBRA-KOBRA!";
    private static final double WINDOW_SIZE = Field.SIDE_SIZE * Cell.CELL_SIZE;

    private Group rootGroup;
    private Scene rootScene;
    private Field field;

    public Window(Stage stage) {
        createWindow(stage);
    }

    public Scene getRootScene() {
        return rootScene;
    }

    public Field getField() {
        return field;
    }

    public Cell getCentralCell(){
        return field.getCell(FIELD_CENTER, FIELD_CENTER);
    }

    private void createWindow(Stage primaryStage) {
        rootGroup = new Group();
        rootScene = new Scene(rootGroup, WINDOW_SIZE, WINDOW_SIZE);

        field = new Field();
        fillGroup(rootGroup);

        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(rootScene);
        primaryStage.show();
    }

    private void fillGroup(Group group) {
        for (int i = 0; i < field.SIDE_SIZE; i++) {
            for (int j = 0; j < field.SIDE_SIZE; j++) {
                group.getChildren().addAll(field.getCell(i, j));
            }
        }
    }
}
