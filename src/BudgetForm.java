import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BudgetForm extends JFrame {
    JButton periodic,oneTime,goBack,mainMenu,showMyBudget,suggestionsFromWallet,unlistMyBudget;
    BudgetForm(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        showMyBudget = new JButton("SHOW MY BUDGET");
        showMyBudget.setForeground(new Color(0xFFECECEC, true));
        showMyBudget.setBackground(new Color(0xFF313131, true));
        showMyBudget.setFont(new Font("Calibri",Font.BOLD,25));

        periodic = new JButton("PERIODIC");
        periodic.setForeground(new Color(0xFFECECEC, true));
        periodic.setBackground(new Color(0xFF313131, true));
        periodic.setFont(new Font("Calibri",Font.BOLD,25));

        oneTime = new JButton("ONE TIME");
        oneTime.setForeground(new Color(0xFFECECEC, true));
        oneTime.setBackground(new Color(0xFF313131, true));
        oneTime.setFont(new Font("Calibri",Font.BOLD,25));

        suggestionsFromWallet = new JButton("SUGGESTION FOR YOU FROM WALLET");
        suggestionsFromWallet.setForeground(new Color(0xFFECECEC, true));
        suggestionsFromWallet.setBackground(new Color(0xFF313131, true));
        suggestionsFromWallet.setFont(new Font("Calibri",Font.BOLD,22));

        unlistMyBudget = new JButton("BUDGET COMPLETED");
        unlistMyBudget.setForeground(new Color(0xFFECECEC, true));
        unlistMyBudget.setBackground(new Color(0xFF313131, true));
        unlistMyBudget.setFont(new Font("Calibri",Font.BOLD,25));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));

        mainMenu = new JButton("MAIN MENU");
        mainMenu.setForeground(new Color(0xFF27C684, true));
        mainMenu.setBackground(new Color(0xFF313131, true));
        mainMenu.setFont(new Font("Calibri",Font.BOLD,25));

        add(showMyBudget);add(periodic);add(oneTime);add(unlistMyBudget);
        add(suggestionsFromWallet);add(goBack);add(mainMenu);

        setLayout(new GridLayout(7,1));
        setVisible(true);

        MyActionListener myActionListener = new MyActionListener(user);
        showMyBudget.addActionListener(myActionListener);
        periodic.addActionListener(myActionListener);
        oneTime.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        mainMenu.addActionListener(myActionListener);
        suggestionsFromWallet.addActionListener(myActionListener);
        unlistMyBudget.addActionListener(myActionListener);
    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("PERIODIC")) {
                dispose();
                Periodic periodic = new Periodic(user);
            } else if (e.getActionCommand().equals("ONE TIME")) {
                dispose();
                OneTime oneTime = new OneTime(user);
            } else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                Features features = new Features(user);
            } else if (e.getActionCommand().equals("MAIN MENU")) {
                dispose();
                Accounts accounts = new Accounts(user);
            } else if (e.getActionCommand().equals("SHOW MY BUDGET")) {
                if (user.getBudget()!=null) {
                    if (user.getBudget().toString().equals("[]")){
                        JOptionPane.showMessageDialog(new JFrame(),"NO BUDGET ADDED YET!");
                    }else {
                        JOptionPane.showMessageDialog(new JFrame(), user.getBudget().toString());
                    }
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"NO BUDGET ADDED YET!");
                }
            }else if (e.getActionCommand().equals("SUGGESTION FOR YOU FROM WALLET")) {
                dispose();
                if (user.getBudget() != null) {
                    if (user.getBudget().size()==0){
                        JOptionPane.showMessageDialog(new JFrame(),"PLEASE ADD BUDGET TO GET SUGGESTIONS FROM WALLET");
                        new BudgetForm(user);
                    }else {
                        SuggestionsFromWallet suggestionsFromWallet = new SuggestionsFromWallet(user);
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"PLEASE ADD BUDGET TO GET SUGGESTIONS FROM WALLET");
                    new BudgetForm(user);
                }
            }else if (e.getActionCommand().equals("BUDGET COMPLETED")) {
                dispose();
                BudgetCompleted budgetCompleted = new BudgetCompleted(user);
            }
        }
    }
}
class BudgetCompleted extends JFrame {
    JTextField budgetIdInput;
    JButton goBack, deleteNow;

