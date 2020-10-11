package MailSever;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Tools {
	public static void openForm(JFrame form){
        form.setLocationRelativeTo(null);
        
            Image img = null;
			try {
				img = ImageIO.read(Tools.class.getResource("Icon.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            form.setIconImage(img);
            form.getContentPane().setBackground(Color.white);
        
        form.setVisible(true);
    }
	public static Object inputBox(String title){
        Object myObj=JOptionPane.showInputDialog(title);
        return myObj;
    }
}
