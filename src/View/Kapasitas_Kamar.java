
package View;

import Controller.Control;
import Controller.ControlPasien;
import Model.Cabang;
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
        Control c = new Control();
        ControlPasien cp = new ControlPasien();
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
        // design pattern strategy - Richardo
        // no - Jordan
        int[] tersedia = c.parseDaerahToInt(Cabang.getInstance().getKapasitasDaerah());
        int[] terisi = cp.getIsiKamar(Cabang.getInstance().getId());
        String[][] data = {
             {"VVIP", String.valueOf(terisi[0]), String.valueOf(tersedia[0])},
             {"VIP", String.valueOf(terisi[1]), String.valueOf(tersedia[1])},
             {"I", String.valueOf(terisi[2]), String.valueOf(tersedia[2])},
             {"II", String.valueOf(terisi[3]), String.valueOf(tersedia[3])},
             {"III", String.valueOf(terisi[4]), String.valueOf(tersedia[4])},
             {"UGD", String.valueOf(terisi[5]), String.valueOf(tersedia[5])},
             {"ICU", String.valueOf(terisi[6]), String.valueOf(tersedia[6])},
             {"KARANTINA", String.valueOf(terisi[7]), String.valueOf(tersedia[7])},
             {"ANAK", String.valueOf(terisi[8]), String.valueOf(tersedia[8])},
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
