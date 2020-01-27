// Lab 2.7 - 3x3 Grid
// Landon Holland - 8/21/2019
// Display a grid of rectangles using swing

import javax.swing.*; // JFrame and JPanel
import java.awt.*; // For Color and Container
import java.util.Random; // RNG colors
import java.util.Scanner; // Scanner for inputs for the rows and columns

public class Grid3x3 {
    public static void main(String [] args) {

        String ans = ""; // For run again answer

        do {

            // Make an instance of Scanner
            Scanner reader = new Scanner(System.in);
            Scanner loopreader = new Scanner(System.in);
            // Declare the inputs of rows and column
            int r, c;

            System.out.print("Enter the number of rows: ");
            r = reader.nextInt();

            System.out.print("Enter the number of columns: ");
            c = reader.nextInt();

            // Make instance of the JFrame and set some basic parameters
            JFrame theGUI = new JFrame();
            theGUI.setTitle("Color Grid");
            theGUI.setSize(600, 600);
            //theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setup a Container to make a grid layout named pane
            Container pane = theGUI.getContentPane();
            pane.setLayout(new GridLayout(r, c));

            // Setup RNG for the colors
            Random rng = new Random();

            // Declare the array of panels
            JPanel[] panels = new JPanel[r * c]; // make the size of the array the amount of rows and columns we need

            for (int i = 0; i < r * c; i++) {
                // Make a new panel and set a random RNG then add to the pane
                panels[i] = new JPanel();
                panels[i].setBackground(new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
                pane.add(panels[i]);
            }

            theGUI.setVisible(true); // Make the GUI visible

            // Ask to run again
            System.out.print("Run again? (Y/n): ");
            ans = loopreader.nextLine();

        } while(ans.equals("y") || ans.equals("Y"));

        System.exit(0);
    }
}
