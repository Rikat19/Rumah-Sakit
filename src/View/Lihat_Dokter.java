
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
public class Lihat_Dokter {
    
    public Lihat_Dokter(){
        JFrame frame = new JFrame("Lihat Daftar Dokter");
        frame.setSize(650,550);
        frame.setLocationRelativeTo(null);
        
//        List Pasien
        JLabel lihatPasien = new JLabel();
        lihatPasien.setText("List Dokter\n");
        lihatPasien.setBounds(15,10,175,25);
        lihatPasien.setVisible(true);
        
        frame.add(lihatPasien);
        
        // ntar pake action listener
        // panggil enum
        // design pattern strategy
         String[][] data = {
             { "ID1", "Nama Dokter1", "Spesialis1", "Jam Mulai Praktek1", "Jam Selesai Praktek1", "Biaya Jasa1"},
             { "ID2", "Nama Dokter2", "Spesialis2", "Jam Mulai Praktek2", "Jam Selesai Praktek2", "Biaya Jasa2"}
         };
//         Column Names
        String[] tabel =
        { "ID", "Nama Dokter", "Spesialis", "Jam Mulai Praktek", "Jam Selesai Praktek", "Biaya Jasa"};
        
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
            new Jadwal_Dokter();
            frame.hide();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Lihat_Dokter();
    }
}
