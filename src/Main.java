import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Main extends JPanel {

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    KeyListener listener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    };

    private void moveBall(){
        if (x + xa < 0) xa = 1;

        if (x + xa > getWidth() - 30) xa = -1;

        if (y + ya < 0) ya = 1;

        if (y + ya > getHeight() - 30) ya = -1;

        x= x + xa;

        y = y + ya;
    }

    @Override
    public void paint(Graphics g){
        //superpaint se usa para que el circulo se actualice automaticamnete y no deje la linea
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x,y,30,30);

    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Main main = new Main();
        frame.add(main);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true){
            main.moveBall();
            main.repaint();
            Thread.sleep(10);
        }
    }
}