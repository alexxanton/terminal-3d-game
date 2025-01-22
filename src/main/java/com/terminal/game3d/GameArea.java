package com.terminal.game3d;

public class GameArea {
    private Screen screen = new Screen();
    private char[][][] gameArea = new char[screen.getDepth()][screen.getHeight()][screen.getWidth()];
    private Player player = new Player(screen.getWidth(), screen.getHeight(), screen.getDepth());
    private final char BLOCK = '█';
    private final char LIGHT_SHADE = '░';
    private final char MEDIUM_SHADE = '▒';
    private final char DARK_SHADE = '▓';
    private final char EMPTY_SPACE = ' ';
    private Thread gameLoop = new Thread(() -> gameLoop());
    private final char[] WALL_SHADES = {EMPTY_SPACE, DARK_SHADE, MEDIUM_SHADE, LIGHT_SHADE, EMPTY_SPACE};
    
    

    public GameArea() {
        for (int z = 0; z < gameArea.length; z++) {
            for (int y = 0; y < gameArea[z].length; y++) {
                for (int x = 0; x < gameArea[z][y].length; x++) {
                    gameArea[z][y][x] = WALL_SHADES[z];
                }
            }
        }
    }
     
    private void updatePlayer() {
        gameArea[player.getZ()][player.getY()][player.getX()] = WALL_SHADES[player.getZ()];
        player.move();
        gameArea[player.getZ()][player.getY()][player.getX()] = BLOCK;
    }

    private void gameLoop() {
        while (true) {
            screen.drawScreen(gameArea, player.getZ());
            updatePlayer();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        gameLoop.start();
    }
}