    BudgetCompleted(User user) {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Budget Un-listing");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel budgetId = new JLabel("ENTER BUDGET ID TO UN-LIST");
        budgetIdInput = new JTextField();

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri", Font.BOLD, 25));

        deleteNow = new JButton("UN-LIST");
        deleteNow.setForeground(new Color(0xFF27C684, true));
        deleteNow.setBackground(new Color(0xFF313131, true));
        deleteNow.setFont(new Font("Calibri", Font.BOLD, 25));

        add(budgetId);add(budgetIdInput);add(deleteNow);add(goBack);

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
                if (searchTheBudgetId(user.getBudget())){
                    deleteTheBudgetMethod();
                    JOptionPane.showMessageDialog(new JFrame(),"BUDGET UNLISTED SUCCESSFULLY!");
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"BUDGET ID NOT FOUND!");
                }
            }else if (e.getActionCommand().equals("GO BACK")){
                dispose();
                Features features = new Features(user);
            }
        }

        public void deleteTheBudgetMethod(){
            for (int i = 0; i < userArrayList.size(); i++) {
                if (userArrayList.get(i).getBudget().get(i).getBudgetId() == Integer.parseInt(budgetIdInput.getText())){
                    user.getBudget().remove(i);
                    userArrayList.get(i).getBudget().remove(i);
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
                JOptionPane.showMessageDialog(new JFrame(),"BUDGET LIST IS NOW EMPTY");
            }
        }
        public boolean searchTheBudgetId(ArrayList<Budget> list){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getBudgetId() == Integer.parseInt(budgetIdInput.getText())){
                    return true;
                }
            }
            return false;
        }
    }
}

