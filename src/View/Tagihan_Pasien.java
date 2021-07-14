package View;

import Controller.ControlPasien;
import Model.Pasien;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Richard
 */
public class Tagihan_Pasien {

    ControlPasien cp = new ControlPasien();
    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);

    public Tagihan_Pasien() {
        JFrame frame = new JFrame("Pembayaran Tagihan Pasien");
        frame.setSize(550, 570);
        frame.setLocationRelativeTo(null);

//        Nama Pasien
        JLabel nama = new JLabel();
        nama.setText("Nama Pasien\t:");
        nama.setBounds(15, 15, 175, 25);
        nama.setVisible(true);
        frame.add(nama);

        JTextField textfieldNama = new JTextField();
        textfieldNama.setBounds(210, 15, 300, 25);
        textfieldNama.setBackground(Color.WHITE);
        frame.add(textfieldNama);

//        textfieldNama.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//        });
      
//        TTL Pasien
        JLabel TTL = new JLabel();
        TTL.setText("TTL Pasien\t:");
        TTL.setBounds(15, 55, 175, 25);
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
//        });
      
//        Alamat Pasien
        JLabel alamat = new JLabel();
        alamat.setText("Alamat Pasien\t:");
        alamat.setBounds(15, 95, 175, 25);
        alamat.setVisible(true);
        frame.add(alamat);

        JTextField textfieldAlamat = new JTextField();
        textfieldAlamat.setBounds(210, 95, 300, 25);
        textfieldAlamat.setBackground(Color.WHITE);
        frame.add(textfieldAlamat);

//        textfieldAlamat.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//        });
      
//        cari
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 140, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // cari
            }
        });

//        cari dengan id
        JButton cariId = new JButton("Cari dengan ID");
        cariId.setBounds(210, 140, 140, 25);
        cariId.setBackground(green);
        frame.add(cariId);
        cariId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tagihan_Pasien_ID();
                frame.hide();
            }
        });

//        result box
        JLabel namaPasien = new JLabel("Nama:");
        namaPasien.setBounds(15, 180, 175, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);

//        dari database
        JLabel namaIsi = new JLabel();
        namaIsi.setBounds(210, 180, 300, 50);
        namaIsi.setBackground(Color.BLACK);
        frame.add(namaIsi);

        JLabel TTLPasien = new JLabel("TTL:");
        TTLPasien.setBounds(15, 230, 175, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);

//        dari database
        JLabel TTLIsi = new JLabel();
        TTLIsi.setBounds(210, 230, 300, 50);
        TTLIsi.setBackground(Color.BLACK);
        frame.add(TTLIsi);

        JLabel alamatPasien = new JLabel("Alamat:");
        alamatPasien.setBounds(15, 280, 175, 50);
        alamatPasien.setBackground(Color.WHITE);
        frame.add(alamatPasien);

//        dari database
        JLabel alamatIsi = new JLabel();
        alamatIsi.setBounds(210, 280, 300, 50);
        alamatIsi.setBackground(Color.BLACK);
        frame.add(alamatIsi);

        JLabel tglMasuk = new JLabel("Tanggal Masuk:");
        tglMasuk.setBounds(15, 330, 175, 50);
        tglMasuk.setBackground(Color.WHITE);
        frame.add(tglMasuk);

//        dari database
        JLabel tglMasukIsi = new JLabel();
        tglMasukIsi.setBounds(210, 330, 300, 50);
        tglMasukIsi.setBackground(Color.BLACK);
        frame.add(tglMasukIsi);

//        Tanggal Keluar
//        *date
        JLabel tglKeluar = new JLabel();
        tglKeluar.setText("Tanggal Keluar\t:");
        tglKeluar.setBounds(15, 395, 175, 25);
        tglKeluar.setVisible(true);
        frame.add(tglKeluar);

        JTextField textfieldKeluar = new JTextField();
        textfieldKeluar.setBounds(210, 395, 300, 25);
        textfieldKeluar.setBackground(Color.WHITE);
        frame.add(textfieldKeluar);

//        textfieldKeluar.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//        });
      
//        cek tagihan
        JButton cek = new JButton("Cek Tagihan");
        cek.setBounds(360, 435, 150, 25);
        cek.setBackground(green);
        frame.add(cek);
        cek.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Pasien p = cp.getPasienDariAtribut(textfieldNama.getText(), textfieldTTL.getText(), textfieldAlamat.getText());
            LocalDate tgl = LocalDate.parse(textfieldKeluar.getText());
            Cek_Tagihan(p,tgl);
            frame.hide();
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(360, 475, 150, 25);
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

    public void Tagihan_Pasien_ID() {
        JFrame frame = new JFrame("Pembayaran Tagihan Pasien");
        frame.setSize(550, 570);
        frame.setLocationRelativeTo(null);

//        Nama Pasien
        JLabel id = new JLabel();
        id.setText("ID Pasien\t:");
        id.setBounds(15, 15, 175, 25);
        id.setVisible(true);
        frame.add(id);

        JTextField textfieldId = new JTextField();
        textfieldId.setBounds(210, 15, 300, 25);
        textfieldId.setBackground(Color.WHITE);
        frame.add(textfieldId);

//        textfieldId.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//        });
      
//        cari
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 140, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // cari
            }
        });

//        cari dengan id
        JButton cariBio = new JButton("Cari dengan Nama");
        cariBio.setBounds(210, 140, 140, 25);
        cariBio.setBackground(green);
        frame.add(cariBio);
        cariBio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tagihan_Pasien();
                frame.hide();
            }
        });

