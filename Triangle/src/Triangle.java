// Triangle.java
// Landon Holland - 9/10/2019
// Use Point and LineSeg to do triangle stuff

public class Triangle {
    // Private data
    private LineSeg l1;
    private LineSeg l2;
    private LineSeg l3;

    // Default constructor
    public Triangle() {
        l1 = new LineSeg();
        l2 = new LineSeg();
        l3 = new LineSeg();
    }

    // Fill constructors
    public Triangle(LineSeg a, LineSeg b, LineSeg c) {
        l1 = a;
        l2 = b;
        l3 = c;
    }

    public Triangle(Point a, Point b, Point c) {
        l1 = new LineSeg(a, b);
        l2 = new LineSeg(b, c);
        l3 = new LineSeg(c, a);
    }

    public void setL1(LineSeg a) {
        l1 = a;
    }

    public LineSeg getL1() {
        return l1;
    }

    public void setL2(LineSeg a) {
        l2 = a;
    }

    public LineSeg getL2() {
        return l2;
    }

    public void setL3(LineSeg a) {
        l3 = a;
    }

    public LineSeg getL3() {
        return l3;
    }

    public String getString() {
        return l1.getString() + " - " + l2.getString() + " - " + l3.getString();
    }

    public boolean isTriangle() {

        // If 3 slopes are the same then false
        if (l1.getSlope() == l2.getSlope() && l2.getSlope() == l3.getSlope()) {
            return false;
        }

        // So we're going to be seeing if there are three instances of every point
        Point[] testpoints = new Point[6];

        testpoints[0] = l1.getP1();
        testpoints[1] = l1.getP2();
        testpoints[2] = l2.getP1();
        testpoints[3] = l2.getP2();
        testpoints[4] = l3.getP1();
        testpoints[5] = l3.getP2();

        for (int i = 0; i <= 5; i++) {
            int samepoints = 0;
            for (int j = 0; j <= 5; j++) {
                if (testpoints[i].isEqual(testpoints[j])) {
                    samepoints++;
                }
            }
            if (samepoints != 2) { // If we don't find three instances, then we return false
                return false;
            }
        }
        return true;
    }

    public double getPerimeter() {
        // Just add all the distances
        return l1.getDistance() + l2.getDistance() + l3.getDistance();
    }

    public double getArea() {
        return Math.sqrt((getPerimeter() / 2) * ((getPerimeter() / 2) - l1.getDistance()) * ((getPerimeter() / 2) - l2.getDistance()) * ((getPerimeter() / 2) - l3.getDistance()));
    }

    public String getSideKind() {
        // We test this by checking the distances of the 3 sides.

        if (!isTriangle()) {
            return "No";
        }
        else if (l1.getDistance() == l2.getDistance() && l2.getDistance() == l3.getDistance()) {
            return "Equilateral";
        }
        else if (l1.getDistance() != l2.getDistance() && l2.getDistance() != l3.getDistance()) {
            return "Scalene";
        }
        else {
            return "Isosceles";
        }
    }

    public String getAngleKind() {
        // First we sort the lines
        sortLines();

        // Huge if test for if a^2 + b^2 = c^2
        if (!isTriangle()) {
            return "No";
        }
        else if (Math.pow(l1.getDistance(), 2) + Math.pow(l2.getDistance(), 2) == Math.round((Math.pow(l3.getDistance(), 2) * 1000) / 1000)) {
            return "Right";
        }
        else if (Math.pow(l1.getDistance(), 2) + Math.pow(l2.getDistance(), 2) < Math.round((Math.pow(l3.getDistance(), 2) * 1000) / 1000)) {
            return "Obtuse";
        }
        else if (Math.pow(l1.getDistance(), 2) + Math.pow(l2.getDistance(), 2) > Math.round((Math.pow(l3.getDistance(), 2) * 1000) / 1000)) {
            return "Acute";
        }
        else {
            return "What.";
        }
    }

    private void sortLines() {
        // We need to sort it so that l3 is the biggest
        // Let's make an array to make this sorting easier
        LineSeg[] lines = new LineSeg[3];
        lines[0] = new LineSeg(l1.getP1(), l1.getP2());
        lines[1] = new LineSeg(l2.getP1(), l2.getP2());
        lines[2] = new LineSeg(l3.getP1(), l3.getP2());

        // Exchange sort loop
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (lines[i].getDistance() >= lines[j].getDistance()) {
                    LineSeg templine = new LineSeg(lines[i].getP1(), lines[i].getP2());
                    lines[i] = lines[j];
                    lines[j] = templine;
                }
            }
        }

        // After the loop we need to reassign l1, l2 and l3.
        l1 = lines[0];
        l2 = lines[1];
        l3 = lines[2];
    }
}
