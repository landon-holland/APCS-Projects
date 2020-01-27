// Reader.java
// Landon Holland - 12/9/19
// Reader with ratings for BookRec

public class Reader {
    // Private data
    private String name;
    private int[] ratings;

    public Reader() {
        name = "";
        ratings = new int[55];
    }

    public Reader(String name, int[] ratings) {
        this.name = name;
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return name;
    }

    // Sets and gets
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int[] getRatings() {
        return ratings;
    }
    public void setRatings(int[] ratings) {
        this.ratings = ratings;
    }
}
