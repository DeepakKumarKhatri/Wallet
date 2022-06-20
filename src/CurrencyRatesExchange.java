import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyRatesExchange extends JFrame {
    JButton usd,euro,dinar, mainMenu,cancel;
    JPanel p1,p2,p3;
    CurrencyRatesExchange(User user){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Currency Rates");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        p1 = new JPanel();
        JLabel message = new JLabel("YOU CAN DO FOLLOWING CONVERSIONS");
        message.setForeground(new Color(0xFF27C684, true));
        message.setFont(new Font("Serif",Font.PLAIN,28));
        p1.add(message);
        getContentPane().add(p1).setBackground(new Color(0xFF313131, true));
        add(p1,BorderLayout.NORTH);

        p2 = new JPanel();
        usd = new JButton("PKR/USD");
        usd.setForeground(new Color(0xFFECECEC, true));
        usd.setBackground(new Color(0xFF313131, true));
        usd.setFont(new Font("Calibri",Font.BOLD,35));

        euro = new JButton("PKR/EURO");
        euro.setForeground(new Color(0xFFECECEC, true));
        euro.setBackground(new Color(0xFF313131, true));
        euro.setFont(new Font("Calibri",Font.BOLD,35));

        dinar = new JButton("PKR/DINAR");
        dinar.setForeground(new Color(0xFFECECEC, true));
        dinar.setBackground(new Color(0xFF313131, true));
        dinar.setFont(new Font("Calibri",Font.BOLD,35));

        p2.add(usd);p2.add(euro);p2.add(dinar);
        p2.setLayout(new GridLayout(3,1));
        //getContentPane().add(p2).setBackground(Color.WHITE);
        add(p2,BorderLayout.CENTER);

        p3 = new JPanel();
        mainMenu = new JButton("MAIN MENU");
        mainMenu.setForeground(new Color(0xFF27C684, true));
        mainMenu.setBackground(new Color(0xFF313131, true));
        mainMenu.setFont(new Font("Calibri",Font.BOLD,25));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFF27C684, true));
        cancel.setBackground(new Color(0xFF313131, true));
        cancel.setFont(new Font("Calibri",Font.BOLD,25));

        p3.add(mainMenu);p3.add(cancel);
        p3.setLayout(new GridLayout(1,2));
       // getContentPane().add(p3).setBackground(Color.WHITE);
        add(p3,BorderLayout.SOUTH);

        MyActionListener myActionListener = new MyActionListener(user);
        mainMenu.addActionListener(myActionListener);
        cancel.addActionListener(myActionListener);
        usd.addActionListener(myActionListener);
        euro.addActionListener(myActionListener);
        dinar.addActionListener(myActionListener);

        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        User user;
        MyActionListener(User user){
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("PKR/USD")) {
                USD usd = new USD();
            }else if (e.getActionCommand().equals("PKR/EURO")) {
                EURO euro = new EURO();
            }else if (e.getActionCommand().equals("PKR/DINAR")) {
                DINAR dinar = new DINAR();
            }else if (e.getActionCommand().equals("MAIN MENU")) {
                dispose();
                Accounts accounts = new Accounts(user);
            }else if (e.getActionCommand().equals("CANCEL")) {
                dispose();
                Features features = new Features(user);
            }
        }
    }
}
class USD extends JFrame{
    JTextField pkrAmountInput;
    JButton convertNow,goBack;
    String convertedValue;
    JLabel message,output;
    USD(){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pkr to Usd");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        JLabel pkrAmount = new JLabel("ENTER AMOUNT IN PKR");
        pkrAmount.setForeground(new Color(0xFF2153A3, true));
        pkrAmount.setFont(new Font("Serif",Font.PLAIN,20));
        add(pkrAmount);
        pkrAmountInput = new JTextField();
        add(pkrAmountInput);

        message = new JLabel("AMOUNT IN USD IS");
        message.setVisible(false);
        message.setForeground(new Color(0xFF313131, true));
        message.setFont(new Font("Serif",Font.PLAIN,20));
        add(message);
        output = new JLabel();
        output.setVisible(false);
        output.setForeground(new Color(0xFF27C64D, true));
        output.setFont(new Font("Serif",Font.PLAIN,20));
        add(output);

        convertNow = new JButton("CONVERT");
        convertNow.setForeground(new Color(0xFF27C684, true));
        convertNow.setBackground(new Color(0xFF313131, true));
        convertNow.setFont(new Font("Calibri",Font.BOLD,25));
        add(convertNow);

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));
        add(goBack);

        MyActionListener myActionListener = new MyActionListener();
        convertNow.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);

        setLayout(new GridLayout(3,2,10,200));
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("CONVERT")) {
                convertedValue  = Double.toString(Double.parseDouble(pkrAmountInput.getText())/207.68);
                output.setText(convertedValue);
                message.setVisible(true);output.setVisible(true);
            }else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
            }
        }
    }
}

