import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;

public class DrawingCanvas extends JPanel{
    JFrame f = new JFrame();
    int choice;

    public DrawingCanvas(int choice) throws HeadlessException {
        this.choice = choice;
        f.add(this);
        f.setSize(400, 400);
        f.setVisible(true);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 10; i++) {
            switch (choice) {
                case 1:
                    g.drawRect(10, 10, 50, 50);
                    break;
                case 2:
                    g.drawOval(10, 10, 50, 50);
                    break;
            }
        }
    }
}
