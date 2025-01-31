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

    private void drawCharacter() {
        GameArea.gameGrid[z][y][x] = WallShades.values()[z].getSymbol();
        GameArea.colorGrid[z][y][x] = "";
        updatePosition();
        GameArea.gameGrid[z][y][x] = symbol;
        GameArea.colorGrid[z][y][x] = color;
    }

    public void render() {
        drawCharacter();
    }

    public abstract void updatePosition();
}
