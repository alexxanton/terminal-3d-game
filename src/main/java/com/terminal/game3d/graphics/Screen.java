package com.terminal.game3d.graphics;

import com.terminal.game3d.entities.Player;

public class Screen extends Thread {
    private char[][][] gameGrid;
    private String[][][] colorGrid;
    private Player player;
    private final int SCREEN_WIDTH = ScreenDimensions.SCREEN_WIDTH.getDimension();
    private final String TOP_BORDER = "\033[H╔" + "═".repeat(SCREEN_WIDTH + 2) + "╗\n";
    private final String FLOOR = "║ \033[32m" + "█".repeat(SCREEN_WIDTH) + "\033[0m ║\n";
    private final String BOTTOM_BORDER = "╚" + "═".repeat(SCREEN_WIDTH + 2) + "╝";
    private StringBuilder screenBuilder = new StringBuilder("");
    private final String[] WALL_COLORS = {"\033[36m\033[46m", "\033[36m\033[44m", "\033[34m\033[44m"};

    
    public Screen(char[][][] gameGrid, String[][][] colorGrid, Player player) {
        this.gameGrid = gameGrid;
        this.colorGrid = colorGrid;
        this.player = player;
        System.out.print("\033[2J"); // clear screen
    }

    public void drawScreen() {
        int player_z = player.getZ();
        int index = (int) Math.min(2, Math.floor((player_z + 2) / 3));
        String wallColor = WALL_COLORS[index];
        screenBuilder.append(TOP_BORDER);
        
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

    @Override
    public void run() {
        while (true) {
            drawScreen();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
