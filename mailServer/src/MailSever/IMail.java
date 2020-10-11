package MailSever;
import library.*;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Scanner;

public class IMail implements Serializable{
    private static final long serialVersionUID = 3497652435958943557L;
    public String folderName;
    public String Subject;
    public String Body = "";
    public Date emailDate;
    public Object periority="";
    public singlyLinkedList Attachments = new singlyLinkedList();
    public singlyLinkedList Urls = new singlyLinkedList();
    public doubleLinkedList savedReceivers = new doubleLinkedList();
    public String Sender;
    public transient queueLinkedListImplementation receivers = new queueLinkedListImplementation();
    public transient queueLinkedListImplementation receiversforSender = new queueLinkedListImplementation();

    public void readUrls(){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        URL link = null;
        boolean flag = false;
        while (!flag) {
            try {
                link = new URL(line);
                flag = true;
            } catch (MalformedURLException e) {
                System.out.println("Invalid link");
                line = input.nextLine();
            }
        }
        Urls.add(link);
    }
    public void deleteAttachmentAt(int i){Attachments.remove(i);}
    
    public void sendMail() throws IOException, ClassNotFoundException {
        IFolder F = new IFolder();
        emailDate = new Date();
        String path = "";
        while (!receivers.isEmpty()){
            String  receiver = (String) receivers.dequeue();
            receiversforSender.enqueue(receiver);
            savedReceivers.add(receiver);
            int numberOfNewMessage = F.Count(receiver,"inbox");
            folderName = "Email_" + numberOfNewMessage;
            path = "data_base//" + receiver + "//inbox//"+ folderName + "//";
            File email = new File(path);
            email.mkdir();
            File message = new File(path + "Body.txt");
            message.createNewFile();
            File message1 = new File(path + "URL.txt");
            message1.createNewFile();
            File message2 = new File(path + "Attachement.txt");
            message2.createNewFile();
            File message3 = new File(path + "Title.txt");
            message3.createNewFile();
            File message4 = new File(path + "Sender.txt");
            message4.createNewFile();
            BufferedWriter q = new BufferedWriter(new FileWriter(message4));
            q.write(Sender);
            q.close();
            
            q = new BufferedWriter(new FileWriter(message3));
            q.write(Subject);
            q.close();
            
            q = new BufferedWriter(new FileWriter(message));
            q.write(Body);
            q.close();
            q = new BufferedWriter(new FileWriter(message1));
            if(!Urls.isEmpty()){
                for (int i = 0; i < Urls.size; i++) {
                    q.write(String.valueOf(Urls.get(i)));
                    q.newLine();
                }
            }
            q.close();
            q = new BufferedWriter(new FileWriter(message2));
            if(Attachments.size()!=0){
            for (int i = 0; i < Attachments.size; i++) {
            	q.write((String) Attachments.get(i));
            	q.newLine();
            	}
            }
            q.close();
            F.writeEmails(receiver, "inbox", this);
        }
        if(receiversforSender.size()!=0) {
        int numberOfNewMessage=F.Count(Sender,"sent");
        folderName = "Email_" + numberOfNewMessage;
        F.writeEmails(Sender,"sent",this);
        String newPath = "data_base//" + Sender + "//sent//" + folderName + "//";
        File email = new File(newPath);
        email.mkdir();
        File message = new File(newPath + "Body.txt");
        message.createNewFile();
        File message1 = new File(newPath + "URL.txt");
        message1.createNewFile();
        File message2 = new File(newPath + "Attachement.txt");
        message2.createNewFile();
        File message3 = new File(newPath + "Title.txt");
        message3.createNewFile();
        File message4 = new File(newPath + "Recievers.txt");
        message4.createNewFile();
        BufferedWriter q = new BufferedWriter(new FileWriter(message4));
        for(int v=0; v<receiversforSender.size();v++) {
        	String str=(String) savedReceivers.get(v);
        	System.out.println(str);
        	q.write(str);
        	q.newLine();
        }
        q.close();
        
        q = new BufferedWriter(new FileWriter(message3));
        q.write(Subject);
        q.close();
        
        q = new BufferedWriter(new FileWriter(message));
        q.write(Body);
        q.close();
        q = new BufferedWriter(new FileWriter(message1));
        if(!Urls.isEmpty()){
            for (int i = 0; i < Urls.size; i++) {
                q.write(String.valueOf(Urls.get(i)));
                q.newLine();
            }
        }
        q.close();
        q = new BufferedWriter(new FileWriter(message2));
        if(Attachments.size()!=0){
        for (int i = 0; i < Attachments.size; i++) {
        	q.write((String) Attachments.get(i));
        	q.newLine();
        	}
        }
        q.close();
        } 
        if(receiversforSender.size()==0) {
        	int numberOfNewMessage=F.Count(Sender,"drafts");
        	F.writeEmails(Sender,"drafts",this);
            folderName = "Email_" + numberOfNewMessage;
            String newPath = "data_base//" + Sender + "//drafts//" + folderName + "//";
            File email = new File(newPath);
            email.mkdir();
            File message = new File(newPath + "Body.txt");
            message.createNewFile();
            File message1 = new File(newPath + "URL.txt");
            message1.createNewFile();
            File message2 = new File(newPath + "Attachement.txt");
            message2.createNewFile();
            File message3 = new File(newPath + "Title.txt");
            message3.createNewFile();
            File message4 = new File(newPath + "Recievers.txt");
            message4.createNewFile();
            BufferedWriter q = new BufferedWriter(new FileWriter(message4));
            for(int v=0; v<receiversforSender.size();v++) {
            	String str=(String) savedReceivers.get(v);
            	System.out.println(str);
            	q.write(str);
            	q.newLine();
            }
            q.close();
            
            q = new BufferedWriter(new FileWriter(message3));
            q.write(Subject);
            q.close();
            
            q = new BufferedWriter(new FileWriter(message));
            q.write(Body);
            q.close();
            q = new BufferedWriter(new FileWriter(message1));
            if(!Urls.isEmpty()){
                for (int i = 0; i < Urls.size; i++) {
                    q.write(String.valueOf(Urls.get(i)));
                    q.newLine();
                }
            }
            q.close();
            q = new BufferedWriter(new FileWriter(message2));
            if(Attachments.size()!=0){
            for (int i = 0; i < Attachments.size; i++) {
            	q.write((String) Attachments.get(i));
            	q.newLine();
            	}
            }
            q.close();
            
        }
    }
}