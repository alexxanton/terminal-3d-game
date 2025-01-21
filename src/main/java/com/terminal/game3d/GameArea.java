package com.terminal.game3d;

public class GameArea {
    private Screen screen = new Screen();
    private char[][][] gameArea = new char[screen.getDepth()][screen.getHeight()][screen.getWidth()];
    private Player player = new Player();
    private char[][] sprite = {
        {' ', '@', ' '},
        {'/', '|', '\\'},
        {'/', ' ', '\\'}
    };
    

    public GameArea() {
        for (int z = 0; z < gameArea.length; z++) {
            for (int y = 0; y < gameArea[z].length; y++) {
                for (int x = 0; x < gameArea[z][y].length; x++) {
                    gameArea[z][y][x] = ' ';
                }
            }
        }
    }
        

    public void start() {
        while (true) {
            screen.drawScreen(gameArea[player.getZ()]);
            player.move();
        }
    }
}
