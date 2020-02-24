// RecursionTester.java
// Landon Holland - 2/12/20
// Test all of the static recursion methods

public class RecursionTester {
    public static void main(String[] args) {
        System.out.println("iterFactorial(5) = " + Recursion.iterFactorial(5));
        System.out.println("recFactorial(5) = " + Recursion.recFactorial(5));
        System.out.println();
        System.out.println("iterFibonacci(7) = " + Recursion.iterFibonacci(7));
        System.out.println("recFibonacci(7) = " + Recursion.recFibonacci(7));
        System.out.println();
        System.out.println("iterSummation(4) = " + Recursion.iterSummation(4));
        System.out.println("recSummation(4) = " + Recursion.recSummation(4));
        System.out.println();
        System.out.println("iterExponent(4, 6) = " + Recursion.iterExponent(4, 6));
        System.out.println("recExponent(4, 6) = " + Recursion.recExponent(4, 6));
        System.out.println();
        System.out.println("iterReverse(\"Gamer\") = " + Recursion.iterReverse("Gamer"));
        System.out.println("recReverse(\"racecar\") = " + Recursion.recReverse("racecar"));
        System.out.println("isPalindrome(\"racecar\") = " + Recursion.isPalindrome("racecar"));
        System.out.println();
        System.out.println("iterLettersIn(\"123car\") = " + Recursion.iterLettersIn("123car"));
        System.out.println("recLettersIn(\"123car\") = " + Recursion.recLettersIn("123car"));
    }
}
