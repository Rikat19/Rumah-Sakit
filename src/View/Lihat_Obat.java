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
                = {"ID", "Nama Alat", "Jumlah", "Dosis", "Harga per Dosis"};

        // design pattern strategy
        LinkedList<Item> alat = c.getItemDariIdCabang(Cabang.getInstance().getId());
        for (int j = 0; j < alat.size(); j++) {
            if ((alat.get(j) instanceof Obat) == false) {
                alat.remove(j);
            }
        }
        String[][] data2 = new String[alat.size()][3];
        for (int i = 0; i < alat.size(); i++) {
            data2[i][0] = alat.get(i).getNama();
            data2[i][1] = String.valueOf(alat.get(i).getStock());
            data2[i][2] = String.valueOf(alat.get(i).getHarga());
        }

        String[][] data = data2;

//        Initializing the JTable
        JTable table = new JTable(data, tabel);

//        //adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
//        biar compact
        frame.pack();
    }

    public static void main(String[] args) {
        new Lihat_Obat();
    }
}
