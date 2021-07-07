
package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Richard
 */
public class Menu_Staff {
    
    JButton button;
    
    public Menu_Staff() {
        JFrame frame = new JFrame();
        frame.setSize(650,550);
        frame.setLocationRelativeTo(null);
        
        // edit pasien
        JLabel editPasien = new JLabel();
        editPasien.setText("Edit Pasien\n");
        editPasien.setBounds(15,10,175,25);
        editPasien.setVisible(true);
        
        JButton lihatPasien = new JButton("Lihat Pasien");
        lihatPasien.setBounds(10,55,150,25);
        JButton tambahPasien = new JButton("Tambah Pasien");
        tambahPasien.setBounds(175,55,150,25);
        JButton hapusPasien = new JButton("Hapus Pasien");
        hapusPasien.setBounds(340,55,150,25);
        
        frame.add(editPasien);
        frame.add(lihatPasien);
        frame.add(tambahPasien);
        frame.add(hapusPasien);
        
//        // edit data storage
        JLabel editStorage = new JLabel();
        editStorage.setText("Edit Data Storage\n");
        editStorage.setBounds(15,95,175,25);
        editStorage.setVisible(true);
        
        JButton lihatStorage = new JButton("Lihat Storage");
        lihatStorage.setBounds(10,135,150,25);
        JButton tambahStorage = new JButton("Tambah Storage");
        tambahStorage.setBounds(175,135,150,25);
        JButton hapusStorage = new JButton("Hapus Storage");
        hapusStorage.setBounds(340,135,150,25);
        
        frame.add(editStorage);
        frame.add(lihatStorage);
        frame.add(tambahStorage);
        frame.add(hapusStorage);
        
//        // jadwal dokter
        JLabel jadwalDokter = new JLabel();
        jadwalDokter.setText("Jadwal Dokter\n");
        jadwalDokter.setBounds(15,175,175,25);
        jadwalDokter.setVisible(true);
        
        JButton lihatJadwal = new JButton("Lihat Jadwal Dokter");
        lihatJadwal.setBounds(10,215,150,25);
        
        frame.add(jadwalDokter);
        frame.add(lihatJadwal);
        
//        // kapasitas kamar
        JLabel kapasitasKamar = new JLabel();
        kapasitasKamar.setText("Lihat Kapasitas Kamar\n");
        kapasitasKamar.setBounds(15,255,175,25);
        kapasitasKamar.setVisible(true);
        
        JButton lihatKamar = new JButton("Lihat Kamar");
        lihatKamar.setBounds(10,295,150,25);
        
        frame.add(kapasitasKamar);
        frame.add(lihatKamar);
        
//        // pembayaran tagihan
        JLabel pembayaranTagihan = new JLabel();
        pembayaranTagihan.setText("Pembayaran Tagihan Pasien\n");
        pembayaranTagihan.setBounds(15,335,175,25);
        pembayaranTagihan.setVisible(true);
        
        JButton tagihanPasien = new JButton("Tagihan Pasien");
        tagihanPasien.setBounds(10,375,150,25);
        
        frame.add(pembayaranTagihan);
        frame.add(tagihanPasien);
        
//        // logout      
        JButton logout = new JButton("Logout");
        logout.setBounds(450,450,150,25);
        Color red = new Color(250, 0, 0);
        logout.setBackground(red);
        frame.add(logout);
        
        
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        new Menu_Staff();
    }
}
