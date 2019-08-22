import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game_Field extends Application {
    // 1. throws Exception is never used
    // 2. есть такой принцип - single responsobility - сейчас метода две респонсобилити:
    // стартовать приложение и рисовать фигуры. Нужно разбить на два метода, или вынести создание фигур в отдельный класс,
    // подумай как правильнее (подсказка - для классов single responsobility  тоже работает)
    // Rectangl, Circle и Polygon наследуются от Shape может создавать их как Shape?

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setTitle("Okoshechko");
        Scene s = new Scene(root, 500, 500);
        primaryStage.setScene(s);

        Rectangle rectangle = new Rectangle(200, 200, 100, 100);
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10);
        rectangle.setFill(Color.GRAY);

        root.getChildren().addAll(rectangle);
        primaryStage.show();


        s.setOnKeyPressed(event -> {
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

        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}

