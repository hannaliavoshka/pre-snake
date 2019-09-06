import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application {
    public static final String WINDOW_TITLE = "DOBRA-KOBRA!";
    private double windowSize = GameField.SIDE_CELLS_QUANTITY * Cell.CELL_SIZE;

    //Will add all children to rootGroup
    public void fillGroup(GameField gameField, Group group) {

        for (Cell[] cellLine : gameField.cells) {
            for (Cell unit : cellLine) {
                try {
                    System.out.println("Unit " + unit); // проверка, удалить потом. На данном этапе каждый unit - null
                    group.getChildren().addAll(unit);
                } catch (NullPointerException e) {
                    //e.printStackTrace();
                    //break;
                }
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Group rootGroup = new Group();
        primaryStage.setTitle(WINDOW_TITLE);
        Scene rootScene = new Scene(rootGroup, windowSize, windowSize);
        primaryStage.setScene(rootScene);
        GameField gameField = new GameField();
        fillGroup(gameField, rootGroup);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
