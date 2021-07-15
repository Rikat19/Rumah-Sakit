/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewAdmin;

import Controller.Control;
import Model.Cabang;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Devan
 */
public class Lihat_Cabang {

    public Lihat_Cabang() {
        JFrame frame = new JFrame("Lihat Cabang");
        Control c = new Control();

        frame.setLocationRelativeTo(null);

        LinkedList<Cabang> list = c.getAllCabang();

        String[][] data2 = new String[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            data2[i][0] = String.valueOf(list.get(i).getId());
            data2[i][1] = list.get(i).getNama();
            data2[i][2] = list.get(i).getAlamat();
        }

        String[] tabel
                = {"ID Cabang", "Nama Cabang", "Alamat Cabang"};

        Object[][] data = data2;

        JTable table = new JTable(data, tabel);

        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);

        frame.pack();
        frame.setVisible(true);
    }
}
