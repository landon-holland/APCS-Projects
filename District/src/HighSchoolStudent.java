// HighSchoolStudent.java
// Landon Holland - 1/8/20
// Concrete class for high schoolers

public class HighSchoolStudent extends Student {
    HighSchoolStudent() { // default constructor
        super();
        fee = HSTUFEE;
        totalFees += fee;
    }

    public double getAverage() { // specific percentages for high schoolers
        final double PRJ = .25;
        final double HW = .15;
        final double QT = .6;

        return (HW * scores[0]) + (PRJ * scores[1]) + (QT * scores[2]);
    }

    public double getGPA() {
        if (getLetterGrade() == "F") {
            return 0.0;
        }
        else if (getLetterGrade() == "D") {
            return 1.0;
        }
        else if (getLetterGrade() == "C") {
            return 2.0;
        }
        else if (getLetterGrade() == "B") {
            return 3.0;
        }
        else if (getLetterGrade() == "A") {
            return 4.0;
        }
        return -1;
    }

    public String getLetterGrade() {
        if (getAverage() < .59) {
            return "F";
        }
        else if (getAverage() >= .59 && getAverage() < .69) {
            return "D";
        }
        else if (getAverage() >= .69 && getAverage() < .79) {
            return "C";
        }
        else if (getAverage() >= .79 && getAverage() < .89) {
            return "B";
        }
        else if (getAverage() >= .89) {
            return "A";
        }
        return "Bruh";
    }

    @Override
    public String toString() {
        return super.toString() + "\n GPA: " + getGPA();
    }
}
