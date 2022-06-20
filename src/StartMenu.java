import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartMenu extends JFrame {
    JButton admin, userButton;
    JPanel panel1,panel2,panel3;
    JLabel label;
    StartMenu(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        panel2 = new JPanel();
        label = new JLabel("WELCOME IN WALLET!");
        label.setForeground(new Color(0xFF18D660, true));
        label.setFont(new Font("Serif",Font.PLAIN,50));
        panel2.add(label);
        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2,BorderLayout.NORTH);

        panel1 = new JPanel();
        admin = new JButton("I AM ADMIN");
        admin.setForeground(new Color(0xFFFAF9F4, true));
        admin.setBackground(new Color(0xFF18D660, true));
        admin.setFont(new Font("Calibri",Font.BOLD,25));

        userButton = new JButton("I AM USER");
        userButton.setForeground(new Color(0xFFFAF9F4, true));
        userButton.setBackground(new Color(0xFF18D660, true));
        userButton.setFont(new Font("Calibri",Font.BOLD,25));

        panel1.add(admin);panel1.add(userButton);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,BorderLayout.SOUTH);

        panel3 = new JPanel();
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("AdminUserConfusion.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel3.add(picLabel);
        add(panel3,BorderLayout.CENTER);
        getContentPane().add(panel3).setBackground(Color.WHITE);

        MyActionListener myActionListener = new MyActionListener();
        admin.addActionListener(myActionListener);
        userButton.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("I AM ADMIN")){
                dispose();
                Admin admin = new Admin();
            }else if (e.getActionCommand().equals("I AM USER")){
                dispose();
                Credentials credentials = new Credentials();
            }
        }
    }
}