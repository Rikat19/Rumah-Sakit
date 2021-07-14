/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewAdmin;

import java.awt.Color;
import static java.awt.Color.green;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
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
        frame.setLocationRelativeTo(null);
       
      String[]tabel = 
             {"ID", "Nama", "Cabang", "Tugas", "ShiftKerja", "Gaji/Bulan"};
        
      Object[][] data ={
            {1,"Wanto","Cabang A","Satpam","0","1500000"},
            {2,"Iwan","Cabang B","Dokter","1","2500000"}
      };
        
        
        JTable table = new JTable(data, tabel);
        
         JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        
        frame.pack();
        frame.setVisible(true);
    }
    
        public static void main(String[] args) {
        new Lihat_Staff();
    }
}
