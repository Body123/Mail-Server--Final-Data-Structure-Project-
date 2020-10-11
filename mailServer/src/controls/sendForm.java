package controls;

import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import MailSever.*;
import library.PriorityQueueImplementation;
import library.doubleLinkedList;
import library.singlyLinkedList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class sendForm extends javax.swing.JFrame {

    private static String mailName="bb@raa.com";
    private String Subject;
    private String Body = "";
    private Date emailDate;
    private singlyLinkedList Attachments = new singlyLinkedList();
    private singlyLinkedList Urls = new singlyLinkedList();
    private doubleLinkedList recievers = new doubleLinkedList ();
    private doubleLinkedList DeleteSelected = new doubleLinkedList ();
    private doubleLinkedList moveSelected = new doubleLinkedList ();
    private int  indicatorForSortingReicevers=0;
    public String Sender;
    doubleLinkedList mydl=new doubleLinkedList();
    JTable tblOdDelete =new JTable();
    public sendForm() {
        initComponents();
    }
    public sendForm(String name) {
        initComponents();
        this.mailName=name;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttitle = new JTextBox(20);
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBody = new javax.swing.JTextArea();
        rdoBody = new javax.swing.JRadioButton();
        txtSearch = new JTextBox(15);
        btnSearch = new controls.JMyButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        rdoReciever = new javax.swing.JRadioButton();
        rdoTitle = new javax.swing.JRadioButton();
        rdoDate = new javax.swing.JRadioButton();
        rdoPeriority = new javax.swing.JRadioButton();
        cbxUrls = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnBack = new JMyButton();
        cbxRecievers = new javax.swing.JComboBox<>();
        //JComboBox cbxRecievers = new JComboBox();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                try {
                    formWindowOpened(evt);
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                } catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Recievers :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Title :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Body :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Attachement :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("URLS:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Send File");

        txttitle.setEditable(false);

        txtBody.setEditable(false);
        txtBody.setColumns(20);
        txtBody.setRows(5);
        jScrollPane1.setViewportView(txtBody);

        rdoBody.setBackground(new java.awt.Color(255, 255, 255));
        rdoBody.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoBody.setText("Body");
        rdoBody.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoBodyActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
				    btnSearchActionPerformed(evt);
				} catch (ParseException e) {
				    // TODO Auto-generated catch block
				    //JOptionPane.showMessageDialog(null,e.getMessage());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Message Name"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Search By :");

        rdoReciever.setBackground(new java.awt.Color(255, 255, 255));
        rdoReciever.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoReciever.setText("Recievers");

        rdoTitle.setBackground(new java.awt.Color(255, 255, 255));
        rdoTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoTitle.setText("Title");
        rdoTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTitleActionPerformed(evt);
            }
        });

        rdoDate.setBackground(new java.awt.Color(255, 255, 255));
        rdoDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoDate.setSelected(true);
        rdoDate.setText("Date");
        rdoDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDateActionPerformed(evt);
            }
        });

        rdoPeriority.setBackground(new java.awt.Color(255, 255, 255));
        rdoPeriority.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoPeriority.setText("Periority");
        rdoPeriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoContactActionPerformed(evt);
            }
        });

        cbxUrls.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnBackActionPerformed(evt);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
        });
    
        JLabel lblPeriority = new JLabel("Periority :");
        lblPeriority.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtPeriority = new JTextBox(20);
        txtPeriority.setColumns(10);
        txtPeriority.setEditable(false);

        JMyButton btnDelete = new JMyButton();
        btnDelete.setAction(action);
        btnDelete.setText("Delete Selected");
        
        JLabel lblPage = new JLabel("Page ");
        lblPage.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtPage = new JTextBox(10);
        txtPage.setColumns(10);
        txtPage.setText("1");
        
        JButton btnMoveSelected = new JMyButton();
        btnMoveSelected.setAction(action_1);
        btnMoveSelected.setText("Move Selected");
        btnMoveSelected.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnopenAttachement = new JMyButton();
        btnopenAttachement.setAction(action_2);
        btnopenAttachement.setText("Show");
        btnopenAttachement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        JMyButton btnopenURL = new JMyButton();
        btnopenURL.setAction(action_3);
        btnopenURL.setText("Show");
        btnopenURL.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(54)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(jLabel5)
        							.addComponent(jLabel2)
        							.addComponent(jLabel3)))
        					.addComponent(jLabel4))
        				.addComponent(lblPeriority)
        				.addComponent(jLabel1)
        				.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(cbxUrls, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnopenURL, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(txttitle, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
        					.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(cbxRecievers, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(txtPeriority, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jComboBox1, Alignment.LEADING, 0, 160, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnopenAttachement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(25)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel9)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(rdoReciever)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(rdoTitle)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(rdoDate)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(rdoBody)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(rdoPeriority))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(29)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(lblPage)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        								.addGap(40)
        								.addComponent(btnMoveSelected, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        							.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(4)
        					.addComponent(jLabel6))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(83)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addGroup(layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        										.addComponent(jLabel9)
        										.addComponent(rdoReciever)
        										.addComponent(rdoTitle)
        										.addComponent(rdoDate)
        										.addComponent(rdoPeriority)
        										.addComponent(rdoBody))
        									.addGap(34))
        								.addGroup(layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        										.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        										.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        									.addPreferredGap(ComponentPlacement.RELATED)))
        							.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(cbxRecievers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel1))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel2)
        								.addComponent(txttitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel3)
        								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel4)
        								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        									.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addComponent(btnopenAttachement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblPeriority, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtPeriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGap(11)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(btnopenURL, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        									.addComponent(jLabel5)
        									.addComponent(cbxUrls, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
        						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addContainerGap())
        					.addGroup(layout.createSequentialGroup()
        						.addGap(18)
        						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(lblPage)
        							.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addContainerGap()))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(btnMoveSelected, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>

    private void rdoBodyActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) throws NumberFormatException, Exception {
        // TODO add your handling code here:
        IFolder folder=new IFolder();
        doubleLinkedList dl=new doubleLinkedList();
        doubleLinkedList dlAfterSorting=new doubleLinkedList();
        //System.out.println(mailName);
        dl=folder.readIndexFile(mailName, "sent");
        PriorityQueueImplementation pQ = new PriorityQueueImplementation();


        if(rdoReciever.isSelected()) {
        	indicatorForSortingReicevers=1;
            IFilter filter=new IFilter("");
            dlAfterSorting=dl;
            if(!txtSearch.getText().isEmpty()){
                dlAfterSorting=filter.binarySearchEmails3(dl, txtSearch.getText());
            }

        }else if(rdoTitle.isSelected()) {
        	indicatorForSortingReicevers=0;
            ISort sort =new ISort("Subject");
            IFilter filter=new IFilter("Subject");
            dlAfterSorting=sort.sorting(dl);
            if(!txtSearch.getText().isEmpty()){
                dlAfterSorting=filter.binarySearchEmails1(dlAfterSorting, txtSearch.getText());
            }
        }else if(rdoDate.isSelected()) {
        	indicatorForSortingReicevers=0;
            ISort sort =new ISort("date");
            IFilter filter=new IFilter("date");
            SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
            dlAfterSorting=sort.sorting(dl);
            if(!txtSearch.getText().isEmpty()){
            	Date dateH=f.parse((String)  txtSearch.getText());
                dlAfterSorting=filter.binarySearchEmails2(dlAfterSorting,dateH);
            }
        }else if(rdoBody.isSelected()) {
        	indicatorForSortingReicevers=0;
            ISort sort =new ISort("Body");
            IFilter filter=new IFilter("Body");
            dlAfterSorting=sort.sorting(dl);
            if(!txtSearch.getText().isEmpty()){
                dlAfterSorting=filter.linearSearchBody(dlAfterSorting, txtSearch.getText());
            }
        }else if(rdoPeriority.isSelected()) {
        	indicatorForSortingReicevers=0;
            for (int i = 0; i < dl.size(); i++) {
                pQ.insert((IMail)dl.get(i),Integer.parseInt(((IMail)dl.get(i)).periority.toString()));
            }
            for (int i = 0; i < dl.size(); i++) {
                dlAfterSorting.add((IMail)pQ.removeMin());
            }
        }
        DefaultTableModel model= (DefaultTableModel)tbl.getModel();
        model.setRowCount(0);
        
        App AppFinal=new App();
        AppFinal.shownMails=dlAfterSorting;
        IMail mailsFinal[];

        mailsFinal=AppFinal.listEmails(Integer.parseInt(txtPage.getText()));
        doubleLinkedList finalDl=new doubleLinkedList();
        
        for(int b=0;b<mailsFinal.length;b++) {
        	finalDl.add(mailsFinal[b]);
        	System.out.println(mailsFinal[b].folderName);
        }
        
        this.mydl.clear();
        this.mydl=finalDl;
        for(int x=0;x<finalDl.size();x++) {
            Object [] ob=new Object[1];

            ob[0]=(((IMail)mydl.get(x)).folderName).toString();
            model.addRow(ob);
        }
    }

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int row =tbl.getSelectedRow();

        txtBody.setText((((IMail)mydl.get(row)).Body).toString());
        txttitle.setText((((IMail)mydl.get(row)).Subject).toString());
        txtPeriority.setText((((IMail)mydl.get(row)).periority).toString());
        this.Attachments=(((IMail)mydl.get(row)).Attachments);
        this.Urls=(((IMail)mydl.get(row)).Urls);
        this.recievers=(((IMail)mydl.get(row)).savedReceivers);
        jComboBox1.removeAllItems();
        cbxUrls.removeAllItems();
        cbxRecievers.removeAllItems();
        if(indicatorForSortingReicevers==1) {
        	ISort sortingRecievers=new ISort("");
        	this.recievers=sortingRecievers.sorting(this.recievers);
        }
        
        
        for(int z=0;z<(this.recievers.size());z++) {
            cbxRecievers.addItem((String) this.recievers.get(z));
        }

        for(int z=0;z<(this.Attachments.size());z++) {
            this.jComboBox1.addItem((String) this.Attachments.get(z));
        }
        for(int z=0;z<this.Urls.size();z++) {
            this.cbxUrls.addItem(String.valueOf(this.Urls.get(z)));
        }
    }

    private void rdoTitleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void rdoDateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void rdoContactActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) throws NumberFormatException, Exception {
        // TODO add your handling code here:
        btnGroup.add(rdoBody);
        btnGroup.add(rdoPeriority);
        btnGroup.add(rdoDate);
        btnGroup.add(rdoTitle);
        btnGroup.add(rdoReciever);
        rdoBody.setSelected(false);
        rdoTitle.setSelected(false);
        rdoPeriority.setSelected(false);
        rdoDate.setSelected(false);
        rdoReciever.setSelected(true);
        jComboBox1.removeAllItems();
        cbxUrls.removeAllItems();
        cbxRecievers.removeAllItems();
        IFolder folderForBegin=new IFolder();
        doubleLinkedList dl=new doubleLinkedList();
        doubleLinkedList dlAfterSorting=new doubleLinkedList();
        dl=folderForBegin.readIndexFile(mailName, "sent");
        
        System.out.println(dl.size());
        ISort sort =new ISort("date");
        dlAfterSorting=sort.sorting(dl);
        DefaultTableModel model= (DefaultTableModel)tbl.getModel();
        model.setRowCount(0);
        
        App AppFinal=new App();
        AppFinal.shownMails=dlAfterSorting;
        IMail mailsFinal[];

        mailsFinal=AppFinal.listEmails(Integer.parseInt(txtPage.getText()));
        doubleLinkedList finalDl=new doubleLinkedList();
        
        for(int b=0;b<mailsFinal.length;b++) {
        	finalDl.add(mailsFinal[b]);
        }
        
        this.mydl.clear();
        this.mydl=finalDl;
        for(int x=0;x<finalDl.size();x++) {
            Object [] ob=new Object[1];

            ob[0]=(((IMail)mydl.get(x)).folderName).toString();
            model.addRow(ob);
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        this.dispose();
        Tools.openForm(new MainForm(mailName));
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sendForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sendForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sendForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sendForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sendForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbxUrls;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoBody;
    private javax.swing.JRadioButton rdoPeriority;
    private javax.swing.JRadioButton rdoDate;
    private javax.swing.JRadioButton rdoReciever;
    private javax.swing.JRadioButton rdoTitle;
    private javax.swing.JTable tbl;
    private javax.swing.JTextArea txtBody;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txttitle;
    private JTextField txtPeriority;
    private javax.swing.JComboBox<String> cbxRecievers;
    private final Action action = new SwingAction();
    private JTextField txtPage;
    private final Action action_1 = new SwingAction_1();
    private JButton btnopenAttachement;
    private final Action action_2 = new SwingAction_2();
    private final Action action_3 = new SwingAction_3();
    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "SwingAction");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
            DeleteSelected.clear();
            int[] dd=  tbl.getSelectedRows();
            for (int item : dd) {
                DeleteSelected.add(tbl.getValueAt(item, 0));
            }

            //Enter Your Code Here please
            IFolder Fx = new IFolder("data_base//" + mailName + "//trash");
            App J = new App();
            J.contact = mailName;
            J.Type = "sent";
            try {
                J.moveEmails(DeleteSelected,Fx);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Moved to trash");
            dispose();
            Tools.openForm(new sendForm(mailName));

        }
    }
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Move Selected");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			moveSelected.clear();
            int[] dd=  tbl.getSelectedRows();
            for (int item : dd) {
                moveSelected.add(tbl.getValueAt(item, 0));
                System.out.println(tbl.getValueAt(item, 0));
            }

            //Enter Your Code Here please for move
            IFolder Fx = new IFolder("data_base//" + mailName + "//drafts");
            App J = new App();
            J.contact = mailName;
            J.Type = "sent";
            try {
                J.moveEmails(moveSelected,Fx);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Moved to Drefts");
            dispose();
            Tools.openForm(new sendForm(mailName));
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "SwingAction_2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Desktop browser =Desktop.getDesktop();
	        
			
            try {
				browser.browse(new URI((String) jComboBox1.getSelectedItem()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "SwingAction_3");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Desktop browser =Desktop.getDesktop();
	        
			
            try {
            	
				browser.browse(new URI((String)cbxUrls.getSelectedItem()));
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