//        result box
        JLabel namaPasien = new JLabel("Nama:");
        namaPasien.setBounds(15, 180, 175, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);

//        dari database
        JLabel namaIsi = new JLabel();
        namaIsi.setBounds(210, 180, 300, 50);
        namaIsi.setBackground(Color.BLACK);
        frame.add(namaIsi);

        JLabel TTLPasien = new JLabel("TTL:");
        TTLPasien.setBounds(15, 230, 175, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);

//        dari database
        JLabel TTLIsi = new JLabel();
        TTLIsi.setBounds(210, 230, 300, 50);
        TTLIsi.setBackground(Color.BLACK);
        frame.add(TTLIsi);

        JLabel alamatPasien = new JLabel("Alamat:");
        alamatPasien.setBounds(15, 280, 175, 50);
        alamatPasien.setBackground(Color.WHITE);
        frame.add(alamatPasien);

//        dari database
        JLabel alamatIsi = new JLabel();
        alamatIsi.setBounds(210, 280, 300, 50);
        alamatIsi.setBackground(Color.BLACK);
        frame.add(alamatIsi);

        JLabel tglMasuk = new JLabel("Tanggal Masuk:");
        tglMasuk.setBounds(15, 330, 175, 50);
        tglMasuk.setBackground(Color.WHITE);
        frame.add(tglMasuk);

//        dari database
        JLabel tglMasukIsi = new JLabel();
        tglMasukIsi.setBounds(210, 330, 300, 50);
        tglMasukIsi.setBackground(Color.BLACK);
        frame.add(tglMasukIsi);

//        Tanggal Keluar
//        *date
        JLabel tglKeluar = new JLabel();
        tglKeluar.setText("Tanggal Keluar\t:");
        tglKeluar.setBounds(15, 395, 175, 25);
        tglKeluar.setVisible(true);
        frame.add(tglKeluar);


        JTextField textfieldKeluar = new JTextField();
        textfieldKeluar.setBounds(210, 395, 300, 25);
        textfieldKeluar.setBackground(Color.WHITE);
        frame.add(textfieldKeluar);

//        textfieldKeluar.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//        });
      
//        cek tagihan
        JButton cek = new JButton("Cek Tagihan");
        cek.setBounds(360, 435, 150, 25);
        cek.setBackground(green);
        frame.add(cek);
        cek.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Pasien p = cp.getPasienDariId(Integer.valueOf(textfieldId.getText()));
            LocalDate tgl = LocalDate.parse(textfieldKeluar.getText());
            Cek_Tagihan(p,tgl);
            frame.hide();
        }
       });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(360, 475, 150, 25);
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
    
    public void Cek_Tagihan(Pasien p,LocalDate tgl) {
        JFrame frame = new JFrame("Cek Tagihan Pasien");
        frame.setSize(550, 550);
        frame.setLocationRelativeTo(null);
        
    //        result box
        JLabel namaPasien = new JLabel("nama: " + p.getNama());
        namaPasien.setBounds(15, 15, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        JLabel TTLPasien = new JLabel("TTL: " + p.getTanggalLahir().toString());
        TTLPasien.setBounds(15, 65, 495, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);
        JLabel alamatPasien = new JLabel("alamat: " + p.getAlamat());
        alamatPasien.setBounds(15, 115, 495, 50);
        alamatPasien.setBackground(Color.WHITE);
        frame.add(alamatPasien);

//        tagihan
        JLabel tagihan = new JLabel("Tagihan: RP" + cp.getBill(p));
        tagihan.setBounds(15, 165, 495, 150);
        tagihan.setBackground(Color.WHITE);
        frame.add(tagihan);

//        print      
        JButton print = new JButton("Print");
        print.setBounds(185, 330, 150, 25);
        print.setBackground(green);
        frame.add(print);
        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Print_Tagihan(p,tgl);
                frame.hide();
            }
        });

//        pelunasan      
        JButton hapus = new JButton("Pelunasan");
        hapus.setBounds(350, 330, 150, 25);
        hapus.setBackground(green);
        frame.add(hapus);
        hapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pelunasan();
                frame.hide();
            }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350, 370, 150, 25);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tagihan_Pasien();
                frame.hide();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void Print_Tagihan(Pasien p,LocalDate tgl) {
        JFrame frame = new JFrame("Print Tagihan Pasien");
        frame.setSize(550, 550);
        frame.setLocationRelativeTo(null);

//        tagihan
        JLabel tagihan = new JLabel("Tagihan"/*dari database*/);
        tagihan.setBounds(15, 15, 495, 50);
        tagihan.setBackground(Color.WHITE);
        frame.add(tagihan);


        JButton ok = new JButton("OK");
        ok.setBounds(350, 485, 150, 25);
        ok.setBackground(green);
        frame.add(ok);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cp.UpdateTanggalKeluar(p.getId(),tgl);
                Cek_Tagihan(p,tgl);
                frame.hide();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void Pelunasan() {
        JFrame frame = new JFrame("Cek Tagihan Pasien");
        frame.setSize(250, 150);
        frame.setLocationRelativeTo(null);

        // ubah enum menjadi lunas
        JButton ok = new JButton("OK");
        ok.setBounds(50, 50, 150, 25);
        ok.setBackground(green);
        frame.add(ok);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tagihan_Pasien();
                frame.hide();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Tagihan_Pasien();
    }
}
