package org.example;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public final class InputMap {
    private final Map<String, Integer> bindings = new HashMap<>();
    InputHandler inputHandler = InputHandler.getInstance();

    public InputMap() {
        bindings.put("move_up", KeyEvent.VK_W);
        bindings.put("move_down", KeyEvent.VK_S);
        bindings.put("move_left", KeyEvent.VK_A);
        bindings.put("move_right", KeyEvent.VK_D);
    }

    public boolean isActive(String action) {
        Integer key = bindings.get(action);
        return key != null && inputHandler.isDown(key);
    }
}
