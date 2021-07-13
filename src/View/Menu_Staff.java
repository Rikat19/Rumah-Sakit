package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Richard
 */
public class Menu_Staff {

    public Menu_Staff() {
        JFrame frame = new JFrame("Menu Staff");
        frame.setSize(500, 575);
        frame.setLocationRelativeTo(null);

//        edit pasien
        JLabel Pasien = new JLabel();
        Pasien.setText("Edit Pasien\n");
        Pasien.setBounds(15, 10, 175, 25);
        Pasien.setVisible(true);
        frame.add(Pasien);

        JButton lihatPasien = new JButton("Lihat Pasien");
        lihatPasien.setBounds(10, 45, 125, 25);
        frame.add(lihatPasien);

        lihatPasien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Lihat_Pasien();
            }
        });

        JButton tambahPasien = new JButton("Tambah Pasien");
        tambahPasien.setBounds(150, 45, 125, 25);
        frame.add(tambahPasien);

        tambahPasien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tambah_Pasien();
                frame.hide();
            }
        });

        JButton editPasien = new JButton("Edit Pasien");
        editPasien.setBounds(290, 45, 125, 25);
        frame.add(editPasien);

        editPasien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Edit_Pasien();
                frame.hide();
            }
        });

        JButton tambahPenyakit = new JButton("Tambah Penyakit Pasien");
        tambahPenyakit.setBounds(10, 80, 200, 25);
        frame.add(tambahPenyakit);

        tambahPenyakit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tambah_Penyakit_Pasien();
                frame.hide();
            }
        });

        JButton tambahPerawatan = new JButton("Tambah Perawatan Pasien");
        tambahPerawatan.setBounds(225, 80, 200, 25);
        frame.add(tambahPerawatan);

        tambahPerawatan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tambah_Perawatan_Pasien();
                frame.hide();
            }
        });

//        edit data storage
        JLabel editStorage = new JLabel();
        editStorage.setText("Edit Data Storage\n");
        editStorage.setBounds(15, 125, 175, 25);
        editStorage.setVisible(true);
        frame.add(editStorage);

        JButton lihatStorage = new JButton("Lihat Items");
        lihatStorage.setBounds(10, 160, 150, 25);
        frame.add(lihatStorage);

        lihatStorage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Lihat_Data_Storage();
            }
        });

        JButton RestockStorage = new JButton("Restock Storage");
        RestockStorage.setBounds(175, 160, 150, 25);
        frame.add(RestockStorage);

        RestockStorage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Restock_Data_Storage();
                frame.hide();
            }
        });

        JButton tambahAlat = new JButton("Tambah Alat");
        tambahAlat.setBounds(10, 195, 150, 25);
        frame.add(tambahAlat);

        tambahAlat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tambah_Alat();
                frame.hide();
            }
        });

        JButton tambahObat = new JButton("Tambah Obat");
        tambahObat.setBounds(175, 195, 150, 25);
        frame.add(tambahObat);

        tambahObat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tambah_Obat();
                frame.hide();
            }
        });

//        jadwal dokter
        JLabel jadwalDokter = new JLabel();
        jadwalDokter.setText("Jadwal Dokter\n");
        jadwalDokter.setBounds(15, 240, 175, 25);
        jadwalDokter.setVisible(true);
        frame.add(jadwalDokter);

        JButton lihatJadwal = new JButton("Lihat Jadwal Dokter");
        lihatJadwal.setBounds(10, 275, 150, 25);
        frame.add(lihatJadwal);

        lihatJadwal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Jadwal_Dokter();
            }
        });

//        kapasitas kamar
        JLabel kapasitasKamar = new JLabel();
        kapasitasKamar.setText("Lihat Kapasitas Kamar\n");
        kapasitasKamar.setBounds(15, 320, 175, 25);
        kapasitasKamar.setVisible(true);
        frame.add(kapasitasKamar);

        JButton lihatKamar = new JButton("Lihat Kamar");
        lihatKamar.setBounds(10, 355, 150, 25);
        frame.add(lihatKamar);

        lihatKamar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Kapasitas_Kamar();
            }
        });

//        pembayaran tagihan
        JLabel pembayaranTagihan = new JLabel();
        pembayaranTagihan.setText("Pembayaran Tagihan Pasien\n");
        pembayaranTagihan.setBounds(15, 400, 175, 25);
        pembayaranTagihan.setVisible(true);
        frame.add(pembayaranTagihan);

        JButton tagihanPasien = new JButton("Tagihan Pasien");
        tagihanPasien.setBounds(10, 435, 150, 25);
        frame.add(tagihanPasien);

        tagihanPasien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tagihan_Pasien();
                frame.hide();
            }
        });

//        logout      
        JButton logout = new JButton("Logout");
        logout.setBounds(320, 480, 150, 25);
        Color red = new Color(250, 0, 0);
        logout.setBackground(red);
        frame.add(logout);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Logout();
                frame.hide();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Menu_Staff();
    }
}
