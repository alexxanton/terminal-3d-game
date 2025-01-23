package com.terminal.game3d.main;


import com.terminal.game3d.logic.GameArea;
import com.terminal.game3d.utils.SongPlayer;

public class Main {
    public static void main(String[] args) {
        SongPlayer.playSong("src/main/resources/sounds/song.wav");
        GameArea gameArea = new GameArea();
        gameArea.start();
    }
}
