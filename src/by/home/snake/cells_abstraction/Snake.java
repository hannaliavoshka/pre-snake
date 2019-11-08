package by.home.snake.cells_abstraction;

import java.util.ArrayDeque;

public class Snake {
    // змея это коллекция ссылок на клетки (очередь)
    private ArrayDeque<Cell> snake;
    private State state;
    private String name;

    public Snake(String name, Cell cell) {
        this.snake = new ArrayDeque<>();
        this.name = name;
        //when the snake is created, it needs a one Cell for it's body
        grow(cell);
    }

    public static enum State {
        MOVE,
        GROW,
        BYTE_ITSELF,
        BUMP_INTO_WALL
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // змея может двигаться, если продвижение вперед прошло успешно - вернем true
    public boolean move(Cell cell) {
        // если врезались сами в себя возвращаем false - змея умирает
        if (!isByteItself(cell)) {
            state = State.BYTE_ITSELF;
            return false;
        }
        // если еда - змея растёт, если просто движение - змея движется
        if (isGrow(cell)) {
            grow(cell);
            state = State.GROW;
        } else {
            snake.addFirst(cell);
            cell.setState(Cell.State.SNAKE);
            snake.getLast().setState(Cell.State.DEFAULT);
            snake.removeLast();
            state = State.MOVE;
        }

        return true;
    }

    public Cell getSnakeHead() {
        return snake.getFirst();
    }

    public int getSnakeSize() {
        return snake.size();
    }

    public String getName() {
        return name;
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
    private boolean isByteItself(Cell cell) {
        return cell != null && (cell.getState() != Cell.State.SNAKE);
    }

}
