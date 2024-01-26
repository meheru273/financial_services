package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {

    String pin;
    JLabel label2;
    JButton b1;
    BalanceEnquriy(String pin){
        this.pin =pin;

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(40,200,100,100);
        add(iimage);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pink.png"));
        Image i2 = i1.getImage().getScaledInstance(180,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,180,500);
        add(image);

        JLabel label1 = new JLabel("Your Current Balance is taKa :");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(250,180,300,35);
        add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("System", Font.BOLD, 21));
        label2.setBounds(550,180,400,35);
        //l3.add(label2);
        add(label2);

        b1 = new RoundedButton("Back");
        b1.setBounds(300,350,150,35);
        b1.setBackground(new Color(250, 2, 109));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        int balance =0;
        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);


        setLayout(null);
        setSize(700,500);
        setLocation(400,100);
        setUndecorated(true);
        getContentPane().setBackground(new Color(252, 251, 251));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}
