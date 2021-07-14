package View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Obat {

    public Lihat_Obat() {
        JFrame frame = new JFrame("Lihat List Obat");
        frame.setLocationRelativeTo(null);

//         Column Names
        String[] tabel
                = {"ID", "Nama Alat", "Jumlah", "Dosis", "Harga per Dosis"};

        // design pattern strategy
        Object[][] data = {
            {1, "Aspirin", 125, 5, 25000.0},
            {2, "Antibiotic", 135, 5, 35000.0},
            {3, "Antiseptic", 115, 3, 30000.0},
            {4, "AntiPyretics", 125, 3, 40000.0}
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
        new Lihat_Obat();
    }
}
