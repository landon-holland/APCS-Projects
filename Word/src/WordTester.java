// WordTester.java
// Landon Holland - 1/21/20
// Test word please

public class WordTester {
    public static void main(String[] args) {
        Word w = new Word("hello");
        Word w2 = new Word("time");
        Word w3 = new Word("moan");
        Word w4 = new Word("table");
        Word w5 = new Word("beautiful");

        System.out.println(w.toString());
        System.out.println(w2.toString());
        System.out.println(w3.toString());
        System.out.println(w4.toString());
        System.out.println(w5.toString());
    }
}
