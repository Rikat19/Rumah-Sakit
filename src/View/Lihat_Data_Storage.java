package View;


import Controller.Control;
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
public class Lihat_Data_Storage {

    Control c = new Control();

    public Lihat_Data_Storage() {
        JFrame frame = new JFrame("Lihat List Items");
        frame.setLocationRelativeTo(null);

//         Column Names
        String[] tabel = {"Nama Item", "Jumlah", "Harga"};
      
        // ntar pake action listener
        // panggil enum
        // design pattern strategy
        
        LinkedList<Item> list = c.getItemDariIdCabang(Cabang.getInstance().getId());
        String[][] data2 = new String[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            data2[i][0] = list.get(i).getNama();
            data2[i][1] = String.valueOf(list.get(i).getStock());
            data2[i][2] = String.valueOf(list.get(i).getHarga());
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

    public static void main(String[] args) {
        new Lihat_Data_Storage();
    }
}
