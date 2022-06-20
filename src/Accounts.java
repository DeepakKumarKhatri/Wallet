import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Accounts extends JFrame {
    JPanel titlePanel,cashPanel,dayGoalPanel,buttonsPanel;
    JButton performMoreAction,adjustBalance,logout;
    public JLabel myCashIsLabel;
    Accounts(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4,1,0,0));

        titlePanel = new JPanel();
        JLabel intro = new JLabel("LIST OF OPERATIONS");
        intro.setFont(new Font("Calibri",Font.BOLD,30));
        intro.setForeground(new Color(0xFF2153A3, true));
        titlePanel.add(intro);
        titlePanel.setLayout(new GridLayout());
        add(titlePanel);
        getContentPane().add(titlePanel).setBackground(new Color(0xFFFAF9F4, true));

        cashPanel = new JPanel();
        JLabel cashLabel = new JLabel("YOUR CASH IS");
        cashLabel.setFont(new Font("Calibri",Font.BOLD,25));
        cashLabel.setForeground(Color.BLACK);
        cashPanel.add(cashLabel);

        myCashIsLabel = new JLabel();
        myCashIsLabel.setText(String.valueOf(user.getCashBalance()));
        myCashIsLabel.setFont(new Font("Calibri",Font.BOLD,30));
        myCashIsLabel.setForeground(new Color(0xFF8D2B6C, true));
        myCashIsLabel.setVisible(true);
        cashPanel.add(myCashIsLabel);

        cashPanel.setLayout(new GridLayout(1,2,0,0));
        add(cashPanel);
        getContentPane().add(cashPanel).setBackground(new Color(0xFFFAF9F4, true));

        dayGoalPanel = new JPanel();
        JLabel dayGoalLabel = new JLabel("GOAL REMINDER!!");
        dayGoalLabel.setForeground(Color.RED);
        dayGoalLabel.setFont(new Font("Calibri",Font.BOLD,40));
        dayGoalPanel.add(dayGoalLabel);

        JLabel dayGoalTextField = new JLabel();
        dayGoalTextField.setText(user.getGoal().get(0).getGoalDescription());
        dayGoalTextField.setForeground(new Color(0xFF8D712B, true));
        dayGoalTextField.setFont(new Font("Calibri",Font.BOLD,30));

        dayGoalPanel.add(dayGoalTextField);

        dayGoalPanel.setLayout(new GridLayout(2,1,0,0));
        add(dayGoalPanel);
        getContentPane().add(dayGoalPanel).setBackground(new Color(0xFFFAF9F4, true));

        buttonsPanel = new JPanel();
        adjustBalance = new JButton("ADJUST BALANCE");
        adjustBalance.setForeground(new Color(0xFF27C684, true));
        adjustBalance.setBackground(new Color(0xFF313131, true));
        adjustBalance.setFont(new Font("Calibri",Font.BOLD,22));
        buttonsPanel.add(adjustBalance);

        performMoreAction = new JButton("PERFORM MORE ACTIONS");
        performMoreAction.setForeground(new Color(0xFF27C684, true));
        performMoreAction.setBackground(new Color(0xFF313131, true));
        performMoreAction.setFont(new Font("Calibri",Font.BOLD,15));
        buttonsPanel.add(performMoreAction);

        logout = new JButton("LOGOUT");
        logout.setForeground(new Color(0xFF27C684, true));
        logout.setBackground(new Color(0xFF313131, true));
        logout.setFont(new Font("Calibri",Font.BOLD,20));
        buttonsPanel.add(logout);

        buttonsPanel.setLayout(new GridLayout(1,3));
        add(buttonsPanel);
        getContentPane().add(buttonsPanel).setBackground(new Color(0xFFFAF9F4, true));
        setVisible(true);

        MyActionListener myActionListener = new MyActionListener(user);
        adjustBalance.addActionListener(myActionListener);
        performMoreAction.addActionListener(myActionListener);
        logout.addActionListener(myActionListener);

    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADJUST BALANCE")) {
                dispose();
                AdjustBalance adjustBalance = new AdjustBalance(user);
            }else if (e.getActionCommand().equals("PERFORM MORE ACTIONS")) {
                dispose();
                Features features = new Features(user);
            }else if (e.getActionCommand().equals("LOGOUT")) {
                dispose();
                StartMenu startMenu = new StartMenu();
            }
        }
    }
}
class AdjustBalance extends JFrame{
    JTextField newCashInput;
    JButton changeNow,goBack;
    AdjustBalance(User user){
        setSize(600,600);
        setLocation(400,300);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0xFFFAF9F4, true));

        JLabel newCashLabel = new JLabel("ENTER NEW BALANCE");
        newCashLabel.setFont(new Font("Calibri",Font.BOLD,25));
        add(newCashLabel);
        newCashInput = new JTextField();
        add(newCashInput);

        changeNow = new JButton("CHANGE NOW");
        changeNow.setForeground(new Color(0xFF27C684, true));
        changeNow.setBackground(new Color(0xFF313131, true));
        changeNow.setFont(new Font("Calibri",Font.BOLD,25));
        add(changeNow);

        goBack = new JButton("CANCEL");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));
        add(goBack);

        MyActionListener myActionListener = new MyActionListener(user);
        changeNow.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);

        setLayout(new GridLayout(2,2,40,400));
        setVisible(true);
    }

    FileOperations fileOperations = new FileOperations();
    ArrayList<User> userArrayList = fileOperations.readInFile();

    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("CHANGE NOW")) {
                double myNewCash = Double.parseDouble(newCashInput.getText());
                updateTheCash(myNewCash);
                JOptionPane.showMessageDialog(new JFrame(),"BALANCE UPDATED SUCCESSFULLY");

            }else if (e.getActionCommand().equals("CANCEL")) {
                dispose();
                Accounts accounts = new Accounts(user);
            }
        }

        public void updateTheCash(double myNewCash){
            for (int i = 0; i < userArrayList.size(); i++) {
                if (userArrayList.get(i).getFirstName().equals(user.getFirstName())) {
                    userArrayList.get(i).setCashBalance(myNewCash);
                }
            }

            ObjectOutputStream objectOutputStream = null;
            File file = new File("UsersData.ser");
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,false));
                objectOutputStream.writeObject(userArrayList.get(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i=1;i<userArrayList.size();i++){
                fileOperations.writeInFile(userArrayList.get(i),true);
            }
        }
    }
}
