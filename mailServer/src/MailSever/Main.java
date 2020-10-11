package MailSever;
import library.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controls.MainForm;
import controls.TrashForm;
import controls.composeForm;
import controls.contactForm;
import controls.draftForm;
import controls.inboxForm;
import controls.sendForm;

import library.doubleLinkedList;
import library.singlyLinkedList;

public class Main {
	/////////////////////////////
    public static void main(String[] args) throws Exception {
    	
    	Tools.openForm(new GUI());
    	//Tools.openForm(new composeForm("bb@raa.com"));
    	//Tools.openForm(new TrashForm("aa@raa.com"));
    	//Tools.openForm(new draftForm("aa@raa.com"));
    	//Tools.openForm(new inboxForm("aa@raa.com"));
    	//Tools.openForm(new sendForm("bb@raa.com"));
    	 //Tools.openForm(new contactForm("aa@raa.com"));
    }
}
    
    
    
   


