package com.terminal.game3d.entities;

import java.util.Random;

import com.terminal.game3d.graphics.Colors;

public class Meteorite extends Entity {
    private final char[][][] METEORITE_SHAPES = {
        {
            {' ','█','█','█','█',' '},
            {'█','█','█','█','█','█'},
            {'█','█','█','█','█','█'},
            {' ','█','█','█','█',' '},
        },
        {
            {' ',' ','█','█','█','█','█','█',' ',' '},
            {' ','█','█','█','█','█','█','█','█',' '},
            {'█','█','█','█','█','█','█','█','█','█'},
            {'█','█','█','█','█','█','█','█','█','█'},
            {' ','█','█','█','█','█','█','█','█',' '},
            {' ',' ','█','█','█','█','█','█',' ',' '},
        },
        {
            {' ',' ','█','█','█','█','█','█','█','█','█','█',' ',' '},
            {' ','█','█','█','█','█','█','█','█','█','█','█','█',' '},
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█'},
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█'},
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█'},
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█'},
            {' ','█','█','█','█','█','█','█','█','█','█','█','█',' '},
            {' ',' ','█','█','█','█','█','█','█','█','█','█',' ',' '},
        },
    };

    private final int[][] METEORITE_VARIANTS = {
        {0},
        {0, 1, 0},
        {0, 1, 2, 1, 0}
    };

    private Random rand = new Random();
    private int[] variant;

    public Meteorite(int x, int y, int z) {
        super(x, y, z);
        this.color = Colors.values()[rand.nextInt(0, Colors.values().length)].getColor();
        this.symbol = BLOCK;
        this.variant = METEORITE_VARIANTS[rand.nextInt(0, METEORITE_VARIANTS.length)];
    }
    
    @Override
    public void renderEntity() {
        draw3DShape(METEORITE_SHAPES, variant, false, "");
        updatePosition();
        draw3DShape(METEORITE_SHAPES, variant, true, color);

        if (y > SCREEN_HEIGHT) {
            isAlive = false;
            draw3DShape(METEORITE_SHAPES, variant, false, "");
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePosition() {
        verticalVelocity -= GRAVITY;
        y -= Math.ceil(verticalVelocity);
    }
}
