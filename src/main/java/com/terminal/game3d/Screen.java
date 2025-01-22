package com.terminal.game3d;

public class Screen {
    private final int SCREEN_WIDTH = 50;
    private final int SCREEN_HEIGHT = 20;
    private final int SCREEN_DEPTH = 5;
    private final String[] WALL_COLORS = {"\033[44m", "\033[34m\033[46m", "\033[34m\033[46m", "\033[34m\033[46m", "\033[46m"};

    public Screen() {
        System.out.print("\033[2J"); // clear screen
    }

    public void drawScreen(char[][][] gameArea, int player_z) {
        System.out.print("\033[H"); // move cursor to top left corner
        System.out.println("╔" + "═".repeat(SCREEN_WIDTH + 2) + "╗");
        
        for (int y = 0; y < gameArea[player_z].length; y++) {
            System.out.print("║ " + WALL_COLORS[player_z]);
            for (int x = 0; x < gameArea[player_z][y].length; x++) {
                if (gameArea[player_z][y][x] == '█') {
                    System.out.print("\033[31m" + gameArea[player_z][y][x] + WALL_COLORS[player_z]);
                } else {
                    System.out.print(gameArea[player_z][y][x]);
                }
            }
            System.out.println("\033[0m ║");
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
