/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bug_tracking_system;

import com.sun.jdi.connect.spi.Connection;
import java.awt.*;
import java.sql.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author bassant
 */
public class BUG extends JFrame implements ActionListener{
    
    String regex = "[0-9]+";
    JLabel l1=new JLabel("BUG TRACKING SYSTEM");
        JLabel l2=new JLabel("BUG ID");
    JLabel l3=new JLabel("PRODUCT");
    JLabel l4=new JLabel("ENVIRONMENT");
    JLabel l5=new JLabel("TYPE");
    JLabel l6=new JLabel("STATUS");
        JLabel l7=new JLabel("DESCRIPTION");
         JLabel l8=new JLabel("BUG IMPORTANCE");
         JLabel l9=new JLabel("DEVELOPER NAME");
       
JLabel l10=new JLabel();
   String s []={"html edit","css edit","javascript edit"};
   String s1 []={"windows","linux","mac"};
   String s2 []={"database","gui","others"};
    String s3 []={"high","medium","low"};
    JComboBox c1=new JComboBox(s);
        JComboBox c2=new JComboBox(s1);
        JComboBox c3=new JComboBox(s2);
 JComboBox c4=new JComboBox(s3);
     JTextField f1=new JTextField();
          JTextField f2=new JTextField();
          JButton b1=new JButton("add ");
                    JButton b2=new JButton("update");
          JButton b3=new JButton("delete");
          JButton b4=new JButton("show bugs");
           JTextField f3=new JTextField();

                 

BUG(){
    setLayout(null);
    setSize(600,600);
    setResizable(false);
//  ImageIcon background=new ImageIcon("bug.jpg");
//    Image img=background.getImage();
//    Image temp=img.getScaledInstance(600,500,Image.SCALE_SMOOTH);
//    background=new ImageIcon(temp);
//    JLabel back=new JLabel(background);
//    back.setLayout(null);
//    back.setBounds(0,0,600,500);
setLocation(250,50);
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

l1.setBounds(200,10,500,50);
  add(l1);
 l2.setBounds(30,80,50,20);
 add(l2);
 f1.setBounds(140,75,150,30);
 add(f1);
  l3.setBounds(30,110,100,30);
 add(l3);
c1.setBounds(140,115,150,25);
  add (c1);

  l5.setBounds(30,150,150,30);
 add(l5);
  c3.setBounds(140,155,150,25);
 add(c3);
 l4.setBounds(30,190,150,30);
 add(l4);
 c2.setBounds(140,195,150,25);
 add(c2);
  
   l7.setBounds(30,230,150,30);
  add(l7);
  
  l9.setBounds(30,350,150,30);
  add(l9);
  
  f3.setBounds(140,350,150,30);
 add(f3);
 
 
// java.util.Date date=new java.util.Date();
//       l10 =new JLabel(""+date);
//        l10.setBounds(140,350,260,25);
//        l10.setFont(new Font("Raleway",Font.ITALIC,16));
//        add(l10);
 
        l8.setBounds(30,400,150,30);
  add(l8);
  
  c4.setBounds(140,403,130,25);
 add(c4);
  f2.setBounds(140,230,150,100);
  add(f2);
 b1.setBounds(30,480 , 100, 60);
 add(b1);
 b1.addActionListener(this);
  b2.setBounds(160,480 , 100, 60);
  add(b2);
  b2.addActionListener(this);
  b3.setBounds(290,480 , 100, 60);
  add(b3);
  b3.addActionListener(this);

b4.setBounds(420,480 , 100, 60);
  add(b4);
  b4.addActionListener(this);

setVisible(true);  

    
    
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String id=f1.getText();
      String describtion=f2.getText();
String product= (String) c1.getSelectedItem();  
   String environment= (String) c2.getSelectedItem();  
    String typ= (String) c3.getSelectedItem();  
    String time=l10.getText().toString();
   String name= f3.getText().toString();
    String importa= (String) c4.getSelectedItem();  
            if(e.getSource()==b1){
           if(f1.getText().isEmpty()||f2.getText().isEmpty()||f3.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"please fill empty fields"); 
           }else if(id.matches(regex)){
           
                connection conn =new connection();
                   String query ="insert into bug values('"+id+"','"+describtion+"','"+product+"','"+environment+"','"+typ+"','"+name+"','"+importa+"')";
                
                try {
                  conn.s.executeUpdate(query);
               } catch (SQLException ex) {
                    Logger.getLogger(BUG.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
                   JOptionPane.showMessageDialog(null,"bug added successfully"); 
                }else{
                                  JOptionPane.showMessageDialog(null,"please input correct id"); 

               
           }
                
            }
                
        if(e.getSource()==b2){
            connection conn =new connection();
                  String id1=f1.getText();
                   String query="select * from bug where id = '"+id1+"'";
          
             ResultSet rs1;
            try {
                rs1 = conn.s.executeQuery(query);
          
                if(rs1.next()){
                    
                    String describtion1=f2.getText();
                    String product1= (String) c1.getSelectedItem();
                    String environment1= (String) c2.getSelectedItem();
                    String typ1= (String) c3.getSelectedItem();
                    String time1=l10.getText().toString();
   String name1= f3.getText().toString();
    String importa1= (String) c4.getSelectedItem();  
//             connection conn =new connection();
try {
    conn.s.executeUpdate("update bug set describtion ='"+describtion1+"', product1 = '"+product1+"', environment1 = '"+environment1+"' , typ = '"+typ1+"',DEVELOPER_NAME = '"+name1+"',BUG_IMPORTANCE = '"+importa1+"' where id = '"+id1+"'");
} catch (SQLException ex) {
    Logger.getLogger(BUG.class.getName()).log(Level.SEVERE, null, ex);
}

JOptionPane.showMessageDialog(null, "bug Updated Successfully");

                }else{
                    JOptionPane.showMessageDialog(null, "please enter correct Id");
                    
                }} catch (SQLException ex) {   
                Logger.getLogger(BUG.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(e.getSource()==b3){
           
            connection conn =new connection();
              String id2=f1.getText();
              if(id2.isEmpty()){
                                              JOptionPane.showMessageDialog(null, "please enter your id");

              }else if(id.matches(regex)){
                  
                  
              
               
          
            
                 try{
                conn.s.executeUpdate("delete from bug where id = '"+id2+"'");
                            JOptionPane.showMessageDialog(null, "bug deleted Successfully");
              
            } catch (SQLException ex) {
                Logger.getLogger(BUG.class.getName()).log(Level.SEVERE, null, ex);
            }
              }else{
                                              JOptionPane.showMessageDialog(null, "please enter correct id");

                  
              }
        }else if(e.getSource()==b4){
         setVisible(false);
        new data();
        }
    }
 public static void main(String[] args) {
        new BUG();
    }
 
    
    




}