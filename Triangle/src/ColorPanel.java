// ColorPanel.java
// Landon Holland - 9/18/19
// GUI stuff for Triangle. We want to click on three points and make a flippin triangle

import javax.swing.*; // For JPanel
import java.awt.*; // For Container stuff
import java.awt.event.*; // For events

public class ColorPanel extends JPanel {
    // Private data
    private Triangle ta;
    private Point[] p = new Point[3];
    private int cp; // current point
    private boolean ttd; // time to draw

    public ColorPanel(Color backColor) { // Fill constructor
        setBackground(backColor);
        cp = 0;
        ttd = false;
        addMouseListener(new PanelListener());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Let's get the width and height
        int w = getWidth();
        int h = getHeight();

        // Draw the axes
        g.setColor(Color.black);
        g.drawLine(0, h / 2, w, h / 2); // x
        g.drawLine(w / 2, 0, w / 2, h); // y

        // Draw the points, only if we can
        if (ttd) {
            ta = new Triangle(p[0], p[1], p[2]);

            g.setColor(Color.red);
            for (int i = 0; i < 3; i++) {
                p[i].draw(g, w, h);
            }

            // then we draw lines
            ta.getL1().draw(g);
            ta.getL2().draw(g);
            ta.getL3().draw(g);

            // Output all triangle info
            System.out.println(ta.isTriangle());
            System.out.println(ta.getSideKind());
            System.out.println(ta.getAngleKind());
            System.out.println("Area: " + ta.getArea());
            System.out.println("Perimeter: " + ta.getPerimeter());
        }
    }

    private class PanelListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (cp == 3) { // if we already clicked 3 points then just start over
                ttd = true;
            }
            else {
                // set the current point to where we just clicked
                p[cp] = new Point(e.getX(), e.getY());
                cp++;
            }
            repaint();
        }
    }
}
