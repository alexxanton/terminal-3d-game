package com.terminal.game3d.graphics;

public class Screen {
    private static final int SCREEN_WIDTH = 50;
    private static final int SCREEN_HEIGHT = 20;
    private static final int SCREEN_DEPTH = 5;
    private final String TOP_BORDER = "\033[H╔" + "═".repeat(SCREEN_WIDTH + 2) + "╗\n";
    private final String FLOOR = "║ \033[32m" + "█".repeat(SCREEN_WIDTH) + "\033[0m ║\n";
    private final String BOTTOM_BORDER = "╚" + "═".repeat(SCREEN_WIDTH + 2) + "╝";
    private StringBuilder screenBuilder = new StringBuilder("");
    private final String[] WALL_COLORS = {"\033[46m", "\033[36m\033[44m", "\033[44m"};

    
    public Screen() {
        System.out.print("\033[2J"); // clear screen
    }

    public void drawScreen(char[][][] gameGrid, String[][][] colorGrid, int player_z) {
        screenBuilder.append(TOP_BORDER);
        int index = (int) Math.min(2, Math.floor((player_z + 2) / 3));
        String wallColor = WALL_COLORS[index];
        
        for (int y = 0; y < gameGrid[player_z].length; y++) {
            screenBuilder.append("║ " + wallColor);
            for (int x = 0; x < gameGrid[player_z][y].length; x++) {
                String color = colorGrid[player_z][y][x].isEmpty() ? "" : wallColor;
                screenBuilder.append(colorGrid[player_z][y][x]).append(gameGrid[player_z][y][x]).append(color);
            }
            screenBuilder.append("\033[0m ║\n");
        }
        screenBuilder.append(FLOOR).append(BOTTOM_BORDER);

        System.out.println(screenBuilder);
        screenBuilder.setLength(0);
    }

    public static int getHeight() {
        return SCREEN_HEIGHT;
    }

    public static int getWidth() {
        return SCREEN_WIDTH;
    }

    public static int getDepth() {
        return SCREEN_DEPTH;
    }
}
