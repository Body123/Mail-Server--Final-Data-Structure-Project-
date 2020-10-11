package MailSever;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signin extends javax.swing.JFrame{
    String email;
    JPanel p1;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    Signin(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(500,600);
        this.createUIComponents();
        this.setTitle("Radwan Mail Server ");
        p1=new JPanel();
        b1=new JButton("+ Compose");
        b2=new JButton("inbox");
        b3=new JButton("sent");
        b4=new JButton("drafts");
        b5=new JButton("trash");
        b6=new JButton("contacts");
        this.setLayout(new GridLayout(1,1));
        this.add(p1);

        p1.setLayout(null);
        b1.setBounds(20,20,100,20);
        b2.setBounds(20,40,100,20);
        b3.setBounds(20,60,100,20);
        b4.setBounds(20,80,100,20);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b6);
        p1.setBackground(Color.RED);

        p1.setLayout(null);


    }

    private void createUIComponents() {
    }
}
