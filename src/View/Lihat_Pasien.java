
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Pasien {
    
    public Lihat_Pasien(){
        JFrame frame = new JFrame("Lihat Daftar Pasien");
        frame.setSize(650,550);
        frame.setLocationRelativeTo(null);
        
//        List Pasien
        JLabel lihatPasien = new JLabel();
        lihatPasien.setText("List Pasien\n");
        lihatPasien.setBounds(15,10,175,25);
        lihatPasien.setVisible(true);
        
        frame.add(lihatPasien);
        
        // ntar pake action listener
        // panggil enum
        // design pattern strategy
         String[][] data = {
             { "ID1", "Nama1", "TTL1", "Gender1", "Alamat1", "Daerah Perawatan1", "Tanggal Masuk1", "Tanggal Keluar1", /*1*/},
             { "ID2", "Nama2", "TTL2", "Gender2", "Alamat2", "Daerah Perawatan2", "Tanggal Masuk2", "Tanggal Keluar2" /*0*/}
         };
//         Column Names
        String[] tabel =
        { "ID", "Nama", "TTL", "Gender", "Alamat", "Daerah Perawatan", "Tanggal Masuk", "Tanggal Keluar"};
        
//        Initializing the JTable
        JTable table = new JTable(data, tabel);
        table.setBounds(15, 50, 600, 300);
        frame.add(table);
  
//        //adding it to JScrollPane
//        JScrollPane sp = new JScrollPane(table);
//        frame.add(sp);
        
//        back      
        JButton back = new JButton("Back");
        back.setBounds(450,450,150,25);
        Color red = new Color(250, 0, 0);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Menu_Staff();
            frame.hide();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Lihat_Pasien();
    }
}
