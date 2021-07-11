/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import static java.awt.Color.green;
import java.awt.PopupMenu;
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
 * @author Devan
 */
public class Hapus_Staff {

    public Hapus_Staff() {
    JFrame frame = new JFrame("Hapus Staff");
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        
    //Nama Staff
        JLabel nama = new JLabel();
        nama.setText("Nama Staff\t:");
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
        
    //TTL Staff
        JLabel TTL = new JLabel();
        TTL.setText("TTL Staff\t:");
        TTL.setBounds(15,55,175,25);
        TTL.setVisible(true);
        frame.add(TTL);
        
        JTextField textfieldTTL = new JTextField();
        textfieldTTL.setBounds(210, 55, 300, 25);
        textfieldTTL.setBackground(Color.WHITE);
        frame.add(textfieldTTL);
        
//        textfieldName.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
        
        //        Tugas Staff
        JLabel tugas = new JLabel();
        tugas.setText("Alamat Pasien\t:");
        tugas.setBounds(15,95,175,25);
        tugas.setVisible(true);
        frame.add(tugas);
        
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

        //cari
        JButton cariId = new JButton("Cari dengan ID");
        cariId.setBounds(210, 140, 140, 25);
        Color green = new Color(0, 200, 0);
        cariId.setBackground(green);
        frame.add(cariId);
        cariId.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Hapus_ID();
        }
        });
        
        //cari dengan id
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
        JLabel namaPasien = new JLabel("Nama"/*dari database*/);
        namaPasien.setBounds(15, 180, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        JLabel cabangKerja = new JLabel("Cabangkerja"/*dari database*/);
        cabangKerja.setBounds(15, 230, 495, 50);
        cabangKerja.setBackground(Color.WHITE);
        frame.add(cabangKerja);
        JLabel tugasStaff = new JLabel("Tugas staff"/*dari database*/);
        tugasStaff.setBounds(15, 280, 495, 50);
        tugasStaff.setBackground(Color.WHITE);
        frame.add(tugasStaff);
    
        
        //Hapus      
        JButton hapus = new JButton("Hapus");
        hapus.setBounds(350,345,150,25);
        hapus.setBackground(green);
        frame.add(hapus);
        hapus.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // hapus dari database
        }
        });
        //back      
        JButton back = new JButton("Back");
        back.setBounds(350,385,150,25);
        Color red = new Color(250, 0, 0);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Menu_Admin();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
        public void Hapus_ID(){
            JFrame frame = new JFrame("Hapus Staff");
            frame.setSize(550,550);
            frame.setLocationRelativeTo(null);
            
        //        Nama Staff
        JLabel id = new JLabel();
        id.setText("ID Staff\t:");
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

        //cari dengan id
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
        JLabel namaPasien = new JLabel("Nama"/*dari database*/);
        namaPasien.setBounds(15, 180, 495, 50);
        namaPasien.setBackground(Color.WHITE);
        frame.add(namaPasien);
        JLabel cabangKerja = new JLabel("Cabang kerja"/*dari database*/);
        cabangKerja.setBounds(15, 230, 495, 50);
        cabangKerja.setBackground(Color.WHITE);
        frame.add(cabangKerja);
        JLabel tugasStaff = new JLabel("Tugas staff"/*dari database*/);
        tugasStaff.setBounds(15, 280, 495, 50);
        tugasStaff.setBackground(Color.WHITE);
        frame.add(tugasStaff);
        
        //        back      
        JButton back = new JButton("Back");
        back.setBounds(350,380,150,25);
        Color red = new Color(250, 0, 0);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Menu_Admin();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
        }
        public static void main(String[] args) {
        new Hapus_Staff();
    }
}
