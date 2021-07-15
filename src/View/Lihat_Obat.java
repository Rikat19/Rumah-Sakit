package View;

import Controller.Control;
import Model.Cabang;
import Model.Item;
import Model.Obat;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Obat {

    Control c = new Control();

    public Lihat_Obat() {
        JFrame frame = new JFrame("Lihat List Obat");
        frame.setLocationRelativeTo(null);

//         Column Names
        String[] tabel
                = {"Nama Alat", "Jumlah", "Dosis", "Harga per Dosis"};

        // design pattern strategy
        LinkedList<Item> alat = c.getItemDariIdCabang(Cabang.getInstance().getId());
        for (int j = 0; j < alat.size(); j++) {
            if ((alat.get(j) instanceof Obat) == false) {
                alat.remove(j);
            }
        }
        String[][] data2 = new String[alat.size()][3];
        for (int i = 0; i < alat.size(); i++) {
            Obat obat = (Obat) alat.get(i);
            data2[i][0] = obat.getNama();
            data2[i][1] = String.valueOf(obat.getStock());
            data2[i][2] = String.valueOf(obat.getHarga());
            data2[i][3] = obat.getDosis();
        }

        String[][] data = data2;

//        Initializing the JTable
        JTable table = new JTable(data, tabel);

//        //adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
//        biar compact
        frame.pack();
        frame.setVisible(true);
    }
}
