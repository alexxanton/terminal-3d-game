package com.terminal.game3d.logic;

import com.terminal.game3d.entities.Player;
import com.terminal.game3d.graphics.Screen;
import com.terminal.game3d.utils.WallShades;

public class GameArea {
    private Screen screen = new Screen();
    private char[][][] gameArea = new char[screen.getDepth()][screen.getHeight()][screen.getWidth()];
    private Player player = new Player(gameArea, screen.getWidth(), screen.getHeight(), screen.getDepth());
    private Thread gameLoop = new Thread(() -> gameLoop());

    
    public GameArea() {
        for (int z = 0; z < gameArea.length; z++) {
            for (int y = 0; y < gameArea[z].length; y++) {
                for (int x = 0; x < gameArea[z][y].length; x++) {
                    gameArea[z][y][x] = WallShades.values()[z].getSymbol();
                }
            }
        }
    }

    private void gameLoop() {
        while (true) {
            screen.drawScreen(gameArea, player.getZ());
            player.renderPlayer();
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
