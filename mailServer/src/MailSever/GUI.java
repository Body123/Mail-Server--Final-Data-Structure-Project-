package MailSever;

import javax.swing.*;

import controls.JPasswordBox;
import controls.JTextBox;
import controls.MainForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {
    private JPanel p1,p2;
    private JButton signin=new controls.JMyButton();
    private JButton signup=new controls.JMyButton();
    private JTextBox t1;
    private JPasswordBox t2;
    private Label l1,l2,l3;
    String s1 ;
    String s2 ;


    public GUI() {
    	signin.setText("Sign In");
    	signup.setText("Sign Up");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(500,500);
        this.createUIComponents();
        this.setTitle("Mail Server ");

       p1= new JPanel();
       p2=new JPanel();
       t1=new controls.JTextBox(20);
       t2=new controls.JPasswordBox(20);
       l1=new Label();
       l2=new Label();
       l3=new Label();
       l3.setText("Login Form ");
       l1.setText("ID:");
       l1.setFont(new Font("",Font.BOLD,22));
       l2.setText("Password:");
       l2.setFont(new Font("",Font.BOLD,22));
       l3.setFont(new Font("",Font.BOLD,22));
       p1.setBackground(Color.white);
       p2.setBackground(Color.white);
       this.setLayout(new GridLayout(2,1));
       this.add(p1);
       signin.setBounds(100,180,100,40);
       signup.setBounds(240,180,100,40);
       t1.setBounds(168,80,150,20);
       t2.setBounds(168,120,150,20);
       l1.setBounds(135,80,150,20);
       l2.setBounds(55,120,150,20);
       l3.setBounds(180,10,180,40);
       
       
       
       p1.setLayout(null);
       p1.add(l3);
       p1.add(signin);
       p1.add(signup);
       p1.add(t1);
       p1.add(t2);
       p1.add(l1);
       p1.add(l2);
       signup.addActionListener(this);
       signin.addActionListener(this);
    }

    private void createUIComponents() {

        // TODO: place custom component creation code here
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            try {
                s1 = t1.getText();
                s2 = t2.getText();
                IContact c1 = new IContact(s1, s2);
                App x = new App();
                if (!x.signup(c1)) {
                    //default title and icon
                    JOptionPane.showMessageDialog(null,
                            "invalid name or password");
                }else {
                	if(x.signin(s1,s2)){
                	this.setVisible(false);
                    Tools.openForm(new MainForm(t1.getText()));
                	}
                }
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == signin) {
            s1 = t1.getText();
            s2 = t2.getText();
            App x=new App();
            try {
				if(x.signin(s1,s2)){this.setVisible(false);
				try {
					Tools.openForm(new MainForm(t1.getText()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else {
				    //default title and icon
				    JOptionPane.showMessageDialog(null,
				            "invalid name or password");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }

}
