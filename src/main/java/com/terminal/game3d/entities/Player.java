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
    private Thread controlThread = new Thread(() -> getDirection());

    public Player(int screenWidth, int screenHeight, int screenDepth) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.screenDepth = screenDepth;
        player_y = this.screenHeight - 1;
        controlThread.start();
    }

    private void getDirection() {
        while (true) {
            String key = Character.toString(control.readKeys());
            direction = key.toLowerCase();
        }
    }

    public void move() {
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
        switch (direction) {
            case "a":
                movement += 10;
                break;
            case "d":
                movement += -10;
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
        }

        direction = "";
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
