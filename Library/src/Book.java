// Book.java
// Landon Holland - 10/28/19
// Book for Library and Patron

public class Book {
    // Private data
    private String title;
    private String author;

    public Book() { // Default constructor
        title = null;
        author = null;
    }
    public Book(String title, String author) { // Fill constructor
        this.title = title;
        this.author = author;
    }

    // Set's and get's
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        if (author == null || title == null) {
            return null;
        }
        return title + ", by " + author;
    }
}
