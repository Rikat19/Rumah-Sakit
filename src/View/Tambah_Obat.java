package View;

import Controller.Control;
import Model.Cabang;
import Model.Obat;
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
public class Tambah_Obat {

    Control c = new Control();

    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);

    public Tambah_Obat() {
        JFrame frame = new JFrame("Tambah Data Storage");
        frame.setSize(550, 350);
        frame.setLocationRelativeTo(null);

//        Nama Obat
        JLabel nama = new JLabel();
        nama.setText("Nama Barang\t:");
        nama.setBounds(15, 15, 175, 25);
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
//        ???
//        JLabel jenis = new JLabel();
//        jenis.setText("Jenis Barang\t:");
//        jenis.setBounds(15, 55, 175, 25);
//        jenis.setVisible(true);
//        frame.add(jenis);
//
//        JTextField textfieldJenis = new JTextField();
//        textfieldJenis.setBounds(210, 55, 300, 25);
//        textfieldJenis.setBackground(Color.WHITE);
//        frame.add(textfieldJenis);
//        textfieldTTL.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        Gender
// radio
        JLabel jml = new JLabel();
        jml.setText("Jumlah\t:");
        jml.setBounds(15, 95, 175, 25);
        jml.setVisible(true);
        frame.add(jml);

        JTextField textfieldJML = new JTextField();
        textfieldJML.setBounds(210, 95, 300, 25);
        textfieldJML.setBackground(Color.WHITE);
        frame.add(textfieldJML);

//        textfieldJML.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        Alamat Pasien
        JLabel dosis = new JLabel();
        dosis.setText("dosis\t:");
        dosis.setBounds(15, 135, 175, 25);
        dosis.setVisible(true);
        frame.add(dosis);

        JTextField textfieldKondisi = new JTextField();
        textfieldKondisi.setBounds(210, 135, 300, 25);
        textfieldKondisi.setBackground(Color.WHITE);
        frame.add(textfieldKondisi);

//        textfieldKondisi.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        harga
        JLabel harga = new JLabel();
        harga.setText("Harga\t:");
        harga.setBounds(15, 175, 175, 25);
        harga.setVisible(true);
        frame.add(harga);

        JTextField textfieldHarga = new JTextField();
        textfieldHarga.setBounds(210, 175, 300, 25);
        textfieldHarga.setBackground(Color.WHITE);
        frame.add(textfieldHarga);

//        textfieldHarga.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        cari
        JButton cari = new JButton("Tambah");
        cari.setBounds(370, 220, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Obat obat = new Obat();
                obat.setNama(textfieldName.getText());
                obat.setIdCabang(Cabang.getInstance().getId());
                obat.setDosis(textfieldKondisi.getText());
                obat.setStock(Integer.valueOf(textfieldJML.getText()));
                obat.setHarga(Integer.valueOf(textfieldHarga.getText()));

                c.insertItemToCabang(obat, obat.getIdCabang());

                new Menu_Staff();
                frame.hide();
                // cari
            }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(370, 260, 140, 25);
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
