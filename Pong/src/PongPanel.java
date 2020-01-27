// PongPanel.java
// Landon Holland - 10/29/19
// Extend the JPanel to do stuff

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class PongPanel extends JPanel {
    // Private data
    private Ball b;
    private Player p1;
    ImageIcon kummer = new ImageIcon("D:\\AP CS\\Project Files\\Pong\\src\\Enemy.png");
    private TopTen tt;

    private boolean gameover = false;

    private Timer t;
    private Animation a = new Animation();

    // Fill constructor
    public PongPanel(Color backColor, String name) throws IOException {
        setBackground(backColor);

        b = new Ball(500, 250, 5, Color.white, 45, 10);

        tt = new TopTen("D:\\AP CS\\Project Files\\Pong\\src\\TopTen.txt");
        System.out.println(tt.toString());
        tt.sortPlayers();
        System.out.println(tt.toString());

        t = new Timer();
        t.schedule(a, 5000, 17);

        p1 = new Player(name, new Paddle(100, 100, 25, 100, Color.white), 0);

        addMouseMotionListener(new FrameListener());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        b.fill(g);

        p1.getP().fill(g);

        kummer.paintIcon(this, g, getWidth() - 100, 175);

        // score
        g.setColor(Color.white);
        Font yeet = new Font(null, Font.BOLD, 32);
        g.setFont(yeet);
        g.drawString(String.valueOf(p1.getScore()), 500, 100);
    }

    private class Animation extends TimerTask {
        public void run() {
            if (!gameover) {
                b.animate(getWidth(), getHeight(), p1.getP(), p1);
                repaint();
            }
            // gonna check losing here
            if (b.getX() < 0 && !gameover) {
                gameover = true;
                tt.addPlayer(p1);
                System.out.println(tt.toString());
                try {
                    tt.saveFile();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class FrameListener extends MouseMotionAdapter {
        public void mouseMoved(MouseEvent e) {
            p1.getP().move(e.getYOnScreen() - 100);
        }
    }
}
