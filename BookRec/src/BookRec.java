// BookRec.java
// Landon Holland - 12/11/19
// The Class where we actually Do Stuff™

import java.io.IOException;

public class BookRec {
    // Private data
    private ReaderList rl;
    private BookList bl;

    public BookRec() { // default constructor
        rl = new ReaderList();
        bl = new BookList();
    }

    public BookRec(String readerpath, String bookpath) throws IOException { // file constructor
        rl = new ReaderList(readerpath);
        bl = new BookList(bookpath);
    }

    @Override
    public String toString() {
        return "Readers:\n" + rl.toString() + "\nBooks:\n" + bl.toString();
    }

    // sets and gets
    public void setBl(BookList bl) {
        this.bl = bl;
    }
    public BookList getBl() {
        return bl;
    }

    public void setRl(ReaderList rl) {
        this.rl = rl;
    }
    public ReaderList getRl() {
        return rl;
    }

    // actual methods for BookRec
    public Book[] findBooksA(Reader r) {
        // first we're gonna find the average of the books
        double[] avgBookRatings = new double[bl.getBooks().length];
        for (int i = 0; i < bl.getBooks().length; i++) {
            int totalRating = 0;
            int numebrOfRatings = 0;
            for (int j = 0; j < rl.getReaders().length; j++) {
                if (rl.getReaders()[j].getRatings()[i] != 0) {
                    totalRating += rl.getReaders()[j].getRatings()[i];
                    numebrOfRatings++;
                }
            }

            if (numebrOfRatings == 0) {
                avgBookRatings[i] = -1;
            }
            else {
                avgBookRatings[i] = (double) totalRating / (double) numebrOfRatings;
            }
        }

        // now we return the first three that the current reader hasn't read
        for (int i = 0; i < avgBookRatings.length; i++) {
            if (r.getRatings()[i] != 0) {
                avgBookRatings[i] = -1000;
            }
        }

        // we have to make an array for the indexes of these average ratings
        int[] avgBookRatingsIndexes = new int[avgBookRatings.length];
        for (int i = 0; i < avgBookRatingsIndexes.length; i++) {
            avgBookRatingsIndexes[i] = i;
        }

        // now we sort the ratings
        for (int i = 0; i < avgBookRatings.length - 1; i++) {
            for (int j = i; j < avgBookRatings.length; j++) {
                if (avgBookRatings[i] < avgBookRatings [j]) {
                    double temp = avgBookRatings[i];
                    avgBookRatings[i] = avgBookRatings[j];
                    avgBookRatings[j] = temp;

                    int tempi = avgBookRatingsIndexes[i];
                    avgBookRatingsIndexes[i] = avgBookRatingsIndexes[j];
                    avgBookRatingsIndexes[j] = tempi;
                }
            }
        }

        Book[] outBooks = new Book[3];
        outBooks[0] = bl.getBooks()[avgBookRatingsIndexes[0]];
        outBooks[1] = bl.getBooks()[avgBookRatingsIndexes[1]];
        outBooks[2] = bl.getBooks()[avgBookRatingsIndexes[2]];

        return outBooks;
    }

    public Reader findSimilarReaderB(Reader r) {
        // some data to do stuff
        int maxScore = 0;
        Reader out = new Reader();

        // loop through all readers
        for (int i = 0; i < rl.getReaders().length; i++) {
            // first we have to make sure we aren't doing anything to our own reader
            if (!rl.getReaders()[i].toString().equals(r.toString())) {
                int score = 0;
                // loop through ratings of current reader[i] and then add it to the score
                for (int j = 0; j < bl.getBooks().length; j++) {
                    score += rl.getReaders()[i].getRatings()[j] * r.getRatings()[j];
                }
                if (score > maxScore) {
                    maxScore = score;
                    out = rl.getReaders()[i];
                }
            }
        }
        return out;
    }

    public Book findSimilarBookC(Reader r) {
        int score = 0;
        int[] similarity = new int[rl.getReaders().length];
        for (int i = 0; i < rl.getReaders().length; i++) {
            if (rl.getReaders()[i].getName().equals(r.getName())) {
                score = -1;
            }
            else {
                score = 0;
                for (int j = 0; j < bl.getBooks().length; j++) {
                    score += rl.getReaders()[i].getRatings()[j] * r.getRatings()[j];
                }
            }
            similarity[i] = score;
        }

        int[] prediction = new int[bl.getBooks().length];
        for (int i = 0; i < bl.getBooks().length; i++) {
            prediction[i] = 0;
        }

        for (int i = 0; i < prediction.length; i++) {
            for (int j = 0; j < similarity.length; j++) {
                prediction[i] = rl.getReaders()[j].getRatings()[i] * similarity[j];
            }
        }

        boolean firsttime = true;
        int similarid = 0;
        int maxprediction;

        do {
            maxprediction = -1;
            if (!firsttime) {
                prediction[similarid] = -1;
            }
            for (int i = 0; i < prediction.length; i++) {
                if (prediction[i] > maxprediction) {
                    maxprediction = prediction[i];
                    similarid = i;
                }
            }
            firsttime = false;
        } while (r.getRatings()[similarid] != 0);
        return bl.getBooks()[similarid];
    }

    public Book[] findSimilarBooks(Reader inputR, Reader targetR) {
        int bookCount = 0;
        for (int i = 0; i < bl.getBooks().length; i++) {
            if (targetR.getRatings()[i] == 5 && inputR.getRatings()[i] == 0) {
                bookCount++;
            }
        }

        // now we know what to make the array
        Book[] outBooks = new Book[bookCount];

        int j = 0; // counter
        for (int i = 0; i < bl.getBooks().length; i++) {
            if (targetR.getRatings()[i] == 5 && inputR.getRatings()[i] == 0) {
                outBooks[j] = bl.getBooks()[i];
                j++;
            }
        }
        return outBooks;
    }
}
