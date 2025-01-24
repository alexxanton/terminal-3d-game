package com.terminal.game3d.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    private static boolean soundEnded = true;
    private static Clip clipLoop;
    private static FloatControl gainControl;
    private static boolean isSoundPlaying = true;

    public static void playSound(String filePath, boolean loop) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            clipLoop = AudioSystem.getClip();
            clipLoop.open(audioInputStream);
            clipLoop.start();

            // Get the volume control
            gainControl = (FloatControl) clipLoop.getControl(FloatControl.Type.MASTER_GAIN);
            clipLoop.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playSound(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            if (!soundEnded) {
                clip.stop();
            }

            clip.start();
            soundEnded = false;

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    event.getLine().close();
                    soundEnded = true;
                }
            });
        
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void toggleMute() {
        if (isSoundPlaying) {
            mute();
        } else {
            unmute();
        }
        isSoundPlaying = !isSoundPlaying;
    }

    public static void mute() {
        if (clipLoop != null && clipLoop.isOpen() && gainControl != null) {
            gainControl.setValue(gainControl.getMinimum());
        }
    }

    public static void unmute() {
        if (clipLoop != null && clipLoop.isOpen() && gainControl != null) {
            gainControl.setValue(0.0f);
        }
    }
}
