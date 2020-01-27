// PayrollEmployee.java
// Landon Holland - 9/25/19
// Extend Employee for this stupid lab

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class PayrollEmployee extends Employee {
    private int numberofdependents;

    public PayrollEmployee() throws IOException { // Random fill will be default
        // Let's setup all the BufferedFileReaders
        FileReader femalefn = new FileReader("D:\\AP CS\\Project Files\\100 Employees\\src\\FemaleNamesDictionary.txt");
        FileReader malefn = new FileReader("D:\\AP CS\\Project Files\\100 Employees\\src\\MaleNamesDictionary.txt");
        FileReader ln = new FileReader("D:\\AP CS\\Project Files\\100 Employees\\src\\LastNames.txt");

        BufferedReader femalebreader = new BufferedReader(femalefn);
        BufferedReader malebreader = new BufferedReader(malefn);
        BufferedReader lnbreader = new BufferedReader(ln);

        // first let's decide if this will be :BoyOrGirl:
        Random rng = new Random();
        int ds = rng.nextInt(2); // 0 male, 1 female
        int i = 0;

        if (ds == 0) {
            // So we're gonna do a do while loop until we get to the RNG number then set that as the name.
            final int NUMBER_OF_MALE_NAMES = 1219;
            int eomn = rng.nextInt(NUMBER_OF_MALE_NAMES);
            String line;
            do {
                line = malebreader.readLine();
                i++;
            } while (i < eomn);
            setFirstName(line);
            setSex('M');
        }
        else if (ds == 1) {
            // Same for the yeojas
            final int NUMBER_OF_FEMALE_NAMES = 4275;
            int eofn = rng.nextInt(NUMBER_OF_FEMALE_NAMES);
            String line;
            do {
                line = femalebreader.readLine();
                i++;
            } while (i < eofn);
            setFirstName(line);
            setSex('F');
        }

        // last name
        final int NUMBER_OF_LAST_NAMES = 65536;
        int eoln = rng.nextInt(NUMBER_OF_LAST_NAMES);
        String line;
        i = 0;
        do {
            line = lnbreader.readLine();
            i++;
        } while (i < eoln);
        setLastName(line);

        setHours(rng.nextInt(40));
        setRate(rng.nextInt(1000) / 10);

        // Time to deal with unique id's
        File idfile = new File("D:\\AP CS\\Project Files\\100 Employees\\src\\id.txt");
        Scanner idscanner = new Scanner(idfile);

        int id = idscanner.nextInt() + 1;
        setId(id);

        PrintWriter idwriter = new PrintWriter("D:\\AP CS\\Project Files\\100 Employees\\src\\id.txt");
        idwriter.println(id);
        idwriter.close();

        numberofdependents = rng.nextInt(10);
    }

    public String getPString() {
        return super.getString() + " Number of dependents: " + numberofdependents + ".";
    }

    public void setNumberOfDependents(int nd) {
        numberofdependents = nd;
    }

    public int getNumberOfDependents() {
        return numberofdependents;
    }
}
