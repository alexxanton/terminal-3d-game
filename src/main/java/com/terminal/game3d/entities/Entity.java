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
    
    protected void render2DEntity(char[][][] shape, int section, char symbol, String color) {
        for (int row = 0; row < shape[section].length; row++) {
            for (int col = 0; col < shape[section][row].length; col++) {
                if (shape[section][row][col] == BLOCK) {
                    gameGrid[z][y + row][x + col] = symbol;
                    colorGrid[z][y + row][x + col] = color;
                }
            }
        }
    }

    protected void render3DEntity(char[][][] shape, int[] sections, char symbol, String color) {
        for (int depth = 0; depth < sections.length; depth++) {
            int section = sections[depth];
            int center_y = Math.round(shape[section].length) / 2;

            for (int row = 0; row < shape[section].length; row++) {
                int center_x = Math.round(shape[section][row].length) / 2;

                for (int col = 0; col < shape[section][row].length; col++) {
                    if (shape[z + section][row][col] == BLOCK) {
                        try {
                            gameGrid[z + depth][y - center_y + row][x - center_x + col] = symbol;
                            colorGrid[z + depth][y - center_y + row][x - center_x + col] = color;
                        } catch (IndexOutOfBoundsException e) {
                        }
                    }
                }
            }
        }
    }

    protected abstract void updatePosition();
}
