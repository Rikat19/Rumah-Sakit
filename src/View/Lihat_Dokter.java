package View;


import Model.Dokter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Dokter {

    public Lihat_Dokter(ArrayList<Dokter> list,int hari) {
        JFrame frame = new JFrame("Lihat List Dokter");
        frame.setLocationRelativeTo(null);

            
//         Column Names
        String[] tabel = {"ID", "Nama Dokter", "Spesialis", "Jam Mulai Praktek", "Jam Selesai Praktek", "Biaya Jasa"};
      
        // ntar pake action listener
        // panggil enum
        // design pattern strategy
        String[][] data2 = new String[list.size()][6];
        for (int i = 0; i < data2.length; i++) {
            data2[i][0] = String.valueOf(list.get(i).getId());
            data2[i][1] = list.get(i).getNama();
            data2[i][2] = list.get(i).getSpecialist();
            data2[i][3] = String.valueOf(list.get(i).getJadwal()[hari][0]) + ":" + String.valueOf(list.get(i).getJadwal()[hari][2]);
            data2[i][4] = String.valueOf(list.get(i).getJadwal()[hari][1]) + ":" + String.valueOf(list.get(i).getJadwal()[hari][3]);
            data2[i][5] = String.valueOf(list.get(i).getBiayaJasa());
        }

        String[][] data = data2;
      
//        Initializing the JTable
        JTable table = new JTable(data, tabel);

//        adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
//        biar compact
        frame.pack();

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        
    }

}


