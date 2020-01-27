// BookRecTester.java
// Landon Holland - 12/10/19
// Test BookRec

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BookRecTester {
    public static void main(String[] args) throws IOException {
        BookRec br  = new BookRec("D:\\AP CS\\Project Files\\BookRec\\src\\resources\\ratings.txt",
                "D:\\AP CS\\Project Files\\BookRec\\src\\resources\\books.txt");
        BookRecGUI brGUI = new BookRecGUI(br);
    }
}
