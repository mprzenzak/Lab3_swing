import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EscapingButton extends JFrame implements KeyListener {
    Container container = getContentPane();
    private final JButton loginButton = new JButton("Złap mnie!");
    private final JButton resetButton = new JButton("Reset");
    private final JLabel drawingInfoLabel = new JLabel("Naciśnij k, żeby narysowac kwadrat lub o, żeby narysowac koło");

    public EscapingButton() throws HeadlessException {
        this("undefined");
    }

    public EscapingButton(String title) {
        super(title);
        setFocusable(true);
        requestFocus();
        requestFocusInWindow();
        this.addKeyListener(this);
        container.setLayout(null);
        container.setBackground(Color.white);
        buildFrame();
        addComponentsToContainer();

        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                PointerInfo a = MouseInfo.getPointerInfo();
                Point currentMousePosition = a.getLocation();
                int mouseX = (int) currentMousePosition.getX();
                int mouseY = (int) currentMousePosition.getY();
                if (mouseX != loginButton.getLocationOnScreen().x) {
                    if (loginButton.getBounds().x < 600 && loginButton.getBounds().y < 700) {
                        if (getRandomDirection() == 1) {
                            loginButton.setBounds(loginButton.getBounds().x + 30, loginButton.getBounds().y - 60, 100, 30);
                        } else {
                            loginButton.setBounds(loginButton.getBounds().x + 30, loginButton.getBounds().y + 60, 100, 30);
                        }
                    } else {
                        loginButton.setBounds(mouseX + 30, mouseY + 30, 100, 30);
                    }
                } else {
                    System.out.println("jestes bezpieczny");
                }
            }
        });
    }

    private int getRandomDirection() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

    protected void buildFrame() {
        this.setBounds(10, 10, 800, 800);
        this.setResizable(false);
        drawingInfoLabel.setBounds(50, 30, 500, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(650, 30, 100, 30);
        resetButton.addActionListener(e -> {
            clear();
        });
    }


    public void addComponentsToContainer() {
        container.add(drawingInfoLabel);
        container.add(loginButton);
        container.add(resetButton);
    }

    private void clear() {
        loginButton.setBounds(50, 300, 100, 30);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 107) {
            //K - kwadrat
            DrawingCanvas drawingCanvas = new DrawingCanvas(1);
            //drawingCanvas.choice = 1;

            drawingCanvas.setVisible(true);
            drawingCanvas.setBounds(10, 10, 800, 800);
        } else if (e.getKeyChar() == 111) {
            //O - koło
            DrawingCanvas drawingCanvas = new DrawingCanvas(2);
            //drawingCanvas.choice = 1;

            drawingCanvas.setVisible(true);
            drawingCanvas.setBounds(10, 10, 800, 800);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}