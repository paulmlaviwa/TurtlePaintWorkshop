package com.pluralsight;

import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    private static World world = new World();
    private static Turtle turtle = new Turtle(world);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayHomeScreen();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    handleAddShape();
                    break;
                case 2:
                    handleSaveImage();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("Home Screen");
        System.out.println("1. Add Shape");
        System.out.println("2. Save Image");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void handleAddShape() {
        System.out.println("Add New Shape");
        System.out.println("Which shape (1. Square, 2. Circle, 3. Triangle)?");
        int shapeChoice = getUserChoice();

        switch (shapeChoice) {
            case 1:
                addSquare();
                break;
            case 2:
                addCircle();
                break;
            case 3:
                addTriangle();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void addSquare() {
        int sideLength = getUserInputInt("Enter side length: ");
        int borderWidth = getUserInputInt("Enter border width: ");
        Color borderColor = getColorInput("Enter border color (RED, BLUE, GREEN, CYAN, MAGENTA): ");
        Point location = getUserInputPoint("Enter location (x, y): ");

        Square square = new Square(turtle, location, borderColor, borderWidth, sideLength);
        square.paint();
    }

    private static void addCircle() {
        int radius = getUserInputInt("Enter radius: ");
        int borderWidth = getUserInputInt("Enter border width: ");
        Color borderColor = getColorInput("Enter border color (RED, BLUE, GREEN, CYAN, MAGENTA): ");
        Point location = getUserInputPoint("Enter location (x, y): ");

        Circle circle = new Circle(turtle, location, borderColor, borderWidth, radius);
        circle.paint();
    }

    private static void addTriangle() {
        int baseLength = getUserInputInt("Enter base length: ");
        int height = getUserInputInt("Enter height: ");
        int borderWidth = getUserInputInt("Enter border width: ");
        Color borderColor = getColorInput("Enter border color (RED, BLUE, GREEN, CYAN, MAGENTA): ");
        Point location = getUserInputPoint("Enter location (x, y): ");

        Triangle triangle = new Triangle(turtle, location, borderColor, borderWidth, baseLength, height);
        triangle.paint();
    }

    private static int getUserInputInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private static Point getUserInputPoint(String message) {
        System.out.print(message);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return new Point(x, y);
    }

    private static void handleSaveImage() {
        world.saveAs("image.png");
        System.out.println("Image saved.");
    }

    private static Color getColorInput(String message) {
        Color color;
        while (true) {
            System.out.print(message);
            String colorInput = scanner.nextLine().toUpperCase();

            switch (colorInput) {
                case "RED":
                    color = Color.RED;
                    break;
                case "BLUE":
                    color = Color.BLUE;
                    break;
                case "GREEN":
                    color = Color.GREEN;
                    break;
                case "CYAN":
                    color = Color.CYAN;
                    break;
                case "MAGENTA":
                    color = Color.MAGENTA;
                    break;
                default:
                    System.out.println("Invalid color. Please enter a valid color.");
                    continue;
            }
            break;
        }
        return color;
    }

    private static void saveImage() {
        String fileName = "image.png";
        world.saveAs(fileName);
        System.out.println("Image saved to: " + fileName);
    }
}