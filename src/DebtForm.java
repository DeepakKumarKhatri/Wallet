import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DebtForm extends JFrame {
    JButton iLent,iBorrowed,goBack,mainMenu,showMyDebt,suggestionsFromWallet,unlistMyDebt;
    DebtForm(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        showMyDebt = new JButton("SHOW MY DEBT");
        showMyDebt.setForeground(new Color(0xFFECECEC, true));
        showMyDebt.setBackground(new Color(0xFF313131, true));
        showMyDebt.setFont(new Font("Calibri",Font.BOLD,25));

        iLent = new JButton("I LENT");
        iLent.setForeground(new Color(0xFFECECEC, true));
        iLent.setBackground(new Color(0xFF313131, true));
        iLent.setFont(new Font("Calibri",Font.BOLD,25));

        iBorrowed = new JButton("I BORROWED");
        iBorrowed.setForeground(new Color(0xFFECECEC, true));
        iBorrowed.setBackground(new Color(0xFF313131, true));
        iBorrowed.setFont(new Font("Calibri",Font.BOLD,25));

        suggestionsFromWallet = new JButton("SUGGESTION FOR YOU FROM WALLET");
        suggestionsFromWallet.setForeground(new Color(0xFFECECEC, true));
        suggestionsFromWallet.setBackground(new Color(0xFF313131, true));
        suggestionsFromWallet.setFont(new Font("Calibri",Font.BOLD,22));

        unlistMyDebt = new JButton("DEBT IS FULFILLED");
        unlistMyDebt.setForeground(new Color(0xFFECECEC, true));
        unlistMyDebt.setBackground(new Color(0xFF313131, true));
        unlistMyDebt.setFont(new Font("Calibri",Font.BOLD,25));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));

        mainMenu = new JButton("MAIN MENU");
        mainMenu.setForeground(new Color(0xFF27C684, true));
        mainMenu.setBackground(new Color(0xFF313131, true));
        mainMenu.setFont(new Font("Calibri",Font.BOLD,25));

        add(iLent);add(iBorrowed);
        add(showMyDebt);add(suggestionsFromWallet);add(unlistMyDebt);
        add(goBack);add(mainMenu);

        setLayout(new GridLayout(7,1));
        setVisible(true);

        MyActionListener myActionListener = new MyActionListener(user);
        showMyDebt.addActionListener(myActionListener);
        iLent.addActionListener(myActionListener);
        iBorrowed.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        mainMenu.addActionListener(myActionListener);
        suggestionsFromWallet.addActionListener(myActionListener);
        unlistMyDebt.addActionListener(myActionListener);
    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("I LENT")) {
                dispose();
                Lent lent = new Lent(user);
            }else if (e.getActionCommand().equals("I BORROWED")) {
                dispose();
                Borrowed borrowed = new Borrowed(user);
            }else if (e.getActionCommand().equals("GO BACK")) {
                Features features = new Features(user);
                dispose();
            } else if (e.getActionCommand().equals("MAIN MENU")) {
                dispose();
                Accounts accounts = new Accounts(user);
            } else if (e.getActionCommand().equals("SHOW MY DEBT")) {
                if (user.getDebt()!=null) {
                    if (user.getDebt().toString().equals("[]")){
                        JOptionPane.showMessageDialog(new JFrame(),"NO DEBT ADDED YET!");
                    }else {
                        JOptionPane.showMessageDialog(new JFrame(), user.getDebt().toString());
                    }
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"NO DEBT ADDED YET!");
                }
            }else if (e.getActionCommand().equals("SUGGESTION FOR YOU FROM WALLET")) {
                dispose();
                if (user.getDebt() != null) {
                    if (user.getDebt().size()==0){
                        JOptionPane.showMessageDialog(new JFrame(),"PLEASE ADD DEBT TO GET SUGGESTIONS FROM WALLET");
                    }else {
                        SuggestionsFromWalletForDEBT suggestionsFromWalletForDEBT = new SuggestionsFromWalletForDEBT(user);
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"PLEASE ADD DEBT TO GET SUGGESTIONS FROM WALLET");
                }
            }else if (e.getActionCommand().equals("DEBT IS FULFILLED")) {
                dispose();
                DebtIsOver debtIsOver = new DebtIsOver(user);
            }
        }
    }
}

class DebtIsOver extends JFrame {
    JTextField debtIdInput;
    JButton goBack, deleteNow;

