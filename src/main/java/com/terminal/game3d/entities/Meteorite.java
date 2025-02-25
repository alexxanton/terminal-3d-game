package com.terminal.game3d.entities;

import java.util.Random;

import com.terminal.game3d.graphics.WallShades;

public class Meteorite extends Entity {
    private char[][][] meteorites = {
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

    private int[][] sizes = {
        {0},
        {0, 1, 0},
        {0, 1, 2, 1, 0}
    };

    private int[] size;
    private Random random = new Random();

    public Meteorite(int x, int y, int z) {
        super(x, y, z);
        this.color = COLOR_RED;
        this.symbol = BLOCK;
        this.size = sizes[random.nextInt(0, 2)];
    }
    
    @Override
    public void renderEntity() {
        render3DEntity(meteorites, size, WallShades.values()[z].getSymbol(), "");
        updatePosition();
        render3DEntity(meteorites, size, BLOCK, COLOR_RED);
    }

    @Override
    public void updatePosition() {
    }
}
