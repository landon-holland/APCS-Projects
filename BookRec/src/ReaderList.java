// ReaderList.java
// Landon Holland - 12/10/19
// List of readers

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderList {
    // Private data
    private Reader[] readers;

    public ReaderList() { // default constructor
        readers = new Reader[86];
    }

    public ReaderList(String filepath) throws IOException { // file constructor
        readers = new Reader[86];

        // initialize these objects for reading the file
        FileReader fr = new FileReader(filepath);
        BufferedReader bfr = new BufferedReader(fr);

        String line = bfr.readLine(); // we're gonna read the first line then loop til we're out
        int i = 0; // count
        while (!(line == null)) {
            String name = line;
            String ratings[] = bfr.readLine().split(" ");

            // now that we got the lines, we're gonna loop through the ratings and convert them
            int[] nums = new int[ratings.length];

            for (int j = 0; j < ratings.length; j++) {
                if (ratings[j].equals("N")) {
                    nums[j] = 0;
                }
                else if (ratings[j].equals("O")) {
                    nums[j] = 1;
                }
                else if (ratings[j].equals("L")) {
                    nums[j] = 3;
                }
                else if (ratings[j].equals("R")) {
                    nums[j] = 5;
                }
                else if (ratings[j].equals("D")) {
                    nums[j] = -3;
                }
                else if (ratings[j].equals("H")) {
                    nums[j] = -5;
                }
                else {
                    System.out.println("Invalid rating " + ratings[j]);
                }
            }

            // finish up
            readers[i] = new Reader(name, nums);
            i++;
            line = bfr.readLine();
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (Reader reader : readers) {
            out.append(reader.toString()).append("\n");
        }

        return out.toString();
    }

    // sets and gets
    public Reader[] getReaders() {
        return readers;
    }
    public void setReaders(Reader[] readers) {
        this.readers = readers;
    }

    // find reader based on name
    public Reader findReader(String name) {
        for (int i = 0; i < readers.length; i++) {
            if (readers[i].getName().equals(name)) {
                return readers[i];
            }
        }
        return null;
    }
}
