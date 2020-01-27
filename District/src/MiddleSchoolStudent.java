// MiddleSchoolStudent.java
// Landon Holland - 1/8/20
// Concrete class for middle schoolers

public class MiddleSchoolStudent extends Student {
    MiddleSchoolStudent() { // default constructor
        super();
        fee = MSTUFEE;
        totalFees += fee;
    }

    public double getAverage() { // specific percentages for middle schoolers
        final double PRJ = .3;
        final double HW = .2;
        final double QT = .5;

        avgTotal += (HW * scores[0]) + (PRJ * scores[1]) + (QT * scores[2]);
        avgCounter++;

        return (HW * scores[0]) + (PRJ * scores[1]) + (QT * scores[2]);
    }

    public double getGPA() {
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
}
