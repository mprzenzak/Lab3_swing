import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EscapingButton extends JFrame implements ActionListener {
    Container container = getContentPane();
    private final JButton loginButton = new JButton("Złap mnie!");
    private final JButton resetButton = new JButton("Reset");
    private final JButton drawingCanvasButton = new JButton("Rysowanie kształtów");
    private final ArrayList<String> userInfo = new ArrayList<>();
    private final HashMap<String, String> usersMap = new HashMap();

    public EscapingButton() throws HeadlessException {
        this("undefined");
    }

    public EscapingButton(String title) {
        super(title);
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
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(650, 30, 100, 30);
        drawingCanvasButton.setBounds(600, 70, 200, 30);
        resetButton.addActionListener(e -> {
            clear();
        });
    }


    public void addComponentsToContainer() {
        container.add(loginButton);
        container.add(resetButton);
        container.add(drawingCanvasButton);
        drawingCanvasButton.addActionListener(this);
    }

    private void clear() {
        loginButton.setBounds(50, 300, 100, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();

        if(eventSource == drawingCanvasButton){
            DrawingCanvas drawingCanvas = new DrawingCanvas();
            drawingCanvas.setVisible(true);
            drawingCanvas.setBounds(10,10,800, 800);
//            drawingCanvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            drawingCanvas.setResizable(false);
        }
    }
}