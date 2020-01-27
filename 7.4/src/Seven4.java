// 7.4.java
// Landon Holland - 12/2/2019
// 7.4 in textbook (8.4 in PDF version)

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Seven4 {
    public static void main(String[] args) {
        // JFrame init
        JFrame theGUI = new JFrame("7.4");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setSize(1400, 850);
        theGUI.setResizable(false);
        theGUI.setLocationRelativeTo(null);

        // Container init
        Container contentPane = theGUI.getContentPane();
        contentPane.setLayout(new FlowLayout());

        // Textbox
        JTextField inputBox = new JTextField("Payment amount", 30);

        // Setup the JTable
        JTable loanTable = new JTable(24, 6); // don't init it until we know the amount of rows
        loanTable.setValueAt("Month", 0, 0);
        loanTable.setValueAt("Current Total Balance", 0, 1);
        loanTable.setValueAt("Interest owed this month", 0, 2);
        loanTable.setValueAt("Principal owed this month", 0, 3);
        loanTable.setValueAt("Payment this month", 0, 4);
        loanTable.setValueAt("Balance remaining", 0, 5);

        loanTable.setFont(new Font("serif", Font.PLAIN, 20));
        loanTable.setRowHeight(30);

        for (int i = 0; i < 6; i++) {
            loanTable.getColumnModel().getColumn(i).setPreferredWidth(200);
        }

        JButton jbtnCalculate = new JButton("Calculate");

        // Add stuff
        contentPane.add(loanTable);
        contentPane.add(inputBox);
        contentPane.add(jbtnCalculate);

        // Actual calc stuff
        jbtnCalculate.addActionListener(e -> {
            double bal = Double.parseDouble(inputBox.getText());
            int month = 0;
            // Some info about the actual loan table
            final double AIR = 0.12; // Annual interest rate
            final double DP = 0.1; // Down payment
            double MP = 0.05 * (bal - (bal * DP)); // Monthly payment

            // we're gonna calculate all our givens now
            double remainingBal = bal - (bal * DP);

            while (remainingBal > 0) {
                double prevBal = remainingBal;
                double interest = remainingBal * (AIR / 12);
                remainingBal = remainingBal + interest - MP;

                if (remainingBal < 0) {
                    remainingBal = 0;
                    MP = prevBal;
                }

                double principalOwed = MP - interest;

                month++;

                loanTable.setValueAt(month, month, 0);
                loanTable.setValueAt(String.format("%10.2f$", prevBal), month, 1);
                loanTable.setValueAt(String.format("%10.2f$", interest), month, 2);
                loanTable.setValueAt(String.format("%10.2f$", principalOwed), month, 3);
                loanTable.setValueAt(String.format("%10.2f$", MP), month, 4);
                loanTable.setValueAt(String.format("%10.2f$", remainingBal), month, 5);
            }

        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
        for (int i = 0; i < 6; i++) {
            loanTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Display JFrame
        theGUI.setVisible(true);
    }
}