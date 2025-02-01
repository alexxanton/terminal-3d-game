package com.terminal.game3d.entities;

import com.terminal.game3d.graphics.ScreenDimensions;
import com.terminal.game3d.graphics.WallShades;
import com.terminal.game3d.logic.GameArea;

public abstract class Entity extends Thread {
    protected final int SCREEN_WIDTH = ScreenDimensions.SCREEN_WIDTH.getDimension();
    protected final int SCREEN_HEIGHT = ScreenDimensions.SCREEN_HEIGHT.getDimension();
    protected final int SCREEN_DEPTH = ScreenDimensions.SCREEN_DEPTH.getDimension();
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
            render();
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

    protected void drawCharacter() {
        gameGrid[z][y][x] = WallShades.values()[z].getSymbol();
        colorGrid[z][y][x] = "";
        updatePosition();
        gameGrid[z][y][x] = symbol;
        colorGrid[z][y][x] = color;
    }

    protected void render() {
        drawCharacter();
    }

    protected abstract void updatePosition();
}
