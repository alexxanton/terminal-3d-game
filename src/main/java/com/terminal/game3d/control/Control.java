package com.terminal.game3d.control;

import java.io.IOException;
import java.util.ArrayList;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;


public class Control {
    private NonBlockingReader reader;
    private Thread inpuThread = new Thread(() -> getPressedKeys());
    private ArrayList<String> currentKeys = new ArrayList<>();
    public static volatile Control instance;

    
    private Control() {
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

    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }

        return instance;
    }

    private void hideCursor(Terminal terminal) {
        terminal.writer().print("\033[?25l");
        terminal.writer().flush();
    }

    private void showCursor(Terminal terminal) {
        terminal.writer().print("\033[?25h");
        terminal.writer().flush();
    }

    private char readKeys() {
        try {
            return (char) reader.read();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void getPressedKeys() {
        while (true) {
            String key = Character.toString(readKeys());
            currentKeys.add(key.toLowerCase());
        }
    }

    public boolean isKeyPressed(String key) {
        if (currentKeys.size() > 0) {
            try {
                return currentKeys.get(0).equals(key);
            } catch (NullPointerException e) {
                return false;
            }
        }
        return false;
    }

    public boolean containsKey(String keys) {
        synchronized (currentKeys) {
            if (currentKeys.size() > 0) {
                try {
                    return keys.contains(currentKeys.get(0));
                } catch (NullPointerException | IndexOutOfBoundsException e) {
                    return false;
                }
            }
        }
        return false;
    }

    public void consumeKey() {
        if (currentKeys.size() > 0) {
            currentKeys.remove(0);
        }
    }
}
