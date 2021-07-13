package View;

import Model.Dokter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Richard
 */
public class Lihat_Dokter {

    public Lihat_Dokter(ArrayList<Dokter> list,int hari) {
        JFrame frame = new JFrame("Lihat Daftar Dokter");
        frame.setSize(650, 550);
        frame.setLocationRelativeTo(null);

//        List Pasien
        JLabel lihatPasien = new JLabel();
        lihatPasien.setText("List Dokter\n");
        lihatPasien.setBounds(15, 10, 175, 25);
        lihatPasien.setVisible(true);

        frame.add(lihatPasien);

        // ntar pake action listener
        // panggil enum
        // design pattern strategy
        String[][] data2 = new String[list.size()][6];
        for (int i = 0; i < data2.length; i++) {
            data2[i][0] = String.valueOf(list.get(i).getId());
            data2[i][1] = list.get(i).getNama();
            data2[i][2] = list.get(i).getSpecialist();
            data2[i][3] = String.valueOf(list.get(i).getJadwal()[hari][0]) + ":" + String.valueOf(list.get(i).getJadwal()[hari][2]);
            data2[i][4] = String.valueOf(list.get(i).getJadwal()[hari][1]) + ":" + String.valueOf(list.get(i).getJadwal()[hari][3]);
            data2[i][5] = String.valueOf(list.get(i).getBiayaJasa());
        }

        String[][] data = data2;
//         Column Names
        String[] tabel
                = {"ID", "Nama Dokter", "Spesialis", "Jam Mulai Praktek", "Jam Selesai Praktek", "Biaya Jasa"};

//        Initializing the JTable
        JTable table = new JTable(data, tabel);
        table.setBounds(15, 50, 600, 300);
        frame.add(table);

//        //adding it to JScrollPane
//        JScrollPane sp = new JScrollPane(table);
//        frame.add(sp);
//        back      
        JButton back = new JButton("Back");
        back.setBounds(450, 450, 150, 25);
        Color red = new Color(250, 0, 0);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new Jadwal_Dokter();
                frame.hide();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
