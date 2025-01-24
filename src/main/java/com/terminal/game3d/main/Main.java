package com.terminal.game3d.main;

import com.terminal.game3d.logic.GameArea;
import com.terminal.game3d.utils.SoundPlayer;

public class Main {
    public static void main(String[] args) {
        SoundPlayer.playSound("src/main/resources/sounds/song.wav", true);
        GameArea gameArea = new GameArea();
        gameArea.start();
    }
}
