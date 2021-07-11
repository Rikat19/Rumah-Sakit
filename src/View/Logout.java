
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Richard
 */
public class Logout {
       
    public Logout() {
        JFrame frame = new JFrame("Logout");
        frame.setSize(350,200);
        frame.setLocationRelativeTo(null);
        
//        logout     
        JLabel cekLogout = new JLabel();
        cekLogout.setText("Anda yakin ingin Logout?\n");
        cekLogout.setBounds(100, 25, 150, 30);
        cekLogout.setVisible(true);
        frame.add(cekLogout);
        
        JButton ya = new JButton("Ya");
        ya.setBounds(50, 80, 100, 25);
        Color green = new Color(0, 255, 0);
        ya.setBackground(green);
        
        JButton tidak = new JButton("Tidak");
        tidak.setBounds(175, 80, 100, 25);
        Color red = new Color(250, 0, 0);
        tidak.setBackground(red);
        
        frame.add(ya);
        frame.add(tidak);
        ya.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                frame.hide();
            }
        });
        tidak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Menu_Staff();
                frame.hide();
            }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Logout();
    }
}
