package org.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class InputHandler extends KeyAdapter {

    private static final InputHandler INSTANCE = new InputHandler();
    private final Set<Integer> pressedKeys = new HashSet<>();

    private InputHandler() {}

    public static InputHandler getInstance() {
        return INSTANCE;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    public boolean isDown(int keyCode) {
        return pressedKeys.contains(keyCode);
    }
}
