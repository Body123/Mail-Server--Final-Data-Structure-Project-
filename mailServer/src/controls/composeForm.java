package controls;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.MalformedParametersException;
import java.net.MalformedURLException;
import java.net.URL;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import MailSever.IFolder;
import MailSever.IMail;
import MailSever.Tools;
import MailSever.App;
import library.queueLinkedListImplementation;
import library.singlyLinkedList;

public class composeForm  extends JFrame implements ActionListener {
	int numberOfReciever=0;
	int numberOfAtat=0;
	int numberOfURl=0;
	String mailSender="bb@raa.com";
	String EmailOfReciever="";
	String title ="";
	String Body="";
	singlyLinkedList Attachment = new singlyLinkedList();
	private JPanel p1=new JPanel();
	private JButton btnSend=new JMyButton();
	private JButton btnAddReciever=new JMyButton();
	private JButton btnAddURLs=new JMyButton();
	private JButton btnInsertAttach=new JMyButton();
	private JButton btnBack=new JMyButton();
	private Label l1,l2,l3,l4,l5,l6;
	private Label l7=new Label();
	private JComboBox cbxReciever=new JComboBox();
	private JComboBox cbxURLS=new JComboBox();
	private JComboBox cbxPeriority=new JComboBox();
	private JComboBox cbxAttach=new JComboBox();
	private JTextBox txtTitle=new JTextBox(40);
	private JTextArea txtBody=new  JTextArea();
	private JTextArea t4=new  JTextArea();
	
	public composeForm(String mailSender) {
		this.mailSender=mailSender;
		//System.out.println(this.mailSender);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(500,600);
        p1= new JPanel();
        p1.setLayout(null);
        this.add(p1);
        btnAddReciever.setText("+");
        btnAddURLs.setText("+");
        btnInsertAttach.setText("Insert");
        btnBack.setText("Back");
        btnAddReciever.setBounds(340,70,50,25);
        btnAddURLs.setBounds(340,440,50,25);
        btnInsertAttach.setBounds(411,350,67,25);
        l1=new Label();
        l2=new Label();
        l3=new Label();
        l4=new Label();
        l5=new Label();
        l6=new Label();
        l1.setText("Compose Message ");
        l2.setText("Reciever :");
        l3.setText("Title :");
        l4.setText("Body :");
        l5.setText("Attachement :");
        l6.setText("Add URL :");
        l7.setText("periority :");
        l1.setFont(new Font("",Font.BOLD,20));
        l2.setFont(new Font("",Font.BOLD,20));
        l3.setFont(new Font("",Font.BOLD,20));
        l4.setFont(new Font("",Font.BOLD,20));
        l5.setFont(new Font("",Font.BOLD,17));
        l5.setFont(new Font("",Font.BOLD,17));
        l6.setFont(new Font("",Font.BOLD,17));
        l7.setFont(new Font("",Font.BOLD,17));
        p1.setBackground(Color.white);
        l1.setBounds(140,10,250,30);
        l2.setBounds(40,70,100,20);
        l3.setBounds(40,100,100,20);
        l4.setBounds(40,140,100,40);  
        l5.setBounds(40,343,120,40);
        l6.setBounds(40,430,120,40);
        l7.setBounds(40,380,120,40);
        cbxPeriority.setBounds(160,390,230,20);
        cbxURLS.setBounds(160,440,170,20);
        cbxReciever.setBounds(160,70,170,20);
        txtTitle.setBounds(160,100,170,20);
        txtBody.setBounds(160,145,250,150);
        cbxAttach.setBounds(160,345,230,30);
        t4.setBounds(160,330,250,75);
        btnBack.setBounds(250,500,70,40);
        txtBody.setFont(new Font("",Font.BOLD,12));
        txtBody.setBackground(Color.LIGHT_GRAY);
        t4.setFont(new Font("",Font.BOLD,12));
        t4.setBackground(Color.LIGHT_GRAY);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(cbxURLS);
        p1.add(cbxReciever);
        p1.add(cbxAttach);
        p1.add(txtTitle);
        p1.add(btnAddReciever);
        p1.add(btnAddURLs);
        p1.add(btnBack);
        p1.add(btnInsertAttach);
        p1.add(cbxPeriority);
        t4.setEditable(false);
        //p1.add(t3);
        //p1.add(t4);
        btnSend.setText("Send");
    	btnSend.setBounds(160,500,70,40);
    	p1.add(btnSend);
        JScrollPane scroll = new JScrollPane ( txtBody );
    	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	scroll.setBounds(160, 145, 250, 159);
    	JScrollPane scroll2 = new JScrollPane ( t4 );
    	scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	scroll2.setBounds(160, 330, 250, 75);
    	p1.add(scroll);
    	//p1.add(scroll2);
    	btnSend.addActionListener(this);
    	btnAddReciever.addActionListener(this);
    	btnAddURLs.addActionListener(this);
    	btnBack.addActionListener(this);
    	btnInsertAttach.addActionListener(this);
    	cbxPeriority.addItem(1);cbxPeriority.addItem(2);
    	cbxPeriority.addItem(3);cbxPeriority.addItem(4);
    	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSend) {
			
			//System.out.println(txtBody.getText());
			try {
				IMail mail=new IMail();
				 
			     singlyLinkedList Url = new singlyLinkedList();
			     queueLinkedListImplementation receiver = new queueLinkedListImplementation();
			     
			     for(int i=0; i<numberOfReciever;i++) {
			     	 App y = new App();
			     	 if(y.checkNewContact(cbxReciever.getItemAt(i).toString()))
			    	 	receiver.enqueue(cbxReciever.getItemAt(i));
			     }
			     
			     for(int i=0; i<numberOfURl;i++) {
			     	try {

						Url.add(new URL((String) cbxURLS.getItemAt(i)));
					} catch (MalformedURLException e1){}

			     }
			     mail.Subject=txtTitle.getText();
			     mail.Body=txtBody.getText();
			     mail.Sender=mailSender;
			     mail.Attachments=Attachment;
			     mail.receivers=receiver;
			     mail.Urls=Url;
			     //System.out.println((String) cbxPeriority.getSelectedItem());
			     Object per=cbxPeriority.getSelectedItem();
			     
			     mail.periority= per;
			     mail.sendMail();
			     IFolder folders=new IFolder();
			     
			     
			     
			     if(numberOfReciever==0) {
			    	 JOptionPane.showMessageDialog(null, "Message saved in drafts");
			     }
			     this.dispose();
			     Tools.openForm(new MainForm(mailSender));
			     
			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}else if(e.getSource() == btnAddReciever) {
			String mail="";
			mail= (String) Tools.inputBox("Enter Reciver Mail");
			App appObj=new App();
			if(appObj.checkNewContact(mail)) {
				cbxReciever.addItem(mail);
				numberOfReciever++;
			}else {
	    		JOptionPane.showMessageDialog(null, "there is no user with this mail");
			}
			
		}else if(e.getSource() == btnAddURLs) {
			String mail="";
			mail= (String) Tools.inputBox("Enter URl");
			cbxURLS.addItem(mail);
			numberOfURl++;
		}else if(e.getSource() == btnBack) {
			this.dispose();
			try {
				Tools.openForm(new  MainForm(mailSender));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == btnInsertAttach) {
			JFileChooser fc=new JFileChooser();
			fc.showDialog(btnInsertAttach, "Choose File");
			String pathAttach=fc.getSelectedFile().toURI().toString();
			cbxAttach.addItem(pathAttach);
			Attachment.add(pathAttach);
			numberOfAtat++;
		}
		
	}
	
}
