import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Credentials extends JFrame {
    JButton newUser,oldUser,goBack;
    JPanel panel1,panel2,panel3;
    JLabel label;
    Credentials(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Wallet");
        ImageIcon imageIcon = new ImageIcon("officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        panel2 = new JPanel();
        label = new JLabel("HEY THERE!");
        label.setForeground(new Color(0xFF18D660, true));
        label.setFont(new Font("Serif",Font.PLAIN,50));
        panel2.add(label);
        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2,BorderLayout.NORTH);

        panel1 = new JPanel();
        newUser = new JButton("NEW USER?");
        newUser.setForeground(new Color(0xFFFAF9F4, true));
        newUser.setBackground(new Color(0xFF18D660, true));
        newUser.setFont(new Font("Calibri",Font.BOLD,25));

        oldUser = new JButton("ALREADY A USER");
        oldUser.setForeground(new Color(0xFFFAF9F4, true));
        oldUser.setBackground(new Color(0xFF18D660, true));
        oldUser.setFont(new Font("Calibri",Font.BOLD,25));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFFFAF9F4, true));
        goBack.setBackground(new Color(0xFF18D660, true));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));
        add(goBack);

        panel1.add(newUser);panel1.add(oldUser);panel1.add(goBack);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,BorderLayout.SOUTH);

        panel3 = new JPanel();
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("confused.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel3.add(picLabel);
        getContentPane().add(panel3).setBackground(Color.WHITE);
        add(panel3,BorderLayout.CENTER);

        MyActionListener myActionListener = new MyActionListener();
        newUser.addActionListener(myActionListener);
        oldUser.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("NEW USER?")){
                dispose();
                NewUser newUser =new NewUser();
            }else if (e.getActionCommand().equals("ALREADY A USER")){
                dispose();
                LoginPage loginPage = new LoginPage();
            } else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                StartMenu startMenu = new StartMenu();
            }
        }
    }
}