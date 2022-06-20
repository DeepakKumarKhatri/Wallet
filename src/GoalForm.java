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
    JButton addNewGoal,showAll,goBack,mainMenu,suggestionsFromWallet,unlistMyGoal;
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

        suggestionsFromWallet = new JButton("SUGGESTION FOR YOU FROM WALLET");
        suggestionsFromWallet.setForeground(new Color(0xFFECECEC, true));
        suggestionsFromWallet.setBackground(new Color(0xFF313131, true));
        suggestionsFromWallet.setFont(new Font("Calibri",Font.BOLD,22));

        unlistMyGoal = new JButton("GOAL COMPLETED");
        unlistMyGoal.setForeground(new Color(0xFFECECEC, true));
        unlistMyGoal.setBackground(new Color(0xFF313131, true));
        unlistMyGoal.setFont(new Font("Calibri",Font.BOLD,25));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));

        mainMenu = new JButton("MAIN MENU");
        mainMenu.setForeground(new Color(0xFF27C684, true));
        mainMenu.setBackground(new Color(0xFF313131, true));
        mainMenu.setFont(new Font("Calibri",Font.BOLD,25));

        add(addNewGoal);add(suggestionsFromWallet);add(unlistMyGoal);
        add(showAll);add(goBack);add(mainMenu);

        MyActionListener myActionListener = new MyActionListener(user);
        addNewGoal.addActionListener(myActionListener);
        showAll.addActionListener(myActionListener);
        suggestionsFromWallet.addActionListener(myActionListener);
        unlistMyGoal.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        mainMenu.addActionListener(myActionListener);

        setLayout(new GridLayout(6,1));
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
                new AddNewGoal(user);
            }else if (e.getActionCommand().equals("SHOW ALL GOALS")) {
                if (user.getGoal()!=null) {
                    if (user.getGoal().toString().equals("[]")){
                        JOptionPane.showMessageDialog(new JFrame(),"NO GOAL ADDED YET!");
                    }else {
                        JOptionPane.showMessageDialog(new JFrame(), user.getGoal().toString());
                    }
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"NO GOAL ADDED YET!");
                }
            }else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new Features(user);
            } else if (e.getActionCommand().equals("MAIN MENU")) {
                dispose();
                new Accounts(user);
            }else if (e.getActionCommand().equals("SUGGESTION FOR YOU FROM WALLET")) {
                dispose();
                if (user.getGoal() != null) {
                    new SuggestionsFromWalletForGOAL(user);
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"PLEASE ADD GOALS TO GET SUGGESTIONS FROM WALLET");
                }
            }else if (e.getActionCommand().equals("GOAL COMPLETED")) {
                dispose();
                new GoalCompleted(user);
            }
        }
    }
}

class GoalCompleted extends JFrame {
    JTextField goalIdInput;
    JButton goBack, deleteNow;

    GoalCompleted(User user) {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Goal Un-listing");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel goalId = new JLabel("ENTER GOAL ID TO UN-LIST");
        goalIdInput = new JTextField();

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri", Font.BOLD, 25));

        deleteNow = new JButton("UN-LIST");
        deleteNow.setForeground(new Color(0xFF27C684, true));
        deleteNow.setBackground(new Color(0xFF313131, true));
        deleteNow.setFont(new Font("Calibri", Font.BOLD, 25));

        add(goalId);add(goalIdInput);add(deleteNow);add(goBack);

        MyActionListener myActionListener = new MyActionListener(user);
        deleteNow.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);

