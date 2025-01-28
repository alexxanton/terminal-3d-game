package com.terminal.game3d.entities;

import com.terminal.game3d.graphics.WallShades;

public abstract class Entity {
    protected char[][][] gameArea;
    protected String[][][] colorGrid;
    protected int screenWidth;
    protected int screenHeight;
    protected int screenDepth;
    protected int z;
    protected int x;
    protected int y;
    protected char symbol;

    public Entity(int x, int y, int z, char symbol, char[][][] gameArea, String[][][] colorGrid, int[] screenDimensions) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.gameArea = gameArea;
        this.colorGrid = colorGrid;
        this.screenWidth = screenDimensions[0];
        this.screenHeight = screenDimensions[1];
        this.screenDepth = screenDimensions[2];
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

    public void render() {
        gameArea[z][y][x] = WallShades.values()[z].getSymbol();
        colorGrid[z][y][x] = "\033[0m";
        updatePosition();
        gameArea[z][y][x] = symbol;
        colorGrid[z][y][x] = "\033[31m";
    }

    public abstract void updatePosition();
}
