// Ball.java
// Landon Holland - 10/29/19
// Extend circle and add pong stuff

import java.awt.*;

public class Ball extends Circle {
    // Private data
    private int direction; // direction of travel
    private int speed; // of travel

    // Default constructor
    public Ball() {
        super();
        direction = 0;
        speed = 0;
    }

    // Fill constructor
    public Ball(int x, int y, int r, Color c, int direction, int speed) {
        super(x, y, r, c);
        this.direction = direction;
        this.speed = speed;
    }

    // Set's and get's
    public void setDirection(int degrees) {
        direction = degrees % 360;
    }
    public int getDirection() {
        return direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }

    // turning
    public void turn(int degrees) {
        direction = (direction + degrees) % 360;
        //System.out.println(direction);
    }

    // standard moving
    public void move() {
        super.move((int)(speed * Math.cos(Math.toRadians(direction))), (int)(speed * Math.sin(Math.toRadians(direction))));
    }

    // we're gonna use containspoint to turn
    public boolean collides(Paddle p) {
        // we're gonna assume that the left most point is gonna collide
        return p.containsPoint(x - r, y);
    }

    // Animation
    public void animate(int width, int height, Paddle p, Player p1) {
        // before we doing anything, lets check if it's colliding
        if (super.x + super.r >= width) { // if we're going off the right of the screen we need to turn around
            turn(2 * (90 - (direction % 90)));
        }

        // we test the y stuff separately
        if (super.y > height) { // bottom
            turn(2 * (90 - (direction % 90)));
        }
        else if (super.y < 0) { // top
            turn(2 * (90 - (direction % 90)));
        }

        // let's test some COLLISION
        if (collides(p)) {
            turn(2 * (90 - (direction % 90)));
            p1.hit();
        }

        move();
    }

}
