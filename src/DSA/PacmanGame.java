package DSA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacmanGame extends JFrame implements KeyListener {
    private int pacmanX = 250; // Initial x-coordinate of Pacman
    private int pacmanY = 250; // Initial y-coordinate of Pacman

    public PacmanGame() {
        setTitle("Pacman Game");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.YELLOW);
        g.fillArc(pacmanX, pacmanY, 50, 50, 45, 270);
    }

    public void movePacman(int dx, int dy) {
        pacmanX += dx;
        pacmanY += dy;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            movePacman(-5, 0);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            movePacman(5, 0);
        } else if (keyCode == KeyEvent.VK_UP) {
            movePacman(0, -5);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            movePacman(0, 5);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PacmanGame());
    }
}
