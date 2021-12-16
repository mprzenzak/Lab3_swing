import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    EscapingButton window = new EscapingButton();
                    window.setVisible(true);
                    window.setBounds(10,10,800, 800);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }
}
