
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
public class Restock_Data_Storage {
    
    public Restock_Data_Storage(){
        JFrame frame = new JFrame("Hapus Data Storage");
        frame.setSize(550,450);
        frame.setLocationRelativeTo(null);
        
//        Nama Barang
        JLabel nama = new JLabel();
        nama.setText("Nama Barang\t:");
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

//        Jumlah
        JLabel jml = new JLabel();
        jml.setText("Jumlah\t:");
        jml.setBounds(15,55,175,25);
        jml.setVisible(true);
        frame.add(jml);
        
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

//        cari
        JButton cariId = new JButton("Cari dengan ID");
        cariId.setBounds(210, 100, 140, 25);
        Color green = new Color(0, 200, 0);
        cariId.setBackground(green);
        frame.add(cariId);
        cariId.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Hapus_dengan_ID();
            frame.hide();
        }
        });
        
//        cari dengan id
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 100, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // cari
            //frame.hide();
        }
        });
        
        // result box
        JLabel namaPasien = new JLabel("nama"/*dari database*/);
        namaPasien.setBounds(15, 140, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        JLabel TTLPasien = new JLabel("TTL"/*dari database*/);
        TTLPasien.setBounds(15, 190, 495, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);
        
//        Hapus      
        JButton hapus = new JButton("Hapus");
        hapus.setBounds(350,255,150,25);
        hapus.setBackground(green);
        frame.add(hapus);
        hapus.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // hapus database
            //frame.hide();
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350,295,150,25);
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
    
    public void Hapus_dengan_ID(){
        JFrame frame = new JFrame("Hapus Data Storage");
        frame.setSize(550,450);
        frame.setLocationRelativeTo(null);
        
//        Nama Barang
        JLabel id = new JLabel();
        id.setText("ID Barang\t:");
        id.setBounds(15,15,175,25);
        id.setVisible(true);
        frame.add(id);
        
        JTextField textfieldID = new JTextField();
        textfieldID.setBounds(210, 15, 300, 25);
        textfieldID.setBackground(Color.WHITE);
        frame.add(textfieldID);
        
//        textfieldName.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        Jumlah
        JLabel jml = new JLabel();
        jml.setText("Jumlah\t:");
        jml.setBounds(15,55,175,25);
        jml.setVisible(true);
        frame.add(jml);
        
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

//        cari
        JButton cariId = new JButton("Cari dengan Nama");
        cariId.setBounds(210, 100, 140, 25);
        Color green = new Color(0, 200, 0);
        cariId.setBackground(green);
        frame.add(cariId);
        cariId.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Restock_Data_Storage();
            frame.hide();
        }
        });
        
//        cari dengan id
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 100, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // cari
        }
        });
        
        // result box
        JLabel namaPasien = new JLabel("nama"/*dari database*/);
        namaPasien.setBounds(15, 140, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        JLabel TTLPasien = new JLabel("TTL"/*dari database*/);
        TTLPasien.setBounds(15, 190, 495, 50);
        TTLPasien.setBackground(Color.WHITE);
        frame.add(TTLPasien);
        
//        Hapus      
        JButton hapus = new JButton("Hapus");
        hapus.setBounds(350,255,150,25);
        hapus.setBackground(green);
        frame.add(hapus);
        hapus.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // hapus database
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350,295,150,25);
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
        new Restock_Data_Storage();
    }
}
