package com;

import org.jline.keymap.KeyMap;
import org.jline.reader.*;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Terminal terminal = null;
        try {
            terminal = TerminalBuilder.builder()
                    .system(true)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();

        MyWidgets myWidgets = new MyWidgets(reader);
        KeyMap<Binding> keyMap = reader.getKeyMaps().get("main");
        keyMap.bind(new Reference("_plus7"), "k");

        while (true) {
            reader.readLine();
        }
    }

}

class MyWidgets extends org.jline.builtins.Widgets {
    private LineReader reader;

    public MyWidgets(LineReader reader) {
        super(reader);
        this.reader = reader;
        addWidget("_plus7", this::plus7);
    }

    public boolean plus7() {
        try {
            Integer num = Integer.parseInt(buffer().toString()) + 7;
            buffer().clear();
            buffer().write(num.toString());
            callWidget(LineReader.REDRAW_LINE);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return true;
    }
}