    DebtIsOver(User user) {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Debt Un-listing");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel debtId = new JLabel("ENTER DEBT ID TO UN-LIST");
        debtIdInput = new JTextField();

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri", Font.BOLD, 25));

        deleteNow = new JButton("UN-LIST");
        deleteNow.setForeground(new Color(0xFF27C684, true));
        deleteNow.setBackground(new Color(0xFF313131, true));
        deleteNow.setFont(new Font("Calibri", Font.BOLD, 25));

        add(debtId);add(debtIdInput);add(deleteNow);add(goBack);

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
                if (searchTheDebtId(user.getDebt())){
                    unlistTheDebt();
                    JOptionPane.showMessageDialog(new JFrame(),"DEBT UNLISTED SUCCESSFULLY!");
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"DEBT ID NOT FOUND!");
                }
            }else if (e.getActionCommand().equals("GO BACK")){
                dispose();
                Features features = new Features(user);
            }
        }

        public void unlistTheDebt(){
            for (int i = 0; i < userArrayList.size(); i++) {
                if (userArrayList.get(i).getDebt().get(i).getDebtId() == Integer.parseInt(debtIdInput.getText())){
                    userArrayList.get(i).getDebt().remove(i);
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
                JOptionPane.showMessageDialog(new JFrame(),"DEBT LIST IS NOW EMPTY");
            }
        }
        public boolean searchTheDebtId(ArrayList<Debt> list){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDebtId() == Integer.parseInt(debtIdInput.getText())){
                    return true;
                }
            }
            return false;
        }
    }
}

class SuggestionsFromWalletForDEBT extends JFrame{
    JButton okayButton,mainMenu;
    JPanel p1,p2,superierPanel;
    SuggestionsFromWalletForDEBT(User user){
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
        JLabel message1 = new JLabel("FROM YOUR VERY FIRST DEBT");
        message1.setForeground(new Color(0xFF2153A3, true));
        message1.setFont(new Font("Serif",Font.BOLD,16));
        p1.add(message1);

        JLabel debtName = new JLabel(user.getDebt().get(0).getName());
        debtName.setForeground(new Color(0xFF313131, true));
        debtName.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(debtName);

        JLabel message2 = new JLabel("ARRANGE THIS AMOUNT");
        message2.setForeground(new Color(0xFF2153A3, true));
        message2.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(message2);

        JLabel message3 = new JLabel(Double.toString(user.getCashBalance()-user.getDebt().get(0).getAmount()));
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

class Lent extends JFrame{
    JTextField nameInput,descriptionInput,amountInput,startDayInput,startMonthInput,startYearInput,
            endDayInput,endMonthInput,endYearInput,debtIdInput;
   JButton addButton,cancel;

    Lent(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel name = new JLabel("NAME (To Whom)");
        nameInput = new JTextField();
        JLabel description = new JLabel("DESCRIPTION (For What)");
        descriptionInput = new JTextField();
        JLabel amount = new JLabel("AMOUNT");
        amountInput = new JTextField();
        JLabel startDate = new JLabel("START DATE");
        startDayInput = new JTextField();
        JLabel startMonth = new JLabel("START MONTH");
        startMonthInput = new JTextField();
        JLabel startYear = new JLabel("START YEAR");
        startYearInput = new JTextField();
        JLabel endDate = new JLabel("DUE DATE");
        endDayInput = new JTextField();
        JLabel endMonth = new JLabel("DUE MONTH");
        endMonthInput = new JTextField();
        JLabel endYear = new JLabel("DUE YEAR");
        endYearInput = new JTextField();
        JLabel debtIdLabel = new JLabel("ENTER DEBT ID");
        debtIdInput = new JTextField();

        addButton = new JButton("ADD");
        addButton.setForeground(new Color(0xFF27C684, true));
        addButton.setBackground(new Color(0xFF313131, true));
        addButton.setFont(new Font("Calibri",Font.BOLD,25));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFF27C684, true));
        cancel.setBackground(new Color(0xFF313131, true));
        cancel.setFont(new Font("Calibri",Font.BOLD,25));

        add(name);add(nameInput);
        add(description);add(descriptionInput);
        add(amount);add(amountInput);
        add(startDate);add(startDayInput);
        add(startMonth);add(startMonthInput);
        add(startYear);add(startYearInput);
        add(endDate);add(endDayInput);
        add(endMonth);add(endMonthInput);
        add(endYear);add(endYearInput);
        add(debtIdLabel);add(descriptionInput);

        add(addButton);add(cancel);

        setLayout(new GridLayout(11,2,10,10));
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
                String description = descriptionInput.getText();
                double amount = Double.parseDouble(amountInput.getText());
                int startDate = Integer.parseInt(startDayInput.getText());
                int startMonth= Integer.parseInt(startMonthInput.getText());
                int startYear= Integer.parseInt(startYearInput.getText());
                int endDate= Integer.parseInt(endDayInput.getText());
                int endMonth= Integer.parseInt(endMonthInput.getText());
                int endYear= Integer.parseInt(endYearInput.getText());
                int debtId = Integer.parseInt(debtIdInput.getText());

                Date date_start = new Date(startDate,startMonth,startYear);
                Date date_end = new Date(endDate,endMonth,endYear);

                String debtType = "LENT";
                Debt debt = new Debt(debtId,debtType,name,description,amount,date_start,date_end);
                ////I HAVE TO INITIALIZE THE COMPLETE_USER_INFORMATION

                FileOperations fileOperations = new FileOperations();
                ArrayList<User>debtList = fileOperations.readInFile();

                for (User i: debtList) {
                    if (i.getFirstName().equals(user.getFirstName())){
                        i.setDebt(debt);
                    }
                }

                ObjectOutputStream objectOutputStream = null;
                File file = new File("UsersData.ser");
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,false));
                    objectOutputStream.writeObject(debtList.get(0));

                    for (int i=1;i<debtList.size();i++){
                        fileOperations.writeInFile(debtList.get(i),true);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(new JFrame(),"DEBT ADDED SUCCESSFULLY");

            }else if (e.getActionCommand().equals("CANCEL")){
                dispose();
                Features features = new Features(user);
            }
        }
    }
}

