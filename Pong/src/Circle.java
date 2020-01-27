// Circle.java
// Landon Holland - 10/29/19

import java.awt.*;

public class Circle {
    // Private data
    protected int x;
    protected int y;
    protected int r;
    protected Color c;

    // Default constructor
    public Circle() {
        x = 0;
        y = 0;
        r = 0;
        c = Color.white;
    }

    // Fill constructor
    public Circle(int x, int y, int r, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
    }

    // Set's and get's
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void setR(int r) {
        this.r = r;
    }
    public int getR() {
        return r;
    }

    public Color getC() {
        return c;
    }
    public void setC(Color c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + "). R: " + r + ". Color: " + c.toString();
    }

    public void draw(Graphics g) {
        // Store the old color so we can set it back later
        Color oldcolor = g.getColor();
        g.setColor(c);

        // Translate to compensate
        g.drawOval(x - r, y - r, r * 2, r * 2);

        // Reset color
        g.setColor(oldcolor);
    }

    public void fill(Graphics g) {
        // Same thing with storing
        Color oldcolor = g.getColor();
        g.setColor(c);

        // Translate to compensate
        g.fillOval(x - r, y - r, r * 2, r * 2);

        // Reset color
        g.setColor(oldcolor);
    }

    // idk how this works
    public boolean containsPoint(int x, int y) {
        int x2 = (x - this.x) * (x - this.x);
        int y2 = (y - this.y) * (y - this.y);
        int r2 = r * r;
        return x2 + y2 - r2 <= 0;
    }

    public void move(int xm, int ym) {
        x += xm;
        y += ym;
    }
}
