/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import static java.awt.Color.green;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author Devan
 */
public class Lihat_Staff {

    public Lihat_Staff() {
    JFrame frame = new JFrame("Lihat Staff");
        frame.setSize(650,550);
        frame.setLocationRelativeTo(null);
        
     //List Staff
        JLabel lihatStaff = new JLabel();
        lihatStaff.setText("List Staff\n");
        lihatStaff.setBounds(15,10,175,25);
        lihatStaff.setVisible(true);
        
        frame.add(lihatStaff);
        
        String[][] data = {
             { "ID", "Nama", "Cabang", "Tugas", "ShiftKerja", "Gaji/Bulan", /*1*/},
         };
        
         String[] tabel =
        { "ID", "Nama", "Cabang", "Tugas", "ShiftKerja", "Gaji/Bulan"};
        
        
        JTable table = new JTable(data, tabel);
        table.setBounds(15, 50, 600, 300);
        frame.add(table);
        
          //back      
        JButton back = new JButton("Back");
        back.setBounds(450,450,150,25);
        Color red = new Color(250, 0, 0);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Menu_Admin();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
        public static void main(String[] args) {
        new Lihat_Staff();
    }
}
