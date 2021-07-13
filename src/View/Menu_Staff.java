
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
        frame.setSize(650,550);
        frame.setLocationRelativeTo(null);
        
        // edit pasien
        JLabel Pasien = new JLabel();
        Pasien.setText("Edit Pasien\n");
        Pasien.setBounds(15,10,175,25);
        Pasien.setVisible(true);
        
        JButton lihatPasien = new JButton("Lihat Pasien");
        lihatPasien.setBounds(10,55,150,25);
        JButton tambahPasien = new JButton("Tambah Pasien");
        tambahPasien.setBounds(175,55,150,25);
        JButton tambahPenyakit = new JButton("Tambah Penyakit Pasien");
        tambahPenyakit.setBounds(340,55,75,25);
        JButton tambahPerawatan = new JButton("Tambah Perawatan Pasien");
        tambahPerawatan.setBounds(415,55,75,25);
        
        frame.add(Pasien);
        frame.add(lihatPasien);
        lihatPasien.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Lihat_Pasien();
            frame.hide();
        }
        });
        
        frame.add(tambahPasien);
        tambahPasien.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tambah_Pasien();
            frame.hide();
        }
        });
        
        frame.add(tambahPenyakit);
        tambahPenyakit.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tambah_Penyakit_Pasien();
            frame.hide();
        }
        });
        
        frame.add(tambahPerawatan);
        tambahPerawatan.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tambah_Perawatan_Pasien();
            frame.hide();
        }
        });
        
        
//        // edit data storage
        JLabel editStorage = new JLabel();
        editStorage.setText("Edit Data Storage\n");
        editStorage.setBounds(15,95,175,25);
        editStorage.setVisible(true);
        
        JButton lihatStorage = new JButton("Lihat Items");
        lihatStorage.setBounds(10,135,150,25);
        JButton tambahALat = new JButton("Tambah Alat");
        tambahALat.setBounds(175,135,75,25);
        JButton tambahObat = new JButton("Tambah Obat");
        tambahObat.setBounds(250,135,75,25);
        JButton hapusStorage = new JButton("Restock Storage");
        hapusStorage.setBounds(340,135,150,25);
        
        frame.add(editStorage);
        frame.add(lihatStorage);
        lihatStorage.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Lihat_Data_Storage();
            frame.hide();
        }
        });
        
        frame.add(tambahALat);
        tambahALat.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tambah_Alat();
            frame.hide();
        }
        });
        frame.add(tambahObat);
        tambahObat.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tambah_Obat();
            frame.hide();
        }
        });
        
        frame.add(hapusStorage);
        hapusStorage.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Restock_Data_Storage();
            frame.hide();
        }
        });
        
        
//        // jadwal dokter
        JLabel jadwalDokter = new JLabel();
        jadwalDokter.setText("Jadwal Dokter\n");
        jadwalDokter.setBounds(15,175,175,25);
        jadwalDokter.setVisible(true);
        
        JButton lihatJadwal = new JButton("Lihat Jadwal Dokter");
        lihatJadwal.setBounds(10,215,150,25);
        
        frame.add(jadwalDokter);
        frame.add(lihatJadwal);
        lihatJadwal.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Jadwal_Dokter();
//            frame.hide();
            
        }
        });
        
        
//        // kapasitas kamar
        JLabel kapasitasKamar = new JLabel();
        kapasitasKamar.setText("Lihat Kapasitas Kamar\n");
        kapasitasKamar.setBounds(15,255,175,25);
        kapasitasKamar.setVisible(true);
        
        JButton lihatKamar = new JButton("Lihat Kamar");
        lihatKamar.setBounds(10,295,150,25);
        
        frame.add(kapasitasKamar);
        frame.add(lihatKamar);
        lihatKamar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Kapasitas_Kamar();
//            frame.hide();
        }
        });
        
        
//        // pembayaran tagihan
        JLabel pembayaranTagihan = new JLabel();
        pembayaranTagihan.setText("Pembayaran Tagihan Pasien\n");
        pembayaranTagihan.setBounds(15,335,175,25);
        pembayaranTagihan.setVisible(true);
        
        JButton tagihanPasien = new JButton("Tagihan Pasien");
        tagihanPasien.setBounds(10,375,150,25);
        
        frame.add(pembayaranTagihan);
        frame.add(tagihanPasien);
        tagihanPasien.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tagihan_Pasien();
            frame.hide();
        }
        });
        
        
//        // logout      
        JButton logout = new JButton("Logout");
        logout.setBounds(450,450,150,25);
        Color red = new Color(250, 0, 0);
        logout.setBackground(red);
        frame.add(logout);
        logout.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
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
