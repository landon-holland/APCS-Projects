// Tester.java
// Landon Holland - 10/28/19
// Test Book and Patron

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        // Declare books
        Book HP = new Book("Harry Potter", "JK Rowlings");
        Book HG = new Book("Hunger Games", "John Cena");
        Book CM = new Book("Communist Manifesto", "Karl Marxist");

       Patron p = new Patron("Landon", new Book[]{HP, HG, CM});

       System.out.println(p.toString());
       System.out.println();


        p.returnBook("Communist Manifesto");
       p.returnBook("Hunger Games");

        System.out.println(p.toString());
        System.out.println();

        Book Minecraft = new Book("Minecraft", "Notch");

        p.borrowBook(Minecraft);

        System.out.println(p.toString());
        System.out.println();


        System.out.println(p.isBorrowed("Minecraft"));
        System.out.println(p.isBorrowed("Hunger Games"));
    }
}
