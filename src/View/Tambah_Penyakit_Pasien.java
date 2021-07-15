package View;

import Controller.ControlPasien;
import Model.Pasien;
import Model.Penyakit;
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
public class Tambah_Penyakit_Pasien {

    ControlPasien cp = new ControlPasien();

    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);

    public Tambah_Penyakit_Pasien() {
        JFrame frame = new JFrame("Tambah Penyakit Pasien");
        frame.setSize(550, 550);
        frame.setLocationRelativeTo(null);

//        ID Pasien
        JLabel id = new JLabel();
        id.setText("ID Pasien\t:");
        id.setBounds(15, 15, 175, 25);
        id.setVisible(true);
        frame.add(id);

        JTextField textfieldID = new JTextField();
        textfieldID.setBounds(210, 15, 300, 25);
        textfieldID.setBackground(Color.WHITE);
        frame.add(textfieldID);

//        textfieldID.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        nama??
//        JLabel nama = new JLabel();
//        nama.setText("Nama Pasien\t:");
//        nama.setBounds(15,55,175,25);
//        nama.setVisible(true);
//        frame.add(nama);
//        
//        JTextField textfieldName = new JTextField();
//        textfieldName.setBounds(210, 55, 300, 25);
//        textfieldName.setBackground(Color.WHITE);
//        frame.add(textfieldName);
//        textfieldName.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        penyakit
// radio
        JLabel penyakit = new JLabel();
        penyakit.setText("Penyakit\t:");
        penyakit.setBounds(15, 95, 175, 25);
        penyakit.setVisible(true);
        frame.add(penyakit);

        JTextField textfieldPenyakit = new JTextField();
        textfieldPenyakit.setBounds(210, 95, 300, 25);
        textfieldPenyakit.setBackground(Color.WHITE);
        frame.add(textfieldPenyakit);

//        textfieldPenyakit.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        lethality
        JLabel lethal = new JLabel();
        lethal.setText("Lethality Level\t:");
        lethal.setBounds(15, 135, 175, 25);
        lethal.setVisible(true);
        frame.add(lethal);

        JTextField textfieldLethal = new JTextField();
        textfieldLethal.setBounds(210, 135, 300, 25);
        textfieldLethal.setBackground(Color.WHITE);
        frame.add(textfieldLethal);

//        textfieldLethal.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        infectious
        JLabel infect = new JLabel();
        infect.setText("Infectious Level\t:");
        infect.setBounds(15, 175, 175, 25);
        infect.setVisible(true);
        frame.add(infect);

        JTextField textfieldInfect = new JTextField();
        textfieldInfect.setBounds(210, 175, 300, 25);
        textfieldInfect.setBackground(Color.WHITE);
        frame.add(textfieldInfect);

//        textfieldInfect.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        cari
        JButton cari = new JButton("Insert");
        cari.setBounds(370, 335, 140, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pasien p = cp.getPasienDariIdPerson(Integer.valueOf(textfieldID.getText()));
                Penyakit pp = new Penyakit();
                pp.setNama(textfieldPenyakit.getText());
                pp.setInfectious(Integer.valueOf(textfieldInfect.getText()));
                pp.setLethality(Integer.valueOf(textfieldLethal.getText()));

                cp.insertPenyakitKePasien(p, pp);
                new Menu_Staff();
                frame.hide();
                // cari
            }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(370, 375, 140, 25);
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
