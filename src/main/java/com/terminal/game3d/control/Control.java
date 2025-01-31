package com.terminal.game3d.control;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;


public class Control {
    private NonBlockingReader reader;
    private Thread inpuThread = new Thread(() -> getPressedKeys());
    public static volatile String currentDirection = "";

    public Control() {
        try {
            Terminal terminal = TerminalBuilder.terminal();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> showCursor(terminal)));
            terminal.enterRawMode();
            reader = terminal.reader();
            hideCursor(terminal);
            inpuThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static Control getInstance() {
    //     if (instance == null) {
    //         instance = new Control();
    //     }
    //     return instance;
    // }

    private static void hideCursor(Terminal terminal) {
        terminal.writer().print("\033[?25l");
        terminal.writer().flush();
    }

    private static void showCursor(Terminal terminal) {
        terminal.writer().print("\033[?25h");
        terminal.writer().flush();
    }

    public char readKeys() {
        try {
            return (char) reader.read();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void getPressedKeys() {
        while (true) {
            String key = Character.toString(readKeys());
            Control.currentDirection = key.toLowerCase();
        }
    }
}
