package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1,r2,m1,m2,m3;
    JButton next;

    JTextField textName ,textFname, textEmail,textAdd,textcity,textState,textPin;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 =(ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);
    Signup(){
        super ("APPLICATION FORM");
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/sign1.png"));
        Image ii2 = ii1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(40,100,80,80);
        add(iimage);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway",Font.BOLD, 15));
        label2.setBounds(60,220,400,20);
        label2.setForeground(new Color(252, 251, 251));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD,16));
        label3.setBounds(30,250,400,30);
        label3.setForeground(new Color(252, 251, 251));
        add(label3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pink.png"));
        Image i2 = i1.getImage().getScaledInstance(180,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,180,500);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+ first);
        label1.setBounds(200,20,300,20);
        label1.setFont(new Font("Arial",Font.BOLD,16));
        add(label1);



        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 18));
        labelName.setBounds(200,130,100,20);
        add(labelName);
        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD, 18));
        textName.setBounds(350,130,300,25);
        add(textName);


        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(new Font("Raleway", Font.BOLD, 18));
        DOB.setBounds(200,180,200,20);
        add(DOB);
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(252, 251, 251));
        dateChooser.setBounds(350,180,300,25);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Raleway", Font.BOLD, 18));
        labelG.setBounds(200,230,200,25);
        add(labelG);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(255, 255, 255));
        r1.setBounds(350,230,60,25);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(252, 251, 251));
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBounds(500,230,90,30);
        add(r2);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 18));
        labelEmail.setBounds(200,280,200,25);
        add(labelEmail);
        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD, 14));
        textEmail.setBounds(350,280,300,25);
        add(textEmail);





        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 18));
        labelAdd.setBounds(200,330,200,25);
        add(labelAdd);
        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD, 14));
        textAdd.setBounds(350,330,300,25);
        add(textAdd);





        next = new RoundedButton("Next");
        next.setFont(new Font("Arial",Font.BOLD, 14));
        next.setBackground(new Color(250, 2, 109));
        next.setForeground(Color.WHITE);
        next.setBounds(450,400,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(700,500);
        setLocation(400,100);
        setUndecorated(true);
        getContentPane().setBackground(new Color(252, 251, 251));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if (r2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();

        String address = textAdd.getText();


        try{
            if (textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }else {
                Connn c = new Connn();
                String q = "insert into signup values('"+formno+"', '"+name+"','"+dob+"','"+gender+"','"+email+"', '"+address+"' )";
                c.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup();
    }
}
