
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class Login {
       
    public Login() {
        JFrame frame = new JFrame("Login");
        frame.setSize(350,250);
        frame.setLocationRelativeTo(null);
        
//        Login ID
        JLabel id = new JLabel();
        id.setText("ID");
        id.setBounds(15,15,175,25);
        id.setVisible(true);
        frame.add(id);
        
        JTextField textfieldID = new JTextField();
        textfieldID.setBounds(15, 40, 300, 25);
        textfieldID.setBackground(Color.WHITE);
        frame.add(textfieldID);
        
        
//        Login pass
        JLabel pass = new JLabel();
        pass.setText("Password");
        pass.setBounds(15,80,175,25);
        pass.setVisible(true);
        frame.add(pass);
        
        JPasswordField  textfieldPass = new JPasswordField ();
        textfieldPass.setBounds(15, 105, 300, 25);
        textfieldPass.setBackground(Color.WHITE);
        frame.add(textfieldPass);
        
        
//        button
        JButton login = new JButton("Login");
        login.setBounds(215, 145, 100, 25);
        Color green = new Color(0, 255, 0);
        login.setBackground(green);
        
        frame.add(login);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // if admin 
//                new Menu_Admin();
//            frame.hide();
                // if staff
                new Menu_Staff();
                frame.hide();
            }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
