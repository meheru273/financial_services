package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox,comboBox2,comboBox3,comboBox5;
    JTextField textAadhar;
    JButton next;
    String formno;
    Signup2(String formno){
        super("APPLICATION FORM");

        this.formno = formno;

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/sign2.png"));
        Image ii2 = ii1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(40,100,80,80);
        add(iimage);


        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Raleway", Font.BOLD,18));
        l1.setBounds(50,200,400,40);
        l1.setForeground(new Color(252, 251, 251));
        add(l1);

        JLabel l2 = new JLabel("Additonal Details");
        l2.setFont(new Font("Raleway", Font.BOLD,18));
        l2.setBounds(20,250,300,40);
        l2.setForeground(new Color(252, 251, 251));
        add(l2);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pink.png"));
        Image i2 = i1.getImage().getScaledInstance(180,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,180,500);
        add(image);





        JLabel l4 = new JLabel("Category : ");
        l4.setFont(new Font("Raleway", Font.BOLD,18));
        l4.setBounds(200,170,100,30);
        add(l4);

        String Category [] = {"personal","business","professional", "student", "Other"};
        comboBox2 = new JComboBox(Category);
        comboBox2.setBackground(new Color(252, 251, 251));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(400,170,250,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income : ");
        l5.setFont(new Font("Raleway", Font.BOLD,18));
        l5.setBounds(200,220,100,30);
        add(l5);

        String income [] = {"Null","<1,50,00 tk","<2,50,00 tk", "5,00,00 tk<",
                "Upt0 10,00,00 tk","Above 10,00,00 tk"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(252, 251, 251));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(400,220,250,30);
        add(comboBox3);




        JLabel l7 = new JLabel("Occupation : ");
        l7.setFont(new Font("Raleway", Font.BOLD,18));
        l7.setBounds(200,270,150,30);
        add(l7);

        String Occupation [] = {"Service Holder","Self-Employed","Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox(Occupation);
        comboBox5.setBackground(new Color(252, 251, 251));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(400,270,250,30);
        add(comboBox5);



        JLabel l9 = new JLabel("NID no:");
        l9.setFont(new Font("Raleway", Font.BOLD,18));
        l9.setBounds(200,330,180,30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD,18));
        textAadhar.setBounds(400,320,250,30);
        add(textAadhar);



        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway", Font.BOLD,14));
        l12.setBounds(700,10,100,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD,14));
        l13.setBounds(760,10,60,30);
        add(l13);

        next = new RoundedButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(new Color(250, 2, 109));
        next.setForeground(Color.WHITE);
        next.setBounds(570,400,100,30);
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

        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String addhar = textAadhar.getText();


        try{
            if (textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }else {
                Connn c = new Connn();
                String q = "insert into Signuptwo values('" + formno + "','" + cate + "','" + inc + "','" + occ + "','" + addhar + "')";

                c.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
