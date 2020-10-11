package MailSever;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import library.ILinkedList;
import library.doubleLinkedList;

public class App implements IApp {
    public String contact;
    public String Type;
    public  doubleLinkedList shownMails=new doubleLinkedList();
    public IMail ourMail[];
    @Override
public boolean signin(String email,String pw) throws Exception {
    try {
        IContact check=new IContact(email,pw);
        if(check.exist()==true){
            this.contact = email;
            return true;
        }
        else {return false;}
    } catch (IOException e) {
        e.printStackTrace();
    }
   return true;
}
    @Override
    public boolean signup(IContact contact) throws IOException {
    if(!contact.exist_signup()) {
        if (contact.getName() != null) {
            try (Writer writer = Files.newBufferedWriter(
                    Paths.get("data_base//accounts//ID.txt"), StandardCharsets.UTF_8,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND)) {
                writer.write(contact.getName() + "\n");
                writer.write(contact.getPw() + "\n");} catch (IOException e) {
                e.printStackTrace();
            }
            this.contact = contact.getName();
            File file = new File("data_base//" + contact.getName());
            boolean bool = file.mkdir(); 
            if(bool){
                System.out.println("Directory created successfully");
            }else{
                System.out.println("Sorry couldn’t create specified directory");
            }

            File file1 = new File("data_base//" + contact.getName()+"//inbox");

            boolean bool1= file1.mkdir();
            if(bool1){
                System.out.println("Directory created successfully");
                File indexFile = new File("data_base//" + contact.getName() + "//inbox//index.txt");
                indexFile.createNewFile();
            }else{
                System.out.println("Sorry couldn’t create specified directory");
            }

            File file2 = new File("data_base//" + contact.getName()+"//sent");

            boolean bool2 = file2.mkdir();
            if(bool2){
                System.out.println("Directory created successfully");
		File indexFile = new File("data_base//" + contact.getName() + "//sent//index.txt");
                indexFile.createNewFile();
            }else{
                System.out.println("Sorry couldn’t create specified directory");
            }
            File file3 = new File("data_base//" + contact.getName()+"//trash");

            boolean bool3 = file3.mkdir();
            if(bool3){
                System.out.println("Directory created successfully");
		File indexFile = new File("data_base//" + contact.getName() + "//trash//index.txt");
                indexFile.createNewFile();
            }else{
                System.out.println("Sorry couldn’t create specified directory");
            }
            File file4 = new File("data_base//" + contact.getName()+"//drafts");

            boolean bool4 = file4.mkdir();
            if(bool4){
                System.out.println("Directory created successfully");
		File indexFile = new File("data_base//" + contact.getName() + "//drafts//index.txt");
                indexFile.createNewFile();
            }else{
                System.out.println("Sorry couldn’t create specified directory");
            }
            File file5 = new File("data_base//" + contact.getName()+"//contacts");

            boolean bool5 = file5.mkdir();
            if(bool5){
                System.out.println("Directory created successfully");
		File indexFile = new File("data_base//" + contact.getName() + "//contacts//index.txt");
                indexFile.createNewFile();
            }else{
                System.out.println("Sorry couldn’t create specified directory");
            }
            return true;
        }

    return false;}
        else {return false;}
}

    @Override
    public IMail[] listEmails(int page) throws Exception {
        IMail mails[];
        doubleLinkedList dl=new doubleLinkedList();
        int size=0;
        if(shownMails.size()==0)       return null;
        else {
            if(((page*10)-10)>shownMails.size()) {
                return null;
            }else {
                int initialElement=(page*10)-10;
                size=((shownMails.size())-((page*10)-10));
                if(size>10)size=10;
                mails=new IMail[size];
                
                for(int i=0;(i<size);i++) {
                    mails[i]=((IMail)shownMails.get(initialElement++));
                    
                }
                return mails;
            }
        }
    }

