package com.terminal.game3d.entities;

import com.terminal.game3d.control.Control;
import com.terminal.game3d.utils.WallShades;

public class Player {
    private final float JUMP_FORCE = 0.9f;
    private final float GRAVITY = 0.05f;
    private final char BLOCK = '█';
    private Control control = new Control();
    private char[][][] gameArea;
    private int player_z = 2;
    private int player_x = 0;
    private int player_y;
    private int screenHeight;
    private int screenWidth;
    private int screenDepth;
    private String currentDirection = "";
    private int lateralMovement = 0;
    private boolean isJumping = false;
    private float verticalVelocity = 0;
    private Thread inputThread = new Thread(() -> getPressedKey());

    
    public Player(char[][][] gameArea, int screenWidth, int screenHeight, int screenDepth) {
        this.gameArea = gameArea;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.screenDepth = screenDepth;
        player_y = screenHeight - 1;
        inputThread.start();
    }

    private void getPressedKey() {
        while (true) {
            String key = Character.toString(control.readKeys());
            currentDirection = key.toLowerCase();
        }
    }

    private void handleInput() {
        switch (currentDirection) {
            case "a":
                if (lateralMovement < 10) {
                    lateralMovement += 10;
                }
                break;
            case "d":
                if (lateralMovement > -10) {
                    lateralMovement += -10;
                }
                break;
            case "w":
                player_z--;
                if (player_z < 0) {
                    player_z = 0;
                }
                break;
            case "s":
                player_z++;
                if (player_z > screenDepth - 1) {
                    player_z = screenDepth - 1;
                }
                break;
            case " ":
                if (player_y == screenHeight - 1) {
                    isJumping = true;
                }
                break;
            case "m":
                break;
        }

        currentDirection = "";
    }

    private void updatePlayerPosition() {
        if (lateralMovement > 0) {
            player_x--;
            lateralMovement--;
            if (player_x < 0) {
                player_x = 0;
            }
        } else if (lateralMovement < 0) {
            player_x++;
            lateralMovement++;
            if (player_x > screenWidth - 1) {
                player_x = screenWidth - 1;
            }
        }

        
        if (isJumping) {
            verticalVelocity = JUMP_FORCE;
            isJumping = false;
        }
        
        verticalVelocity -= GRAVITY;
        player_y -= Math.ceil(verticalVelocity);
        
        if (player_y > screenHeight - 1) {
            player_y = screenHeight - 1;
        } else if (player_y < 0) {
            player_y = 0;
        }

        handleInput();
    }

    public void renderPlayer() {
        gameArea[player_z][player_y][player_x] = WallShades.values()[player_z].getSymbol();
        updatePlayerPosition();
        gameArea[player_z][player_y][player_x] = BLOCK;
    }

    public int getZ() {
        return player_z;
    }

    public int getX() {
        return player_x;
    }

    public int getY() {
        return player_y;
    }
}
