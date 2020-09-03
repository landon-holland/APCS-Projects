// RecursionTester.java
// Landon Holland - 2/12/20
// Test all of the static recursion methods

public class RecursionTester {
    public static void main(String[] args) {
        System.out.println("iterFactorial(5) = " + Recursion.iterFactorial(5));
        System.out.println("recFactorial(5) = " + Recursion.recFactorial(5));
        System.out.println();
        System.out.println("iterFibonacci(6) = " + Recursion.iterFibonacci(6));
        System.out.println("recFibonacci(6) = " + Recursion.recFibonacci(6));
        System.out.println();
        System.out.println("iterSummation(5) = " + Recursion.iterSummation(5));
        System.out.println("recSummation(5) = " + Recursion.recSummation(5));
        System.out.println();
        System.out.println("iterExponent(5, 3) = " + Recursion.iterExponent(5, 3));
        System.out.println("recExponent(5, 3) = " + Recursion.recExponent(5, 3));
        System.out.println();
        System.out.println("iterReverse(\"racecar\") = " + Recursion.iterReverse("racecar"));
        System.out.println("recReverse(\"racecar\") = " + Recursion.recReverse("racecar"));
        System.out.println("isPalindrome(\"racecar\") = " + Recursion.isPalindrome("racecar"));
        System.out.println();
        System.out.println("iterLettersIn(\"1c2a3r\") = " + Recursion.iterLettersIn("1c2a3r"));
        System.out.println("recLettersIn(\"1c2a3r\") = " + Recursion.recLettersIn("1c2a3r"));
    }
}
