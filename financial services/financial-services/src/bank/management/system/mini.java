package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    mini(String pin){

        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pink.png"));
        Image i2 = i1.getImage().getScaledInstance(180,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,180,500);
        add(image);

        JLabel label1 = new JLabel();
        label1.setBounds(200,140,400,200);
        add(label1);

        JLabel label2 = new JLabel("Transaction History");
        label2.setFont(new Font("System", Font.BOLD,22));
        label2.setBounds(300,50,300,30);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(200,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(200,360,300,20);
        add(label4);

        button = new RoundedButton("Exit");
        button.setBounds(400,420,100,25);
        button.addActionListener(this);
        button.setBackground(new Color(250, 2, 109));
        button.setForeground(Color.WHITE);
        add(button);

        setLayout(null);
        setSize(700,500);
        setLocation(400,100);
        setUndecorated(true);
        getContentPane().setBackground(new Color(252, 251, 251));
        setVisible(true);

        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while (resultSet.next()){
                label3.setText("Card Number:  "+ resultSet.getString("card_number").substring(0,4) + "XXXXXXXX"+ resultSet.getString("card_number").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
            int balance =0;
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is Tk. "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new mini("");
    }
}
