package View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Pasien {

    public Lihat_Pasien() {
        JFrame frame = new JFrame("Lihat List Obat");
        frame.setLocationRelativeTo(null);

//         Column Names
        String[] tabel
                = {"ID", "Nama", "TTL", "Gender", "Alamat", "Daerah Perawatan", "Tanggal Masuk", "Tanggal Keluar"};

        // design pattern strategy
        Object[][] data = {
            {1, "Geri", "12-05-1999", "M", "Dago", "VIP", "13-07-2021", "13-07-2021"},
            {2, "Leri", "12-05-1999", "M", "Dago", "UGD", "13-07-2021", " "},
            {3, "Terry", "12-05-1999", "M", "Dago", "Karantina", "13-07-2021", " "},
            {4, "Mary", "12-05-2015", "F", "Dago", "Anak", "13-07-2021", "13-07-2021"}
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
        new Lihat_Pasien();
    }
}
