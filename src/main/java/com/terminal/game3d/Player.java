package com.terminal.game3d;

public class Player {
    private Control control = new Control();
    private int player_z = 0;
    private int player_x = 3;
    private int player_y = 5;

    public Player() {}

    public void move() {
        int key = control.readKeys();
        System.out.println(key);
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
