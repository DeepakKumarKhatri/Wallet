import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Admin extends JFrame {
    JButton admin, userButton,goBack;
    JPanel panel1,panel2,panel3;
    JLabel label;
    Admin(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        panel2 = new JPanel();
        label = new JLabel("LET'S GET BACK TO WORK!");
        label.setForeground(new Color(0xFF18D660, true));
        label.setFont(new Font("Serif",Font.PLAIN,40));
        getContentPane().add(panel2).setBackground(Color.WHITE);
        panel2.add(label);
        add(panel2,BorderLayout.NORTH);

        panel1 = new JPanel();
        admin = new JButton("SIGN-IN");
        admin.setForeground(new Color(0xFFFAF9F4, true));
        admin.setBackground(new Color(0xFF18D660, true));
        admin.setFont(new Font("Calibri",Font.BOLD,25));

        userButton = new JButton("SIGN-UP");
        userButton.setForeground(new Color(0xFFFAF9F4, true));
        userButton.setBackground(new Color(0xFF18D660, true));
        userButton.setFont(new Font("Calibri",Font.BOLD,25));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFFFAF9F4, true));
        goBack.setBackground(new Color(0xFF18D660, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));
        add(goBack);

        panel1.add(admin);panel1.add(userButton);panel1.add(goBack);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,BorderLayout.SOUTH);

        panel3 = new JPanel();
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("SignSignUpAdmin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel3.add(picLabel);
        getContentPane().add(panel3).setBackground(Color.WHITE);
        add(panel3,BorderLayout.CENTER);

        MyActionListener myActionListener = new MyActionListener();
        admin.addActionListener(myActionListener);
        userButton.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("SIGN-IN")) {
                dispose();
                AdminSignIn adminSignIn = new AdminSignIn();
            } else if (e.getActionCommand().equals("SIGN-UP")) {
                JOptionPane.showMessageDialog(new JFrame(),"ADMIN CAN'T SIGN UP");
            } else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                StartMenu startMenu = new StartMenu();
            }
        }
    }
}
class AdminSignIn extends JFrame{
    JTextField userNameInput;
    JPasswordField passwordNameInput;

