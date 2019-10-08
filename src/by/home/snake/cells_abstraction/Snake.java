package by.home.snake.cells_abstraction;

import java.util.ArrayDeque;

public class Snake {
    // змея это коллекция ссылок на клетки (очередь)
    private ArrayDeque<Cell> snake;

    public Snake(Cell cell) {
        snake = new ArrayDeque<>();
        //when the snake is created, it needs a one Cell for it's body
        grow(cell);
    }

    // змея может двигаться, если продвижение вперед прошло успешно - вернем true
    public boolean move(Cell cell) {
        // если врезались сами в себя возвращаем false
        if (!isAlive(cell)) {
            return false;
        }

        // если еда - растём, если нет - продвигаемся вперед.
        if (isGrow(cell)) {
            grow(cell);
        } else {
            snake.addFirst(cell);
            snake.removeLast();
        }

        return true;
    }

    public Cell getSnakeHead(){
        return snake.getFirst();
    }

    private void grow(Cell cell) {
        cell.setState(Cell.State.SNAKE);
        snake.addFirst(cell);
    }


    // if cell state is apple return true
    private boolean isGrow(Cell cell) {
        return (cell.getState() == Cell.State.FOOD);
    }

    // if state is snake return false
    private boolean isAlive(Cell cell) {
        return cell != null && (cell.getState() != Cell.State.SNAKE);
    }

}
