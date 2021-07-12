package View;

import Controller.ControlPasien;
import Model.Cabang;
import Model.Pasien;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Lihat_Pasien {
    ControlPasien cp = new ControlPasien();

    public Lihat_Pasien() {
        JFrame frame = new JFrame("Lihat Daftar Pasien");
        frame.setSize(650, 550);
        frame.setLocationRelativeTo(null);

//        List Pasien
        JLabel lihatPasien = new JLabel();
        lihatPasien.setText("List Pasien\n");
        lihatPasien.setBounds(15, 10, 175, 25);
        lihatPasien.setVisible(true);

        frame.add(lihatPasien);

        // ntar pake action listener
        // panggil enum
        // design pattern strategy
        ArrayList<Pasien> list = cp.getPasienByCabang(Cabang.getInstance().getId());
        String[][] data2 = new String[list.size()][8];
        for (int i = 0; i < list.size(); i++) {
            data2[i][0] = String.valueOf(list.get(i).getId());
            data2[i][1] = list.get(i).getNama();
            data2[i][2] = list.get(i).getTanggalLahir().toString();
            data2[i][3] = list.get(i).getGender();
            data2[i][4] = list.get(i).getAlamat();
            data2[i][5] = list.get(i).getDaerahPerawatan();
            data2[i][6] = list.get(i).getTanggalMasuk().toString();
            data2[i][7] = list.get(i).getTanggalKeluar().toString();
        }
        
        String[][] data = data2;
//         Column Names
        String[] tabel
                = {"ID", "Nama", "TTL", "Gender", "Alamat", "Daerah Perawatan", "Tanggal Masuk", "Tanggal Keluar"};

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
                new Menu_Staff();
                frame.hide();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Lihat_Pasien();
    }
}
