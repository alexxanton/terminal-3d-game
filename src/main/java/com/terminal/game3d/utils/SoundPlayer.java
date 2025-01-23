package com.terminal.game3d.utils;

import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {
    public static void playSound(String soundFilePath) {
        new Thread(() -> {
            try {
                File soundFile = new File(soundFilePath);
                if (!soundFile.exists()) {
                    System.err.println("Sound file not found: " + soundFilePath);
                    return;
                }

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                AudioFormat format = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                    line.write(buffer, 0, bytesRead);
                }

                line.drain();
                line.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
