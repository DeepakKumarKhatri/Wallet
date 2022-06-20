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
    JButton addNewList, showAllLists,goBack,mainMenu;
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

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));

        mainMenu = new JButton("MAIN MENU");
        mainMenu.setForeground(new Color(0xFF27C684, true));
        mainMenu.setBackground(new Color(0xFF313131, true));
        mainMenu.setFont(new Font("Calibri",Font.BOLD,25));

        add(addNewList);add(showAllLists);
        add(goBack);add(mainMenu);

        setLayout(new GridLayout(4,1));
        setVisible(true);

        MyActionListener myActionListener = new MyActionListener(user);
        addNewList.addActionListener(myActionListener);
        showAllLists.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        mainMenu.addActionListener(myActionListener);
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
                    JOptionPane.showMessageDialog(new JFrame(), user.getShoppingList().toString());
                }else {
                    JOptionPane.showMessageDialog(new JFrame(),"NO SHOPPING LIST ADDED YET!");
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

class AddNewList extends JFrame {
    JTextField listNameInput,product1NameInput,product2NameInput
            ,product3NameInput,product1PriceInput,product2PriceInput,product3PriceInput;
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
        add(addButton);add(cancel);

        setLayout(new GridLayout(8,2,10,20));
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

                ShoppingList shoppingList = new ShoppingList(listName,product1Name,product1Price,product2Name,product2Price,product3Name,product3Price);
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
                Features features = new Features(user);
                dispose();
            }
        }
    }
}