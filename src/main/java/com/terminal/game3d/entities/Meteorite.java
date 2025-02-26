package com.terminal.game3d.entities;

import java.util.Random;

import com.terminal.game3d.graphics.WallShades;

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
        draw3DShape(METEORITE_SHAPES, variant, WallShades.values()[z].getSymbol(), "");
        updatePosition();
        draw3DShape(METEORITE_SHAPES, variant, BLOCK, COLOR_RED);
    }

    @Override
    public void updatePosition() {
    }
}
