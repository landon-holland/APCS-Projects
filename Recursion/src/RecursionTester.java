// RecursionTester.java
// Landon Holland - 2/12/20
// Test all of the static recursion methods

public class RecursionTester {
    public static void main(String[] args) {
        System.out.println(Recursion.iterExponent(6, 0));
        System.out.println(Recursion.recExponent(1, 8));
        System.out.println(Recursion.iterReverse("jack"));
        System.out.println(Recursion.recReverse("jack"));
        System.out.println(Recursion.isPallindrome("racecar"));
    }
}
