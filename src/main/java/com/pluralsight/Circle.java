package com.pluralsight;

import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(Turtle turtle, Point location, Color color, int border, int radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    @Override
    public void paint() {
        drawCircle(radius);
    }
    public void drawCircle(double radius) {
        setTurtleProperties();
        turtle.setDelay(.000000000001);
        int numSides = 360;
        double angle = 360.0 / numSides;
        double circumference = 2 * Math.PI * radius;

        for (int i = 0; i < numSides; i++) {
            turtle.forward((int) (circumference / numSides));
            turtle.turnRight(angle);
        }
    }
}