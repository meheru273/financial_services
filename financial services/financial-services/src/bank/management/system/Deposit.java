package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
   String pin;
   TextField textField;

   JButton b1, b2;
    Deposit(String pin){
        this.pin = pin;


        ImageIcon a21 = new ImageIcon(ClassLoader.getSystemResource("icon/cashout.png"));
        Image a22 = a21.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon a23 = new ImageIcon(a22);
        JLabel a2 = new JLabel(a23);
        a2.setBounds(40,200,100,100);
        add(a2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pink.png"));
        Image i2 = i1.getImage().getScaledInstance(180,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,180,500);
        add(image);

        JLabel label1 = new JLabel("ENETR AMOUNT YOU WANT TO CASHIN");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(210,180,400,35);
        add(label1);

        textField = new TextField();
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        textField.setBounds(210,230,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        add(textField);

        b1 = new RoundedButton("Enter");
        b1.setBounds(400,362,150,35);
        b1.setBackground(new Color(250, 2, 109));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new RoundedButton("BACK");
        b2.setBounds(400,406,150,35);
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
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource()==b1){
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Cash in");
                }else {
                    Connn c = new Connn();
                    c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"','Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Entered Successfully");
                    setVisible(false);
                    new main_Class(pin);
                }
            }else if (e.getSource()==b2){
                setVisible(false);
                new main_Class(pin);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
