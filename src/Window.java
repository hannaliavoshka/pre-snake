import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application {
    public static final String WINDOW_TITLE = "DOBRA-KOBRA!";
    private double windowSize = GameField.SIDE_CELLS_QUANTITY * Cell.CELL_SIZE;

    //Will add all children to rootGroup
    public void setStage(GameField gameField) {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group rootGroup = new Group();
        primaryStage.setTitle(WINDOW_TITLE);
        Scene rootScene = new Scene(rootGroup, windowSize, windowSize);
        primaryStage.setScene(rootScene);
        GameField gameField = new GameField();
        setStage(gameField);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