    AdminSignIn() {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        JLabel userName = new JLabel("ADMIN USERNAME:");
        userName.setFont(new Font("Calibri",Font.BOLD,30));
        add(userName);
        userNameInput = new JTextField();
        add(userNameInput);

        JLabel password = new JLabel("ADMIN PASSWORD:");
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
                if (userNameInput.getText().equals("admin") && passwordNameInput.getText().equals("admin")){
                    dispose();
                    AdminOperations adminOperations = new AdminOperations();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "WRONG VALIDATIONS");
                }
            }else if (e.getActionCommand().equals("Exit")){
                dispose();
                StartMenu startMenu = new StartMenu();
            }
        }
    }
}
class AdminOperations extends JFrame{
    JButton showAllUsers,top3RichUsers,deleteUser,logout,exit;
    AdminOperations(){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Admin Operations");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        showAllUsers = new JButton("SHOW ALL USERS");
        showAllUsers.setForeground(new Color(0xFFECECEC, true));
        showAllUsers.setBackground(new Color(0xFF313131, true));
        showAllUsers.setFont(new Font("Calibri",Font.BOLD,25));

        top3RichUsers = new JButton("TOP 3 RICH USERS");
        top3RichUsers.setForeground(new Color(0xFFECECEC, true));
        top3RichUsers.setBackground(new Color(0xFF313131, true));
        top3RichUsers.setFont(new Font("Calibri",Font.BOLD,25));

        deleteUser = new JButton("DELETE A USER");
        deleteUser.setForeground(new Color(0xFFECECEC, true));
        deleteUser.setBackground(new Color(0xFF313131, true));
        deleteUser.setFont(new Font("Calibri",Font.BOLD,25));


        logout = new JButton("LOGOUT");
        logout.setForeground(new Color(0xFF27C684, true));
        logout.setBackground(new Color(0xFF313131, true));
        logout.setFont(new Font("Calibri",Font.BOLD,25));

        exit = new JButton("EXIT");
        exit.setForeground(new Color(0xFF27C684, true));
        exit.setBackground(new Color(0xFF313131, true));
        exit.setFont(new Font("Calibri",Font.BOLD,25));

        add(top3RichUsers);add(showAllUsers);add(deleteUser);add(logout);add(exit);
        setLayout(new GridLayout(5,1));

        MyActionListener myActionListener = new MyActionListener();
        showAllUsers.addActionListener(myActionListener);
        top3RichUsers.addActionListener(myActionListener);
        deleteUser.addActionListener(myActionListener);
        logout.addActionListener(myActionListener);
        exit.addActionListener(myActionListener);

        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("SHOW ALL USERS")) {

                FileOperations fileOperations = new FileOperations();
                ArrayList<User> showAllUsersList = fileOperations.readInFile();

                StringBuilder result = new StringBuilder("DETAILS OF ALL USERS IS AS FOLLOWS \n");
                for (User user : showAllUsersList) {
                    result.append(user.toString());
                }
                JOptionPane.showMessageDialog(new JFrame(), result.toString());

            }else if (e.getActionCommand().equals("TOP 3 RICH USERS")) {
                dispose();
                RichUsersInfo richUsersInfo = new RichUsersInfo();
            }else if (e.getActionCommand().equals("LOGOUT")) {
                dispose();
                StartMenu startMenu = new StartMenu();
            }else if (e.getActionCommand().equals("EXIT")) {
                System.exit(0);
            }else if (e.getActionCommand().equals("DELETE A USER")){
                dispose();
                DeleteTheUser deleteTheUser = new DeleteTheUser();
            }
        }
    }
}
class DeleteTheUser extends JFrame{
    JButton goBackButton,deleteButton;
    JTextField userNameInput;
    DeleteTheUser(){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("User Deletion");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel nameInputLabel = new JLabel("ENTER USER FIRST NAME");
        nameInputLabel.setForeground(new Color(0xFF2153A3, true));
        nameInputLabel.setFont(new Font("Serif",Font.PLAIN,20));
        userNameInput = new JTextField();

        deleteButton = new JButton("DELETE");
        deleteButton.setForeground(new Color(0xFFFAF9F4, true));
        deleteButton.setBackground(new Color(0xFF18D660, true));
        deleteButton.setFont(new Font("Calibri",Font.BOLD,25));


        goBackButton = new JButton("GO BACK");
        goBackButton.setForeground(new Color(0xFFFAF9F4, true));
        goBackButton.setBackground(new Color(0xFF18D660, true));
        goBackButton.setFont(new Font("Calibri",Font.BOLD,25));

        add(nameInputLabel);add(userNameInput);
        add(deleteButton);add(goBackButton);

        setLayout(new GridLayout(2,2,40,400));
        setVisible(true);

        MyActionListener myActionListener = new MyActionListener();
        goBackButton.addActionListener(myActionListener);
        deleteButton.addActionListener(myActionListener);
    }
    FileOperations fileOperations = new FileOperations();
    ArrayList<User> toCheck = fileOperations.readInFile();
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                AdminOperations adminOperations = new AdminOperations();
            }else if (e.getActionCommand().equals("DELETE")) {
                if (searchTheUser(userNameInput.getText())){
                    deleteTheUserMethod();
                    JOptionPane.showMessageDialog(new JFrame(),"USER DELETED SUCCESSFULLY!");
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"USER NOT FOUND!");
                }
            }
        }
    }
    public void deleteTheUserMethod(){
        for (int i = 0; i < toCheck.size(); i++) {
            if (toCheck.get(i).getFirstName().equals(userNameInput.getText())){
               toCheck.remove(i);
               break;
            }
        }

        ObjectOutputStream objectOutputStream = null;
        File file = new File("UsersData.ser");
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,false));
            objectOutputStream.writeObject(toCheck.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (toCheck.size()>0) {
            for (int i = 1; i < toCheck.size(); i++) {
                fileOperations.writeInFile(toCheck.get(i), true);
            }
        }
    }

    public boolean searchTheUser(String name){
        for (int i = 0; i < toCheck.size(); i++) {
            if (toCheck.get(i).getFirstName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
class RichUsersInfo extends JFrame{
    JLabel firstOne,secondOne,thirdOne;
    JLabel one,two,three;
    JButton goBackButton,exitButton;
    JPanel regularButtonsPanel,functionalButtonsPanel,messagePanel;
    RichUsersInfo(){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Top 3 Rich Users");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        messagePanel = new JPanel();
        JLabel message = new JLabel("TOP 3 RICH USERS");
        message.setForeground(new Color(0xFF547CEF, true));
        message.setFont(new Font("Serif",Font.PLAIN,50));
        getContentPane().add(messagePanel).setBackground(Color.WHITE);
        messagePanel.add(message);
        add(messagePanel,BorderLayout.NORTH);

        functionalButtonsPanel = new JPanel();
        one = new JLabel("1)");
        two = new JLabel("2)");
        three = new JLabel("3)");

        firstOne = new JLabel();
        setFirstOne(firstOne);
        firstOne.setForeground(new Color(0xFFBB4F2E, true));
        one.setFont(new Font("Calibri",Font.BOLD,30));
        firstOne.setFont(new Font("Calibri",Font.BOLD,30));
        functionalButtonsPanel.add(one);
        functionalButtonsPanel.add(firstOne);

        secondOne = new JLabel();
        setSecondOne(secondOne);
        secondOne.setForeground(new Color(0xFFBB4F2E, true));
        two.setFont(new Font("Calibri",Font.BOLD,30));
        secondOne.setFont(new Font("Calibri",Font.BOLD,30));
        functionalButtonsPanel.add(two);
        functionalButtonsPanel.add(secondOne);

        thirdOne = new JLabel();
        setThirdOne(thirdOne);
        thirdOne.setForeground(new Color(0xFFBB4F2E, true));
        three.setFont(new Font("Calibri",Font.BOLD,30));
        thirdOne.setFont(new Font("Calibri",Font.BOLD,30));
        functionalButtonsPanel.add(three);
        functionalButtonsPanel.add(thirdOne);

        functionalButtonsPanel.setLayout(new GridLayout(3,2,0,0));
        getContentPane().add(functionalButtonsPanel).setBackground(Color.WHITE);
        add(functionalButtonsPanel,BorderLayout.CENTER);

        regularButtonsPanel = new JPanel();

        goBackButton = new JButton("GO BACK");
        goBackButton.setForeground(new Color(0xFFFAF9F4, true));
        goBackButton.setBackground(new Color(0xFF18D660, true));
        goBackButton.setFont(new Font("Calibri",Font.BOLD,25));

        exitButton = new JButton("EXIT");
        exitButton.setForeground(new Color(0xFFFAF9F4, true));
        exitButton.setBackground(new Color(0xFF18D660, true));
        exitButton.setFont(new Font("Calibri",Font.BOLD,25));

        regularButtonsPanel.add(goBackButton);
        regularButtonsPanel.add(exitButton);
        regularButtonsPanel.setLayout(new GridLayout(1,2));
        add(regularButtonsPanel,BorderLayout.SOUTH);

        MyActionListener myActionListener = new MyActionListener();
        goBackButton.addActionListener(myActionListener);
        exitButton.addActionListener(myActionListener);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                AdminOperations adminOperations = new AdminOperations();
            }else if (e.getActionCommand().equals("EXIT")) {
                System.exit(0);
            }
        }
    }

    FileOperations fileOperations = new FileOperations();
    ArrayList<User> richUsersList = fileOperations.readInFile();

    String firstUserIs = "";
    String firstUserName = richUsersList.get(0).getFirstName();
    double firstUserBalance = richUsersList.get(0).getCashBalance();
    public String firstUser () {
        for (int i = 1; i < richUsersList.size(); i++) {
            if (richUsersList.get(i).getCashBalance() > richUsersList.get(i - 1).getCashBalance()) {
                firstUserIs = richUsersList.get(i).getFirstName() + " " + richUsersList.get(i).getLastName();
                firstUserName = richUsersList.get(i).getFirstName();
                firstUserBalance = richUsersList.get(1).getCashBalance();
            }
        }
        return firstUserIs;
    }

    String secondUserIs = richUsersList.get(0).getFirstName() + " " + richUsersList.get(0).getLastName();
    String secondUserName = richUsersList.get(0).getFirstName();
    double secondUserBalance = richUsersList.get(0).getCashBalance();
    public String secondUser () {
        for (int i = 1; i < richUsersList.size(); i++) {
            if ((richUsersList.get(i).getCashBalance() > richUsersList.get(i - 1).getCashBalance()) && (firstUserName != richUsersList.get(i).getFirstName())) {
                secondUserIs = richUsersList.get(i).getFirstName() + " " + richUsersList.get(i).getLastName();
                secondUserName = richUsersList.get(i).getFirstName();
                secondUserBalance = richUsersList.get(i).getCashBalance();
            }
        }
        return secondUserIs;
    }


    String thirdUserIs = richUsersList.get(0).getFirstName() + " " + richUsersList.get(0).getLastName();
    String thirdUserName = richUsersList.get(0).getFirstName();

    public String thirdUser () {
        for (int i = 1; i < richUsersList.size(); i++) {
            if (richUsersList.get(i).getCashBalance() < (firstUserBalance) && richUsersList.get(i).getCashBalance() <(secondUserBalance) && (secondUserName != richUsersList.get(i).getFirstName()) && (firstUserName != richUsersList.get(i).getFirstName())) {
                thirdUserIs = richUsersList.get(i).getFirstName() + " " + richUsersList.get(i).getLastName();
                thirdUserName = richUsersList.get(i).getFirstName();
            }
        }
        return thirdUserIs;
    }
    public void setFirstOne (JLabel firstOne){
        firstOne.setText(firstUser());
        firstOne.setVisible(true);
    }

    public void setSecondOne (JLabel secondOne){
        secondOne.setText(secondUser());
        secondOne.setVisible(true);
    }

    public void setThirdOne (JLabel thirdOne){
        thirdOne.setText(thirdUser());
        thirdOne.setVisible(true);
    }
}
