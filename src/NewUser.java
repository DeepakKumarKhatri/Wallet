import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewUser extends JFrame {
    JPanel panel1, panel2, panel4;
    JButton nextButton;
    NewUser() {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLayout(new GridLayout(3, 1));
        setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1));
        BufferedImage myPicture = null;
        Image newImage = null;
        try {
            myPicture = ImageIO.read(new File("introImage1.jpeg"));
            newImage = myPicture.getScaledInstance(250, 200, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        panel1.add(picLabel);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1, new GridLayout());

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        JLabel label1 = new JLabel("Your Finances in One Place");
        label1.setFont(new Font("Calibri", Font.BOLD, 30));
        label1.setForeground(new Color(0xFFC6426C, true));
        JLabel label2 = new JLabel("Get the big picture on all of your money");
        JLabel label3 = new JLabel("Connect your back, track cash, or import data.");
        label2.setFont(new Font("Calibri", Font.BOLD, 20));
        label3.setFont(new Font("Calibri", Font.BOLD, 20));
        panel2.add(label1);
        panel2.add(label2);
        panel2.add(label3);
        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2, new GridLayout());

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 1));
        nextButton = new JButton("NEXT");
        nextButton.setForeground(new Color(0xFFFAF9F4, true));
        nextButton.setBackground(new Color(0xFF18D660, true));
        nextButton.setFont(new Font("Calibri",Font.BOLD,40));
        panel4.add(nextButton);
        getContentPane().add(panel4).setBackground(Color.WHITE);
        add(panel4, new GridLayout());

        MyActionListener myActionListener = new MyActionListener();
        nextButton.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("NEXT")) {
                dispose();
                Intro2 intro2 = new Intro2();
            }
        }
    }
}
class Intro2 extends JFrame {
    JPanel panel1,panel2,panel4;
    JButton nextButton;
    Intro2(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLayout(new GridLayout(3,1));
        setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,1));
        BufferedImage myPicture = null;
        Image newImage = null;
        try {
            myPicture = ImageIO.read(new File("introImage2.jpeg"));
            newImage = myPicture.getScaledInstance(250, 200, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        panel1.add(picLabel);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,new GridLayout());

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));
        JLabel label1 = new JLabel("Track Your Spending");
        label1.setFont(new Font("Calibri",Font.BOLD,30));
        label1.setForeground(new Color(0xFFC6426C, true));
        JLabel label2 = new JLabel("Track and analyse spending immediately");
        JLabel label3 = new JLabel("and automatically through our bank connection");
        label2.setFont(new Font("Calibri",Font.BOLD,20));
        label3.setFont(new Font("Calibri",Font.BOLD,20));
        panel2.add(label1);panel2.add(label2);panel2.add(label3);
        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2,new GridLayout());

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,1));
        nextButton = new JButton("NEXT");
        nextButton.setForeground(new Color(0xFFFAF9F4, true));
        nextButton.setBackground(new Color(0xFF18D660, true));
        nextButton.setFont(new Font("Calibri",Font.BOLD,40));
        panel4.add(nextButton);
        getContentPane().add(panel4).setBackground(Color.WHITE);
        add(panel4,new GridLayout());
        MyActionListener myActionListener = new MyActionListener();
        nextButton.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("NEXT")) {
                dispose();
                Intro3 intro3 = new Intro3();
            }
        }
    }
}
class Intro3 extends JFrame {
    JPanel panel1,panel2,panel4;
    JButton nextButton;
    Intro3(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLayout(new GridLayout(3,1));
        setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,1));
        BufferedImage myPicture = null;
        Image newImage = null;
        try {
            myPicture = ImageIO.read(new File("introImage3.jpeg"));
            newImage = myPicture.getScaledInstance(250, 200, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        panel1.add(picLabel);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,new GridLayout());

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));
        JLabel label1 = new JLabel("Follow your plan and dreams");
        label1.setFont(new Font("Calibri",Font.BOLD,30));
        label1.setForeground(new Color(0xFFC6426C, true));
        JLabel label2 = new JLabel("Build your financial life. ");
        JLabel label3 = new JLabel("Make the right financial decisions.");
        label2.setFont(new Font("Calibri",Font.BOLD,20));
        label3.setFont(new Font("Calibri",Font.BOLD,20));
        panel2.add(label1);panel2.add(label2);panel2.add(label3);
        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2,new GridLayout());

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,1));
        nextButton = new JButton("NEXT");
        nextButton.setForeground(new Color(0xFFFAF9F4, true));
        nextButton.setBackground(new Color(0xFF18D660, true));
        nextButton.setFont(new Font("Calibri",Font.BOLD,40));
        panel4.add(nextButton);
        getContentPane().add(panel4).setBackground(Color.WHITE);
        add(panel4,new GridLayout());
        MyActionListener myActionListener = new MyActionListener();
        nextButton.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("NEXT")) {
                dispose();
                Intro4 intro4 = new Intro4();
            }
        }
    }
}
class Intro4 extends JFrame {
    JPanel panel1,panel2,panel4;
    JButton nextButton;
    Intro4(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1));

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,1));
        BufferedImage myPicture = null;
        Image newImage = null;
        try {
            myPicture = ImageIO.read(new File("introImage4.jpeg"));
            newImage = myPicture.getScaledInstance(250, 200, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        panel1.add(picLabel);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,new GridLayout());

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));
        JLabel label1 = new JLabel("Budget your money");
        label1.setFont(new Font("Calibri",Font.BOLD,30));
        label1.setForeground(new Color(0xFFC6426C, true));
        JLabel label2 = new JLabel("Build Healthy Financial Habits.");
        JLabel label3 = new JLabel("Control Unnecessary expenses.");
        label2.setFont(new Font("Calibri",Font.BOLD,20));
        label3.setFont(new Font("Calibri",Font.BOLD,20));
        panel2.add(label1);panel2.add(label2);panel2.add(label3);
        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2,new GridLayout());

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,1));
        nextButton = new JButton("NEXT");
        nextButton.setForeground(new Color(0xFFFAF9F4, true));
        nextButton.setBackground(new Color(0xFF18D660, true));
        nextButton.setFont(new Font("Calibri",Font.BOLD,40));
        panel4.add(nextButton);
        getContentPane().add(panel4).setBackground(Color.WHITE);
        add(panel4,new GridLayout());

        MyActionListener myActionListener = new MyActionListener();
        nextButton.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("NEXT")) {
                dispose();
                Intro5 intro5 = new Intro5();
            }
        }
    }
}
class Intro5 extends JFrame {
    JPanel panel1,panel2,panel4;
    JButton startNowButton;
    Intro5(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1));

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,1));
        BufferedImage myPicture = null;
        Image newImage = null;
        try {
            myPicture = ImageIO.read(new File("introImage5.jpeg"));
            newImage = myPicture.getScaledInstance(250, 200, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        panel1.add(picLabel);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,new GridLayout());

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));
        JLabel label1 = new JLabel("Set up your Goals");
        label1.setFont(new Font("Calibri",Font.BOLD,30));
        label1.setForeground(new Color(0xFFC6426C, true));
        JLabel label2 = new JLabel("Track and follow what matters to you.");
        JLabel label3 = new JLabel("Save for important things.");
        label2.setFont(new Font("Calibri",Font.BOLD,20));
        label3.setFont(new Font("Calibri",Font.BOLD,20));
        panel2.add(label1);panel2.add(label2);panel2.add(label3);
        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2,new GridLayout());

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,1));
        startNowButton = new JButton("GET STARTED");
        startNowButton.setForeground(new Color(0xFFFAF9F4, true));
        startNowButton.setBackground(new Color(0xFF10DBDB, true));
        startNowButton.setFont(new Font("Calibri",Font.BOLD,40));
        panel4.add(startNowButton);
        add(panel4,new GridLayout());
        getContentPane().add(panel4).setBackground(Color.WHITE);
        MyActionListener myActionListner = new MyActionListener();
        startNowButton.addActionListener(myActionListner);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("GET STARTED")) {
                dispose();
                NewUserForm newUserForm = new NewUserForm();
            }
        }
    }
}