package com.terminal.game3d.entities;

import com.terminal.game3d.control.Control;

public class Player extends Entity {
    private final float JUMP_FORCE = 0.9f;
    private final float GRAVITY = 0.05f;
    private final String UP_KEY = "w";
    private final String DOWN_KEY = "s";
    private final String LEFT_KEY;
    private final String RIGHT_KEY;
    private final String JUMP_KEY;
    private final String PLAYER_1_DIRECTIONS = "wasd ";
    private final String PLAYER_2_DIRECTIONS = "jkl";
    
    private int lateralMovement = 0;
    private boolean isJumping = false;
    private boolean isPlayer1;
    private float verticalVelocity = 0;
    
    public Player(int x, int y, int z, boolean isPlayer1) {
        super(x, y, z);
        this.y = SCREEN_HEIGHT - 1;
        this.color = isPlayer1 ? COLOR_RED : COLOR_GREEN;
        this.symbol = BLOCK;
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

    private void handleInput() {
        if (Control.currentDirection.equals(LEFT_KEY)) {
            if (lateralMovement < 10) {
                lateralMovement += 10;
            }
        } else if (Control.currentDirection.equals(RIGHT_KEY)) {
            if (lateralMovement > -10) {
                lateralMovement += -10;
            }
        } else if (Control.currentDirection.equals(UP_KEY)) {
            // GameArea.z_axis--;
            z--;
            if (z < 0) {
                z = 0;
            }
        } else if (Control.currentDirection.equals(DOWN_KEY)) {
            z++;
            if (z > SCREEN_DEPTH - 1) {
                z = SCREEN_DEPTH - 1;
            }
        } else if (Control.currentDirection.equals(JUMP_KEY)) {
            isJumping = true;
        }

        if (isPlayer1 && PLAYER_1_DIRECTIONS.contains(Control.currentDirection)
        || !isPlayer1 && PLAYER_2_DIRECTIONS.contains(Control.currentDirection)) {
            Control.currentDirection = "";
        }
    }

    @Override
    public void updatePosition() {
        if (lateralMovement > 0) {
            x--;
            lateralMovement--;
            x = Math.max(x, 0);
        } else if (lateralMovement < 0) {
            x++;
            lateralMovement++;
            x = Math.min(x, SCREEN_WIDTH - 1);
        }

        
        if (isJumping && y == SCREEN_HEIGHT - 1) {
            verticalVelocity = JUMP_FORCE;
        }

        if (y > SCREEN_HEIGHT - 5) {
            isJumping = false;
        }
        
        verticalVelocity -= GRAVITY;
        y -= Math.ceil(verticalVelocity);
        y = Math.max(0, Math.min(y, SCREEN_HEIGHT - 1));

        handleInput();
    }
}
