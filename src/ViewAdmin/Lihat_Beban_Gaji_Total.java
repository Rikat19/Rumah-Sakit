/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewAdmin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Devan
 */
public class Lihat_Beban_Gaji_Total {
 
    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);

    public Lihat_Beban_Gaji_Total() {
        JFrame frame = new JFrame("Beban Gaji Total ");
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        
        

//        bulan
        JLabel bulan = new JLabel();
        bulan.setText("Bulan \t:");
        bulan.setBounds(15,15,175,25);
        bulan.setVisible(true);
        frame.add(bulan);
        
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

//        Tahun
        JLabel tahun = new JLabel();
        tahun.setText("Tahun \t:");
        tahun.setBounds(15,55,175,25);
        tahun.setVisible(true);
        frame.add(tahun);
        
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
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 335, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener(){
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
        new Lihat_Beban_Gaji_Total();
    }
    
}
