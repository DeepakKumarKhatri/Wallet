import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ShoppingListForm extends JFrame {
    JButton addNewList, showAllLists,goBack,mainMenu,suggestionsFromWallet,unlistMyList;
    ShoppingListForm(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        addNewList = new JButton("ADD NEW LIST");
        addNewList.setForeground(new Color(0xFFECECEC, true));
        addNewList.setBackground(new Color(0xFF313131, true));
        addNewList.setFont(new Font("Calibri",Font.BOLD,25));

        showAllLists = new JButton("SHOW MY LIST");
        showAllLists.setForeground(new Color(0xFFECECEC, true));
        showAllLists.setBackground(new Color(0xFF313131, true));
        showAllLists.setFont(new Font("Calibri",Font.BOLD,25));

        suggestionsFromWallet = new JButton("SUGGESTION FOR YOU FROM WALLET");
        suggestionsFromWallet.setForeground(new Color(0xFFECECEC, true));
        suggestionsFromWallet.setBackground(new Color(0xFF313131, true));
        suggestionsFromWallet.setFont(new Font("Calibri",Font.BOLD,22));

        unlistMyList = new JButton("LIST COMPLETED");
        unlistMyList.setForeground(new Color(0xFFECECEC, true));
        unlistMyList.setBackground(new Color(0xFF313131, true));
        unlistMyList.setFont(new Font("Calibri",Font.BOLD,25));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));

        mainMenu = new JButton("MAIN MENU");
        mainMenu.setForeground(new Color(0xFF27C684, true));
        mainMenu.setBackground(new Color(0xFF313131, true));
        mainMenu.setFont(new Font("Calibri",Font.BOLD,25));

        add(addNewList);add(showAllLists);add(unlistMyList);
        add(suggestionsFromWallet);add(goBack);add(mainMenu);

        setLayout(new GridLayout(6,1));
        setVisible(true);

        MyActionListener myActionListener = new MyActionListener(user);
        addNewList.addActionListener(myActionListener);
        showAllLists.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        mainMenu.addActionListener(myActionListener);
        unlistMyList.addActionListener(myActionListener);
        suggestionsFromWallet.addActionListener(myActionListener);
    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADD NEW LIST")) {
                dispose();
                AddNewList addNewList = new AddNewList(user);
            }else if (e.getActionCommand().equals("SHOW MY LIST")) {
                if (user.getShoppingList()!=null) {
                    if (user.getShoppingList().toString().equals("[]")){
                        JOptionPane.showMessageDialog(new JFrame(),"NO SHOPPING LIST ADDED YET!");
                    }else {
                        JOptionPane.showMessageDialog(new JFrame(), user.getShoppingList().toString());
                    }
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"NO SHOPPING LIST ADDED YET!");
                }
            }else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                Features features = new Features(user);
            } else if (e.getActionCommand().equals("MAIN MENU")) {
                dispose();
                Accounts accounts = new Accounts(user);
            }else if (e.getActionCommand().equals("SUGGESTION FOR YOU FROM WALLET")) {
                dispose();
                if (user.getShoppingList() != null) {
                    if (user.getShoppingList().size()==0){
                        JOptionPane.showMessageDialog(new JFrame(),"PLEASE ADD SHOPPING LIST TO GET SUGGESTIONS FROM WALLET");
                        new ShoppingListForm(user);
                    }else {
                        new SuggestionsFromWalletForShoppingList(user);
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"PLEASE ADD SHOPPING LISTS TO GET SUGGESTIONS FROM WALLET");
                    new ShoppingListForm(user);
                }
            }else if (e.getActionCommand().equals("LIST COMPLETED")) {
                dispose();
                new ListCompleted(user);
            }
        }
    }
}
class ListCompleted extends JFrame {
    JTextField listIdInput;
    JButton goBack, deleteNow;

    ListCompleted(User user) {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Shopping List Un-listing");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel budgetId = new JLabel("ENTER SHOPPING LIST ID TO UN-LIST");
        listIdInput = new JTextField();

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri", Font.BOLD, 25));

        deleteNow = new JButton("UN-LIST");
        deleteNow.setForeground(new Color(0xFF27C684, true));
        deleteNow.setBackground(new Color(0xFF313131, true));
        deleteNow.setFont(new Font("Calibri", Font.BOLD, 25));

        add(budgetId);add(listIdInput);add(deleteNow);add(goBack);

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
                if (searchTheListId(user.getShoppingList())){
                    deleteTheShoppingList();
                    JOptionPane.showMessageDialog(new JFrame(),"SHOPPING LIST UNLISTED SUCCESSFULLY!");
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"SHOPPING LIST ID NOT FOUND!");
                }
            }else if (e.getActionCommand().equals("GO BACK")){
                dispose();
                new ShoppingListForm(user);
            }
        }

        public void deleteTheShoppingList(){
            for (int i = 0; i < user.getShoppingList().size(); i++) {
                if (user.getShoppingList().get(i).getListId() == Integer.parseInt(listIdInput.getText())){
                    user.getShoppingList().remove(i);
                    userArrayList.get(i).getShoppingList().remove(i);
                    break;
                }
            }
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
        }
        public boolean searchTheListId(ArrayList<ShoppingList> list){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getListId() == Integer.parseInt(listIdInput.getText())){
                    return true;
                }
            }
            return false;
        }
    }
}

