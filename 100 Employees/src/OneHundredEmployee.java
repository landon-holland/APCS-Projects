// OneHundredEmployee.java
// Landon Holland - 9/25/2019
// We gonna use Employee.java and make some sick random employees

import java.io.IOException;
import java.io.PrintWriter;

public class OneHundredEmployee {
    public static void main(String[] args) throws IOException {
        // Let's start with declaring the array!
        PayrollEmployee[] ohe = new PayrollEmployee[100];
        for (int i = 0; i < 100; i++) {
            ohe[i] = new PayrollEmployee();
        }

        PrintWriter w = new PrintWriter("D:\\AP CS\\Project Files\\100 Employees\\src\\out.txt");

        for (int i = 0; i < 100; i++) {
            w.println(ohe[i].getFirstName());
            w.println(ohe[i].getLastName());
            w.println(ohe[i].getId());
            w.println(ohe[i].getNumberOfDependents());
            w.println(ohe[i].getRate());
            w.println(ohe[i].getHours());
            System.out.println(ohe[i].getPString());
        }
        w.close();
    }
}
