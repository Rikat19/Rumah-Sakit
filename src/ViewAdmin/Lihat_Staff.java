/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewAdmin;

import Controller.Control;
import Controller.ControlStaff;
import Model.Staff;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Devan
 */
public class Lihat_Staff {

    public Lihat_Staff() {
        Control c = new Control();
        ControlStaff cs = new ControlStaff();
        JFrame frame = new JFrame("Lihat Staff");
        frame.setLocationRelativeTo(null);
        ArrayList<Staff> list = cs.getAllStaff();
        String[][] data2 = new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            data2[i][0] = String.valueOf(list.get(i).getId());
            data2[i][1] = list.get(i).getNama();
            data2[i][2] = c.getCabangDariId(list.get(i).getIdCabang()).getNama();
            data2[i][3] = list.get(i).getTugas();
            data2[i][4] = String.valueOf(list.get(i).getGaji());
        }

        String[] tabel
                = {"ID", "Nama", "Cabang", "Tugas", "Gaji/Bulan"};

        Object[][] data = data2;

        JTable table = new JTable(data, tabel);

        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);

        frame.pack();
        frame.setVisible(true);
    }
}
