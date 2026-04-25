package org.example.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class Area2Test {
    @Test
    public void pointInsideAreaReturnsTrue() {
        Area2 area = new Area2(10, 10, 20, 20);

        assertTrue(area.isInside(15, 15));
        assertTrue(area.isInside(new Vector2(10, 10)));
        assertFalse(area.isInside(35, 15));
    }

    @Test
    public void intersectsAndTouchesAreDifferentCases() {
        Area2 a = new Area2(0, 0, 10, 10);
        Area2 overlap = new Area2(5, 5, 10, 10);
        Area2 edgeTouch = new Area2(10, 0, 4, 4);

        assertTrue(a.intersects(overlap));
        assertFalse(a.touches(overlap));

        assertFalse(a.intersects(edgeTouch));
        assertTrue(a.touches(edgeTouch));
        assertTrue(a.intersectsOrTouches(edgeTouch));
    }

    @Test
    public void containsChecksFullArea() {
        Area2 container = new Area2(0, 0, 100, 100);
        Area2 inside = new Area2(10, 10, 30, 30);
        Area2 outside = new Area2(90, 90, 20, 20);

        assertTrue(container.contains(inside));
        assertFalse(container.contains(outside));
    }

    @Test
    public void negativeSizeStillWorksWithMinMax() {
        Area2 area = new Area2(10, 10, -5, -8);

        assertTrue(area.isInside(6, 3));
        assertFalse(area.isInside(12, 12));
    }
}
