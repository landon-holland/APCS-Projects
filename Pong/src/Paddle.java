// Paddle.java
// Landon Holland - 10/29/19
// Extend rectangle and do hitting stuff

import java.awt.*;

public class Paddle extends Rectangle {
    // Private data
    Color c;

    public Paddle() {
        super();
        c = Color.white;
    }
    public Paddle(int x, int y, int width, int height, Color c) {
        super(x, y, width, height);
        this.c = c;
    }

    public void draw(Graphics g) {
        // Store the old color so we can set it back later
        Color oldcolor = g.getColor();
        g.setColor(c);

        // Translate to compensate
        g.drawRect(super.x, super.y, super.width, super.height);

        // Reset color
        g.setColor(oldcolor);
    }

    public void fill(Graphics g) {
        // Store the old color so we can set it back later
        Color oldcolor = g.getColor();
        g.setColor(c);

        // Translate to compensate
        g.fillRect(super.x, super.y, super.width, super.height);

        // Reset color
        g.setColor(oldcolor);
    }

    public boolean containsPoint(int x, int y) {
        if (x >= this.x && x <= this.x + this.width) { // deal with x range
            // now we deal with y range
            return y >= this.y && y <= this.y + this.height;
        }
        return false;
    }

    public void move(int y) {
        this.y = y;
    }
}
