package com.terminal.game3d.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.terminal.game3d.entities.Entity;
import com.terminal.game3d.entities.Meteorite;
import com.terminal.game3d.entities.Player;
import com.terminal.game3d.graphics.Screen;
import com.terminal.game3d.graphics.ScreenDimensions;
import com.terminal.game3d.graphics.WallShades;

public class GameArea {
    private static final int SCREEN_WIDTH = ScreenDimensions.SCREEN_WIDTH.getDimension();
    private static final int SCREEN_HEIGHT = ScreenDimensions.SCREEN_HEIGHT.getDimension();
    private static final int SCREEN_DEPTH = ScreenDimensions.SCREEN_DEPTH.getDimension();
    public static char[][][] gameGrid = new char[SCREEN_DEPTH][SCREEN_HEIGHT][SCREEN_WIDTH];
    public static String[][][] colorGrid = new String[SCREEN_DEPTH][SCREEN_HEIGHT][SCREEN_WIDTH];
    public static List<Entity> collideableEntities = new ArrayList<>();
    public static int z_axis = 2;
    private Player player = new Player(0, 0, 2, true);
    private Player player2 = new Player(10, 0, 2, false);
    private Screen screen = new Screen(gameGrid, colorGrid, player);
    private Random rand = new Random();

    
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

    public void start() {
        player.start();
        player2.start();
        screen.start();
        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            int x = rand.nextInt(0, SCREEN_WIDTH);
            int y = 0;
            int z = rand.nextInt(0, 1);
            int delay = rand.nextInt(1, 3);
            collideableEntities.add(new Meteorite(x, y, z));

            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
