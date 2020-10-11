package controls;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import MailSever.IContact;
import MailSever.Tools;

public class MainForm  extends JFrame  implements ActionListener{
	String finalPath="";
	IContact user ;
	JPanel p1;
	JPanel p2;
	private JButton b1=new JMyButton();
	private JButton b2=new JMyButton();
	private JButton b3=new JMyButton();
	private JButton b4=new JMyButton();
	private JButton b5=new JMyButton();
	private JButton b6=new JMyButton();
	JFileChooser fc=new JFileChooser();
	public MainForm(String path) throws IOException{
		this.finalPath+=path;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(300,430);
        this.setTitle("Radwan Mail Server ");
        p1=new JPanel();
        p2=new JPanel();
        p1.setLayout(null);
        this.add(p1);
        p1.setBackground(Color.white);
        
        b1.setText("+ Compose");
        b2.setText("inbox");
        b3.setText("sent");
        b4.setText("drafts");
        b5.setText("trash");
        b6.setText("contacts");
        b1.setBounds(70, 50, 150, 40);
        b2.setBounds(70, 100, 150, 40);
        b3.setBounds(70, 150, 150, 40);
        b4.setBounds(70, 200, 150, 40);
        b5.setBounds(70, 250, 150, 40);
        b6.setBounds(70, 300, 150, 40);
        
        
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
        

    }
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == b1) {
	        	Tools.openForm(new composeForm(finalPath));
	        	//finalPath+="\\";
	        	//finalPath+="+ Compose";
	        	this.dispose();
	        	
	        }else if (e.getSource() == b2) {
	        	Tools.openForm(new inboxForm(finalPath));
	        	finalPath+="\\";
	        	finalPath+="inbox";
			    this.dispose();
	        }else if (e.getSource() == b3) {
	        	Tools.openForm(new sendForm(finalPath));
	        	finalPath+="\\";
	        	finalPath+="sent";
			    this.dispose();
	        }else if (e.getSource() == b4) {
	        	
	        	Tools.openForm(new draftForm(finalPath));
	        	finalPath+="\\";
	        	finalPath+="drafts";
			    this.dispose();
	        }else if (e.getSource() == b5) {
	        	Tools.openForm(new TrashForm(finalPath));
	        	finalPath+="\\";
	        	finalPath+="trash";
			    this.dispose();
	        }else if (e.getSource() == b6) {
	        	Tools.openForm(new contactForm(finalPath));
	        	finalPath+="\\";
	        	finalPath+="contacts";
			    this.dispose();
	        }
	        //System.out.println(finalPath);
        
	}
	
	
	public void disableNewFolderButton( Container c ) {

	     System.out.print("in disable fn");
	int len = c.getComponentCount();
	for (int i = 0; i < len; i++) {
	  Component comp = c.getComponent(i);
	  if (comp instanceof JButton) {
	    JButton b = (JButton)comp;
	    Icon icon = b.getIcon();
	    if (icon != null
	         && icon == UIManager.getIcon("FileChooser.newFolderIcon"))
	    {
	        System.out.print("in disable fn");
	       b.setEnabled(false);
	    }
	    }
	  else if (comp instanceof Container) {
	    disableNewFolderButton((Container)comp);
	  }
	}
	 }
}
