// Point.java
// Landon Holland - 9/9/2019
// Smallest level for this project

import java.awt.*; // For gwaphics owo what's this?

public class Point {
    // Private data first
    private double myX;
    private double myY;

    public Point() { // Default constructor
        myX = 0.0;
        myY = 0.0;
    }

    public Point(double x, double y) { // Fill constructor
        myX = x;
        myY = y;
    }

    // Sets and gets
    public void setMyX(double x) {
        myX = x;
    }

    public double getMyX() {
        return myX;
    }

    public void setMyY(double y) {
        myY = y;
    }

    public double getMyY() {
        return myY;
    }

    public String getString() { // ToString method
        return "(" + myX + ", " + myY + ")";
    }

    // For later in Triangle
    public boolean isEqual(Point a) {
        return a.getMyX() == myX && a.getMyY() == myY;
    }

    // For later in ColorPanel and paintComponent
    public void draw(Graphics g, int w, int h) {
        g.fillOval((int) myX - 3, (int) myY - 3, 6, 6);
        g.drawString("(" + ((myX - (w / 2)) + ", " + -(myY - (h / 2)) + ")"), (int) myX + 15, (int) myY - 15);
    }
}
