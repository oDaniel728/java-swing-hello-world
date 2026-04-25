package org.example;

import java.awt.Color;
import java.awt.Graphics;

import org.example.math.Area2;
import org.example.math.Vector2;

public class Square {
    protected final Area2 area;
    protected Color c;
    private boolean loaded;

    public Square(double x, double y, double w, double h, Color c) {
        this.area = new Area2(x, y, w, h);
        this.c = c;
    }

    public Square(Area2 area, Color c) {
        this.area = new Area2(area.position, area.size);
        this.c = c;
    }

    public void update(double dt) {
    }

    public final void load() {
        if (loaded) {
            return;
        }

        onLoad();
        loaded = true;
    }

    public final void unload() {
        if (!loaded) {
            return;
        }

        onUnload();
        loaded = false;
    }

    protected void onLoad() {
    }

    protected void onUnload() {
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void draw(Graphics g) {
        if (!loaded) {
            return;
        }

        Color lastColor = g.getColor();
        g.setColor(this.c);
        g.fillRect(
            (int) this.area.position.x,
            (int) this.area.position.y,
            (int) this.area.size.x,
            (int) this.area.size.y
        );
        g.setColor(lastColor);
    }

    public double getXPos() {
        return area.position.x;
    }

    public double getYPos() {
        return area.position.y;
    }

    public Vector2 getPosition() {
        return area.position.copy();
    }

    public double getWidthSize() {
        return area.size.x;
    }

    public double getHeightSize() {
        return area.size.y;
    }

    public Vector2 getSize() {
        return area.size.copy();
    }

    public Area2 getArea() {
        return area;
    }

    public Area2 getAreaCopy() {
        return new Area2(area.position, area.size);
    }

    public void setPosition(double x, double y) {
        this.area.setPosition(x, y);
    }

    public void setPosition(Vector2 position) {
        this.area.setPosition(position);
    }

    public void setSize(double width, double height) {
        this.area.setSize(width, height);
    }

    public void setSize(Vector2 size) {
        this.area.setSize(size);
    }
}
