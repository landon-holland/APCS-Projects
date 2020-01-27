// ColorPanel.java
// Landon Holland - 9/4/2019
// Class for the color panel and Graphics

import javax.swing.*; // For JPanel
import java.awt.*; // For Container stuff
import java.awt.event.*; // For events

public class ColorPanel extends JPanel {

    private int x, y; // Mouse coordinates

    public ColorPanel(Color backColor) { // Fill constructor
        setBackground(backColor);

        x = 0;
        y = 0;

        addMouseListener(new PanelListener());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println(x);
        System.out.println(y);

        // Let's get the width and height
        int w = getWidth();
        int h = getHeight();
        // Draw the axes first
        g.setColor(Color.black);

        g.drawLine(0, h / 2, w, h / 2); // x
        g.drawLine(w / 2, 0, w / 2, h); // y

        // Center point
        g.fillOval((w / 2) - 3, (h / 2) - 3, 6, 6);
        g.drawString("(0, 0)", ((w / 2) + 15), (h / 2) - 15);

        // Now we have to deal with the point :]
        g.setColor(Color.red);

        g.fillOval(x - 3, y - 3, 6, 6);
        g.drawString("(" + (x - (w / 2)) + ", " + -(y - (h / 2)) + ")", x + 15, y - 15); // Make sure to work with the display so it's the x y coords not the Java coords
    }

    private class PanelListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            // Get the current x and y and draw again
            x = e.getX();
            y = e.getY();
            repaint();
        }
    }
}
