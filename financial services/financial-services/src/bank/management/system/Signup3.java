package bank.management.system;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.ExportException;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton s,c;
    String formno;
    JTextField textnum;
    Signup3(String formno){

        this.formno = formno;

        ImageIcon a21 = new ImageIcon(ClassLoader.getSystemResource("icon/info.png"));
        Image a22 = a21.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon a23 = new ImageIcon(a22);
        JLabel a2 = new JLabel(a23);
        a2.setBounds(50,100,80,80);
        add(a2);

        JLabel l1 = new JLabel("Page 3:");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(50,200,400,20);
        l1.setForeground(new Color(252, 251, 251));
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        l2.setBounds(20,250,400,30);
        l2.setForeground(new Color(252, 251, 251));
        add(l2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pink.png"));
        Image i2 = i1.getImage().getScaledInstance(180,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,180,500);
        add(image);


        JLabel lnum = new JLabel("Mobile no:");
        lnum.setFont(new Font("Raleway", Font.BOLD,18));
        lnum.setBounds(200,100,180,30);
        add(lnum);

        textnum = new JTextField();
        textnum.setFont(new Font("Raleway", Font.BOLD,18));
        textnum.setBounds(300,100,350,30);
        add(textnum);

        JLabel l3 = new JLabel("Account Type:");
        l3.setFont(new Font("Raleway",Font.BOLD,16));
        l3.setBounds(200,180,200,30);
        add(l3);

        r1 = new JRadioButton("Personal");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(252, 251, 251));
        r1.setBounds(200,210,100,30);
        add(r1);

        r2 = new JRadioButton("Merchant");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(252, 251, 251));
        r2.setBounds(450,210,100,30);
        add(r2);



        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);



        JLabel l10 = new JLabel("You'r mobile number will be used as your account number");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(300,130,400,20);
        add(l10);

        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway",Font.BOLD,16));
        l11.setBounds(200,250,200,30);
        add(l11);

        c1 = new JCheckBox("Auto Pay");
        c1.setBackground(new Color(252, 251, 251));
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBounds(200,290,100,30);
        add(c1);

        c2 = new JCheckBox("Bank Account");
        c2.setBackground(new Color(252, 251, 251));
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBounds(450,290,150,30);
        add(c2);

        c3 = new JCheckBox("Remitance");
        c3.setBackground(new Color(252, 251, 251));
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBounds(200,330,100,30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(new Color(252, 251, 251));
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBounds(450,330,150,30);
        add(c4);



        JCheckBox c7 = new JCheckBox("I agreed to the terms and policies.",true);
        c7.setBackground(new Color(252, 251, 251));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(200,380,600,20);
        add(c7);

        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway", Font.BOLD,14));
        l12.setBounds(550,10,100,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD,14));
        l13.setBounds(600,10,60,30);
        add(l13);


        s = new RoundedButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD,14));
        s.setBackground(new Color(250, 2, 109));
        s.setForeground(Color.WHITE);
        s.setBounds(300,430,100,30);
        s.addActionListener(this);
        add(s);

        c = new RoundedButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD,14));
        c.setBackground(new Color(250, 2, 109));
        c.setForeground(Color.WHITE);
        c.setBounds(450,430,100,30);
        c.addActionListener(this);
        add(c);


        setLayout(null);
        setSize(700,500);
        setLocation(400,100);
        setUndecorated(true);
        getContentPane().setBackground(new Color(252, 251, 251));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String number = textnum.getText();


        String atype = null;
        if (r1.isSelected()){
            atype = "Personal";
        } else if (r2.isSelected()) {
            atype ="Business";
        }

        Random ran = new Random();

        String cardno=number;

        long first3 = (ran.nextLong() % 9000L)+ 1000L;
        String pin = "" + Math.abs(first3);

        String fac = "";
        if(c1.isSelected()){
            fac = fac+"ATM CARD ";
        } else if (c2.isSelected()) {
            fac = fac+"Internet Banking";
        } else if (c3.isSelected()) {
            fac = fac+"Mobile Banking";
        } else if (c4.isSelected()) {
            fac = fac+"EMAIL Alerts";
        }

        try {
            if (e.getSource()==s){
                if (atype.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else {
                    Connn c1 = new Connn();
                    String q1 = "insert into signupthree values('"+formno+"', '"+atype+"','"+cardno+"','"+pin+"','"+fac+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin : "+pin );
                    new Deposit(pin);
                    setVisible(false);
                }
            } else if (e.getSource()==c) {
                System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
