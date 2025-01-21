package com.terminal.game3d;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;


public class Control {
    private NonBlockingReader reader;

    public Control() {
        try {
            Terminal terminal = TerminalBuilder.terminal();
            reader = terminal.reader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int readKeys() {
        try {
            return reader.read();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
