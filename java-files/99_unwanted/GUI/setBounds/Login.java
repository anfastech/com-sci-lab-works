// Using setBounds

import java.awt.*;

class Login extends Frame {
    TextField t1, t2;
    Button b1,b2;

    public Login(String title) {
        super(title);

        Label l1 = new Label("username");
        Label l2 = new Label("password");

        t1 = new TextField(10);
        t2 = new TextField(10);

        b1 = new Button("ok");
        b2 = new Button("cancel");

        setLayout(null);
        l1.setBounds(50,70,100,25);
        t1.setBounds(160,70,100,25);
        l2.setBounds(50,110,100,25);
        t2.setBounds(160,110,100,25);
        b1.setBounds(80,160,50,25);
        b2.setBounds(130,160,50,25);

        add(l1); add(t1); add(l2); add(t2); add(b1); add(b2);
    }

    public static void main(String arg[]) {

        Login login = new Login("Login page");
        login.setSize(400,200);
        login.setVisible(true);
    }

}