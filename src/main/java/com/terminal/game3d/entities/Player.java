package com.terminal.game3d.entities;

import com.terminal.game3d.control.Control;

public class Player extends Entity {
    private final float JUMP_FORCE = 0.9f;
    private final float GRAVITY = 0.05f;
    private Control control = new Control();
    private String currentDirection = "";
    private int lateralMovement = 0;
    private boolean isJumping = false;
    private float verticalVelocity = 0;

    
    public Player(int x, int y, int z, char symbol) {
        super(x, y, z, symbol);
        this.y = screenHeight - 1;
    }

    @Override
    public void run() {
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
                z--;
                if (z < 0) {
                    z = 0;
                }
                break;
            case "s":
                z++;
                if (z > screenDepth - 1) {
                    z = screenDepth - 1;
                }
                break;
            case " ":
                if (y == screenHeight - 1) {
                    isJumping = true;
                }
                break;
            case "m":
                break;
        }

        currentDirection = "";
    }

    @Override
    public void updatePosition() {
        if (lateralMovement > 0) {
            x--;
            lateralMovement--;
            if (x < 0) {
                x = 0;
            }
        } else if (lateralMovement < 0) {
            x++;
            lateralMovement++;
            if (x > screenWidth - 1) {
                x = screenWidth - 1;
            }
        }

        
        if (isJumping) {
            verticalVelocity = JUMP_FORCE;
            isJumping = false;
        }
        
        verticalVelocity -= GRAVITY;
        y -= Math.ceil(verticalVelocity);
        
        if (y > screenHeight - 1) {
            y = screenHeight - 1;
        } else if (y < 0) {
            y = 0;
        }

        handleInput();
    }
}
