// Polygon.java
// Landon Holland - 10/14/19
// Make a class about lines and stuff

public class Polygon {
    private LineSeg[] l; // Private data array of lines

    public Polygon() { // Default constructor
        l = new LineSeg[3]; // Default is going to be a triangle with (0,0)
        l[0] = new LineSeg();
        l[1] = new LineSeg();
        l[2] = new LineSeg();
    }
    public Polygon(LineSeg[] lines) { // Line fill constructor
        l = new LineSeg[lines.length];
        System.arraycopy(lines, 0, l, 0, lines.length);
    }
    public Polygon(Point[] points) {
        l = new LineSeg[points.length];
        for (int i = 0; i < points.length - 1; i++) {
            l[i] = new LineSeg(points[i], points[i + 1]);
        }
        l[points.length - 1] = new LineSeg(points[points.length - 1], points[0]); // Last connecting point
    }

    public void setLs(LineSeg[] l) {
        this.l = l;
    }

    public LineSeg[] getLs() {
        return l;
    }

    public void setL(LineSeg l, int i) {
        this.l[i] = l;
    }

    public LineSeg getL(int i) {
        return l[i];
    }

    public String getString() {
        StringBuilder out = new StringBuilder();
        for (LineSeg lineSeg : l) {
            out.append(lineSeg.getString());
        }
        out.append("\nType: " + findType());
        out.append("\nPerimeter: " + findPerimeter());
        out.append("\nArea: " + findArea());
        return out.toString();
    }

    public double findArea() {
        int s1 = 0, s2 = 0; // s1 is left products, s2 is right products

        for (int i = 0; i < l.length - 1; i++) { // loop through the array and do shoelace
            s1 += l[i].getP1().getMyX() * l[i + 1].getP1().getMyY();
            s2 += l[i].getP1().getMyY() * l[i + 1].getP1().getMyX();
        }

        // gotta loop back to the first one
        s1 += l[l.length - 1].getP1().getMyX() * l[0].getP1().getMyY();
        s2 += l[l.length - 1].getP1().getMyY() * l[0].getP1().getMyX();

        // time to return the right thing!
        return (Math.abs(s1 - s2)) / 2;
    }

    public double findPerimeter() {
        double out = 0;
        for (LineSeg lineSeg : l) {
            out += lineSeg.getDistance();
        }
        return out;
    }

    public String findType() {
        if (!isPolygon()) {
            return "Nope.";
        }
        if (l.length == 3) {
            return "Triangle";
        }
        else if (l.length == 4) {
            return "Quadrilateral";
        }
        else if (l.length == 5) {
            return "Pentagon";
        }
        else if (l.length == 6) {
            return "Hexagon";
        }
        else if (l.length == 7) {
            return "Heptagon";
        }
        else if (l.length == 8) {
            return "Octogon";
        }
        else if (l.length == 9) {
            return "Nonagon";
        }
        else if (l.length == 10) {
            return "Decagon";
        }
        else if (l.length > 10){
            return "Too big bro.";
        }
        return "BRUH.";
    }

    public boolean isPolygon() {
        if (findArea() == 0) {
            return false;
        }

        if (!l[l.length - 1].getP2().isEqual(l[0].getP1())) {
            return false;
        }

        for (int i = 0; i < l.length; i++) {
            for (int j = 0; i < l.length; i++) {
                if (i == j) {
                    continue;
                }
                else if (l[i].isIntersecting(l[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
