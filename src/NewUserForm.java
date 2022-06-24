import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewUserForm extends JFrame {

    JTextField firstNameInput;
    JTextField lastNameInput;
    JTextField phoneInput;
    JTextField cnicInput;
    JTextField cashBalanceInput;
    JTextField emailInput;
    JTextField passwordInput;

    NewUserForm(){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel firstName = new JLabel("ENTER YOUR FIRST NAME");
        add(firstName);
        firstNameInput = new JTextField();
        add(firstNameInput);

        JLabel lastName = new JLabel("ENTER YOUR LAST NAME");
        add(lastName);
        lastNameInput = new JTextField();
        add(lastNameInput);

        JLabel phone = new JLabel("ENTER YOUR PHONE");
        add(phone);
        phoneInput = new JTextField();
        add(phoneInput);

        JLabel cnic = new JLabel("ENTER YOUR CNIC");
        add(cnic);
        cnicInput = new JTextField();
        add(cnicInput);

        JLabel cash_balance = new JLabel("ENTER YOUR CASH BALANCE");
        add(cash_balance);
        cashBalanceInput = new JTextField();
        add(cashBalanceInput);

        JLabel email = new JLabel("ENTER YOUR EMAIL");
        add(email);
        emailInput = new JTextField();
        add(emailInput);

        JLabel password = new JLabel("ENTER YOUR PASSWORD");
        add(password);
        passwordInput = new JTextField();
        add(passwordInput);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setForeground(new Color(0xFF27C684, true));
        submitButton.setBackground(new Color(0xFF313131, true));
        submitButton.setFont(new Font("Calibri",Font.BOLD,25));
        add(submitButton);

        JButton homeButton = new JButton("HOME");
        homeButton.setForeground(new Color(0xFF27C684, true));
        homeButton.setBackground(new Color(0xFF313131, true));
        homeButton.setFont(new Font("Calibri",Font.BOLD,25));
        add(homeButton);

        setLayout(new GridLayout(8,2,20,20));
        setVisible(true);

        MyActionListener myActionListener = new MyActionListener();
        submitButton.addActionListener(myActionListener);
        homeButton.addActionListener(myActionListener);
    }
    FileOperations fileOperations = new FileOperations();
    ArrayList<User>myTemp = fileOperations.readInFile();
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getActionCommand().equals("SUBMIT")){
                String firstName = firstNameInput.getText();
                String lastName = lastNameInput.getText();
                String phone = phoneInput.getText();
                String cnic = cnicInput.getText();
                double cashBalance = Double.parseDouble(cashBalanceInput.getText());
                String email = emailInput.getText();
                String password = passwordInput.getText();

                if (phone.length()==11 && cnic.length()==13 && cashBalance>=0
                && email.contains("@gmail.com") ||email.contains("@yahoo.com") || email.contains("@outlook.com")
                && password.length()>=6){
                    User user = new User(firstName, lastName, phone, cnic, cashBalance, email, password);
                    fileOperations.writeInFile(user, true);
                    dispose();
                    boolean doubleCheck = new AddNewGoal(user).isConfirmCheck();
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"INVALID CREDENTIALS");
                }
            }else if (e.getActionCommand().equals("HOME")){
                dispose();
                Credentials credentials = new Credentials();
            }
        }
    }
}
class NewUserWait extends JFrame {
    NewUserWait(){
        setSize(600,600);
        setLocation(400,300);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2,1));
        JPanel p = new JPanel();
        p.add(new JLabel(new ImageIcon("mainTheme.gif")));
        getContentPane().add(p);
        getContentPane().add(p).setBackground(new Color(0xFF27C677, true));
        JPanel p2 = new JPanel();
        p2.add(new JLabel(new ImageIcon("ajax.gif")));
        getContentPane().add(p2);
        getContentPane().add(p2).setBackground(new Color(0xFF27C677, true));
        setVisible(true);
    }
}
