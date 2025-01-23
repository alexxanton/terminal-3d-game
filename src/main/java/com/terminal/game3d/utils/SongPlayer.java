package com.terminal.game3d.utils;

import javax.sound.sampled.*;
import java.io.File;

public class SongPlayer {
    private static Clip clip;
    private static FloatControl gainControl;
    private static boolean isMute = false;


    public static void playSong(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            if (!soundFile.exists()) {
                System.err.println("Sound file not found: " + soundFilePath);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = audioInputStream.getFormat();

            // Create a Clip for looping
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);

            // Get the volume control
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void toggleMute() {
        isMute = !isMute;
        if (isMute) {
            unmute();
        } else {
            mute();
        }
    }

    public static void mute() {
        if (clip != null && clip.isOpen() && gainControl != null) {
            gainControl.setValue(gainControl.getMinimum());
        }
    }

    public static void unmute() {
        if (clip != null && clip.isOpen() && gainControl != null) {
            gainControl.setValue(0.0f);
        }
    }
}
