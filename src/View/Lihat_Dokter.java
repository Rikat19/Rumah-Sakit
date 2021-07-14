package View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Dokter {

    public Lihat_Dokter() {
        JFrame frame = new JFrame("Lihat List Dokter");
        frame.setLocationRelativeTo(null);

//         Column Names
        String[] tabel
                = {"ID", "Nama Dokter", "Spesialis", "Jam Mulai Praktek", "Jam Selesai Praktek", "Biaya Jasa"};

//        design pattern strategy
        Object[][] data = {
            {1, "Joni", "Paru Paru", "07.00", "11.00", 250000.0},
            {2, "Hilda", "Internis", "08.00", "12.00", 150000.0},
            {3, "Septian", "Anak", "12.00", "17.00", 100000.0},
            {4, "Mary", "Anak", "10.00", "14.00", 100000.0}
        };

//        Initializing the JTable
        JTable table = new JTable(data, tabel);

//        adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
//        biar compact
//        frame.pack();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Lihat_Dokter();
    }
}
