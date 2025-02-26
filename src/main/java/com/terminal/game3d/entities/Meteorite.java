package com.terminal.game3d.entities;

import java.util.Random;

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
        this.color = COLOR_RED;
        this.symbol = BLOCK;
        this.variant = METEORITE_VARIANTS[rand.nextInt(0, METEORITE_VARIANTS.length)];
    }
    
    @Override
    public void renderEntity() {
        draw3DShape(METEORITE_SHAPES, variant, false, "");
        updatePosition();
        draw3DShape(METEORITE_SHAPES, variant, true, COLOR_RED);
    }

    @Override
    public void updatePosition() {
        verticalVelocity -= GRAVITY;
        y -= Math.ceil(verticalVelocity);
        y = Math.max(0, Math.min(y, SCREEN_HEIGHT - 1));
    }
}
