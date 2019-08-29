import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameField extends Application {
    //это будет не Application
    //содержать массив


    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setTitle("DOBRA-KOBRA!");
        Scene s = new Scene(root, 500, 500);
        primaryStage.setScene(s);

        // 10 -> в константу
        Cell[][] cells = new Cell[10][10];

        int x = 0;
        int y = 0;

        /*        Яра
        //List<List<Cell>> cells = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Cell> cellList = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                cellList.add(new Cell(x,y));
                x += Cell.CELL_SIZE;
            }
            cells.add(cellList);
            y += Cell.CELL_SIZE;
            x = 0;
        }

        for (List<Cell> cell : cells) {
            root.getChildren().addAll(cell);
        }*/

        // путаница в именах
        for (Cell[] lineOfCells : cells){
            for (Cell cell : lineOfCells){
                cell = new Cell(x,y);
                x+=Cell.CELL_SIZE;
                root.getChildren().add(cell);
            }
            y+=Cell.CELL_SIZE;
            x=0;
        }

        primaryStage.show();

        /*s.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            switch (key) {
                case UP:
                    rectangle.setY(rectangle.getY() - 10);
                    break;
                case DOWN:
                    rectangle.setY(rectangle.getY() + 10);
                    break;
                case LEFT:
                    rectangle.setX(rectangle.getX() - 10);
                    break;
                case RIGHT:
                    rectangle.setX(rectangle.getX() + 10);
                    break;
            }

        });*/

    }

    public static void main(String[] args) {
        launch(args);
    }
}

