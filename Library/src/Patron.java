// Patron.java
// Landon Holland - 10/28/19
// Patron has some books and is in a library

public class Patron {
    // Private data
    private String name;
    private Book[] books;

    public Patron() { // Default constructor
        name = null;
        books = new Book[3];
        for (int i = 0; i < 3; i++) {
            books[i] = new Book();
        }
    }
    public Patron(String name, Book[] books) { // Fill constructor
        this.name = name;
        this.books = books;
    }

    // Set's and get's
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book getBook(int i) {
        return books[i];
    }
    public void setBook(Book b, int i) {
        books[i] = b;
    }

    public String toString() {
        return name + ":\n" + books[0] + "\n" + books[1] + "\n" + books[2];
    }

    public boolean isBorrowed(String title) {
        for (int i = 0; i < 3; i++) {
            if (books[i].getTitle() == null) {
                continue;
            }
            else if (books[i].getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String title) {
        for (int i = 0; i < 3; i++) {
            //System.out.println(i);
            if (books[i].getTitle() == null) {
                continue;
            }
            else if (books[i].getTitle().equals(title)) {
                books[i].setAuthor(null);
                books[i].setTitle(null);
                return true;
            }
        }
        return false;
    }

    public boolean borrowBook(Book b) {
        for (int i = 0; i < 3; i++) {
            //System.out.println(i);
            //System.out.println(b.toString());
            if (books[i].getTitle() == null || books[i].getAuthor() == null) {
                books[i].setTitle(b.getTitle());
                books[i].setAuthor(b.getAuthor());
                return true;
            }
        }
        return false;
    }
}
