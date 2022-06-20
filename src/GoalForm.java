import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GoalForm extends JFrame {
    JButton addNewGoal,showAll,goBack,mainMenu;
    GoalForm(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        addNewGoal = new JButton("ADD NEW GOAL");
        addNewGoal.setForeground(new Color(0xFFECECEC, true));
        addNewGoal.setBackground(new Color(0xFF313131, true));
        addNewGoal.setFont(new Font("Calibri",Font.BOLD,25));

        showAll = new JButton("SHOW ALL GOALS");
        showAll.setForeground(new Color(0xFFECECEC, true));
        showAll.setBackground(new Color(0xFF313131, true));
        showAll.setFont(new Font("Calibri",Font.BOLD,25));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));

        mainMenu = new JButton("MAIN MENU");
        mainMenu.setForeground(new Color(0xFF27C684, true));
        mainMenu.setBackground(new Color(0xFF313131, true));
        mainMenu.setFont(new Font("Calibri",Font.BOLD,25));

        add(addNewGoal);add(showAll);
        add(goBack);add(mainMenu);

        MyActionListener myActionListener = new MyActionListener(user);
        addNewGoal.addActionListener(myActionListener);
        showAll.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        mainMenu.addActionListener(myActionListener);

        setLayout(new GridLayout(4,1));
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADD NEW GOAL")) {
                dispose();
                AddNewGoal addNewGoal = new AddNewGoal(user);
            }else if (e.getActionCommand().equals("SHOW ALL GOALS")) {
                if (user.getGoal()!=null) {
                    JOptionPane.showMessageDialog(new JFrame(), user.getGoal().toString());
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"NO GOAL ADDED YET!");
                }
            }else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                Features features = new Features(user);
            } else if (e.getActionCommand().equals("MAIN MENU")) {
                dispose();
                Accounts accounts = new Accounts(user);
            }
        }
    }
}
class AddNewGoal extends JFrame{
    private boolean confirmCheck = false;

    public boolean isConfirmCheck() {
        return confirmCheck;
    }

    public void setConfirmCheck(boolean confirmCheck) {
        this.confirmCheck = confirmCheck;
    }

    JTextField goalNameInput,goalDescriptionInput,targetAmountInput,savedAmountInput,desiredDayInput,desiredMonthInput,desiredYearInput;
    JButton addButton,cancel;
    AddNewGoal(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel goalName = new JLabel("YOUR GOAL'S NAME");
        goalNameInput = new JTextField();
        JLabel forWhat = new JLabel("FOR WHAT (Home,Car,Travel)");
        goalDescriptionInput = new JTextField();
        JLabel targetAmount = new JLabel("TARGET AMOUNT NEEDED");
        targetAmountInput = new JTextField();
        JLabel savedAmount = new JLabel("AMOUNT YOU HAVE SAVED ALREADY");
        savedAmountInput = new JTextField();
        JLabel desireDay = new JLabel("ENTER ACCOMPLISH DAY");
        desiredDayInput = new JTextField();
        JLabel desireMonth = new JLabel("ENTER ACCOMPLISH MONTH");
        desiredMonthInput = new JTextField();
        JLabel desireYear = new JLabel("ENTER ACCOMPLISH YEAR");
        desiredYearInput = new JTextField();

        addButton = new JButton("ADD");
        addButton.setForeground(new Color(0xFF27C684, true));
        addButton.setBackground(new Color(0xFF313131, true));
        addButton.setFont(new Font("Calibri",Font.BOLD,25));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFF27C684, true));
        cancel.setBackground(new Color(0xFF313131, true));
        cancel.setFont(new Font("Calibri",Font.BOLD,25));

        add(goalName);add(goalNameInput);
        add(forWhat);add(goalDescriptionInput);
        add(targetAmount);add(targetAmountInput);
        add(savedAmount);add(savedAmountInput);
        add(desireDay);add(desiredDayInput);
        add(desireMonth);add(desiredMonthInput);
        add(desireYear);add(desiredYearInput);
        add(addButton);add(cancel);

        setLayout(new GridLayout(8,2,0,0));
        setVisible(true);

        MyActionListener myActionListener = new MyActionListener(user);
        addButton.addActionListener(myActionListener);
        cancel.addActionListener(myActionListener);
    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("ADD")) {
                String name = goalNameInput.getText();
                String description = goalDescriptionInput.getText();
                double targetAmount = Double.parseDouble(targetAmountInput.getText());
                double savedAmount = Double.parseDouble(savedAmountInput.getText());
                int day = Integer.parseInt(desiredDayInput.getText());
                int month = Integer.parseInt(desiredMonthInput.getText());
                int year = Integer.parseInt(desiredYearInput.getText());

                Date date = new Date(day, month, year);
                Goal goal = new Goal(name, description, targetAmount, savedAmount, date);
                FileOperations fileOperations = new FileOperations();
                ////I HAVE TO INITIALIZE THE COMPLETE_USER_INFORMATION
                ArrayList<User> goalList = fileOperations.readInFile();
                for (User i: goalList) {
                    if (i.getFirstName().equals(user.getFirstName())){
                        i.setGoal(goal);
                    }
                }

                ObjectOutputStream objectOutputStream = null;
                File file = new File("UsersData.ser");
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,false));
                    objectOutputStream.writeObject(goalList.get(0));

                    for (int i=1;i<goalList.size();i++){
                        fileOperations.writeInFile(goalList.get(i),true);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(new JFrame(),"GOAL ADDED SUCCESSFULLY");
                setConfirmCheck(true);
                NewUserWait newUserWait = new NewUserWait();
                new Timer().schedule(new TimerTask() {
                    public void run() {
                        // this should be final
                        newUserWait.dispose();
                        JOptionPane.showMessageDialog(new JFrame(),user.toString()+"\nACCOUNT CREATED SUCCESSFULLY");
                    }
                }, 5000);
                dispose();
                Credentials credentials = new Credentials();
            } else if (e.getActionCommand().equals("CANCEL")) {
                dispose();
                Features features = new Features(user);
            }
        }
    }
}