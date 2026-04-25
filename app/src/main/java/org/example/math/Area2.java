package org.example.math;

public final class Area2 {
    public final Vector2 position;
    public final Vector2 size;

    public Area2(Vector2 position, Vector2 size) {
        this.position = position.copy();
        this.size = size.copy();
    }

    public Area2(double x, double y, double width, double height) {
        this.position = new Vector2(x, y);
        this.size = new Vector2(width, height);
    }

    public double minX() {
        return Math.min(position.x, position.x + size.x);
    }

    public double minY() {
        return Math.min(position.y, position.y + size.y);
    }

    public double maxX() {
        return Math.max(position.x, position.x + size.x);
    }

    public double maxY() {
        return Math.max(position.y, position.y + size.y);
    }

    public Vector2 center() {
        return new Vector2((minX() + maxX()) * 0.5, (minY() + maxY()) * 0.5);
    }

    public boolean isInside(Vector2 point) {
        return isInside(point.x, point.y);
    }

    public boolean isInside(double x, double y) {
        return x >= minX() && x <= maxX() && y >= minY() && y <= maxY();
    }

    public boolean contains(Area2 other) {
        return other.minX() >= minX()
            && other.maxX() <= maxX()
            && other.minY() >= minY()
            && other.maxY() <= maxY();
    }

    public boolean intersects(Area2 other) {
        return maxX() > other.minX()
            && minX() < other.maxX()
            && maxY() > other.minY()
            && minY() < other.maxY();
    }

    public boolean intersectsOrTouches(Area2 other) {
        return maxX() >= other.minX()
            && minX() <= other.maxX()
            && maxY() >= other.minY()
            && minY() <= other.maxY();
    }

    public boolean touches(Area2 other) {
        return intersectsOrTouches(other) && !intersects(other);
    }

    public void setPosition(Vector2 position) {
        this.position.set(position.x, position.y);
    }

    public void setPosition(double x, double y) {
        this.position.set(x, y);
    }

    public void setSize(Vector2 size) {
        this.size.set(size.x, size.y);
    }

    public void setSize(double width, double height) {
        this.size.set(width, height);
    }
}