class SuggestionsFromWalletForShoppingList extends JFrame{
    JButton okayButton,mainMenu;
    JPanel p1,p2,superierPanel;
    SuggestionsFromWalletForShoppingList(User user){
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
        JLabel message1 = new JLabel("FROM YOUR VERY FIRST LIST");
        message1.setForeground(new Color(0xFF2153A3, true));
        message1.setFont(new Font("Serif",Font.BOLD,16));
        p1.add(message1);

        JLabel shoppingListName = new JLabel(user.getShoppingList().get(0).getListName());
        shoppingListName.setForeground(new Color(0xFF313131, true));
        shoppingListName.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(shoppingListName);

        JLabel message2 = new JLabel("ARRANGE THIS AMOUNT");
        message2.setForeground(new Color(0xFF2153A3, true));
        message2.setFont(new Font("Serif",Font.BOLD,20));
        p1.add(message2);

        JLabel message3 = new JLabel(Double.toString(user.getShoppingList().get(0).getProduct1Price()+user.getShoppingList().get(0).getProduct2Price()+user.getShoppingList().get(0).getProduct3Price()));
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
                new ShoppingListForm(user);
            }else  if (e.getActionCommand().equals("MAIN MENU")) {
                dispose();
                Accounts accounts = new Accounts(user);
            }
        }
    }
}
class AddNewList extends JFrame {
    JTextField listNameInput,product1NameInput,product2NameInput
            ,product3NameInput,product1PriceInput,product2PriceInput,product3PriceInput,listIdInput;
    JButton addButton, cancel;

    AddNewList(User user) {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel goalName = new JLabel("YOUR LIST NAME");
        listNameInput = new JTextField();

        JLabel product1Name = new JLabel("PRODUCT 1 NAME");
        JLabel product2Name = new JLabel("PRODUCT 2 NAME");
        JLabel product3Name = new JLabel("PRODUCT 3 NAME");

        JLabel product1Price = new JLabel("PRODUCT 1 PRICE");
        JLabel product2Price = new JLabel("PRODUCT 2 PRICE");
        JLabel product3Price = new JLabel("PRODUCT 3 PRICE");

        JLabel listId = new JLabel("ENTER LIST ID");
        listIdInput = new JTextField();

        addButton = new JButton("ADD");
        addButton.setForeground(new Color(0xFF27C684, true));
        addButton.setBackground(new Color(0xFF313131, true));
        addButton.setFont(new Font("Calibri",Font.BOLD,25));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFF27C684, true));
        cancel.setBackground(new Color(0xFF313131, true));
        cancel.setFont(new Font("Calibri",Font.BOLD,25));

        product1NameInput = new JTextField();
        product2NameInput = new JTextField();
        product3NameInput = new JTextField();
        product1PriceInput = new JTextField();
        product2PriceInput = new JTextField();
        product3PriceInput = new JTextField();

        add(goalName);add(listNameInput);
        add(product1Name);add(product1NameInput);
        add(product1Price);add(product1PriceInput);
        add(product2Name);add(product2NameInput);
        add(product2Price);add(product2PriceInput);
        add(product3Name);add(product3NameInput);
        add(product3Price);add(product3PriceInput);
        add(listId);add(listIdInput);
        add(addButton);add(cancel);

        setLayout(new GridLayout(9,2,10,20));
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
                String listName = listNameInput.getText();
                String product1Name = product1NameInput.getText();
                String product2Name = product2NameInput.getText();
                String product3Name = product3NameInput.getText();
                double product1Price = Double.parseDouble(product1PriceInput.getText());
                double product2Price = Double.parseDouble(product2PriceInput.getText());
                double product3Price = Double.parseDouble(product3PriceInput.getText());
                int listId = Integer.parseInt(listIdInput.getText());

                ShoppingList shoppingList = new ShoppingList(listName,product1Name,product1Price,product2Name,product2Price,product3Name,product3Price,listId);
                //I HAVE TO INITIALIZE THE COMPLETE_USER_INFORMATION

                FileOperations fileOperations = new FileOperations();
                ArrayList<User>shoppingArrayList = fileOperations.readInFile();

                for (User i: shoppingArrayList) {
                    if (i.getFirstName().equals(user.getFirstName())){
                        i.setShoppingList(shoppingList);
                    }
                }

                ObjectOutputStream objectOutputStream = null;
                File file = new File("UsersData.ser");
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,false));
                    objectOutputStream.writeObject(shoppingArrayList.get(0));

                    for (int i=1;i<shoppingArrayList.size();i++){
                        fileOperations.writeInFile(shoppingArrayList.get(i),true);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(new JFrame(),"SHOPPING LIST ADDED SUCCESSFULLY");

            }else if (e.getActionCommand().equals("CANCEL")) {
                new ShoppingListForm(user);
                dispose();
            }
        }
    }
}