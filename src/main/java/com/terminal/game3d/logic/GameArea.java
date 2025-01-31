package com.terminal.game3d.logic;

import com.terminal.game3d.control.Control;
import com.terminal.game3d.entities.Player;
import com.terminal.game3d.graphics.Screen;
import com.terminal.game3d.graphics.ScreenDimensions;
import com.terminal.game3d.graphics.WallShades;

public class GameArea {
    public static char[][][] gameGrid = new char[ScreenDimensions.SCREEN_DEPTH.getDimension()][ScreenDimensions.SCREEN_HEIGHT.getDimension()][ScreenDimensions.SCREEN_WIDTH.getDimension()];
    public static String[][][] colorGrid = new String[ScreenDimensions.SCREEN_DEPTH.getDimension()][ScreenDimensions.SCREEN_HEIGHT.getDimension()][ScreenDimensions.SCREEN_WIDTH.getDimension()];
    public Control control = new Control();
    public static Player player = new Player(0, 0, 2, true);
    public Player player2 = new Player(10, 0, 2, false);
    public Screen screen = new Screen(gameGrid, colorGrid, player.getZ());

    
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
    }
}
