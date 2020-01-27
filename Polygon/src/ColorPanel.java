// ColorPanel.java
// Landon Holland - 3/22/19
// This one works with polygon

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorPanel extends JPanel {

    private Point[] ps;
    private int cp; // current point
    private boolean ttd; // time to draw

    public ColorPanel(Color backColor, int sides) { // Fill constructor
        setBackground(backColor);
        cp = 0;
        ttd = false;
        addMouseListener(new PanelListener());
        ps = new Point[sides];
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
            // Private data
            Polygon p = new Polygon(ps);

            if (p.isPolygon()) { // check if it's an actual polygon first

                g.setColor(Color.red);
                for (int i = 0; i < ps.length; i++) {
                    ps[i].draw(g, w, h);
                }

                // then we draw lines
                for (int i = 0; i < ps.length; i++) {
                    p.getL(i).draw(g);
                }

                // Output all triangle info
                System.out.println(p.getString());
            }
            else {
                System.out.println("Not a polygon.");

                g.setColor(Color.red);
                for (int i = 0; i < ps.length; i++) {
                    ps[i].draw(g, w, h);
                }

                for (int i = 0; i < ps.length; i++) {
                    p.getL(i).draw(g);
                }
            }
        }
    }

    private class PanelListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (cp == ps.length) { // if we already clicked 3 points then just start over
                ttd = true;
            }
            else {
                // set the current point to where we just clicked
                ps[cp] = new Point(e.getX(), e.getY());
                System.out.println(ps[cp].getString());
                cp++;
            }
            repaint();
        }
    }
}
