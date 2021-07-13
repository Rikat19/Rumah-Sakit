
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
public class Edit_Pasien {
    
    Color green = new Color(0, 200, 0);
    
    public Edit_Pasien(){
        JFrame frame = new JFrame("Edit Riwayat Pasien");
        frame.setSize(550,500);
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
//        });

//        cari
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 140, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // cari
        }
        });
        
//        cari dengan id
        JButton cariId = new JButton("Cari dengan ID");
        cariId.setBounds(210, 140, 140, 25);
        cariId.setBackground(green);
        frame.add(cariId);
        cariId.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Edit_dengan_ID();
            frame.hide();
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
        
//        edit      
        JButton edit = new JButton("Edit");
        edit.setBounds(350,345,150,25);
        edit.setBackground(green);
        frame.add(edit);
        edit.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.setVisible(false);
            // bikin frame buat lihat hasil edit pasien
            // menuju frame menu utama
            new Menu_Staff();
            // menuju frame lihat list pasien
            new Lihat_Pasien();
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350,385,150,25);
        Color red = new Color(250, 0, 0);
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
    
    public void Edit_dengan_ID(){
        JFrame frame = new JFrame("Edit Riwayat Pasien");
        frame.setSize(550,420);
        frame.setLocationRelativeTo(null);
        
//        Id Pasien
        JLabel id = new JLabel();
        id.setText("Nama Pasien\t:");
        id.setBounds(15,15,175,25);
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
        cari.setBounds(370, 60, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // cari
        }
        });
        
//        cari dengan nama
        JButton cariNama = new JButton("Cari dengan ID");
        cariNama.setBounds(210, 60, 140, 25);
        cariNama.setBackground(green);
        frame.add(cariNama);
        cariNama.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Edit_Pasien();
            frame.hide();
        }
        });
        
//        result box
        JLabel namaPasien = new JLabel("nama"/*dari database*/);
        namaPasien.setBounds(15, 100, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        
        JLabel TTLPasien = new JLabel("TTL"/*dari database*/);
        TTLPasien.setBounds(15, 150, 495, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);
        
        JLabel alamatPasien = new JLabel("alamat"/*dari database*/);
        alamatPasien.setBounds(15, 200, 495, 50);
        alamatPasien.setBackground(Color.WHITE);
        frame.add(alamatPasien);
        
//        edit      
        JButton edit = new JButton("Edit");
        edit.setBounds(350,265,150,25);
        edit.setBackground(green);
        frame.add(edit);
        edit.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.setVisible(false);
            // bikin frame buat lihat hasil edit pasien
            // menuju frame menu utama
            new Menu_Staff();
            // menuju frame lihat list pasien
            new Lihat_Pasien();
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350,305,150,25);
        Color red = new Color(250, 0, 0);
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
        new Edit_Pasien();
    }
}
