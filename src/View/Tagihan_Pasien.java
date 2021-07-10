
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Richard
 */
public class Tagihan_Pasien {
    
    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);
    
    public Tagihan_Pasien(){
        JFrame frame = new JFrame("Pembayaran Tagihan Pasien");
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

//        Alamat Pasien
        JLabel alamat = new JLabel();
        alamat.setText("Alamat Pasien\t:");
        alamat.setBounds(15,95,175,25);
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
//            
//        });

//        cari
        JButton cariId = new JButton("Cari dengan ID");
        cariId.setBounds(210, 140, 140, 25);
        cariId.setBackground(green);
        frame.add(cariId);
        cariId.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Tagihan_Pasien_ID();
            frame.hide();
        }
        });
        
//        cari dengan id
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 140, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // cari
        }
        });
        
        // result box
        JLabel namaPasien = new JLabel("nama"/*dari database*/);
        namaPasien.setBounds(15, 180, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        JLabel TTLPasien = new JLabel("TTL"/*dari database*/);
        TTLPasien.setBounds(15, 230, 495, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);
        JLabel alamatPasien = new JLabel("alamat"/*dari database*/);
        alamatPasien.setBounds(15, 280, 495, 50);
        alamatPasien.setBackground(Color.WHITE);
        frame.add(alamatPasien);
        
//        cek tagihan
        JButton hapus = new JButton("Cek Tagihan");
        hapus.setBounds(350,345,150,25);
        hapus.setBackground(green);
        frame.add(hapus);
        hapus.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Cek_Tagihan();
            frame.hide();
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350,385,150,25);
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
    
    public void Tagihan_Pasien_ID(){
    JFrame frame = new JFrame("Pembayaran Tagihan Pasien");
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        
//        Nama Pasien
        JLabel id = new JLabel();
        id.setText("ID Pasien\t:");
        id.setBounds(15,15,175,25);
        id.setVisible(true);
        frame.add(id);
        
        JTextField textfieldID = new JTextField();
        textfieldID.setBounds(210, 15, 300, 30);
        textfieldID.setBackground(Color.WHITE);
        frame.add(textfieldID);
        
//        textfieldName.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        cari
        JButton cariBio = new JButton("Cari dengan Nama");
        cariBio.setBounds(210, 140, 140, 25);
        cariBio.setBackground(green);
        frame.add(cariBio);
        cariBio.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tagihan_Pasien();
            frame.hide();
        }
        });
        
//        cari dengan id
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 140, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // cari
        }
        });
        
//        result box
        JLabel namaPasien = new JLabel("nama"/*dari database*/);
        namaPasien.setBounds(15, 180, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        JLabel TTLPasien = new JLabel("TTL"/*dari database*/);
        TTLPasien.setBounds(15, 230, 495, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);
        JLabel alamatPasien = new JLabel("alamat"/*dari database*/);
        alamatPasien.setBounds(15, 280, 495, 50);
        alamatPasien.setBackground(Color.WHITE);
        frame.add(alamatPasien);
        
//        cek tagihan
        JButton hapus = new JButton("Cek Tagihan");
        hapus.setBounds(350,345,150,25);
        hapus.setBackground(green);
        frame.add(hapus);
        hapus.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Cek_Tagihan();
            frame.hide();
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350,385,150,25);
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
    
    public void Cek_Tagihan() {
        JFrame frame = new JFrame("Cek Tagihan Pasien");
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        
    //        result box
        JLabel namaPasien = new JLabel("nama"/*dari database*/);
        namaPasien.setBounds(15, 15, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        JLabel TTLPasien = new JLabel("TTL"/*dari database*/);
        TTLPasien.setBounds(15, 65, 495, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);
        JLabel alamatPasien = new JLabel("alamat"/*dari database*/);
        alamatPasien.setBounds(15, 115, 495, 50);
        alamatPasien.setBackground(Color.WHITE);
        frame.add(alamatPasien);
        
//        tagihan
        JLabel tagihan = new JLabel("Tagihan" /*dari database */);
        tagihan.setBounds(15, 165, 495, 150);
        tagihan.setBackground(Color.WHITE);
        frame.add(tagihan);

//        print      
        JButton print = new JButton("Print");
        print.setBounds(185,330,150,25);
        print.setBackground(green);
        frame.add(print);
        print.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Print_Tagihan();
            frame.hide();
        }
        });

//        pelunasan      
        JButton hapus = new JButton("Pelunasan");
        hapus.setBounds(350,330,150,25);
        hapus.setBackground(green);
        frame.add(hapus);
        hapus.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Pelunasan();
            frame.hide();
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350,370,150,25);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tagihan_Pasien();
            frame.hide();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
}
    
    public void Print_Tagihan(){
        JFrame frame = new JFrame("Print Tagihan Pasien");
        frame.setSize(550,550);
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
                Cek_Tagihan();
                frame.hide();
            }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void Pelunasan(){
        JFrame frame = new JFrame("Cek Tagihan Pasien");
        frame.setSize(250,150);
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
