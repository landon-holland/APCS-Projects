// Matrix.java
// Landon Holland - 11/11/19
// 2d dimensions with stuff

// file stuff
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Random; // for random constructor

public class Matrix {
    // Private data
    private double[][] arrNums;

    public Matrix() { // Default constructor
        arrNums = new double[2][2]; // rows then columns
    }

    public Matrix(int rows, int cols) { // Fill constructor
        arrNums = new double[rows][cols];
    } // row, col constructor

    public Matrix(double[][] arrNums) { // Fill constructor
        this.arrNums = arrNums;
    } // fill constructor

    public Matrix(int rows, int cols, int bound) { // random constructor
        arrNums = new double[rows][cols]; // init array

        Random r = new Random(); // init r

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arrNums[i][j] = r.nextInt(bound);
            }
        }
    }

    public Matrix(String filename) throws IOException { // file constructor
        // init the objects
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        // the first two lines is going to have the dimensions
        arrNums = new double[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())]; // init the array with the dimensions of the first two lines of code

        // now the next lines are going to read like this:
        // 1 2 3
        // 4 5 6
        // 7 8 9

        for (int i = 0; i < arrNums.length; i++) {
            for (int j = 0; j < arrNums[0].length; j++) {
                arrNums[i][j] = Integer.parseInt(br.readLine());
            }
        }
    }

    // Set's and get's
    public double[][] getArrNums() {
        return arrNums;
    }
    public void setArrNums(double[][] arrNums) {
        this.arrNums = arrNums;
    }

    // get and set one specific element
    public double getElement(int row, int col) {
        return arrNums[row][col];
    }
    public void setElement(double x, int row, int col) {
        arrNums[row][col] = x;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (double[] arrNum : arrNums) {
            for (int i = 0; i < arrNums[0].length; i++) {
                s.append(arrNum[i]).append(" ");
            }
            s.append("\n");
        }

        return s.toString();
    }

    public boolean chAdd(Matrix m) {
        return m.getArrNums().length == arrNums.length && m.getArrNums()[0].length == arrNums[0].length;
    }

    public boolean chMult(Matrix m) {
        return arrNums[0].length == m.getArrNums().length;
    }

    public void add(Matrix m) {
        if (!chAdd(m)) {
            System.out.println("BAD DIMENSIONS");
        }
        else {
            for (int i = 0; i < arrNums.length; i++) {
                for (int j = 0; j < arrNums[0].length; j++) {
                    arrNums[i][j] += m.getArrNums()[i][j];
                }
            }
        }
    }

    // Same as subtracting
    public void subtract(Matrix m) {
        if (!chAdd(m)) {
            System.out.println("BAD DIMENSIONS");
        } else {
            for (int i = 0; i < arrNums.length; i++) {
                for (int j = 0; j < arrNums[0].length; j++) {
                    arrNums[i][j] -= m.getArrNums()[i][j];
                }
            }
        }
    }

    public void multiply(Matrix m) {
        if (!chMult(m)) {
            System.out.println("BAD DIMENSIONS");
        }
        else {
            Matrix temp = new Matrix(arrNums.length, m.getArrNums()[0].length);

            // Code for multiplying
            for (int i = 0; i < arrNums.length; i++) {
                for (int j = 0; j < m.getArrNums()[0].length; j++) {
                    double sum = 0;
                    for (int k = 0; k < arrNums[0].length; k++) {
                        sum += arrNums[i][k] * m.getArrNums()[k][j];
                    }
                    temp.setElement(sum, i, j);
                }
            }

            arrNums = temp.getArrNums();
        }
    }

    public void scmult(double s) {
        for (int i = 0; i < arrNums.length; i++) {
            for (int j = 0; i < arrNums[0].length; j++) {
                arrNums[i][j] *= s;
            }
        }
    }
}
