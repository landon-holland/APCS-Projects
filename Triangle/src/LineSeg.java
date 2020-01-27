// LineSeg.java
// Landon Holland - 9/9/2019
// Use Point to do LineSeg and do some other stuff

import java.awt.*; // Graphics

public class LineSeg {
    // Private data
    private Point p1;
    private Point p2;

    public LineSeg() { // Default constructor
        p1 = new Point();
        p2 = new Point();
    }

    // Fill constructors
    public LineSeg(Point a, Point b) {
        p1 = a;
        p2 = b;
    }

    public LineSeg(double x1, double y1, double x2, double y2) {
        p1.setMyX(x1);
        p1.setMyY(y1);

        p2.setMyX(x2);
        p2.setMyY(y2);
    }

    public String getString() {
        return p1.getString() + " - " + p2.getString();
    }

    // Sets and gets
    public void setP1(Point a) {
        p1 = a;
    }

    public Point getP1() {
        return p1;
    }

    public void setP2(Point a) {
        p2 = a;
    }

    public Point getP2() {
        return p2;
    }

    // Arithmetic stuff
    public double getSlope() {
        if (p2.getMyX() - p1.getMyX() == 0) {
            return -1;
        }
        return (p2.getMyY() - p1.getMyY()) / (p2.getMyX() - p1.getMyX());
    }

    public double getDistance() {
        return Math.sqrt(Math.pow(p2.getMyX() - p1.getMyX(), 2) + Math.pow(p2.getMyY() - p1.getMyY(), 2));
    }

    // For later in Triangle
    public boolean isEqual(LineSeg a) {
        return (p1.isEqual(a.getP1()) && p2.isEqual(a.getP2())) || (p1.isEqual(a.getP2()) && p2.isEqual(a.getP1()));
    }

    // For later in ColorPanel and paintComponent
    public void draw(Graphics g) {
        g.drawLine((int) p1.getMyX(), (int) p1.getMyY(), (int) p2.getMyX(), (int) p2.getMyY());
    }
}
