
package View;

import Controller.ControlPasien;
import Model.Cabang;
import Model.Pasien;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Richard
 */
public class Tambah_Pasien{
    
    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);
    
    public Tambah_Pasien(){
        ControlPasien cp = new ControlPasien();
        JFrame frame = new JFrame("Tambah Riwayat Pasien");
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        
//        Nama Pasien
        JLabel nama = new JLabel();
        nama.setText("Nama Pasien\t:");
        nama.setBounds(15,15,175,25);
        nama.setVisible(true);
        frame.add(nama);
        
        JTextField textfieldName = new JTextField();
        textfieldName.setBounds(210, 15, 300, 25);
        textfieldName.setBackground(Color.WHITE);
        frame.add(textfieldName);
        
//        textfieldName.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        TTL Pasien
        JLabel TTL = new JLabel();
        TTL.setText("TTL Pasien\t:");
        TTL.setBounds(15,55,175,25);
        TTL.setVisible(true);
        frame.add(TTL);
        
        JTextField textfieldTTL = new JTextField();
        textfieldTTL.setBounds(210, 55, 300, 25);
        textfieldTTL.setBackground(Color.WHITE);
        frame.add(textfieldTTL);
        
//        textfieldTTL.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        Gender
// radio
        JLabel gender = new JLabel();
        gender.setText("Gender\t:");
        gender.setBounds(15,95,175,25);
        gender.setVisible(true);
        frame.add(gender);
        
        JTextField textfieldGender = new JTextField();
        textfieldGender.setBounds(210, 95, 300, 25);
        textfieldGender.setBackground(Color.WHITE);
        frame.add(textfieldGender);
        
//        textfieldGender.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        Alamat Pasien
        JLabel alamat = new JLabel();
        alamat.setText("Alamat Pasien\t:");
        alamat.setBounds(15,135,175,25);
        alamat.setVisible(true);
        frame.add(alamat);
        
        JTextField textfieldAlamat = new JTextField();
        textfieldAlamat.setBounds(210, 135, 300, 25);
        textfieldAlamat.setBackground(Color.WHITE);
        frame.add(textfieldAlamat);

//        textfieldAlamat.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        Dokter
// *lempar
//        JLabel dokter = new JLabel();
//        dokter.setText("Dokter yang Merawat\t:");
//        dokter.setBounds(15,175,175,25);
//        dokter.setVisible(true);
//        frame.add(dokter);
//        
//        JButton cariDokter = new JButton("Cari");
//        cariDokter.setBounds(410, 175, 100, 25);
//        cariDokter.setBackground(green);
//        frame.add(cariDokter);
//        cariDokter.addActionListener(new ActionListener(){
//        public void actionPerformed(ActionEvent e){
//            new Jadwal_Dokter();
//        }
//        });
//        
//        JTextField textfieldDokter = new JTextField();
//        textfieldDokter.setBounds(210, 175, 200, 25);
//        textfieldDokter.setBackground(Color.WHITE);
//        frame.add(textfieldDokter);

//        textfieldDokter.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        Daerah Perawatan
// *lempar
        JLabel daerahRawat = new JLabel();
        daerahRawat.setText("Daerah Perawatan\t:");
        daerahRawat.setBounds(15,215,175,25);
        daerahRawat.setVisible(true);
        frame.add(daerahRawat);
        
        JButton cariDaerahRawat = new JButton("Cari");
        cariDaerahRawat.setBounds(410, 215, 100, 25);
        cariDaerahRawat.setBackground(green);
        frame.add(cariDaerahRawat);
        cariDaerahRawat.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Kapasitas_Kamar();
        }
        });
        
        JTextField textfieldDaerahRawat = new JTextField();
        textfieldDaerahRawat.setBounds(210, 215, 200, 25);
        textfieldDaerahRawat.setBackground(Color.WHITE);
        frame.add(textfieldDaerahRawat);

//        textfieldDaerahRawat.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        Tanggal masuk
// *date
        JLabel masuk = new JLabel();
        masuk.setText("Tanggal Masuk\t:");
        masuk.setBounds(15,255,175,25);
        masuk.setVisible(true);
        frame.add(masuk);
        
        JTextField textfieldMasuk = new JTextField();
        textfieldMasuk.setBounds(210, 255, 300, 25);
        textfieldMasuk.setBackground(Color.WHITE);
        frame.add(textfieldMasuk);

//        textfieldMasuk.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });


        
//        cari
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 335, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Pasien p = new Pasien();
            p.setNama(textfieldName.getText());
            p.setAlamat(textfieldAlamat.getText());
            p.setGender(textfieldGender.getText());
            p.setDaerahPerawatan(textfieldDaerahRawat.getText().toUpperCase());
            p.setTanggalLahir(LocalDate.parse(textfieldTTL.getText()));
            p.setTanggalMasuk(LocalDate.parse(textfieldMasuk.getText()));
            
            p.setIdCabang(Cabang.getInstance().getId());
            LocalDate x = LocalDate.MIN;
            boolean get = true;
            try{
                x = LocalDate.parse(textfieldMasuk.getText());
            }catch(Exception ec){
                JOptionPane.showMessageDialog(null, "Format input salah... ini seharusnya pakai date input library.\n tapi sesuatu terjadi dan kita harus improv");
                get = false;
            }
            if(get){
                cp.insertPasien(p);
                new Menu_Staff();
                frame.hide();
            }
            // cari
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(370,375,140,25);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Menu_Staff();
            frame.hide();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Tambah_Pasien();
    }
}
