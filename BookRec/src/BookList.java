// BookList.java
// Landon Holland - 12/10/19
// List of books

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BookList {
    // Private data
    private Book[] books;

    public BookList() { // default constructor
        books = new Book[55];
    }

    public BookList(String filepath) throws IOException { // file constructor
        books = new Book[55];

        FileReader fr = new FileReader(filepath);
        BufferedReader bfr = new BufferedReader(fr);

        String line = bfr.readLine(); // we're gonna read the first line then loop til we're out
        int i = 0; // count
        while (!(line == null)) {
            books[i] = new Book();
            books[i].setAuthor(line.split(",")[0]);
            books[i].setTitle(line.split(",")[1]);

            if (books[i].getTitle().equals("Bourne Series") || books[i].getTitle().equals("Foundation Series") || books[i].getTitle().equals("Harry Potter Series")
            || books[i].getTitle().equals("Maus: A Survivor's Tale") || books[i].getTitle().equals("Twilight Series")) {
                books[i].setisSeries(true);
            }

            // We need to load the cover but there are exceptions to the filenames
            String coverpath = "";
            if (books[i].isSeries()) {
                if (books[i].getTitle().equals("Maus: A Survivor's Tale")) {
                    coverpath = "D:\\AP CS\\Project Files\\BookRec\\src\\resources\\covers\\series\\Maus Series.jpg";
                }
                else {
                    coverpath = "D:\\AP CS\\Project Files\\BookRec\\src\\resources\\covers\\series\\" + books[i].getTitle() +".jpg";
                }
            }
            else {
                if (books[i].getTitle().equals("Dinotopia: A Land Apart from Time")) {
                    coverpath = "D:\\AP CS\\Project Files\\BookRec\\src\\resources\\covers\\Dinotopia.jpg";
                }
                else {
                    coverpath = "D:\\AP CS\\Project Files\\BookRec\\src\\resources\\covers\\" + books[i].getTitle() +".jpg";
                }
            }

            // set the cover
            books[i].setCover(ImageIO.read(new File(coverpath)));

            // new line to evaluate
            line = bfr.readLine();
            i++;
        }

        // Should be everything; cleaning up
        bfr.close();
        fr.close();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (Book book : books) {
            out.append(book.toString()).append("\n");
        }

        return out.toString();
    }

    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }

    // find the book from a toString
    public Book findBook(String book) {
        for (int i = 0; i < books.length; i++) {
            if(books[i].toString().equals(book)) {
                return books[i];
            }
        }
        return null;
    }
}
