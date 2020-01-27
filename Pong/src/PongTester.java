// PongTester.java
// Landon Holland - 10/29/19
// Main running class for this shiz

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PongTester {
    public static void main(String[] args) throws IOException {
        // Setup the frame
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Pong");
        theGUI.setSize(1200, 500);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setResizable(false);

        // Setup the PongPanel
        PongPanel pp = new PongPanel(Color.black, JOptionPane.showInputDialog("Name: "));
        Container pane = theGUI.getContentPane();
        pane.add(pp);
        theGUI.setVisible(true);

        // Let's do a topten
        JFrame topTen = new JFrame();
        topTen.setTitle("Top Ten");
        topTen.setSize(500, 500);
        topTen.setResizable(false);

        JPanel toptenpanel = new JPanel();
        JLabel toptenoutput = new JLabel(new TopTen("D:\\AP CS\\Project Files\\Pong\\src\\TopTen.txt").getHTML());

        toptenpanel.add(toptenoutput);

        topTen.add(toptenpanel);

        topTen.setVisible(true);
    }
}
