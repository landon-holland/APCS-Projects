// AbstractEmployeeTester.java
// Landon Holland - 1/6/20
// Tester for the AbstractEmployee lab

import java.util.Scanner;

public class AbstractEmployeeTester {
    public static void main(String[] args) {
        // declare and fill
        Employee[] emps = new Employee[5];
        int type;

        Scanner reader = new Scanner(System.in);

        double pttotalpay = 0;
        double fttotalpay = 0;

        for (int i = 0; i < emps.length; i++) {
            // Get the type until valid
            while (true){
                System.out.println("  Type (" + Employee.getTypeRules() + "): ");
                type = Integer.parseInt(reader.nextLine());
                if (Employee.typeOK(type)) break;
            }

            // Instantiate an employee of the correct type and set the name
            if (type == 1)
                emps[i] = new FullTimeEmployee();
            else
                emps[i] = new PartTimeEmployee();

            System.out.println("Name: ");
            emps[i].setName(reader.nextLine());

            // Get the hourly pay rate until valid
            while (true){
                System.out.println("  Hourly rate (" + Employee.getRateRules() + "): ");
                if (emps[i].setRate(Double.parseDouble(reader.nextLine()))) break;
            }

            // Get the hours worked until valid
            //   To illustrate the possibilities we compress this code
            //   into a single unreadable statement.
            System.out.println("  Hours worked (" + Employee.getHoursRules() + "): ");
            while (!emps[i].setHours(Integer.parseInt(reader.nextLine())));

            double empPay = emps[i].getPay();

            if (emps[i] instanceof PartTimeEmployee) {
                pttotalpay += empPay;
            } else {
                fttotalpay += empPay;
            }

            // Print the name and pay
            System.out.println("  The weekly pay for (" + emps[i].getID() + ")" + emps[i].getName() + " is $" + empPay);
        }

        System.out.println("Total pay is $" + Employee.totalPay);
        System.out.println("Part time total pay is $" + pttotalpay);
        System.out.println("Full time total pay is $" + fttotalpay);

        for (Employee emp : emps) {
            if (emp instanceof PartTimeEmployee) {
                System.out.println("Part time");
            }
            else {
                System.out.println("Full time");
            }
            System.out.println(emp.toString());
        }
    }
}
