import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginPage extends JFrame {
    JTextField userNameInput;
    JPasswordField passwordNameInput;

    LoginPage() {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel userName = new JLabel("USERNAME:");
        userName.setFont(new Font("Calibri",Font.BOLD,30));
        add(userName);
        userNameInput = new JTextField();
        add(userNameInput);

        JLabel password = new JLabel("PASSWORD:");
        password.setFont(new Font("Calibri",Font.BOLD,30));
        add(password);
        passwordNameInput = new JPasswordField();
        add(passwordNameInput);

        JButton loginButton = new JButton("Login Now");
        loginButton.setForeground(new Color(0xFF27C684, true));
        loginButton.setBackground(new Color(0xFF313131, true));
        loginButton.setFont(new Font("Calibri",Font.BOLD,25));
        add(loginButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setForeground(new Color(0xFF27C684, true));
        exitButton.setBackground(new Color(0xFF313131, true));
        exitButton.setFont(new Font("Calibri",Font.BOLD,25));
        add(exitButton);

        MyActionListener myActionListener = new MyActionListener();
        loginButton.addActionListener(myActionListener);
        exitButton.addActionListener(myActionListener);
        setLayout(new GridLayout(3, 2, 0, 200));
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Login Now")) {
                FileOperations fileOperations = new FileOperations();
                ArrayList<User> myUserList = fileOperations.readInFile();
                User myUser = null;
                for (int i = 0; i < myUserList.size(); i++) {
                    if (myUserList.get(i).getFirstName().equals(userNameInput.getText()) &&
                            myUserList.get(i).getPassword().equals(passwordNameInput.getText())) {
                        myUser = myUserList.get(i);
                    }
                }
                if (myUser != null) {
                    dispose();
                    Accounts accounts = new Accounts(myUser);
                    //JOptionPane.showMessageDialog(new JFrame(), "GETTING LOGGED IN");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "WRONG VALIDATIONS");
                }
            }else if (e.getActionCommand().equals("Exit")){
                dispose();
                Credentials credentials = new Credentials();
            }
        }
    }
}