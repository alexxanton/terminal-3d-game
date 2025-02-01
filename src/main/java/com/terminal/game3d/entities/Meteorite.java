package com.terminal.game3d.entities;

public class Meteorite extends Entity {
    private char[][][] meteorites = {
        {
            {'█','█'},
            {'█','█'},
        },
        {
            {' ','█','█',' '},
            {'█','█','█','█'},
            {'█','█','█','█'},
            {' ','█','█',' '},
        },
        {
            {' ',' ','█','█',' ',' '},
            {' ','█','█','█','█',' '},
            {'█','█','█','█','█','█'},
            {'█','█','█','█','█','█'},
            {' ','█','█','█','█',' '},
            {' ',' ','█','█',' ',' '},
        },
        {
            {' ',' ',' ','█','█',' ',' ',' '},
            {' ',' ','█','█','█','█',' ',' '},
            {' ','█','█','█','█','█','█',' '},
            {'█','█','█','█','█','█','█','█'},
            {'█','█','█','█','█','█','█','█'},
            {' ','█','█','█','█','█','█',' '},
            {' ',' ','█','█','█','█',' ',' '},
            {' ',' ',' ','█','█',' ',' ',' '},
        },
        {
            {' ',' ','█','█','█','█',' ',' '},
            {' ','█','█','█','█','█','█',' '},
            {'█','█','█','█','█','█','█','█'},
            {'█','█','█','█','█','█','█','█'},
            {'█','█','█','█','█','█','█','█'},
            {'█','█','█','█','█','█','█','█'},
            {' ','█','█','█','█','█','█',' '},
            {' ',' ','█','█','█','█',' ',' '},
        }
    };

    public Meteorite(int x, int y, int z) {
        super(x, y, z);
    }

    @Override
    public void run() {}
    
    @Override
    public void render() {
        for (int i = 0; i < meteorites[0].length; i++) {
            for (int j = 0; j < meteorites[0][i].length; j++) {
                drawCharacter();
            }
        }
    }

    @Override
    public void updatePosition() {
    }
}
