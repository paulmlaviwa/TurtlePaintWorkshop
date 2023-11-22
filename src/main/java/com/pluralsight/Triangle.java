package com.pluralsight;

import java.awt.*;

public class Triangle extends Shape {
    private int baseLength;
    private int height;

    public Triangle(Turtle turtle, Point location, Color color, int border, int baseLength, int height) {
        super(turtle, location, color, border);
        this.baseLength = baseLength;
        this.height = height;
    }

    @Override
    public void paint() {
        drawTriangle(baseLength, height);
    }
    private void drawTriangle(int baseLength, int height) {
        setTurtleProperties();
        double hypotenuse = Math.sqrt((baseLength * baseLength) + (height * height));
        double angle = Math.toDegrees(Math.atan2(height, baseLength));
        turtle.turnLeft(90);
        for (int i = 0; i < 3; i++) {
            turtle.penDown();
            turtle.forward((int) hypotenuse);
            turtle.turnRight(120);
            turtle.penUp();
        }
    }
}