package com.terminal.game3d.graphics;

public enum Colors {
    COLOR_RED("\033[31m"),
    COLOR_GREEN("\033[32m"),
    COLOR_YELLOW("\033[33m"),
    COLOR_PURPLE("\033[35m");

    private final String color;
    
    private Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
