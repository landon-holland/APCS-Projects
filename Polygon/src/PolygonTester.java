// PolygonTester.java
// Landon Holland - 10/22/19

import javax.swing.*;
import java.awt.*;

public class PolygonTester {
    public static void main(String[] args) {
        LineSeg a = new LineSeg(0, 0, 0, 3);
        LineSeg b = new LineSeg(0, 3, 3, 3);
        LineSeg c = new LineSeg(3, 3, 3, 0);
        LineSeg d = new LineSeg(3, 0, 0, 0);

        Polygon square = new Polygon(new LineSeg[]{a, b, c, d});
        Polygon bowtie = new Polygon(new LineSeg[]{a, d, b, c});
        Polygon squaretest = new Polygon(new Point[]{new Point(0, 0), new Point(0, 3), new Point(3, 3), new Point(3, 0)});

        //System.out.println(square.isPolygon());
        //System.out.println(bowtie.isPolygon());
        //System.out.println();
        //System.out.println(squaretest.getString());
        //System.out.println(squaretest.isPolygon());

        // Ask for sides with inputboxes
        int sides = Integer.parseInt(JOptionPane.showInputDialog("Number of sides: "));

        // Time to work on GUI stuff
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Polygon");
        theGUI.setSize(600, 600);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setResizable(false);

        // ColorPanel work now
        ColorPanel panel = new ColorPanel(Color.white, sides);
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);
    }
}
