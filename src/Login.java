import com.sun.jdi.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.Key;
import java.util.*;

public class Login extends JFrame {
    Container container = getContentPane();
    private JLabel usernameLabel = new JLabel("USERNAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton clearButton = new JButton("Clear");
    private ArrayList<String> userInfo = new ArrayList<>();
    private HashMap<String, String> usersMap = new HashMap();

    public Login() throws HeadlessException {
        this("undefined");
    }

    public Login(String title) {
        super(title);
        readData("./src/Users.csv");
        container.setLayout(null);
        container.setBackground(Color.gray);
        buildFrame();
        addComponentsToContainer();
    }

    protected void buildFrame() {
        this.setBounds(10, 10, 370, 600);
        this.setResizable(false);
        usernameLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        usernameField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        clearButton.setBounds(200, 300, 100, 30);

        loginButton.addActionListener(e -> {
            if (checkUser(usernameField.getText(), passwordField.getText())) {
                container.setBackground(Color.green);
            } else {
                container.setBackground(Color.red);
            }
        });

        clearButton.addActionListener(e -> {
            clear();
        });
    }

    public void addComponentsToContainer() {
        container.add(usernameLabel);
        container.add(passwordLabel);
        container.add(usernameField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(clearButton);
    }

    private void clear() {
        container.setBackground(Color.gray);
        usernameField.setText(null);
        passwordField.setText(null);
    }

    private void readData(String fileName) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNext()) {
            userInfo.add(sc.next());
        }
        sc.close();
        for (int i = 0; i < userInfo.size(); i += 2) {
            usersMap.put(userInfo.get(i), userInfo.get(i + 1));
        }
    }

    private boolean checkUser(String username, String password) {
        boolean ifCorrect = false;
        for (Map.Entry<String, String> entry1 : usersMap.entrySet()) {
            String correctUsername = entry1.getKey();
            String correctPassword = entry1.getValue();
            if (Objects.equals(username, correctUsername) && password.equals(correctPassword)) {
                ifCorrect = true;
            }
        }
        return ifCorrect;
    }
}