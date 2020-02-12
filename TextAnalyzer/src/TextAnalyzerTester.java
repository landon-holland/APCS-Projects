// TextAnalyzerTester.java
// Landon Holland - 1/31/20
// Test TextAnalyzer

import java.io.File;

public class TextAnalyzerTester {
    public static void main(String[] args) {
        TextAnalyzer t1 = new TextAnalyzer(new File("Gettysburg.txt"));
        TextAnalyzer t2 = new TextAnalyzer(new File("test-6th-grader.txt"));
        TextAnalyzer t3 = new TextAnalyzer(new File("test-college-grad.txt"));

        System.out.println(t1.toString());
        System.out.println();
        System.out.println(t2.toString());
        System.out.println();
        System.out.println(t3.toString());
    }
}
