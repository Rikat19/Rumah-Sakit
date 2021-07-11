
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Kapasitas_Kamar {
    
    public Kapasitas_Kamar(){
        JFrame frame = new JFrame("Lihat Kapasitas Kamar");
        frame.setSize(650,550);
        frame.setLocationRelativeTo(null);
        
//        List Pasien
        JLabel lihatPasien = new JLabel();
        lihatPasien.setText("List Kapasitas Kamar\n");
        lihatPasien.setBounds(15,10,175,25);
        lihatPasien.setVisible(true);
        
        frame.add(lihatPasien);
        
        // ntar pake action listener
        // panggil enum
        // design pattern strategy
         String[][] data = {
             {"ICU", "35", "5"},
             {"UGD", "15", "25"},
             {"Karantina", "10", "35"},
             {"Anak", "18", "30"},
             {"VVIP", "5", "15"},
             {"VIP", "7", "10"},
             {"Kelas 1", "19", "20"},
             {"Kelas 2", "22", "40"},
             {"Kelas 3", "35", "50"},
         };
//         Column Names
        String[] tabel =
        {"Nama Daerah Perawatan", "Terisi", "Tersisa"};
                
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
            frame.setVisible(false);
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Kapasitas_Kamar();
    }
}
