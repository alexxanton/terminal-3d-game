package com.terminal.game3d;

public class Screen {
    private final int SCREEN_WIDTH = 40;
    private final int SCREEN_HEIGHT = 5;
    private final int SCREEN_DEPTH = 5;

    public Screen() {
        System.out.print("\033[2J"); // clear screen
    }

    public void drawScreen(char[][] gameArea) {
        System.out.print("\033[H"); // move cursor to top left corner
        System.out.println("╔" + "═".repeat(SCREEN_WIDTH + 2) + "╗");
        
        for (int y = 0; y < gameArea.length; y++) {
            System.out.print("║ ");
            for (int x = 0; x < gameArea[y].length; x++) {
                System.out.print(gameArea[y][x]);
            }
            System.out.println(" ║");
        }
        System.out.println("║ \033[32m" + "█".repeat(SCREEN_WIDTH) + "\033[0m ║");
        System.out.println("╚" + "═".repeat(SCREEN_WIDTH + 2) + "╝");
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
