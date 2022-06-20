import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Features extends JFrame {
    JButton budgets,debts,goals,shoppingList,currencyRate,hideAmount,goBack,exit;
    Features(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        budgets = new JButton("BUDGET");
        budgets.setForeground(new Color(0xFFECECEC, true));
        budgets.setBackground(new Color(0xFF313131, true));
        budgets.setFont(new Font("Calibri",Font.BOLD,25));

        debts = new JButton("DEBTS");
        debts.setForeground(new Color(0xFFECECEC, true));
        debts.setBackground(new Color(0xFF313131, true));
        debts.setFont(new Font("Calibri",Font.BOLD,25));

        goals  = new JButton("GOALS");
        goals.setForeground(new Color(0xFFECECEC, true));
        goals.setBackground(new Color(0xFF313131, true));
        goals.setFont(new Font("Calibri",Font.BOLD,25));

        shoppingList = new JButton("SHOPPING LIST");
        shoppingList.setForeground(new Color(0xFFECECEC, true));
        shoppingList.setBackground(new Color(0xFF313131, true));
        shoppingList.setFont(new Font("Calibri",Font.BOLD,20));

        currencyRate = new JButton("CURRENCY RATE");
        currencyRate.setForeground(new Color(0xFFECECEC, true));
        currencyRate.setBackground(new Color(0xFF313131, true));
        currencyRate.setFont(new Font("Calibri",Font.BOLD,20));

        hideAmount = new JButton("HIDE BALANCE");
        hideAmount.setForeground(new Color(0xFFECECEC, true));
        hideAmount.setBackground(new Color(0xFF313131, true));
        hideAmount.setFont(new Font("Calibri",Font.BOLD,20));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));

        exit = new JButton("EXIT");
        exit.setForeground(new Color(0xFF27C684, true));
        exit.setBackground(new Color(0xFF313131, true));
        exit.setFont(new Font("Calibri",Font.BOLD,25));

        add(budgets);add(debts);add(goals);add(shoppingList);
        add(currencyRate);add(hideAmount);add(goBack);add(exit);

        MyActionListener myActionListener = new MyActionListener(user);
        budgets.addActionListener(myActionListener);
        debts.addActionListener(myActionListener);
        goals.addActionListener(myActionListener);
        shoppingList.addActionListener(myActionListener);
        currencyRate.addActionListener(myActionListener);
        hideAmount.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        exit.addActionListener(myActionListener);

        setLayout(new GridLayout(4,2,20,20));
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("BUDGET")){
                dispose();
                BudgetForm budgetForm = new BudgetForm(user);
            } else if (e.getActionCommand().equals("DEBTS")){
                dispose();
                DebtForm debtForm = new DebtForm(user);
            }else if (e.getActionCommand().equals("GOALS")){
                dispose();
                GoalForm goalForm = new GoalForm(user);
            }else if (e.getActionCommand().equals("SHOPPING LIST")){
                dispose();
                ShoppingListForm shoppingListForm = new ShoppingListForm(user);
            }else if (e.getActionCommand().equals("CURRENCY RATE")){
                dispose();
                CurrencyRatesExchange currencyRatesExchange = new CurrencyRatesExchange(user);
            }else if (e.getActionCommand().equals("HIDE BALANCE")){
                dispose();
                hideTheAmount(user);
            }else if (e.getActionCommand().equals("GO BACK")){
                dispose();
                Accounts accounts = new Accounts(user);
            }else if (e.getActionCommand().equals("EXIT")){
                System.exit(0);
            }
        }
    }
    public void hideTheAmount(User user){
        Accounts accounts = new Accounts(user);
        accounts.myCashIsLabel.setVisible(false);
        dispose();
        JOptionPane.showMessageDialog(new JFrame(),"BALANCE IS NOW HIDDEN");
    }
}