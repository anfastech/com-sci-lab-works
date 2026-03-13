// Using JFrame 

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JTextField t1, t2;
    private JButton b1, b2;

    public Login(String title) {
        super(title);

        JLabel l1 = new JLabel("username");
        JLabel l2 = new JLabel("password");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
  
        b1 = new JButton("ok");
        b2 = new JButton("cancel");

        setLayout(null);
        l1.setBounds(50, 70, 100, 25);
        t1.setBounds(160, 70, 100, 25);
        l2.setBounds(50, 110, 100, 25);
        t2.setBounds(160, 110, 100, 25);
        b1.setBounds(80, 160, 50, 25);
        b2.setBounds(130, 160, 50, 25);

        add(l1); add(t1); add(l2); add(t2); add(b1); add(b2);
    }

    public static void main(String[] args) {
            Login login = new Login("Login Page");
            login.setSize(300, 250);
            login.setVisible(true);
    }
}