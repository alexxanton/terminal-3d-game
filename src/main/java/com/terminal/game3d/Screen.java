package com.terminal.game3d;

public class Screen {
    private final int SCREEN_WIDTH = 40;
    private final int SCREEN_HEIGHT = 10;
    private final int SCREEN_DEPTH = 5;

    public Screen() {
        
    }

    public void drawScreen(char[][] gameArea) {
        System.out.println("╔" + "═".repeat(SCREEN_WIDTH) + "╗");
        for (int y = 0; y < gameArea.length; y++) {
            System.out.print("║");
            for (int x = 0; x < gameArea[y].length; x++) {
                System.out.print(gameArea[y][x]);
            }
            System.out.println("║");
        }
        System.out.println("╚" + "═".repeat(SCREEN_WIDTH) + "╝");
    }

    public int getHeight() {
        return SCREEN_HEIGHT;
    }

    public int getWidth() {
        return SCREEN_WIDTH;
    }

    public int getDepth() {
        return SCREEN_DEPTH;
    }
}
