package View;

import Controller.Control;
import Model.Alat;
import Model.Cabang;
import Model.Item;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Alat {
    
    Control c = new Control();

    public Lihat_Alat() {
        JFrame frame = new JFrame("Lihat List Alat");
        frame.setLocationRelativeTo(null);

//         Column Names
        String[] tabel
                = {"ID", "Nama Alat", "Jumlah", "Harga"};

        // design pattern strategy
        LinkedList<Item> alat = c.getItemDariIdCabang(Cabang.getInstance().getId());
        for (int j = 0; j < alat.size(); j++) {
            if ((alat.get(j) instanceof Alat) == false) {
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
        new Lihat_Alat();
    }
}
