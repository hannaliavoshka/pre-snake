package by.home.snake.cells_abstraction;

import java.util.ArrayDeque;

public class Snake {
    // змея это коллекция ссылок на клетки (очередь)
    private ArrayDeque<Cell> snake;

    public Snake(Cell cell) {
        snake = new ArrayDeque<>();

        //when the snake is created, it needs a one Cell for it's body
        cell.setState(Cell.State.SNAKE); //TODO merge invocation of method setState and inv meth addFirst to one private method
        snake.addFirst(cell); //TODO to be careful to use arrayDeque methods, read the spec
        // https://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html
    }

    // змея может двигаться
    public boolean move(Cell cell){
        //TODO isAlive? then return false
        //TODO isGROw? if yes then not delete tail and retun true, if no next todo
        //TODO: snake add first cell and remove the last return true
        return false;
    }

    // змея может вырасти (если при добавлении новой координаты окажется что такая есть - умираем)
    private boolean isGrow(Cell cell){
        //TODO: if cell state is apple return true
        return false;
    }

    private boolean isAlive(Cell cell){
        //TODO if cell state is snake or end of field (NULL)
        return false;
    }

}
