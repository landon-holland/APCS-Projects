// Employee.java
// Employee class
// Landon Holland - 8/22/2019

import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Employee {
    // Private data
    private String lastname;
    private String firstname;
    private String middlename;
    private char sex;
    private int hours;
    private double rate;
    private int id;

    // Class constructor
    public Employee() {
        lastname = "";
        firstname = "";
        middlename = "";
        sex = 'M';
        hours = 0;
        rate = 0.0;
        id = 0;
    }

    // Fill constructor
    public Employee(String lname, String fname, String mname, char s, int hrs, double r) throws IOException {
        lastname = lname;
        firstname = fname;
        middlename = mname;
        sex = s;
        hours = hrs;
        rate = r;

        // Time to deal with unique id's
        File idfile = new File("D:\\AP CS\\Project Files\\Employee\\src\\id.txt");
        Scanner idscanner = new Scanner(idfile);

        id = idscanner.nextInt() + 1;

        PrintWriter idwriter = new PrintWriter("D:\\AP CS\\Project Files\\Employee\\src\\id.txt");
        idwriter.println(id);
        idwriter.close();
    }

    // Random constructor
    public Employee(char r) throws IOException {
        // Declare FileReaders
        FileReader lnreader = new FileReader("D:\\AP CS\\Project Files\\Employee\\src\\lastnames.txt");
        FileReader fnreader = new FileReader("D:\\AP CS\\Project Files\\Employee\\src\\firstnames.txt");
        FileReader mnreader = new FileReader("D:\\AP CS\\Project Files\\Employee\\src\\middlenames.txt");

        // Buffered readers from those readers
        BufferedReader lnbreader = new BufferedReader(lnreader);
        BufferedReader fnbreader = new BufferedReader(fnreader);
        BufferedReader mnbreader = new BufferedReader(mnreader);

        // Let's declare the arrays for the three names
        String[] arrlastnames = new String[20000];
        String[] arrfirstnames = new String[4945];
        String[] arrmiddlenames = new String[3897];

        // Now it's into looping through the whole things
        int i = 0;
        String line;

        while((line = lnbreader.readLine()) != null) {
            arrlastnames[i] = line;
            i++;
        }
        lnreader.close();

        i = 0;
        while((line = fnbreader.readLine()) != null) {
            arrfirstnames[i] = line;
            i++;
        }
        fnreader.close();

        i = 0;
        while((line = mnbreader.readLine()) != null) {
            arrmiddlenames[i] = line;
            i++;
        }
        mnreader.close();

        // Time for RNG
        Random rng = new Random();

        lastname = arrlastnames[rng.nextInt(20000)];
        firstname = arrfirstnames[rng.nextInt(4945)];
        middlename = arrmiddlenames[rng.nextInt(3897)];

        // rng for sex
        if (rng.nextInt(1) == 0) {
            sex = 'M';
        }
        else {
            sex = 'F';
        }

        hours = rng.nextInt(100);
        rate = rng.nextDouble();

        // Time to deal with unique id's
        File idfile = new File("E:\\AP CS\\Project Files\\Employee\\src\\id.txt");
        Scanner idscanner = new Scanner(idfile);

        id = idscanner.nextInt() + 1;

        PrintWriter idwriter = new PrintWriter("E:\\AP CS\\Project Files\\Employee\\src\\id.txt");
        idwriter.print(id);
        idwriter.close();
    }

    // getString method
    public String getString() {
        BigDecimal rndedRate = new BigDecimal(rate).setScale(2, RoundingMode.HALF_UP);
        BigDecimal rndedWage = new BigDecimal(getWage()).setScale(2, RoundingMode.HALF_UP);
        return id + " - " + getFullName() + "(" + sex + ")" + ": " + hours + " hours at $" + rndedRate + "." + " This is a total wage of $" + rndedWage + ".";
    }

    // getWage method to get the total wage that they earned
    public double getWage() {
        return hours * rate;
    }

    // getFullName method to get a string version of their full name
    public String getFullName() {
        return lastname + ", " + firstname + " " + middlename;
    }

    // The sets and gets
    public void setLastName(String ln) {
        lastname = ln;
    }

    public String getLastName() {
        return lastname;
    }

    public void setFirstName(String fn) {
        firstname = fn;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setMiddleName(String mn) {
        middlename = mn;
    }

    public String getMiddleName() {
        return middlename;
    }

    public void setSex(char s) {
        sex = s;
    }

    public char getSex() {
        return sex;
    }

    public void setHours(int h) {
        hours = h;
    }

    public int getHours() {
        return hours;
    }

    public void setRate(double r) {
        rate = r;
    }

    public double getRate() {
        return rate;
    }

    public void setId(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }
}
