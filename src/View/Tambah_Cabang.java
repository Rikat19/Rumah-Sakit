/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Devan
 */
public class Tambah_Cabang{
    
    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);
    
    public Tambah_Cabang(){
        JFrame frame = new JFrame("Tambah Cabang");
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        
//        Nama cabang
        JLabel nama = new JLabel();
        nama.setText("Nama Cabang\t:");
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

//        alamat
        JLabel TTL = new JLabel();
        TTL.setText("Alamat Cabang \t:");
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

//       kapkar
// radio
        JLabel gender = new JLabel();
        gender.setText("Kapasitas Kamar \t:");
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


//        tambah
        JButton tambah = new JButton("Tambah");
        tambah.setBounds(370, 335, 140, 25);
        tambah.setBackground(green);
        frame.add(tambah);
        tambah.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
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
            new Menu_Admin();
            frame.hide();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Tambah_Cabang();
    }
}
