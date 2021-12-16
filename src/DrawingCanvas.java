import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.JFrame;

public class DrawingCanvas extends JPanel implements KeyListener, ActionListener {
    JFrame f = new JFrame();
    int choice;

    public DrawingCanvas() throws HeadlessException {
        this.addKeyListener(this);
        f.add(this);
        f.setSize(400, 400);
        f.setVisible(true);
        f.addKeyListener(this);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 10; i++) {
            switch (choice) {
                case 1:
                    g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
                    break;
                case 2:
                    g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
                    break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("okkkkkkkkk");
        if (e.getKeyChar() == 107) {
            //K - kwadrat
            choice = 1;
        } else if (e.getKeyChar() == 111) {
            //O - koło
            choice = 2;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
