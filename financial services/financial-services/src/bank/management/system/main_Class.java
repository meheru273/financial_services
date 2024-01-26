package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JLabel label1;
    String pin;
    main_Class(String pin){
        this.pin = pin;








        JLabel label = new JLabel("Please Select Your Option");
        label.setBounds(200,20,700,35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("System",Font.BOLD,22));
        add(label);



        b1 = new RoundedButton("CASH IN");
        b1.setFont(new Font("Arial",Font.PLAIN,20));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(250, 2, 109));
        b1.setBounds(370,70,300,80);
        b1.addActionListener(this);
        add(b1);
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/cashout.png"));
        Image ii2 = ii1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(250,80,30,30);
        b1.add(iimage);

        b2 = new RoundedButton("CASH OUT");
        b2.setFont(new Font("Arial",Font.PLAIN,20));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(250, 2, 109));
        b2.setBounds(40,70,300,80);
        b2.addActionListener(this);
        add(b2);
        ImageIcon a21 = new ImageIcon(ClassLoader.getSystemResource("icon/getmoney.png"));
        Image a22 = a21.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon a23 = new ImageIcon(a22);
        JLabel a2 = new JLabel(a23);
        a2.setBounds(40,120,30,30);
        b2.add(a2);

        b3 = new RoundedButton("PAY BILL");
        b3.setFont(new Font("Arial",Font.PLAIN,20));
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(250, 2, 109));
        b3.setBounds(40,180,300,80);
        b3.addActionListener(this);
        add(b3);
        ImageIcon a31 = new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image a32 = a31.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon a33 = new ImageIcon(a32);
        JLabel a3 = new JLabel(a33);
        a3.setBounds(40,120,40,40);
        b3.add(a3);

        b4 = new RoundedButton("SEARCH");
        b4.setFont(new Font("Arial",Font.PLAIN,20));
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(250, 2, 109));
        b4.setBounds(40,290,300,80);
        b4.addActionListener(this);
        add(b4);
        ImageIcon a41 = new ImageIcon(ClassLoader.getSystemResource("icon/search.png"));
        Image a42 = a41.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon a43 = new ImageIcon(a42);
        JLabel a4 = new JLabel(a43);
        a4.setBounds(40,120,40,40);
        b4.add(a4);

        b5 = new RoundedButton("CHANGE PIN");
        b5.setFont(new Font("Arial",Font.PLAIN,20));
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(250, 2, 109));
        b5.setBounds(370,290,300,80);
        b5.addActionListener(this);
        add(b5);
        ImageIcon a51 = new ImageIcon(ClassLoader.getSystemResource("icon/settings.png"));
        Image a52 = a51.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon a53 = new ImageIcon(a52);
        JLabel a5 = new JLabel(a53);
        a5.setBounds(450,320,30,30);
        b5.add(a5);

        b6 = new RoundedButton(" BALANCE");
        b6.setFont(new Font("Arial",Font.PLAIN,20));
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(250, 2, 109));
        b6.setBounds(370,180,300,80);
        b6.addActionListener(this);
        add(b6);
        ImageIcon a61 = new ImageIcon(ClassLoader.getSystemResource("icon/balance.png"));
        Image a62 = a61.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon a63 = new ImageIcon(a62);
        JLabel a6 = new JLabel(a63);
        a6.setBounds(450,320,30,30);
        b6.add(a6);

        b7 = new RoundedButton("EXIT");
        b7.setFont(new Font("Arial",Font.PLAIN,20));
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(250, 2, 109));
        b7.setBounds(50,400,600,70);
        b7.addActionListener(this);
        add(b7);
        ImageIcon a71 = new ImageIcon(ClassLoader.getSystemResource("icon/arrow.png"));
        Image a72 = a71.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon a73 = new ImageIcon(a72);
        JLabel a7 = new JLabel(a73);
        a7.setBounds(350,120,40,40);
        b7.add(a7);

       /* b8 = new RoundedButton("Transactions");
        b8.setFont(new Font("Arial",Font.PLAIN,20));
        b8.setForeground(Color.WHITE);
        b8.setBackground(new Color(250, 2, 109));
        b8.setBounds(40,400,300,70);
        b8.addActionListener(this);
        add(b8);
        ImageIcon a81 = new ImageIcon(ClassLoader.getSystemResource("icon/transaction.png"));
        Image a82 = a81.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon a83 = new ImageIcon(a82);
        JLabel a8 = new JLabel(a83);
        a8.setBounds(40,120,40,40);
        b8.add(a8);*/

        setLayout(null);
        setSize(700,500);
        setLocation(400,100);
        setUndecorated(true);
        getContentPane().setBackground(new Color(252, 251, 251));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        }else if (e.getSource()==b7){
            System.exit(0);
        } else if (e.getSource()==b2) {
            new Cashout(pin);
            setVisible(false);

        } else if (e.getSource()==b6) {
            new BalanceEnquriy(pin);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new Paybill(pin);
            setVisible(false);
        } else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource()==b4) {
            openJsonParserSwingApp();
            setVisible(false);
        }/*else if (e.getSource()==b8) {
            new mini(pin);
            setVisible(false);
        }*/

    }

    private void openJsonParserSwingApp() {

        JsonParserSwingApp jsonParserApp = new JsonParserSwingApp();


        jsonParserApp.setVisible(true);
    }



    private void fetchDataFromJsonParser() {
        JFrame jsonParserFrame = new JFrame("JSON Parser Display");
        jsonParserFrame.setSize(700, 500);
        jsonParserFrame.setBounds(400, 100, 700, 500);
        jsonParserFrame.setUndecorated(false);
        jsonParserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JsonParserSwingApp jsonParserApp = new JsonParserSwingApp();
        jsonParserFrame.add(jsonParserApp);
        jsonParserFrame.setVisible(true);
    }


    public static void main(String[] args) {
        new main_Class("");
    }
}