package org.example.math;

public final class Vector2 {
    public double x;
    public double y;

    public Vector2() {
        this(0, 0);
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 copy() {
        return new Vector2(x, y);
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 subtract(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    public Vector2 scale(double scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2 normalized() {
        double len = length();
        if (len == 0) {
            return new Vector2(0, 0);
        }

        return new Vector2(x / len, y / len);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void addInPlace(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void addInPlace(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void scaleInPlace(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

    public String toString() {
        return String.format("Vector2(%.2f, %.2f)", x, y);
    }
}
