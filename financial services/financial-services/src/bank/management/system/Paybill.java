package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Paybill extends JFrame implements ActionListener {

    String pin;
    TextField textField;

    JButton b1, b2;
    JRadioButton c1,c2,c3,c4;

    JDateChooser dateChooser;
    Paybill(String pin){
        this.pin=pin;

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/fire.png"));
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

        JLabel label = new JLabel("Pay Your bills");
        label.setBounds(340,20,700,35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("System",Font.BOLD,22));
        add(label);


        JLabel l11 = new JLabel("Service Type:");
        l11.setFont(new Font("Raleway",Font.BOLD,16));
        l11.setBounds(200,50,200,30);
        add(l11);



        c1 = new JRadioButton("Electricity");
        c1.setBackground(new Color(252, 251, 251));
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBounds(200,120,100,30);
        add(c1);


        c2 = new JRadioButton("Gas");
        c2.setBackground(new Color(252, 251, 251));
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBounds(450,120,150,30);
        add(c2);


        c3 = new JRadioButton("Water");
        c3.setBackground(new Color(252, 251, 251));
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBounds(200,180,100,30);
        add(c3);

        c4 = new JRadioButton("Inter net");
        c4.setBackground(new Color(252, 251, 251));
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBounds(450,180,150,30);
        add(c4);

        JLabel DOB = new JLabel("Date:");
        DOB.setFont(new Font("Arial", Font.BOLD, 16));
        DOB.setBounds(200,240,200,20);
        add(DOB);
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(252, 251, 251));
        dateChooser.setBounds(360,240,300,25);
        add(dateChooser);

        JLabel label2 = new JLabel("Reference Number :");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setBounds(200,300,150,35);
        add(label2);


        textField = new TextField();
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(Color.BLACK);
        textField.setBounds(360,300,300,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        add(textField);

        JLabel labeli = new JLabel("Cash amount :");
        labeli.setForeground(Color.BLACK);
        labeli.setFont(new Font("Arial", Font.BOLD, 16));
        labeli.setBounds(200,360,150,35);
        add(labeli);


        textField = new TextField();
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(Color.BLACK);
        textField.setBounds(360,360,300,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        add(textField);

        b1 = new RoundedButton("Enter");
        b1.setBounds(270,430,150,35);
        b1.setBackground(new Color(250, 2, 109));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new RoundedButton("BACK");
        b2.setBounds(450,430,150,35);
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


        String atype = null;
        if (c1.isSelected()){
            atype += "Current";
        } else if (c2.isSelected()) {
            atype +="Gas";
        }else if (c3.isSelected()){
            atype+="Water";
        }else if (c4.isSelected()){
            atype += "Internet";
        }

        if(e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
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

                    String q2="insert into bill values('"+pin+"','"+atype+"')";

                    c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Paid Successfully");
                    c.statement.executeUpdate(q2);
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
        new Paybill("");
    }
}
