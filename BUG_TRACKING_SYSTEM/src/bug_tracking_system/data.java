/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bug_tracking_system;

 import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;
/**
 *
 * @author bassant
 */

 

public class data extends JFrame implements ActionListener {
    JTable table;
    JButton back=new JButton("back");

    data() {
        setSize(1000,500);
        setLocation(250,100);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Id");
        l1.setBounds(50, 10, 100, 20);
        add(l1);
 l1.setFont(new Font("Raleway",Font.BOLD,16));
        JLabel l2 = new JLabel("DESCRIBTION");
        l2.setBounds(160, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("PRODUCT");
        l3.setBounds(300, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("ENVIRONMENT");
        l4.setBounds(430, 10, 100, 20);
        add(l4);

        
         JLabel l6 = new JLabel("TYPE");
        l6.setBounds(590, 10, 100, 20);
        add(l6);
         JLabel l7 = new JLabel("NAMES");
        l7.setBounds(720, 10, 100, 20);
        add(l7);
          JLabel l8 = new JLabel("IMPORTANCE");
        l8.setBounds(860, 10, 100, 20);
        add(l8);
         l1.setFont(new Font("Raleway",Font.BOLD,12));
 l2.setFont(new Font("Raleway",Font.BOLD,12));
 l3.setFont(new Font("Raleway",Font.BOLD,12));
 l4.setFont(new Font("Raleway",Font.BOLD,12));
 l6.setFont(new Font("Raleway",Font.BOLD,12));
 l7.setFont(new Font("Raleway",Font.BOLD,12));
 l8.setFont(new Font("Raleway",Font.BOLD,12));

 
     back.setBounds(430,350,100,50);
add(back);
back.addActionListener(this);
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from bug");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e1) {
            e1.printStackTrace();
        }
       
        setVisible(true);
    }

   

    public static void main(String[] args) {
        new data();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new BUG();
        }
   }
}
