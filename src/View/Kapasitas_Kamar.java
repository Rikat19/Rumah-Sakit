package View;


import Controller.Control;
import Controller.ControlPasien;
import Model.Cabang;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        frame.setLocationRelativeTo(null);  
      
  //         Column Names
        String[] tabel = {"Nama Daerah Perawatan", "Terisi", "Tersedia"};
  
        // ntar pake action listener
        // panggil enum
        // design pattern strategy - Richardo
        // no - Jordan
        int[] tersedia = c.parseDaerahToInt(Cabang.getInstance().getKapasitasDaerah());
        int[] terisi = cp.getIsiKamar(Cabang.getInstance().getId());
        Object[][] data = {
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

//        Initializing the JTable
        JTable table = new JTable(data, tabel);

//        //adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
//        biar compact
        frame.pack();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Kapasitas_Kamar();
    }
}
