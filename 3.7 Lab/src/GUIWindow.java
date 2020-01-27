// GUIWindow.java
// Landon Holland - 9/4/2019
// To display the ColorPanel in a JFrame

import javax.swing.*;
import java.awt.*;

public class GUIWindow {
    public static void main(String[] args) {
        // Setup JFrame
        JFrame theGUI = new JFrame();
        theGUI.setTitle("3.7 Lab");
        theGUI.setSize(600, 600);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the ColorPanel object and add it to a container, then a JFrame
        ColorPanel panel = new ColorPanel(Color.white);
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);
    }
}