class SuggestionsFromWallet extends JFrame{
    JButton okayButton,mainMenu;
    JPanel p1,p2,superierPanel;
    SuggestionsFromWallet(User user){
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
        JLabel message1 = new JLabel("FROM YOUR VERY FIRST BUDGET");
        message1.setForeground(new Color(0xFF2153A3, true));
        message1.setFont(new Font("Serif",Font.BOLD,16));
        p1.add(message1);

        JLabel budgetName = new JLabel(user.getBudget().get(0).getBudgetName());
        budgetName.setForeground(new Color(0xFF313131, true));
        budgetName.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(budgetName);

        JLabel message2 = new JLabel("ARRANGE THIS AMOUNT");
        message2.setForeground(new Color(0xFF2153A3, true));
        message2.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(message2);

        JLabel message3 = new JLabel(Double.toString(user.getCashBalance()-user.getBudget().get(0).getAmount()));
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
                new BudgetForm(user);
            }else  if (e.getActionCommand().equals("MAIN MENU")) {
                dispose();
                Accounts accounts = new Accounts(user);
            }
        }
    }
}
class Periodic extends JFrame{
    JTextField nameInput,periodInput,amountInput,currencyInput,priorityInput,budgetIdInput;
    JButton addButton,cancel;
    Periodic(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("New Budget");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel name = new JLabel("NAME OF BUDGET");
        nameInput = new JTextField();
        JLabel period = new JLabel("PERIOD (Week,Month,Year)");
        periodInput = new JTextField();
        JLabel amount = new JLabel("AMOUNT");
        amountInput = new JTextField();
        JLabel currency = new JLabel("CURRENCY");
        currencyInput = new JTextField();
        JLabel priority = new JLabel("PRIORITY (1,2,3)");
        priorityInput = new JTextField();
        JLabel budgetId = new JLabel("BUDGET ID");
        budgetIdInput = new JTextField();

        addButton = new JButton("ADD");
        addButton.setForeground(new Color(0xFF27C684, true));
        addButton.setBackground(new Color(0xFF313131, true));
        addButton.setFont(new Font("Calibri",Font.BOLD,25));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFF27C684, true));
        cancel.setBackground(new Color(0xFF313131, true));
        cancel.setFont(new Font("Calibri",Font.BOLD,25));

        add(name);add(nameInput);
        add(period);add(periodInput);
        add(amount);add(amountInput);
        add(currency);add(currencyInput);
        add(priority);add(priorityInput);
        add(budgetId);add(budgetIdInput);
        add(addButton);add(cancel);

        setLayout(new GridLayout(7,2,10,10));
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
                String name = nameInput.getText();
                String period = periodInput.getText();
                double amount = Double.parseDouble(amountInput.getText());
                String currency = currencyInput.getText();
                int priority = Integer.parseInt(priorityInput.getText());
                int budgetIdConverson = Integer.parseInt(budgetIdInput.getText());

                FileOperations fileOperations = new FileOperations();
                Budget periodicBudget = new Budget(name,period,amount,currency,priority,budgetIdConverson);
                //I HAVE TO INITIALIZE THE COMPLETE_USER_INFORMATION
                ArrayList<User>budgetList = fileOperations.readInFile();
                for (User i: budgetList) {
                    if (i.getFirstName().equals(user.getFirstName())){
                        i.setBudget(periodicBudget);
                    }
                }

                ObjectOutputStream objectOutputStream = null;
                File file = new File("UsersData.ser");
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,false));
                    objectOutputStream.writeObject(budgetList.get(0));

                    for (int i=1;i<budgetList.size();i++){
                        fileOperations.writeInFile(budgetList.get(i),true);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(new JFrame(),"BUDGET ADDED SUCCESSFULLY");

            }else if (e.getActionCommand().equals("CANCEL")){
                dispose();
                new BudgetForm(user);
            }
        }
    }
}
class OneTime extends JFrame{
    JTextField nameInput,periodInput,amountInput,currencyInput,priorityInput,budgetIdInput;
    JButton addButton,cancel;
    OneTime(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("New Budget");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel name = new JLabel("NAME OF BUDGET");
        nameInput = new JTextField();
        JLabel period = new JLabel("PERIOD (Week,Month,Year)");
        periodInput = new JTextField();
        JLabel amount = new JLabel("AMOUNT");
        amountInput = new JTextField();
        JLabel currency = new JLabel("CURRENCY");
        currencyInput = new JTextField();
        JLabel priority = new JLabel("PRIORITY (1,2,3)");
        priorityInput = new JTextField();
        JLabel budgetId = new JLabel("BUDGET ID");
        budgetIdInput = new JTextField();

        addButton = new JButton("ADD");
        addButton.setForeground(new Color(0xFF27C684, true));
        addButton.setBackground(new Color(0xFF313131, true));
        addButton.setFont(new Font("Calibri",Font.BOLD,25));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFF27C684, true));
        cancel.setBackground(new Color(0xFF313131, true));
        cancel.setFont(new Font("Calibri",Font.BOLD,25));

        add(name);add(nameInput);
        add(period);add(periodInput);
        add(amount);add(amountInput);
        add(currency);add(currencyInput);
        add(priority);add(priorityInput);
        add(budgetId);add(budgetIdInput);
        add(addButton);add(cancel);

        setLayout(new GridLayout(7,2,10,10));
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
                String name = nameInput.getText();
                String period = periodInput.getText();
                double amount = Double.parseDouble(amountInput.getText());
                String currency = currencyInput.getText();
                int priority = Integer.parseInt(priorityInput.getText());
                int budgetIdConverson = Integer.parseInt(budgetIdInput.getText());

                FileOperations fileOperations = new FileOperations();
                Budget oneTime_Budget = new Budget(name,period,amount,currency,priority,budgetIdConverson);
                //I HAVE TO INITIALIZE THE COMPLETE_USER_INFORMATION
                ArrayList<User>budgetList = fileOperations.readInFile();
                for (User i: budgetList) {
                    if (i.getFirstName().equals(user.getFirstName())){
                        i.setBudget(oneTime_Budget);
                    }
                }
                ObjectOutputStream objectOutputStream = null;
                File file = new File("UsersData.ser");
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,false));
                    objectOutputStream.writeObject(budgetList.get(0));

                    for (int i=1;i<budgetList.size();i++){
                        fileOperations.writeInFile(budgetList.get(i),true);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(new JFrame(),"BUDGET ADDED SUCCESSFULLY");

            }else if (e.getActionCommand().equals("CANCEL")){
                dispose();
                new BudgetForm(user);
            }
        }
    }
}