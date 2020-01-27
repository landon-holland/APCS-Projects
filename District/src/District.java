// District.java
// Landon Holland - 1/10/20
// Use lots of students to do things

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class District {
    // Private data
    private Student[] stus;

    District() { // default constructor
        stus = new Student[1];
        stus[0] =  new ElementaryStudent();
    }

    District(int nos) throws IOException { // random constructor
        Random r = new Random(); // random
        stus = new Student[nos]; // init array

        // time to start filling stuff
        // first we start with what type of student
        for (int i = 0; i < stus.length; i++) {
            int rnum = r.nextInt(3);
            if (rnum == 0) {
                stus[i] = new ElementaryStudent();
            }
            else if (rnum == 1) {
                stus[i] = new MiddleSchoolStudent();
            }
            else if (rnum == 2) {
                stus[i] = new HighSchoolStudent();
            }
            else {
                System.out.println("BRUH");
            }

            // now we do firt name based on random gender
            if (r.nextInt(2) == 1) {
                FileReader fr = new FileReader("D:\\AP CS\\Project Files\\District\\src\\MaleNamesDictionary.txt");
                BufferedReader bfr = new BufferedReader(fr);

                int upb = r.nextInt(1219);
                String line = "";
                for (int j = 0; j < upb; j++) {
                    line = bfr.readLine();
                }
                stus[i].setFname(line);
            }
            else {
                FileReader fr = new FileReader("D:\\AP CS\\Project Files\\District\\src\\FemaleNamesDictionary.txt");
                BufferedReader bfr = new BufferedReader(fr);

                int upb = r.nextInt(4275);
                String line = "";
                for (int j = 0; j < upb; j++) {
                    line = bfr.readLine();
                }
                stus[i].setFname(line);
            }

            // now last name
            FileReader fr = new FileReader("D:\\AP CS\\Project Files\\District\\src\\LastNames.txt");
            BufferedReader bfr = new BufferedReader(fr);

            int upb = r.nextInt(65536);
            String line = "";
            for (int j = 0; j < upb; j++) {
                line = bfr.readLine();
            }
            stus[i].setLname(line);

            // now we deal with scores
            for (int j = 0; j < 3; j++) {
                stus[i].setScore((double) r.nextInt(100) / 100, j);
            }
        }

    }

    // Sets and gets
    public Student[] getStus() {
        return stus;
    }
    public void setStus(Student[] stus) {
        this.stus = stus;
    }
    public Student getStu(int i) {
        return stus[i];
    }
    public void setStu(Student stu, int i) {
        stus[i] = stu;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < stus.length; i++) {
            out.append(stus[i].toString()).append("\n");
        }
        out.append("\nTotal Students: ").append(Student.getTotalStus()).append("\n");
        out.append("Total Fees: ").append(Student.getTotalFees()).append("\n");
        out.append("Average Average: ").append(Student.getAvgAverage());

        return out.toString();
    }
}
