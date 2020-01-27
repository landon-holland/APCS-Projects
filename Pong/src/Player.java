// Player.java
// Landon Holland - 10/29/19
// Has a paddle and score

public class Player {
    // Private data
    private String name;
    private Paddle p;
    private int score;

    // Default Constructor
    public Player() {
        name = "";
        p = new Paddle();
        score = 0;
    }

    // Fill Constructor
    public Player(String name, Paddle p, int score) {
        this.name = name;
        this.p = p;
        this.score = score;
    }

    // Set's and get's
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setP(Paddle p) {
        this.p = p;
    }
    public Paddle getP() {
        return p;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }

    // toString
    @Override
    public String toString() {
        return name + " - " + score;
    }

    // We're gonna make a method to increment the score
    public void hit() {
        score += 50;
    }
}
