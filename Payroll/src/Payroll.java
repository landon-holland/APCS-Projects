// Payroll.java
// Landon Holland - 10/1/19
// Array of PayrollEmployees with some other stuff
//

import java.io.*; // File stuff

public class Payroll {
    private PayrollEmployee[] pemps = new PayrollEmployee[100]; // This means PayrollEMPloyeeS

    public Payroll() throws IOException {
        // For default, we're just gonna use the random stuff for a default 1000 pemps.
        for (int i = 0; i < 100; i++) {
            pemps[i] = new PayrollEmployee();
        }
    }

    // This is a fill constructor from the file
    public Payroll(String filename) throws IOException {
        // Make the BufferedReader from the FileReader
        FileReader infr = new FileReader(filename);
        BufferedReader binfr = new BufferedReader(infr);

        for (int i = 0; i < 100; i++) {
            pemps[i] = new PayrollEmployee();
            pemps[i].setFirstName(binfr.readLine());
            pemps[i].setLastName(binfr.readLine());
            pemps[i].setId(Integer.parseInt(binfr.readLine()));
            pemps[i].setNumberOfDependents(Integer.parseInt(binfr.readLine()));
            pemps[i].setRate(Double.parseDouble(binfr.readLine()));
            pemps[i].setHours(Integer.parseInt(binfr.readLine()));
        }
        binfr.close();
        infr.close();
    }

    public Payroll(int noe) throws IOException {
        for (int i = 0; i < noe; i++) {
            pemps[i] = new PayrollEmployee();
        }
    }

    public Payroll(PayrollEmployee[] pes, int noe) {
        for (int i = 0; i < noe; i++) {
            pemps[i] = pes[i];
        }
    }

    public PayrollEmployee getPEmp(int i) {
        return pemps[i];
    }

    public void setPEmp(int i, PayrollEmployee pemp) {
        pemps[i] = pemp;
    }

    public double[] runPayroll() {
        // lets get all of the totals with a for loop and hecka variables
        double tgp = 0, tfed = 0, tstate = 0, tloc = 0, tss = 0, tnp = 0;

        for (int i = 0; i < 100; i++) {
            tgp += pemps[i].getWage();
            tfed += pemps[i].findFed();
            tstate += pemps[i].findState();
            tloc += pemps[i].findLoc();
            tss += pemps[i].findSS();
            tnp += pemps[i].findNP();
        }

        return new double[]{tgp, tfed, tstate, tloc, tss, tnp};
    }

    public String getString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            out.append("\n").append(pemps[i].getPString());
        }

        out.append("\n");

        double[] totals = runPayroll();

        // time for running totals
        out.append("\nTotal Gross Pay: ").append(totals[0]);
        out.append("\nTotal Federal Tax: ").append(totals[1]);
        out.append("\nTotal State Tax: ").append(totals[2]);
        out.append("\nTotal Local Tax: ").append(totals[3]);
        out.append("\nTotal SS Tax: ").append(totals[4]);
        out.append("\nTotal Net Pay: ").append(totals[5]);

        return out.toString();
    }
}