        setLayout(new GridLayout(2, 2, 40, 400));
        setVisible(true);
    }
    FileOperations fileOperations = new FileOperations();
    ArrayList<User> userArrayList = fileOperations.readInFile();

    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user) {
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("UN-LIST")) {
                if (searchTheGoalId(user.getGoal())){
                    deleteTheGoal();
                    JOptionPane.showMessageDialog(new JFrame(),"GOAL UNLISTED SUCCESSFULLY!");
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"GOAL ID NOT FOUND!");
                }
            }else if (e.getActionCommand().equals("GO BACK")){
                dispose();
                Features features = new Features(user);
            }
        }

        public void deleteTheGoal(){
            for (int i = 0; i < userArrayList.size(); i++) {
                if (userArrayList.get(i).getGoal().get(i).getGoalId() == Integer.parseInt(goalIdInput.getText())){
                    userArrayList.get(i).getGoal().remove(i);
                    break;
                }
            }
            if (userArrayList.size()>0) {
                ObjectOutputStream objectOutputStream = null;
                File file = new File("UsersData.ser");
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, false));
                    objectOutputStream.writeObject(userArrayList.get(0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (int i = 1; i < userArrayList.size(); i++) {
                    fileOperations.writeInFile(userArrayList.get(i), true);
                }
            }else {
                JOptionPane.showMessageDialog(new JFrame(),"GOAL LIST IS NOW EMPTY");
            }
        }
        public boolean searchTheGoalId(ArrayList<Goal> list){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getGoalId() == Integer.parseInt(goalIdInput.getText())){
                    return true;
                }
            }
            return false;
        }
    }
}

class SuggestionsFromWalletForGOAL extends JFrame{
    JButton okayButton,mainMenu;
    JPanel p1,p2,superierPanel;
    SuggestionsFromWalletForGOAL(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Suggestion From Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        // getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        superierPanel = new JPanel();
        JLabel intro = new JLabel("YOU FINANCE DECIDER - WALLET");
        intro.setForeground(new Color(0xFF2153A3, true));
        intro.setFont(new Font("Calibri",Font.BOLD,30));
        getContentPane().add(superierPanel).setBackground(Color.WHITE);
        superierPanel.add(intro);
        add(superierPanel,BorderLayout.NORTH);

        p1 = new JPanel();
        JLabel message1 = new JLabel("FROM YOUR VERY FIRST GOAL");
        message1.setForeground(new Color(0xFF2153A3, true));
        message1.setFont(new Font("Serif",Font.BOLD,16));
        p1.add(message1);

        JLabel goalName = new JLabel(user.getGoal().get(0).getGoalName());
        goalName.setForeground(new Color(0xFF313131, true));
        goalName.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(goalName);

        JLabel message2 = new JLabel("ARRANGE THIS AMOUNT");
        message2.setForeground(new Color(0xFF2153A3, true));
        message2.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(message2);

        JLabel message3 = new JLabel(Double.toString(user.getGoal().get(0).getTargetAmount()-user.getGoal().get(0).getSavedAlready()));
        message3.setForeground(new Color(0xFF313131, true));
        message3.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(message3);
        p1.setLayout(new GridLayout(2,2));
        //  getContentPane().add(p1).setBackground(Color.WHITE);
        add(p1,BorderLayout.CENTER);

        p2 = new JPanel();
        okayButton = new JButton("OKAY");
        okayButton.setForeground(new Color(0xFF27C684, true));
        okayButton.setBackground(new Color(0xFF313131, true));
        okayButton.setFont(new Font("Calibri",Font.BOLD,25));
        p2.add(okayButton);

        mainMenu = new JButton("MAIN MENU");
        mainMenu.setForeground(new Color(0xFF27C684, true));
        mainMenu.setBackground(new Color(0xFF313131, true));
        mainMenu.setFont(new Font("Calibri",Font.BOLD,25));
        p2.add(mainMenu);
        // getContentPane().add(p2).setBackground(Color.WHITE);
        add(p2,BorderLayout.SOUTH);

        MyActionListener myActionListener = new MyActionListener(user);
        okayButton.addActionListener(myActionListener);
        mainMenu.addActionListener(myActionListener);

        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user) {
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("OKAY")) {
                dispose();
                Features features = new Features(user);
            }else  if (e.getActionCommand().equals("MAIN MENU")) {
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

    JTextField goalNameInput,goalDescriptionInput,targetAmountInput,savedAmountInput,desiredDayInput,desiredMonthInput,desiredYearInput,goalIdInput;
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
        JLabel goalId = new JLabel("ENTER GOAL ID");
        goalIdInput = new JTextField();

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
        add(goalId);add(goalIdInput);
        add(addButton);add(cancel);

        setLayout(new GridLayout(9,2,0,0));
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
                int goalId = Integer.parseInt(goalIdInput.getText());

                Date date = new Date(day, month, year);
                Goal goal = new Goal(name, description, targetAmount, savedAmount, date,goalId);
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