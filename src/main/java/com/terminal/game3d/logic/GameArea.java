package com.terminal.game3d.logic;

import com.terminal.game3d.entities.Player;
import com.terminal.game3d.graphics.Screen;
import com.terminal.game3d.graphics.WallShades;

public class GameArea {
    public static Screen screen = new Screen();
    public static char[][][] gameArea = new char[Screen.getDepth()][Screen.getHeight()][Screen.getWidth()];
    public static String[][][] colorGrid = new String[Screen.getDepth()][Screen.getHeight()][Screen.getWidth()];
    public static Player player = new Player(0, 0, 2, '█');
    private Thread gameLoop = new Thread(() -> gameLoop());

    
    public GameArea() {
        for (int z = 0; z < gameArea.length; z++) {
            for (int y = 0; y < gameArea[z].length; y++) {
                for (int x = 0; x < gameArea[z][y].length; x++) {
                    gameArea[z][y][x] = WallShades.values()[z].getSymbol();
                    colorGrid[z][y][x] = "";
                }
            }
        }
    }

    private void gameLoop() {
        while (true) {
            screen.drawScreen(gameArea, colorGrid, player.getZ());
            player.render();
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