    public boolean checkNewContact(String contact) {
    	IFolder folders=new IFolder();
    	doubleLinkedList users=new doubleLinkedList();
    	users=folders.Names("data_base");
    	for(int i=0; i<users.size();i++) {
    		if(contact.equalsIgnoreCase((String) users.get(i))) {
    			return true;
    		}
    	}
		return false;
    	
    }
    public boolean checkPreviousAdded(String mail,String contact) {
    	IFolder folders=new IFolder();
    	doubleLinkedList users=new doubleLinkedList();
    	users=folders.Names("data_base//"+mail+"//contacts");
    	for(int i=0; i<users.size();i++) {
    		if(contact.equalsIgnoreCase((String) users.get(i))) {
    			return true;
    		}
    	}
		return false;
    	
    }
    @Override
    public void deleteEmails(ILinkedList mails) throws IOException, ClassNotFoundException {
        IFolder F = new IFolder();
        doubleLinkedList dl = F.readIndexFile(contact,Type);
        for (int i = 0; i < mails.size(); i++) {
            for (int j = 0; j < dl.size(); j++) {
                if (mails.get(i).equals(((IMail) dl.get(j)).folderName)) {
                    dl.remove(j);
                    File currentEmail = new File("data_base//" + contact + "//" + Type + "//" + mails.get(i));
                    String[] entries = currentEmail.list();
                    for (String s : entries) {
                        File currentFile = new File(currentEmail.getPath(), s);
                        currentFile.delete();
                    }
                    currentEmail.delete();
                    break;
                }
            }
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data_base//" + contact + "//" + Type + "//index.txt"));
        out.writeObject(dl);
        out.close();
    }
    
    
    

    @Override
    public void moveEmails(ILinkedList mails, IFolder des) throws IOException, ClassNotFoundException {
        IFolder F = new IFolder();
        doubleLinkedList dl1 = F.readIndexFile(contact,Type);
        doubleLinkedList dl2 = des.readIndexFile(des.file.getParent().substring(10),des.file.getName());
        for (int i = 0; i < mails.size(); i++) {
            for (int j = 0; j < dl1.size(); j++) {
                if (mails.get(i).equals(((IMail) dl1.get(j)).folderName)) {
                    IMail S = (IMail) dl1.get(j);
                    S.folderName = "Email_" + (dl2.size() + 1);
                    dl2.add(S);
                    File currentEmail = new File("data_base//" + contact + "//" + Type + "//" + mails.get(i));
                    File newEmail = new File("data_base//" + des.file.getParent().substring(10) + "//" + des.file.getName() + "//Email_" + dl2.size() + "//");
                    newEmail.mkdir();
                    String[] entries = currentEmail.list();
                    for (String s : entries) {
                        File currentFile = new File(currentEmail.getPath(), s);
                        File newFile = new File(newEmail.getPath(), s);
                        Files.copy(currentFile.toPath(),newFile.toPath());
                    }
                    break;
                }
            }
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data_base//" + des.file.getParent().substring(10) + "//" + des.file.getName() + "//index.txt"));
        out.writeObject(dl2);
        out.close();
        deleteEmails(mails);
    }
    
    
    @Override
    public boolean compose(IMail email) {
    	if(email.Sender==""||(email.receivers.size()==0)) {
    		return false;
    	}
    	int indicatorSender=0;
    	int indicatorReciever=0;
    	IFolder folder=new IFolder();
    	doubleLinkedList mydl=new doubleLinkedList();
    	doubleLinkedList save=new doubleLinkedList();
    	mydl=folder.Names("data_base");
    	for(int i=0; i<mydl.size();i++) {
    		if(email.Sender.equals(mydl.get(i))) {
    			indicatorSender=1;
    		}
    	}
    	int size=email.receivers.size();
    	for(int i=0;i<size;i++) {
    		save.add(email.receivers.dequeue());
    		email.receivers.enqueue(save.get(i));
    	}
    	for(int i=0; i<email.receivers.size();i++) {
    		for(int j=0;j<mydl.size();j++) {
    			if(save.get(i).equals(mydl.get(j))) {
    				indicatorReciever++;
    			}
    		}
    	}
    	
    	if(indicatorSender==1&&(indicatorReciever==save.size())) {
    		indicatorReciever=indicatorSender=0;
    		return true;
    	}
		indicatorReciever=indicatorSender=0;
		return false;
    }
    // We didn't use it.
    @Override
    public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {

    }
}
