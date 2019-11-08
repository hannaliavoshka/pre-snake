package by.home.snake;


public enum GameConstants {
    CELL_SIZE(17),
    SIDE_SIZE(40),
    GAME_SPEED(100); //time to thread waiting

    private int value;

    GameConstants(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
