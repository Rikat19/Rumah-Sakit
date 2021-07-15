package View;

import Controller.Control;
import Controller.ControlDokter;
import Controller.ControlPasien;
import Model.Pasien;
import Model.Perawatan;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class Tambah_Perawatan_Pasien {

    Control c = new Control();
    ControlPasien cp = new ControlPasien();
    ControlDokter cd = new ControlDokter();

    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);

    public Tambah_Perawatan_Pasien() {
        JFrame frame = new JFrame("Tambah Perawatan Pasien");
        frame.setSize(550, 550);
        frame.setLocationRelativeTo(null);

//        ID Pasien
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
//            
//        });
//        perawatan
        JLabel perawatan = new JLabel();
        perawatan.setText("Perawatan\t:");
        perawatan.setBounds(15, 55, 175, 25);
        perawatan.setVisible(true);
        frame.add(perawatan);

        JTextField textfieldPerawatan = new JTextField();
        textfieldPerawatan.setBounds(210, 55, 300, 25);
        textfieldPerawatan.setBackground(Color.WHITE);
        frame.add(textfieldPerawatan);

//        textfieldPerawatan.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        Dokter
// *lempar
        JLabel dokter = new JLabel();
        dokter.setText("Dokter yang Merawat\t:");
        dokter.setBounds(15, 95, 175, 25);
        dokter.setVisible(true);
        frame.add(dokter);

        JButton cariDokter = new JButton("Cari");
        cariDokter.setBounds(410, 95, 100, 25);
        cariDokter.setBackground(green);
        frame.add(cariDokter);
        cariDokter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Jadwal_Dokter();
            }
        });

        JTextField textfieldDokter = new JTextField();
        textfieldDokter.setBounds(210, 95, 200, 25);
        textfieldDokter.setBackground(Color.WHITE);
        frame.add(textfieldDokter);

//        textfieldDokter.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        alat
// *lempar
        JLabel alat = new JLabel();
        alat.setText("Alat\t:");
        alat.setBounds(15, 135, 175, 25);
        alat.setVisible(true);
        frame.add(alat);

        JButton cariAlat = new JButton("Cari");
        cariAlat.setBounds(410, 135, 100, 25);
        cariAlat.setBackground(green);
        frame.add(cariAlat);
        cariAlat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Lihat_Alat();
            }
        });

        JTextField textfieldAlat = new JTextField();
        textfieldAlat.setBounds(210, 135, 200, 25);
        textfieldAlat.setBackground(Color.WHITE);
        frame.add(textfieldAlat);

//        textfieldAlat.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        obat
// *lempar
        JLabel obat = new JLabel();
        obat.setText("Obat\t:");
        obat.setBounds(15, 175, 175, 25);
        obat.setVisible(true);
        frame.add(obat);

        JButton cariObat = new JButton("Cari");
        cariObat.setBounds(410, 175, 100, 25);
        cariObat.setBackground(green);
        frame.add(cariObat);
        cariObat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Lihat_Obat();
            }
        });

        JTextField textfieldObat = new JTextField();
        textfieldObat.setBounds(210, 175, 200, 25);
        textfieldObat.setBackground(Color.WHITE);
        frame.add(textfieldObat);

//        textfieldObat.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        cari
        JButton cari = new JButton("Cari");
        cari.setBounds(370, 220, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Perawatan p = new Perawatan();

                String[] obat = textfieldObat.getText().split(",");
                String[] alat = textfieldAlat.getText().split(",");
                for (int i = 0; i < obat.length; i++) {
                    p.idObat = new ArrayList();
                    p.idObat.add(Integer.valueOf(obat[i]));
                }
                for (int i = 0; i < alat.length; i++) {
                    p.idAlat = new ArrayList();
                    p.idAlat.add(Integer.valueOf(alat[i]));
                }
                p.setDokter(cd.cariDokterDariIdDokter(Integer.valueOf(textfieldDokter.getText())));
                p.setNama(textfieldPerawatan.getText());

                Pasien pasien = cp.getPasienDariIdPerson(Integer.valueOf(textfieldId.getText()));
                cp.insertPerawatanKePasien(pasien, p);

                new Menu_Staff();
                frame.hide();
                // cari
            }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(370, 265, 140, 25);
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
