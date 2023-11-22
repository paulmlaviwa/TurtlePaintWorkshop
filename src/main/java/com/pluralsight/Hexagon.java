package com.pluralsight;

import java.awt.*;

public class Hexagon extends Shape {
    public Hexagon(Turtle turtle, Point location, Color color, int border) {
        super(turtle, location, color, border);
    }

    @Override
    public void paint() {
        drawHexagon(50);
    }

    public void drawHexagon(int sideLength) {
        setTurtleProperties();
        turtle.setColor(color);

        for (int i = 0; i < 6; i++) {
            turtle.penDown();
            turtle.forward(sideLength);
            turtle.turnRight(60);
            turtle.penUp();
        }
    }
}
