import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JFrame;

public class DrawingCanvas extends Canvas implements KeyListener, ActionListener{
    //Container container = getContentPane();
    JFrame f = new JFrame();

    public DrawingCanvas() throws HeadlessException {
//        buildFrame();
//        addComponentsToContainer();
//        JFrame f = new JFrame();
        this.addKeyListener(this);
        f.add(this);
        f.setSize(400, 400);
        //f.setLayout(null);
        f.setVisible(true);
        f.addKeyListener(this);
    }


    public void paintSpecifiedShape(String shape) {

        Graphics graphics = new Graphics() {
            @Override
            public Graphics create() {
                return null;
            }

            @Override
            public void translate(int x, int y) {

            }

            @Override
            public Color getColor() {
                return null;
            }

            @Override
            public void setColor(Color c) {

            }

            @Override
            public void setPaintMode() {

            }

            @Override
            public void setXORMode(Color c1) {

            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public void setFont(Font font) {

            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                return null;
            }

            @Override
            public Rectangle getClipBounds() {
                return null;
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {

            }

            @Override
            public void setClip(int x, int y, int width, int height) {

            }

            @Override
            public Shape getClip() {
                return null;
            }

            @Override
            public void setClip(Shape clip) {

            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {

            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {

            }

            @Override
            public void fillRect(int x, int y, int width, int height) {
                int x1 = x;
                int y1 = y;
                int x2 = x + width;
                int y2 = y + height;
                drawLine(x1, y1, x2, y1);
                drawLine(x2, y1, x2, y2);
                drawLine(x2, y2, x1, y2);
                drawLine(x1, y2, x1, y1);
                setColor(Color.red);
            }

            @Override
            public void clearRect(int x, int y, int width, int height) {

            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void drawOval(int x, int y, int width, int height) {

            }

            @Override
            public void fillOval(int x, int y, int width, int height) {

            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawString(String str, int x, int y) {

            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {

            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public void dispose() {

            }
        };
        switch (shape) {
            case "square":
                graphics.fillRect(130, 30, 100, 80);
            case "oval":
                graphics.drawOval(30, 130, 50, 60);
                setForeground(Color.RED);
            case "3DRecatangle":
                graphics.drawString("Hello", 10, 10);
//                graphics.fill3DRect(30, 130, 40, 50, true);
        }
//        g.drawString("Hello", 40, 40);
//        setBackground(Color.WHITE);
//        g.fillRect(130, 30, 100, 80);
//        g.drawOval(30, 130, 50, 60);
//        setForeground(Color.RED);
//        g.fillOval(130, 130, 50, 60);
//        g.drawArc(30, 200, 40, 50, 90, 60);
//        g.fillArc(30, 130, 40, 50, 180, 40);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("okkkkkkkkk");
        if (e.getKeyChar() == 107) {
            //K - kwadrat
            paintSpecifiedShape("square");
        } else if (e.getKeyChar() == 79) {
            //O - koło
            paintSpecifiedShape("oval");
        } else if (e.getKeyCode() == 65) {
            //A - trójkąt
            paintSpecifiedShape("3DRecatangle");
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 107) {
            //K - kwadrat
            paintSpecifiedShape("square");
        } else if (e.getKeyCode() == 79) {
            //O - koło
            paintSpecifiedShape("oval");
        } else if (e.getKeyCode() == 65) {
            //A - trójkąt
            paintSpecifiedShape("3DRecatangle");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
