package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin){
        this.pin =pin;

        ImageIcon a21 = new ImageIcon(ClassLoader.getSystemResource("icon/settings.png"));
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

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Arial", Font.BOLD, 25));
        label1.setBounds(300,80,400,35);
        add(label1);


        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setBounds(200,220,150,35);
        add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(252, 252, 250));
        p1.setForeground(Color.BLACK);
        p1.setBounds(350,220,300,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("Black", Font.BOLD, 16));
        label3.setBounds(200,280,400,35);
        add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(252, 251, 251));
        p2.setForeground(Color.BLACK);
        p2.setBounds(350,280,300,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        add(p2);

        label3 = new JLabel("Use characters and symbols to make password stronger");
        label3.setFont(new Font("Ralway", Font.BOLD, 10));
        label3.setForeground(Color.BLACK);
        label3.setBounds(360,300,375,30);
        add(label3);



        b1 = new RoundedButton("CHANGE");
        b1.setBounds(260,380,150,35);
        b1.setBackground(new Color(250, 2, 109));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new RoundedButton("BACK");
        b2.setBounds(460,380,150,35);
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

        try{

            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }

                Connn c = new Connn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new main_Class(pin);

            } else if (e.getSource()==b2) {
                new main_Class(pin);
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new Pin("");
    }
}
