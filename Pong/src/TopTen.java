// TopTen.java
// Landon Holland - 11/5/19
// use players and files to save a topten

import java.io.*;

public class TopTen {
    // Private data
    private Player[] ps;
    private String filepath;
    private int pc; // playercount

    // Constructors
    public TopTen() {
        ps = new Player[10];
        pc = 0;
        filepath = "";
    }
    public TopTen(String filepath) throws IOException { // file constructor
        ps = new Player[10];
        pc = 0;
        this.filepath = filepath;

        // Initialize these classes
        FileReader fr = new FileReader(filepath);
        BufferedReader bfr = new BufferedReader(fr);

        pc = Integer.parseInt(bfr.readLine()); // first line is gonna be the int
        for (int i = 0; i < pc; i++) {
            ps[i] = new Player(bfr.readLine(), new Paddle(), Integer.parseInt(bfr.readLine()));
        }

        // close the files
        bfr.close();
        fr.close();

        // after we're done we can sort
        sortPlayers();
    }

    public void setPs(Player[] ps) {
        this.ps = ps;
    }
    public Player[] getPs() {
        return ps;
    }

    public String getFilepath() {
        return filepath;
    }
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public int getPc() { // no setter cause that can break the shiz
        return pc;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < pc; i++) {
            out.append(ps[i].toString()).append("\n");
        }

        return out.toString();
    }

    public String getHTML() {
        StringBuilder out = new StringBuilder();
        out.append("<html><body>");
        for (int i = 0; i < pc; i++) {
            out.append(ps[i].toString()).append("<br>");
        }
        out.append("</body></html>");

        return out.toString();
    }

    // Now we do actual topten stuff
    public void sortPlayers() {
        for (int i = 0; i < pc - 1; i++) {
            for (int j = i + 1; j < pc; j++) {
                if (ps[i].getScore() < ps[j].getScore()) {
                    Player temp = ps[i];
                    ps[i] = ps[j];
                    ps[j] = temp;
                }
            }
        }
    }

    public void saveFile() throws FileNotFoundException { // we're gonna call this whenever we can
        // do this first
        sortPlayers();

        PrintWriter pw = new PrintWriter(filepath);

        pw.println(pc);
        for (int i = 0; i < pc; i++) {
            pw.println(ps[i].getName());
            pw.println(ps[i].getScore());
        }

        pw.close();
    }

    public void addPlayer(Player p) {
        sortPlayers(); // do this first
        System.out.println(ps[pc - 1].getScore());
        System.out.println(p.getScore());
        if (!(ps[pc - 1].getScore() > p.getScore())) { // make sure we're even in the top ten
            if (pc == 10) {
                // this is for if we're full of crap
                ps[pc - 1] = p;
            }
            else {
                // now we add the dude
                pc++;
                ps[pc - 1] = p;
            }
            sortPlayers(); // resort and then we're gucci gamer
        }
    }
}
