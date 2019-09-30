package by.home.snake.cells_abstraction;

import java.util.ArrayDeque;

public class Snake {
    // змея это коллекция ссылок на клетки (очередь)
    private ArrayDeque<Cell> snake;

    public Snake(Cell cell) {
        snake = new ArrayDeque<>();
        grow(cell);

        //when the snake is created, it needs a one Cell for it's body
        //cell.setState(Cell.State.SNAKE); //isTODO merge invocation of method setState and inv meth addFirst to one private method
        //snake.addFirst(cell); //TODO to be careful to use arrayDeque methods, read the spec
        // https://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html
    }

    // змея может двигаться
    public boolean move(Cell cell){
        //isTODO isAlive? then return false
        //isTODO isGROw? if yes then not delete tail and retun true, if no next to do
        //isTODO: snake add first cell and remove the last return true

        boolean isMove = false;
        if (isAlive(cell)){
            if (isGrow(cell)){
                grow(cell);
            } else {
                snake.addFirst(cell);
                snake.removeLast();
            }
            isMove = true;
        }
        return isMove;
    }

    private void grow (Cell cell){
        cell.setState(Cell.State.SNAKE);
        snake.addFirst(cell);
    }

    // змея может вырасти (если при добавлении новой координаты окажется что такая есть - умираем)
    private boolean isGrow(Cell cell){
        //isTODO: if cell state is apple return true
        return (cell.getState() == Cell.State.FOOD);
    }

    private boolean isAlive(Cell cell){
        // в этом ли методе мы обрабатываем исключение null? Думаю, исключение вылезет раньше, когда мы попытаемся
        // обратиться к несуществующему элементу массива cellNet
        //TODO if cell state is snake or end of field (NULL)
        return (cell.getState() != Cell.State.SNAKE);
    }

}
