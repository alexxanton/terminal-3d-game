package com.terminal.game3d.entities;

import com.terminal.game3d.control.Control;

public class Player {
    private Control control = new Control();
    private int player_z = 2;
    private int player_x = 0;
    private int player_y;
    private int screenHeight;
    private int screenWidth;
    private int screenDepth;
    private String direction = "";
    private int movement = 0;
    private boolean jump = false;
    private float velocity = 0;
    private Thread controlThread = new Thread(() -> getPressedKey());
    private final int BASE_JUMP = 11;
    private final int GRAVITY = 9;

    
    public Player(int screenWidth, int screenHeight, int screenDepth) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.screenDepth = screenDepth;
        player_y = this.screenHeight - 1;
        controlThread.start();
    }

    private void getPressedKey() {
        while (true) {
            String key = Character.toString(control.readKeys());
            direction = key.toLowerCase();
        }
    }

    private void checkPressedKey() {
        switch (direction) {
            case "a":
                if (movement < 10) {
                    movement += 10;
                }
                break;
            case "d":
                if (movement > -10) {
                    movement += -10;
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
                    jump = true;
                }
                break;
            case "m":
                break;
        }

        direction = "";
    }

    public void updatePlayerPosition() {
        if (movement > 0) {
            player_x--;
            movement--;
            if (player_x < 0) {
                player_x = 0;
            }
        } else if (movement < 0) {
            player_x++;
            movement++;
            if (player_x > screenWidth - 1) {
                player_x = screenWidth - 1;
            }
        }

        
        if (jump) {
            velocity = BASE_JUMP;
            jump = false;
        }
        
        velocity -= 0.1;
        player_y -= Math.round(velocity) - GRAVITY;
        
        if (player_y > screenHeight - 1) {
            player_y = screenHeight - 1;
        } else if (player_y < 0) {
            player_y = 0;
        }

        checkPressedKey();
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
