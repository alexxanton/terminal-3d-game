package com.terminal.game3d.entities;

import com.terminal.game3d.graphics.Screen;
import com.terminal.game3d.graphics.WallShades;
import com.terminal.game3d.logic.GameArea;

public abstract class Entity extends Thread {
    protected int screenWidth;
    protected int screenHeight;
    protected int screenDepth;
    protected int z;
    protected int x;
    protected int y;
    protected char symbol;
    protected String color;


    public Entity(int x, int y, int z) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.screenWidth = Screen.getWidth();
        this.screenHeight = Screen.getHeight();
        this.screenDepth = Screen.getDepth();
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

    public void render() {
        GameArea.gameGrid[z][y][x] = WallShades.values()[z].getSymbol();
        GameArea.colorGrid[z][y][x] = "";
        updatePosition();
        GameArea.gameGrid[z][y][x] = symbol;
        GameArea.colorGrid[z][y][x] = color;
    }

    public abstract void updatePosition();
}
