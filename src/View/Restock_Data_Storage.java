package View;

import Controller.Control;
import Controller.ControlPasien;
import Model.Item;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class Restock_Data_Storage {

    Control c = new Control();
    ControlPasien cp = new ControlPasien();
    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);

    public Restock_Data_Storage() {
        JFrame frame = new JFrame("Restock Storage");
        frame.setSize(550, 450);
        frame.setLocationRelativeTo(null);

//        Nama Barang
        JLabel nama = new JLabel();
        nama.setText("Nama Barang\t:");
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
//        Jumlah
        JLabel jml = new JLabel();
        jml.setText("Jumlah\t:");
        jml.setBounds(15, 55, 175, 25);
        jml.setVisible(true);
        frame.add(jml);

        JTextField textfieldJml = new JTextField();
        textfieldJml.setBounds(210, 55, 300, 25);
        textfieldJml.setBackground(Color.WHITE);
        frame.add(textfieldJml);

//        textfieldJml.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//        });
//        cari
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 100, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // cari
                //frame.hide();
            }
        });

//        cari dengan id
//        JButton cariId = new JButton("Cari dengan ID");
//        cariId.setBounds(210, 100, 140, 25);
//        cariId.setBackground(green);
//        frame.add(cariId);
//        cariId.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Edit_dengan_ID();
//                frame.hide();
//            }
//        });
//        result box
        JLabel namaBarang = new JLabel("id Barang: ");
        namaBarang.setBounds(15, 140, 495, 50);
        namaBarang.setBackground(Color.WHITE);
        frame.add(namaBarang);

//        dari database
        JLabel namaIsi = new JLabel();
        namaIsi.setBounds(15, 140, 495, 50);
        namaIsi.setBackground(Color.WHITE);
        frame.add(namaIsi);

        JLabel jmlIsi = new JLabel("Jumlah Barang: ");
        jmlIsi.setBounds(15, 190, 495, 50);
        jmlIsi.setBackground(Color.WHITE);
        frame.add(jmlIsi);

//        dari database
        JLabel jmlBarang = new JLabel();
        jmlBarang.setBounds(15, 190, 495, 50);
        jmlBarang.setBackground(Color.WHITE);
        frame.add(jmlBarang);

//        restock      
        JButton restock = new JButton("Restock");
        restock.setBounds(350, 255, 150, 25);
        restock.setBackground(green);
        frame.add(restock);
        restock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Item item = new Item();
                cp.cariItemDariIdItem(item, Integer.valueOf(textfieldNama.getText()));
                c.restokItem(item, Integer.valueOf(textfieldNama.getText()), Integer.valueOf(textfieldJml.getText()));
                new Menu_Staff();
                frame.hide();
                // hapus database
                //frame.hide();
            }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350, 295, 150, 25);
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

    public void Edit_dengan_ID() {
        JFrame frame = new JFrame("Restock Storage");
        frame.setSize(550, 450);
        frame.setLocationRelativeTo(null);

//        Nama Barang
        JLabel nama = new JLabel();
        nama.setText("Nama Barang\t:");
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
//        Jumlah
        JLabel jml = new JLabel();
        jml.setText("Jumlah\t:");
        jml.setBounds(15, 55, 175, 25);
        jml.setVisible(true);
        frame.add(jml);

        JTextField textfieldJml = new JTextField();
        textfieldJml.setBounds(210, 55, 300, 25);
        textfieldJml.setBackground(Color.WHITE);
        frame.add(textfieldJml);

//        textfieldJml.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//        });
//        cari
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 100, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // cari
                //frame.hide();
            }
        });

//        cari dengan nama
        JButton cariNama = new JButton("Cari dengan Nama");
        cariNama.setBounds(210, 100, 140, 25);
        cariNama.setBackground(green);
        frame.add(cariNama);
        cariNama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Restock_Data_Storage();
                frame.hide();
            }
        });

//        result box
        JLabel namaBarang = new JLabel("Nama Barang: ");
        namaBarang.setBounds(15, 140, 495, 50);
        namaBarang.setBackground(Color.WHITE);
        frame.add(namaBarang);

//        dari database
        JLabel namaIsi = new JLabel();
        namaIsi.setBounds(15, 140, 495, 50);
        namaIsi.setBackground(Color.WHITE);
        frame.add(namaIsi);

        JLabel jmlIsi = new JLabel("Jumlah Barang: ");
        jmlIsi.setBounds(15, 190, 495, 50);
        jmlIsi.setBackground(Color.WHITE);
        frame.add(jmlIsi);

//        dari database
        JLabel jmlBarang = new JLabel();
        jmlBarang.setBounds(15, 190, 495, 50);
        jmlBarang.setBackground(Color.WHITE);
        frame.add(jmlBarang);

//        restock      
        JButton restock = new JButton("Restock");
        restock.setBounds(350, 255, 150, 25);
        restock.setBackground(green);
        frame.add(restock);
        restock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // hapus database

//                Item item = cp.cariItemDariIdItem(item, )
//                c.restokItem(item, 0, 0);
                //frame.hide();
            }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(350, 295, 150, 25);
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
}
