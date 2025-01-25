package com.terminal.game3d.utils;

public enum WallShades {
    BACK_SHADE(' '),
    DARK_SHADE('▓'),
    MEDIUM_SHADE('▒'),
    LIGHT_SHADE('░'),
    FRONT_SHADE(' ');

    private final char symbol;

    private WallShades(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
