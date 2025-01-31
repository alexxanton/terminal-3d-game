package com.terminal.game3d.logic;

import com.terminal.game3d.entities.Player;
import com.terminal.game3d.graphics.Screen;
import com.terminal.game3d.graphics.WallShades;

public class GameArea {
    public static Screen screen = new Screen();
    public static char[][][] gameGrid = new char[Screen.getDepth()][Screen.getHeight()][Screen.getWidth()];
    public static String[][][] colorGrid = new String[Screen.getDepth()][Screen.getHeight()][Screen.getWidth()];
    public Player player = new Player(0, 0, 2, true);
    public Player player2 = new Player(10, 0, 2, false);
    private Thread gameLoop = new Thread(() -> gameLoop());

    
    public GameArea() {
        for (int z = 0; z < gameGrid.length; z++) {
            for (int y = 0; y < gameGrid[z].length; y++) {
                for (int x = 0; x < gameGrid[z][y].length; x++) {
                    gameGrid[z][y][x] = WallShades.values()[z].getSymbol();
                    colorGrid[z][y][x] = "";
                }
            }
        }
    }

    private void gameLoop() {
        while (true) {
            screen.drawScreen(gameGrid, colorGrid, player.getZ());
            player.render();
            player2.render();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        player.start();
        player2.start();
        gameLoop.start();
    }
}
