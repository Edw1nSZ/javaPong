import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int Y = 500;
    private static final int WITH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Main game;

    public Racquet(Main game) {
        this.game = game;
    }

    public void move() {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > game.getWidth() - 30)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - 30)
            ya = -1;

        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WITH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = game.speed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    public int getTopY() {
        return Y - HEIGHT;
    }
}