// PayrollTester.java
// Landon Holland - 10/8/19
// Test the Payroll class

import javax.swing.*;
import java.io.IOException;

public class PayrollTester {
    public static void main(String[] args) throws IOException {
        Payroll pr = new Payroll("D:\\AP CS\\Project Files\\Payroll\\src\\out.txt");
        System.out.println(pr.getString());

        // Let's display this stuff now bro
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Payroll");
        theGUI.setSize(600, 600);
        theGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        StringBuilder out = new StringBuilder();

        double[] totals = pr.runPayroll();

        // time for running totals
        out.append("\nTotal Gross Pay: ").append(totals[0]);
        out.append("\nTotal Federal Tax: ").append(totals[1]);
        out.append("\nTotal State Tax: ").append(totals[2]);
        out.append("\nTotal Local Tax: ").append(totals[3]);
        out.append("\nTotal SS Tax: ").append(totals[4]);
        out.append("\nTotal Net Pay: ").append(totals[5]);

        JLabel output = new JLabel("Total Gross Pay: " + totals[0]);
        JLabel output2 = new JLabel("Total Federal Tax: " + totals[1]);
        JLabel output3 = new JLabel("Total State Tax: " + totals[2]);
        JLabel output4 = new JLabel("Total Local Tax: " + totals[3]);
        JLabel output5 = new JLabel("Total SS Tax: " + totals[4]);
        JLabel output6 = new JLabel("Total Net Pay: " + totals[5]);

        JPanel jp = new JPanel();

        jp.add(output);
        jp.add(output2);
        jp.add(output3);
        jp.add(output4);
        jp.add(output5);
        jp.add(output6);

        theGUI.add(jp);

        // LET THERE BE LIGHT
        theGUI.setVisible(true);
    }
}
