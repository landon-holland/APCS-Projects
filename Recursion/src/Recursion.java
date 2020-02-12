// Recursion.java
// Landon Holland - 2/11/20
// Weird class with stupid recursive methods

public class Recursion {
    // everything is gonna be static probably
    public static long interFactorial(int n) {
        long fact = 1;
        for (int i = n; i > 1; i--) {
            fact *= i;
        }

        return fact;
    }

}
