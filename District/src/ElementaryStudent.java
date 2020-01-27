// ElementaryStudent.java
// Landon Holland - 1/8/20
// Concrete class for elementary dudes

public class ElementaryStudent extends Student {
    ElementaryStudent() { // default constructor
        super();
        fee = ESTUFEE;
        totalFees += fee;
    }

    public double getAverage() { // specific percentages for elementary kids
        final double PRJ = .4;
        final double HW = .3;
        final double QT = .3;



        return (HW * scores[0]) + (PRJ * scores[1]) + (QT * scores[2]);
    }

    public double getGPA() {
        return -1;
    }

    public String getLetterGrade() {
        if (getAverage() < .59) {
            return "F";
        }
        else if (getAverage() >= .59) {
            return "P";
        }
        return "Bruh";
    }
}
