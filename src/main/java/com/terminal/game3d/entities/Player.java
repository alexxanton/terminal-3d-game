package com.terminal.game3d.entities;

import com.terminal.game3d.control.Control;

public class Player extends Entity {
    private final float JUMP_FORCE = 0.9f;
    private final float GRAVITY = 0.05f;
    private Control control = Control.getInstance();
    private int lateralMovement = 0;
    private boolean isJumping = false;
    private float verticalVelocity = 0;
    private boolean isPlayer1;
    private static String currentDirection;
    private final String UP_KEY = "w";
    private final String DOWN_KEY = "s";
    private final String LEFT_KEY;
    private final String RIGHT_KEY;
    private final String JUMP_KEY;

    public Player(int x, int y, int z, char symbol, boolean isPlayer1) {
        super(x, y, z, symbol);
        this.y = screenHeight - 1;
        this.isPlayer1 = isPlayer1;

        if (isPlayer1) {
            LEFT_KEY = "a";
            RIGHT_KEY = "d";
            JUMP_KEY = " ";
        } else {
            LEFT_KEY = "j";
            RIGHT_KEY = "l";
            JUMP_KEY = "k";
        }
    }

    @Override
    public void run() {
        if (!isPlayer1) {
            return;
        }
        if (currentDirection == null) {
            currentDirection = "";
        }
        while (true) {
            String key = Character.toString(control.readKeys());
            currentDirection = key.toLowerCase();
        }
    }

    private void handleInput() {
        if (currentDirection.equals(LEFT_KEY)) {
            if (lateralMovement < 10) {
                lateralMovement += 10;
            }
        } else if (currentDirection.equals(RIGHT_KEY)) {
            if (lateralMovement > -10) {
                lateralMovement += -10;
            }
        } else if (currentDirection.equals(UP_KEY)) {
            z--;
            if (z < 0) {
                z = 0;
            }
        } else if (currentDirection.equals(DOWN_KEY)) {
            z++;
            if (z > screenDepth - 1) {
                z = screenDepth - 1;
            }
        } else if (currentDirection.equals(JUMP_KEY)) {
            isJumping = true;
        }

        if (!isPlayer1) {
            currentDirection = "";
        }
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

        
        if (isJumping && y == screenHeight - 1) {
            verticalVelocity = JUMP_FORCE;
        }

        if (y > screenHeight - 5) {
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
