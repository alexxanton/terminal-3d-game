package com.terminal.game3d.entities;

import com.terminal.game3d.graphics.ScreenDimensions;
import com.terminal.game3d.graphics.WallShades;
import com.terminal.game3d.logic.GameArea;

public abstract class Entity extends Thread {
    protected final int SCREEN_WIDTH = ScreenDimensions.SCREEN_WIDTH.getDimension();
    protected final int SCREEN_HEIGHT = ScreenDimensions.SCREEN_HEIGHT.getDimension();
    protected final int SCREEN_DEPTH = ScreenDimensions.SCREEN_DEPTH.getDimension();
    protected final char BLOCK = '█';
    protected final String COLOR_RED = "\033[31m";
    protected final String COLOR_GREEN = "\033[32m";
    protected int z;
    protected int x;
    protected int y;
    protected char symbol;
    protected String color;
    private char[][][] gameGrid = GameArea.gameGrid;
    private String[][][] colorGrid = GameArea.colorGrid;


    public Entity(int x, int y, int z) {
        this.z = z;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while (true) {
            renderEntity();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void renderEntity() {
        gameGrid[z][y][x] = WallShades.values()[z].getSymbol();
        colorGrid[z][y][x] = "";
        updatePosition();
        gameGrid[z][y][x] = symbol;
        colorGrid[z][y][x] = color;
    }
    
    protected void drawCharacters(char[][][] entity, int section, char symbol, String color) {
        for (int i = 0; i < entity[section].length; i++) {
            for (int j = 0; j < entity[section][i].length; j++) {
                if (entity[section][i][j] == BLOCK) {
                    gameGrid[z][y + i][x + j] = symbol;
                    colorGrid[z][y + i][x + j] = color;
                }
            }
        }
    }

    protected abstract void updatePosition();
}