class EURO extends JFrame{
    JTextField pkrAmountInput;
    JButton convertNow,goBack;
    String convertedValue;
    JLabel message,output;
    EURO(){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pkr to Euro");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        JLabel pkrAmount = new JLabel("ENTER AMOUNT IN PKR");
        pkrAmount.setForeground(new Color(0xFF2153A3, true));
        pkrAmount.setFont(new Font("Serif",Font.PLAIN,20));
        add(pkrAmount);
        pkrAmountInput = new JTextField();
        add(pkrAmountInput);

        message = new JLabel("AMOUNT IN EURO IS");
        message.setVisible(false);
        message.setForeground(new Color(0xFF313131, true));
        message.setFont(new Font("Serif",Font.PLAIN,20));
        add(message);
        output = new JLabel();
        output.setVisible(false);
        output.setForeground(new Color(0xFF27C64D, true));
        output.setFont(new Font("Serif",Font.PLAIN,20));
        add(output);

        convertNow = new JButton("CONVERT");
        convertNow.setForeground(new Color(0xFF27C684, true));
        convertNow.setBackground(new Color(0xFF313131, true));
        convertNow.setFont(new Font("Calibri",Font.BOLD,25));
        add(convertNow);

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));
        add(goBack);

        MyActionListener myActionListener = new MyActionListener();
        convertNow.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);

        setLayout(new GridLayout(3,2,10,200));
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("CONVERT")) {
                convertedValue  = Double.toString(Double.parseDouble(pkrAmountInput.getText())/206.20);
                output.setText(convertedValue);
                message.setVisible(true);output.setVisible(true);
            }else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
            }
        }
    }
}
class DINAR extends JFrame{
    JTextField pkrAmountInput;
    JButton convertNow,goBack;
    String convertedValue;
    JLabel message,output;
    DINAR(){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pkr to Dinar");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        JLabel pkrAmount = new JLabel("ENTER AMOUNT IN PKR");
        pkrAmount.setForeground(new Color(0xFF2153A3, true));
        pkrAmount.setFont(new Font("Serif",Font.PLAIN,20));
        add(pkrAmount);
        pkrAmountInput = new JTextField();
        add(pkrAmountInput);

        message = new JLabel("AMOUNT IN DINAR IS");
        message.setVisible(false);
        message.setForeground(new Color(0xFF313131, true));
        message.setFont(new Font("Serif",Font.PLAIN,20));
        add(message);
        output = new JLabel();
        output.setVisible(false);
        output.setForeground(new Color(0xFF27C64D, true));
        output.setFont(new Font("Serif",Font.PLAIN,20));
        add(output);

        convertNow = new JButton("CONVERT");
        convertNow.setForeground(new Color(0xFF27C684, true));
        convertNow.setBackground(new Color(0xFF313131, true));
        convertNow.setFont(new Font("Calibri",Font.BOLD,25));
        add(convertNow);

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFF27C684, true));
        goBack.setBackground(new Color(0xFF313131, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));
        add(goBack);

        MyActionListener myActionListener = new MyActionListener();
        convertNow.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);

        setLayout(new GridLayout(3,2,10,200));
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("CONVERT")) {
                convertedValue  = Double.toString(Double.parseDouble(pkrAmountInput.getText())/675.91);
                output.setText(convertedValue);
                message.setVisible(true);output.setVisible(true);
            }else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
            }
        }
    }
}