package View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Data_Storage {

    public Lihat_Data_Storage() {
        JFrame frame = new JFrame("Lihat List Obat");
        frame.setLocationRelativeTo(null);

//         Column Names
        String[] tabel
                = {"ID", "Nama Item", "Jumlah", "Harga"};

        // design pattern strategy
        Object[][] data = {
            {1, "Aspirin", 125, 25000.0},
            {2, "Antibiotic", 135, 35000.0},
            {3, "Antiseptic", 115, 30000.0},
            {4, "AntiPyretics", 125, 40000.0},
            {1, "Tongkat", 25, 125000.0},
            {2, "Suntikan", 35, 50000.0},
            {3, "Gips", 15, 85000.0},
            {4, "Infus", 25, 55000.0}
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
        new Lihat_Data_Storage();
    }
}
