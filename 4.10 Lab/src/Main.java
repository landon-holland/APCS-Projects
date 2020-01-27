// Main.java
// Landon Holland - 9/17/2019
// Main class for 4.10 Lab/Teacher

/*
For text files
three data in one text file
output schedule in text file
message box the salary


Three input boxes
Automatically send entire schedule in a chart in the console window and a message box pops up and tells ur salary
*/

import java.util.Scanner; // For Scanner
import java.awt.*;
import java.io.*; // For File and IOException
import javax.swing.*; // Swing

public class Main {
    public static void main(String[] args) throws IOException {
        int ans = 0;
        Scanner r = new Scanner(System.in);
        Scanner lr = new Scanner(System.in);
        do {

            System.out.print("1-Inputboxes, 2-Textfiles: ");
            int option = Integer.parseInt(r.nextLine());

            double ss = 0.0; // starting salary
            int el = 0; // education level
            int years = 0;

            if (option == 1) {
                // Input box code
                ss = Double.parseDouble(JOptionPane.showInputDialog("Enter starting salary: "));
                el = Integer.parseInt(JOptionPane.showInputDialog("Enter education level (1-B, 2-M, 3-PHD): "));
                years = Integer.parseInt(JOptionPane.showInputDialog("Enter years: "));
            }
            else if (option == 2) {
                // Text file code
                FileReader inputreader = new FileReader("D:\\AP CS\\Project Files\\4.10 Lab\\src\\input.txt");
                BufferedReader inputbreader = new BufferedReader(inputreader);

                // we did it bro
                ss = Double.parseDouble(inputbreader.readLine());
                el = Integer.parseInt(inputbreader.readLine());
                years = Integer.parseInt(inputbreader.readLine());

                inputbreader.close();
                inputreader.close();
            }
            else {
                System.out.println("Brother moment."); // Brother moment tho.
            }

            // Let's set some variables based on the education level bro
            double index = 1.0; // This will be the number we edit so that we can do stuff
            double inc = 0.025; // Increment
            double bindex = 1.0;
            double binc = 0.025;
            double mindex = 1.1;
            double minc = 0.045;
            double pindex = 1.25;
            double pinc = 0.055;

            if (el == 1) {
                index = bindex;
                inc = binc;
            }
            else if (el == 2) {
                index = mindex;
                inc = minc;
            }
            else if (el == 3) {
                index = pindex;
                inc = pinc;
            }

            // TIME FOR MATHHHHHHHHHHHUHHH
            // def gonna use some arrays for these poops

            if (option == 1) {
                System.out.println("Year - B - M - PhD"); // Output sample

                for (int i = 0; i < 20; i++) {
                    System.out.println((i + 1) + " - $" + Math.round(ss * bindex) + " - $" + Math.round(ss * mindex) + " - $" + Math.round(ss * pindex));
                    bindex += binc;
                    mindex += minc;
                    pindex += pinc;
                }
            }
            else if (option == 2) {
                // File code
                PrintWriter pp = new PrintWriter("D:\\AP CS\\Project Files\\4.10 Lab\\src\\out.txt");

                pp.println("Year - B - M - PhD"); // Output sample

                for (int i = 0; i < 20; i++) {
                    pp.println((i + 1) + " - $" + Math.round(ss * bindex) + " - $" + Math.round(ss * mindex) + " - $" + Math.round(ss * pindex));
                    bindex += binc;
                    mindex += minc;
                    pindex += pinc;
                }
                pp.close();
            }

            // Show the final message box
            JOptionPane.showMessageDialog(null, "Salary is $" + Math.round(((inc * (years - 1)) + index) * ss) + " after " + years + " years.");

            // Run again
            System.out.print("Run Again bro? [y-1, n-0]: ");
            ans = lr.nextInt();
        } while (ans == 1);
    }
}
