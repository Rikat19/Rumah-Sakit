/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Devan
 */
public class menuadmin {
    
    public menuadmin (){
        JFrame frame = new JFrame("Menu Admin");
        frame.setSize(650,550);
        frame.setLocationRelativeTo(null);
        
        // edit cabang
        JLabel editCabang = new JLabel();
        editCabang.setText("Edit Cabang\n");
        editCabang.setBounds(15,10,175,25);
        editCabang.setVisible(true);
        
        JButton lihatCabang = new JButton("Lihat Cabang");
        lihatCabang.setBounds(10,55,150,25);
        JButton tambahCabang = new JButton("Tambah Cabang");
        tambahCabang.setBounds(175,55,150,25);
        JButton hapusCabang = new JButton("Hapus Cabang");
        hapusCabang.setBounds(340,55,150,25);
        
        frame.add(editCabang);
        frame.add(lihatCabang);
        lihatCabang.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        //    new Lihat_Cabang();
        }
        });
        
        frame.add(tambahCabang);
        tambahCabang.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        //    new Tambah_Cabang();
        }
        });
        
        frame.add(hapusCabang);
        hapusCabang.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        //    new Hapus_Cabang();
        }
        });
        
        // edit staff
        JLabel editStaff = new JLabel();
        editStaff.setText("Edit Staff\n");
        editStaff.setBounds(15,95,175,25);
        editStaff.setVisible(true);
        
        JButton lihatStaff = new JButton("Lihat Staff");
        lihatStaff.setBounds(10,135,150,25);
        JButton tambahStaff = new JButton("Tambah Staff");
        tambahStaff.setBounds(175,135,150,25);
        JButton hapusStaff = new JButton("Hapus Staff");
        hapusStaff.setBounds(340,135,150,25);
        
        frame.add(editStaff);
        frame.add(lihatStaff);
        lihatStaff.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Lihat_Staff();
        }
        });
        
        frame.add(tambahStaff);
        tambahStaff.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Tambah_Staff();
        }
        });
        
        frame.add(hapusStaff);
        hapusStaff.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Hapus_Staff();
        }
        });
        
        // lihat penghasilan
        JLabel lihatPenghasilan = new JLabel();
        lihatPenghasilan.setText("Lihat Penghasilan\n");
        lihatPenghasilan.setBounds(15,175,175,25);
        lihatPenghasilan.setVisible(true);
        
        JButton lihatPenghasilanTotal = new JButton("Lihat Penghasilan Total");
        lihatPenghasilanTotal.setBounds(10,215,150,25);
        JButton lihatPenghasilanPerCabang = new JButton("Lihat Penghasilan Per Cabang");
        lihatPenghasilanPerCabang.setBounds(175,215,150,25);
        
        frame.add(lihatPenghasilan);
        frame.add(lihatPenghasilanTotal);
        lihatPenghasilanTotal.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Lihat_Penghasilan_Total();
        }
        });
        
        frame.add(lihatPenghasilanPerCabang);
        lihatPenghasilanPerCabang.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Lihat_Penghasilan_Per_Cabang();
        }
        });
        
        // beban gaji
        JLabel bebanGaji = new JLabel();
        bebanGaji.setText("Beban Gaji\n");
        bebanGaji.setBounds(15,255,175,25);
        bebanGaji.setVisible(true);
        
        JButton lihatBebanGajiTotal = new JButton("Lihat Beban Gaji Total");
        lihatBebanGajiTotal.setBounds(10,295,150,25);
        JButton lihatBebanGajiPerCabang = new JButton("Lihat Beban Gaji Per Cabang");
        lihatBebanGajiPerCabang.setBounds(175,295,150,25);
        
        frame.add(bebanGaji);
        frame.add(lihatBebanGajiTotal);
        lihatBebanGajiTotal.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
           new Lihat_Beban_Gaji_Total();
        }
        });
        
        frame.add(lihatBebanGajiPerCabang);
        lihatBebanGajiPerCabang.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Lihat_Beban_Gaji_Per_Cabang();
        }
        });
        
        // logout      
        JButton logout = new JButton("Logout");
        logout.setBounds(450,450,150,25);
        Color red = new Color(250, 0, 0);
        logout.setBackground(red);
        frame.add(logout);
        logout.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Logout();
        }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
        
        public static void main(String[] args) {
        new menuadmin();
    }
}
