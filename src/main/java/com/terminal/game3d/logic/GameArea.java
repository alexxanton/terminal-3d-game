package com.terminal.game3d.logic;

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
    public static int z_axis = 2;
    public Player player = new Player(0, 0, 2, true);
    public Player player2 = new Player(10, 0, 2, false);
    public Screen screen = new Screen(gameGrid, colorGrid, player);

    
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
        new Meteorite(10, 5, 0).start();
        new Meteorite(10, 5, 1).start();
        new Meteorite(10, 5, 2).start();
        new Meteorite(10, 5, 3).start();
        new Meteorite(10, 5, 4).start();
    }
}