class Borrowed extends JFrame{
    JTextField nameInput,descriptionInput,amountInput,startDayInput,startMonthInput,startYearInput,
            endDayInput,endMonthInput,endYearInput,debtIdInput;
    JButton addButton,cancel;

    Borrowed(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel name = new JLabel("NAME (From Whom)");
        nameInput = new JTextField();
        JLabel description = new JLabel("DESCRIPTION (For What)");
        descriptionInput = new JTextField();
        JLabel amount = new JLabel("AMOUNT");
        amountInput = new JTextField();
        JLabel startDate = new JLabel("START DATE");
        startDayInput = new JTextField();
        JLabel startMonth = new JLabel("START MONTH");
        startMonthInput = new JTextField();
        JLabel startYear = new JLabel("START YEAR");
        startYearInput = new JTextField();
        JLabel endDate = new JLabel("DUE DATE");
        endDayInput = new JTextField();
        JLabel endMonth = new JLabel("DUE MONTH");
        endMonthInput = new JTextField();
        JLabel endYear = new JLabel("DUE YEAR");
        endYearInput = new JTextField();
        JLabel debtIdLabel = new JLabel("ENTER DEBT ID");
        debtIdInput = new JTextField();

        addButton = new JButton("ADD");
        addButton.setForeground(new Color(0xFF27C684, true));
        addButton.setBackground(new Color(0xFF313131, true));
        addButton.setFont(new Font("Calibri",Font.BOLD,25));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFF27C684, true));
        cancel.setBackground(new Color(0xFF313131, true));
        cancel.setFont(new Font("Calibri",Font.BOLD,25));

        add(name);add(nameInput);
        add(description);add(descriptionInput);
        add(amount);add(amountInput);
        add(startDate);add(startDayInput);
        add(startMonth);add(startMonthInput);
        add(startYear);add(startYearInput);
        add(endDate);add(endDayInput);
        add(endMonth);add(endMonthInput);
        add(endYear);add(endYearInput);
        add(debtIdLabel);add(debtIdInput);

        add(addButton);add(cancel);

        setLayout(new GridLayout(11,2,10,10));
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
                String description = descriptionInput.getText();
                double amount = Double.parseDouble(amountInput.getText());
                int startDate = Integer.parseInt(startDayInput.getText());
                int startMonth= Integer.parseInt(startMonthInput.getText());
                int startYear= Integer.parseInt(startYearInput.getText());
                int endDate= Integer.parseInt(endDayInput.getText());
                int endMonth= Integer.parseInt(endMonthInput.getText());
                int endYear= Integer.parseInt(endYearInput.getText());
                int debtId = Integer.parseInt(debtIdInput.getText());

                Date date_start = new Date(startDate,startMonth,startYear);
                Date date_end = new Date(endDate,endMonth,endYear);

                String debtType = "BORROWED";
                Debt debt = new Debt(debtId,debtType,name,description,amount,date_start,date_end);
                ////I HAVE TO INITIALIZE THE COMPLETE_USER_INFORMATION

                FileOperations fileOperations = new FileOperations();
                ArrayList<User>debtList = fileOperations.readInFile();

                for (User i: debtList) {
                    if (i.getFirstName().equals(user.getFirstName())){
                        i.setDebt(debt);
                    }
                }
                ObjectOutputStream objectOutputStream = null;
                File file = new File("UsersData.ser");
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,false));
                    objectOutputStream.writeObject(debtList.get(0));

                    for (int i=1;i<debtList.size();i++){
                        fileOperations.writeInFile(debtList.get(i),true);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(new JFrame(),"DEBT ADDED SUCCESSFULLY");
            }else if (e.getActionCommand().equals("CANCEL")){
                dispose();
                Features features = new Features(user);
            }
        }
    }
}