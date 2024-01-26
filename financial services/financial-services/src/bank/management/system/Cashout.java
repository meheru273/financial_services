package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Cashout extends JFrame implements ActionListener {

    String pin;
    TextField textField;

    JButton b1, b2;
    Cashout(String pin){
        this.pin=pin;

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/getmoney.png"));
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

        JLabel label1 = new JLabel("MAXIMUM CASH-OUT IS TK.30,000");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setBounds(250,100,700,35);
        add(label1);


        JLabel label2 = new JLabel("Agent's number :");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setBounds(250,150,400,35);
        add(label2);


        textField = new TextField();
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(Color.BLACK);
        textField.setBounds(250,200,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        add(textField);

        JLabel labeli = new JLabel("Cash amount :");
        labeli.setForeground(Color.BLACK);
        labeli.setFont(new Font("Arial", Font.BOLD, 16));
        labeli.setBounds(250,250,400,35);
        add(labeli);


        textField = new TextField();
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(Color.BLACK);
        textField.setBounds(250,300,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        add(textField);

        b1 = new RoundedButton("Enter");
        b1.setBounds(270,380,150,35);
        b1.setBackground(new Color(250, 2, 109));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new RoundedButton("BACK");
        b2.setBounds(450,380,150,35);
        b2.setBackground(new Color(250, 2, 109));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setSize(700,500);
        setLocation(400,100);
        setUndecorated(true);
        getContentPane().setBackground(new Color(252, 251, 251));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to get");
                } else {
                    Connn c = new Connn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Cashed Out Successfully");
                    setVisible(false);
                    new main_Class(pin);

                }
            } catch (Exception E) {

            }
        } else if (e.getSource()==b2) {
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Cashout("");
    }
}
