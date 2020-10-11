package MailSever;

import java.io.*;

import library.doubleLinkedList;
import library.singlyLinkedList;

public class IFolder implements Serializable {
    public File file;
    doubleLinkedList filesOrFolderNames=new doubleLinkedList();
    doubleLinkedList dl = new doubleLinkedList();
    public IFolder() {

    }
    
  public IFolder(String path) {
        this.file = new File(path);
    }
    public int Count (String contactName , String fileType) throws IOException, ClassNotFoundException {
        if (new File("data_base//"+contactName+"//"+fileType+"//index.txt").length() != 0){
            dl = readIndexFile(contactName,fileType);
            return dl.size();
        }
        return 0;
    }
    public doubleLinkedList Names(String path) {
        File file =new File(path);
        String [] files=file.list();
        doubleLinkedList obj=new doubleLinkedList();
        for(int i=0;i<files.length;i++) {
            obj.add(files[i]);
        }
        return obj;
    }
    public void writeEmails(String contactName , String fileType , IMail email) throws IOException, ClassNotFoundException {
        String path = "data_base//" + contactName + "//" + fileType + "//index.txt";
        if(new File(path).length()!=0) {
        	
            dl = readIndexFile(contactName,fileType);
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        dl.add(email);
        out.writeObject(dl);
        dl.clear();
        out.close();
    }
    public doubleLinkedList readIndexFile(String contactName , String fileType) throws IOException, ClassNotFoundException {
        String path = "data_base//" + contactName + "//" + fileType + "//index.txt";
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            dl = (doubleLinkedList) in.readObject();
            in.close();
        }catch (EOFException e){}
        return dl;
    }
}
