package View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Kapasitas_Kamar {

    public Kapasitas_Kamar() {
        JFrame frame = new JFrame("Lihat Kapasitas Kamar");
        frame.setLocationRelativeTo(null);

//         Column Names
        String[] tabel
                = {"Nama Daerah Perawatan", "Terisi", "Tersisa"};

        // design pattern strategy
        Object[][] data = {
            {"ICU", 5, 50},
            {"UGD", 35, 65},
            {"Karantina", 15, 30},
            {"Anak", 25, 85},
            {"VVIP", 3, 15},
            {"VIP", 7, 35},
            {"Kelas 1", 20, 55},
            {"Kelas 2", 35, 75},
            {"Kelas 3", 55, 95}
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
