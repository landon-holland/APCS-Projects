// TriangleTester.java
// Landon Holland - 9/11/2019
// Test all of those classes baby

import javax.swing.*; // All swing stuff
import java.awt.*;

public class TriangleTester {

    public static void main(String[] args) {
        Triangle peepee = new Triangle(new Point(3, 0), new Point(0, 2), new Point(0, 0));

        // Console output
        System.out.println(peepee.isTriangle());
        System.out.println(peepee.getSideKind());
        System.out.println(peepee.getAngleKind());

        // Time to work on GUI stuff
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Triangle");
        theGUI.setSize(600, 600);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setResizable(false);

        // ColorPanel work now
        ColorPanel panel = new ColorPanel(Color.white);
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);
    }
}
