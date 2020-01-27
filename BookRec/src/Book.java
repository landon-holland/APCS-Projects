// Book.java
// Landon Holland - 12/9/19
// Book for BookRec

// All of this for images
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Book {
    // Private data
    private String title;
    private String author;
    private boolean isSeries;
    private BufferedImage cover;

    public Book() { // Default constructor
        title = "";
        author = "";
        isSeries = false;
    }

    public Book(String title, String author, boolean isSeries, BufferedImage cover) { // Fill constructor
        this.title = title;
        this.author = author;
        this.isSeries = isSeries;
        this.cover = cover;
    }

    public Book(String title, String author, boolean isSeries, String coverpath) throws IOException { // Alternate fill constructor
        this.title = title;
        this.author = author;
        this.isSeries = isSeries;
        this.cover = ImageIO.read(new File(coverpath));
    }

    @Override
    public String toString() {
        return title + ", by " + author;
    }

    // Sets and gets
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isSeries() {
        return isSeries;
    }
    public void setisSeries(boolean series) {
        isSeries = series;
    }

    public BufferedImage getCover() {
        return cover;
    }
    public void setCover(BufferedImage cover) {
        this.cover = cover;
    }
}
