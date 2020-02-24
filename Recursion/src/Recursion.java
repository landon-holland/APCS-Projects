// Recursion.java
// Landon Holland - 2/11/20
// Weird class with stupid recursive methods

public class Recursion {

    // Example code
    public static long iterFactorial(int n) {
        long fact = 1;
        for (int i = n; i > 1; i--) {
            fact *= i;
        }

        return fact;
    }

    public static long recFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * recFactorial(n - 1);
        }
    }

    public static long iterFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        else {
            int[] f = new int[n + 1];
            f[1] = 1;
            f[2] = 1;
            for (int i = 3; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }
    }

    public static long recFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recFibonacci(n - 1) + recFibonacci(n - 2);
    }

    public static long iterSummation(int n) {
        long s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        return s;
    }

    public static long recSummation(int n) {
        if (n == 0) {
            return 0;
        }
        else {
            return n + recSummation(n - 1);
        }
    }

    public static long iterExponent(int n, int p) {
        if (p == 0) {
            return 1;
        }
        long s = n;
        for (int i = 1; i <= p - 1; i++) {
            s *= n;
        }
        return s;
    }

    public static long recExponent(int n, int p) {
        if (p == 0) {
            return 1;
        }
        else {
            return n * recExponent(n, p - 1);
        }
    }

    public static String iterReverse(String s) {
        String o = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            o += s.charAt(i);
        }
        return o;
    }

    public static String recReverse(String s) {
        if (s.length() == 1) {
            return s;
        }
        else {
            return s.substring(s.length() - 1) + recReverse(s.substring(0, s.length() - 1));
        }
    }

    public static boolean isPalindrome(String s) {
        return (s.equals(recReverse(s)));
    }

    public static int iterLettersIn(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                c++;
            }
        }

        return c;
    }

    public static int recLettersIn(String s) {
        if (s.length() == 1) {
            if (Character.isLetter(s.charAt(0))) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            if (Character.isLetter(s.charAt(0))) {
                return 1 + recLettersIn(s.substring(1));
            }
            else {
                return recLettersIn(s.substring(1));
            }
        }
    }
}
