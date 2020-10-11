package MailSever;
import library.doubleLinkedList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TrashTester {
    public void autoDelete(String contactName) throws IOException, ClassNotFoundException {
        IFolder S = new IFolder();
        IFilter R = new IFilter("folderName");
        doubleLinkedList dl = S.readIndexFile(contactName , "trash");
        File dir = new File("data_base//" + contactName + "//trash");
        String[] entries = dir.list();
        int i = 0;
        while ((new File(dir.getPath(),entries[i])).isDirectory()){
            File currentEmail = new File(dir.getPath(),entries[i]);
            long diff = new Date().getTime() - currentEmail.lastModified();
            if(diff > 30*24*60*60*1000L) {
                String[] content = currentEmail.list();
                for (String s : content) {
                    File currentFile = new File(currentEmail.getPath(), s);
                    currentFile.delete();
                }
                for (int j = 0; j < dl.size(); j++) {
                    if(((IMail)dl.get(j)).folderName.equals(currentEmail.getName()))    dl.remove(j);
                }
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data_base//" + contactName + "//trash//index.txt"));
                out.writeObject(dl);
                out.close();
                currentEmail.delete();
            }
            i++;
        }
    }
}
