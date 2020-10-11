package MailSever;
import library.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class IContact {

    private String name;
    private String pw;
    public singlyLinkedList stk=new singlyLinkedList();
     public  IContact(String name1,String pw) throws Exception {
    	this.name=name1;
     	name1=name1.toLowerCase();
     	boolean cheakerId=Pattern.matches("\\w+@raa.com", name1);
     	boolean cheakerPass=Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[-@#$%^&+=])[a-zA-Z0-9-@#$%^&+=]{8,}", pw);
         if(cheakerId){
             if (cheakerPass) {
                 BufferedReader br = null;
                 int counter = 0;
                 br = new BufferedReader(new FileReader("data_base/accounts/ID.txt"));
                 for (int i = 0; br.readLine() != null; i++) {
                     counter++;
                 }
                 br = new BufferedReader(new FileReader("data_base//accounts//ID.txt"));
                 for (int i = 0; i < counter; i++) {
                     stk.add(i, br.readLine());
                 }
                 this.name = name1;
                 this.pw = pw;
             }else {
            	 JOptionPane.showMessageDialog(null, "Enter password that has atleast small letter and capitel letter and number and sympol of @#$%^&+= and large than 8 digits ");
            	 throw new Exception("invalid password");
             }
         }
         else {
        	 JOptionPane.showMessageDialog(null,"Invalid ID");
        	 throw new Exception("invalid ID");
         }
     }
            public boolean exist(){
            for(int i=0;i<stk.size;i++){
                if(i%2==0){
                    if(name.equals((String) stk.get(i))){
                        if(pw.equals((String)stk.get(i+1))){
                        return true;}
                    }
                }
            }
            return false;
            }
    public boolean exist_signup(){
        for(int i=0;i<stk.size;i++){
            if(i%2==0){
                if(name.equals((String) stk.get(i))){
                   return true;
                }
            }
        }
        return false;
    }


    public singlyLinkedList getStk() {
        return stk;
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }

    // TODO Auto-generated constructor stub
        }


