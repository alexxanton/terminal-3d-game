package com.terminal.game3d;

public class GameArea {
    final private char PLAYER_CHAR = '▄';
    private final char EMPTY_SPACE = ' ';
    private Screen screen = new Screen();
    private char[][][] gameArea = new char[screen.getDepth()][screen.getHeight()][screen.getWidth()];
    private Player player = new Player(screen.getWidth(), screen.getHeight(), screen.getDepth());
    

    public GameArea() {
        for (int z = 0; z < gameArea.length; z++) {
            for (int y = 0; y < gameArea[z].length; y++) {
                for (int x = 0; x < gameArea[z][y].length; x++) {
                    gameArea[z][y][x] = ' ';
                }
            }
        }
    }
     
    private void updatePlayer() {
        gameArea[player.getZ()][player.getY()][player.getX()] = EMPTY_SPACE;
        player.move();
        gameArea[player.getZ()][player.getY()][player.getX()] = PLAYER_CHAR;
    }

    public void start() {
        while (true) {
            screen.drawScreen(gameArea[player.getZ()]);
            updatePlayer();
        }
    }
}
