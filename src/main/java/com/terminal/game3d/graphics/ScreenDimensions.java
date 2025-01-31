package com.terminal.game3d.graphics;

public enum ScreenDimensions {
    SCREEN_WIDTH(50),
    SCREEN_HEIGHT(20),
    SCREEN_DEPTH(5);

    private final int dimension;

    private ScreenDimensions(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }
}
