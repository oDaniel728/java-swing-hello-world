package org.example;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.example.math.Area2;
import org.example.utils.Player;

public class Game extends JPanel implements Runnable {

    private volatile boolean running;
    private Thread gameThread;

    private final InputMap inputMap = new InputMap();
    private final Player player = new Player(100, 100);

    public Game() {
        setBackground(new Color(30, 30, 30));
        setFocusable(true);
        setDoubleBuffered(true);
    }

    public void startGame() {
        if (gameThread != null && gameThread.isAlive()) {
            return;
        }

        player.load();
        running = true;
        gameThread = new Thread(this, "game-loop");
        gameThread.start();
    }

    public void stopGame() {
        running = false;

        if (gameThread != null) {
            gameThread.interrupt();
        }
    }

    @Override
    public void run() {
        long last = System.nanoTime();

        try {
            while (running) {
                long now = System.nanoTime();

                double dt = (now - last) / 1_000_000_000.0;
                last = now;

                processInput(dt);
                update(dt);
                repaint();

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    running = false;
                }
            }
        } finally {
            player.unload();
        }
    }

    private void processInput(double dt) {
        if (inputMap.isActive("move_up")) {
            player.moveUp(dt);
        }
        if (inputMap.isActive("move_down")) {
            player.moveDown(dt);
        }
        if (inputMap.isActive("move_left")) {
            player.moveLeft(dt);
        }
        if (inputMap.isActive("move_right")) {
            player.moveRight(dt);
        }
    }

    private void update(double dt) {
        if (!player.isLoaded()) {
            return;
        }

        player.update(dt);
        Area2 playerArea = player.getArea();

        double maxX = Math.max(0, getWidth() - playerArea.size.x);
        double maxY = Math.max(0, getHeight() - playerArea.size.y);

        double nextX = Math.max(0, Math.min(playerArea.position.x, maxX));
        double nextY = Math.max(0, Math.min(playerArea.position.y, maxY));

        player.setPosition(nextX, nextY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }

}
