// EmployeeTester.java
// Test the Employee class
// Landon Holland - 8/22/2019


import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class EmployeeTester {
    public static void main(String args[]) throws IOException {
        String ans = "";

        do {

            String lastname, firstname, middlename;
            char sex;
            int hours;
            double rate;

            // Input for the userEmployee
            Scanner reader = new Scanner(System.in);
            Scanner loopreader = new Scanner(System.in);

            System.out.print("Enter last name: ");
            lastname = reader.nextLine();

            System.out.print("Enter first name: ");
            firstname = reader.nextLine();

            System.out.print("Enter middle name: ");
            middlename = reader.nextLine();

            System.out.print("Enter sex (M/F): ");
            String whatever = reader.nextLine();

            System.out.print("Enter hours: ");
            hours = reader.nextInt();

            System.out.print("Enter rate: ");
            rate = reader.nextDouble();

            // Make and output Employees
            Employee userEmployee = new Employee(lastname, firstname, middlename, 'M', hours, rate);
            System.out.println(userEmployee.getString());

            Employee newEmployee = new Employee("Holland", "Landon", "Dale", 'M', 10, 0.03);
            System.out.println(newEmployee.getString());

            Employee ranEmployee = new Employee('r');
            System.out.println(ranEmployee.getString());

            // Let's display this stuff now bro
            JFrame theGUI = new JFrame();
            theGUI.setTitle("Employee Tester");
            theGUI.setSize(600, 600);

            // Make panel to add labels
            JPanel p = new JPanel();

            // Make JLabels for output
            JLabel output1 = new JLabel(userEmployee.getString());
            JLabel output2 = new JLabel(newEmployee.getString());
            JLabel output3 = new JLabel(ranEmployee.getString());

            // add labels to panel
            p.add(output1);
            p.add(output2);
            p.add(output3);

            // add panel to frame
            theGUI.add(p);

            // LET THERE BE LIGHT
            theGUI.setVisible(true);

            System.out.print("Run again? (Y/n): ");
            ans = loopreader.nextLine();

        } while(ans.equals("Y") || ans.equals("y"));

        System.exit(0);
    }
}
