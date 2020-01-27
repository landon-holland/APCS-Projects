// Student.java
// Landon Holland - 1/7/20
// Abstract class for students in a district

abstract public class Student {
    // Protected data
    protected String lname;
    protected String fname;
    protected int id;
    protected double[] scores;
    protected double fee;

    // Static variables
    protected static int totalStus = 0;
    protected static double totalFees = 0.0;
    protected static int idCounter = 100000;
    protected static double avgTotal = 0.0;
    protected static int avgCounter = 0;

    // Default constructor
    Student() {
        lname = "";
        fname = "";
        id = idCounter;
        idCounter++;
        scores = new double[3];
        for (double score : scores) {
            score = 0.0;
        }
        fee = 0.0;
        totalStus++;
    }

    // Sets and gets
    public boolean setLname(String lname) {
        if (lname.equals("")) {
            return false;
        }
        else {
            this.lname = lname;
            return true;
        }
    }
    public String getLname() {
        return lname;
    }

    public boolean setFname(String fname) {
        if (fname.equals("")) {
            return false;
        }
        else {
            this.fname = fname;
            return true;
        }
    }

    public String getFname() {
        return fname;
    }

    public int getId() {
        return id;
    }

    public boolean setScore(double score, int i) {
        if (score < 0 || score > 2) {
            return false;
        }
        else {
            scores[i] = score;
            return true;
        }
    }
    public double getScore(int i) {
        return scores[i];
    }

    public boolean setScores(double[] scores) {
        if (scores.length != this.scores.length) {
            return false;
        }
        for (double score : scores) {
            if (score < 0 || score > 2) {
                return false;
            }
        }
        this.scores = scores;
        return true;
    }
    public double[] getScores() {
        return scores;
    }

    public boolean setFee(double fee) {
        if (fee < 0) {
            return false;
        }
        else {
            this.fee = fee;
            return true;
        }
    }
    public double getFee() {
        return fee;
    }

    // toString
    @Override
    public String toString() {
        String type = "";
        if (this instanceof ElementaryStudent) {
            type = "Elementary Student";
        }
        else if (this instanceof MiddleSchoolStudent) {
            type = "Middle School Student";
        }
        else if (this instanceof HighSchoolStudent) {
            type = "High School Student";
        }

        return type + "\n[" + id + "]" + lname + ", " + fname + ":\n" +
                "HW - " + scores[0] +
                "\nProjects - " + scores[1] +
                "\nQuizzes and Tests - " + scores[2] +
                "\nAverage - " + getAverage() +
                "\nGrade: " + getLetterGrade() +
                "\nFee: " + fee + "\n";
    }

    // Static sets and gets
    public static int getTotalStus() {
        return totalStus;
    }
    public static double getTotalFees() {
        return totalFees;
    }
    public static double getAvgAverage() {
        return avgTotal / avgCounter;
    }

    // Abstract methods
    abstract public double getAverage(); // Different percentages for different students
    abstract public double getGPA(); // GPA only works for HSStu, others return -1
    abstract public String getLetterGrade(); // Different letters for different types of students

    // Some constants for fees
    public final double ESTUFEE = 50;
    public final double MSTUFEE = 100;
    public final double HSTUFEE = 300;
}
