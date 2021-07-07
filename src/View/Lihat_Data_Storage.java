
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
public class Lihat_Data_Storage {
    
    public Lihat_Data_Storage(){
        JFrame frame = new JFrame("Lihat Data Storage");
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
             {"ID1", "Nama Barang1", "Jenis1", "Jumlah1", "Kondisi1", "Harga1"},
             {"ID2", "Nama Barang2", "Jenis2", "Jumlah2", "Kondisi2", "Harga2"}
         };
//         Column Names
        String[] tabel =
        {"ID", "Nama Barang", "Jenis", "Jumlah", "Kondisi", "Harga"};
        
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
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Lihat_Data_Storage();
    }
}
