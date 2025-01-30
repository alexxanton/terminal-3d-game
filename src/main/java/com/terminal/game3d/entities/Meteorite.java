package com.terminal.game3d.entities;

public class Meteorite extends Entity {
    public Meteorite(int x, int y, int z, char symbol, char[][][] gameGrid, String[][][] colorGrid, int[] screenDimensions) {
        super(x, y, z, symbol);
    }
    
    @Override
    public void render() {
    }

    @Override
    public void updatePosition() {
    }
}
