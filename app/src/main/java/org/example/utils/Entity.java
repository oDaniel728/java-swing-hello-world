package org.example.utils;

import java.awt.Color;

import org.example.Square;

public class Entity extends Square {

    public double speed;

    public Entity(double x, double y, double w, double h, Color c, double speed) {
        super(x, y, w, h, c);
        this.speed = speed;
    }

    public void moveUp(double dt) {
        this.area.position.addInPlace(0, -this.speed * dt);
    }

    public void moveDown(double dt) {
        this.area.position.addInPlace(0, this.speed * dt);
    }

    public void moveLeft(double dt) {
        this.area.position.addInPlace(-this.speed * dt, 0);
    }

    public void moveRight(double dt) {
        this.area.position.addInPlace(this.speed * dt, 0);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }
}
