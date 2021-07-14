
package ViewAdmin;

import Controller.ControlStaff;
import Model.Cabang;
import Model.Pasien;
import Model.Staff;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Richard
 */
public class Tambah_Staff{
    
    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);
    
    public Tambah_Staff(){
        ControlStaff cs = new ControlStaff();
        JFrame frame = new JFrame("Tambah Riwayat Pasien");
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        
//        Nama Pasien
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

//        TTL Pasien
        JLabel TTL = new JLabel();
        TTL.setText("TTL Staff\t:");
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

//        Gender
// radio
        JLabel gender = new JLabel();
        gender.setText("Gender\t:");
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

//        Alamat Pasien
        JLabel alamat = new JLabel();
        alamat.setText("Alamat Staff\t:");
        alamat.setBounds(15,135,175,25);
        alamat.setVisible(true);
        frame.add(alamat);
        
        JTextField textfieldAlamat = new JTextField();
        textfieldAlamat.setBounds(210, 135, 300, 25);
        textfieldAlamat.setBackground(Color.WHITE);
        frame.add(textfieldAlamat);

//        textfieldAlamat.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        shift
// *lempar
        JLabel shift = new JLabel();
        shift.setText("Shift Kerja\t:");
        shift.setBounds(15,175,175,25);
        shift.setVisible(true);
        frame.add(shift);
               
        JTextField textfieldShift = new JTextField();
        textfieldShift.setBounds(210, 175, 300, 25);
        textfieldShift.setBackground(Color.WHITE);
        frame.add(textfieldShift);

//        textfieldShift.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        gaji
// *lempar
        JLabel gaji = new JLabel();
        gaji.setText("Gaji\t:");
        gaji.setBounds(15,215,175,25);
        gaji.setVisible(true);
        frame.add(gaji);
        
        JTextField textfieldGaji = new JTextField();
        textfieldGaji.setBounds(210, 215, 300, 25);
        textfieldGaji.setBackground(Color.WHITE);
        frame.add(textfieldGaji);

//        textfieldGaji.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        Tanggal awal kerja
// *date
        JLabel tglAwalKerja = new JLabel();
        tglAwalKerja.setText("Tanggal Awal Kerja\t:");
        tglAwalKerja.setBounds(15,255,175,25);
        tglAwalKerja.setVisible(true);
        frame.add(tglAwalKerja);
        
        JTextField textfieldTglAwalKerja = new JTextField();
        textfieldTglAwalKerja.setBounds(210, 255, 300, 25);
        textfieldTglAwalKerja.setBackground(Color.WHITE);
        frame.add(textfieldTglAwalKerja);

//        textfieldTglAwalKerja.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        id cabang kerja
// *date
        JLabel idCabangKerja = new JLabel();
        idCabangKerja.setText("ID Cabang\t:");
        idCabangKerja.setBounds(15,295,175,25);
        idCabangKerja.setVisible(true);
        frame.add(idCabangKerja);
        
        JTextField textfieldIdCabangKerja = new JTextField();
        textfieldIdCabangKerja.setBounds(210, 295, 300, 25);
        textfieldIdCabangKerja.setBackground(Color.WHITE);
        frame.add(textfieldIdCabangKerja);

//        textfieldIdCabangKerja.getDocument().addDocumentListener(new DocumentListener() {
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
            Staff s = new Staff();
            s.setNama(textfieldName.getText());
            s.setTanggalLahir(LocalDate.parse(textfieldTTL.getText()));
            s.setGender(textfieldGender.getText());
            s.setAlamat(textfieldAlamat.getText());
//            s.setShift(textfieldShift.getText()); -> harus ubah k int
//            s.setGaji(textfieldGaji.getText()); -> ??
//            s.setTglAwalKerja(textfieldTglAwalKerja.getText()); -> blm ada get set
//            s.setIdCabangKerja(textfieldIdCabangKerja.getText()); -> blmada get set?
            
            s.setIdCabang(Cabang.getInstance().getId());
            LocalDate x = LocalDate.MIN;
            boolean get = true;
            try{
                x = LocalDate.parse(textfieldTglAwalKerja.getText());
            }catch(Exception ec){
                JOptionPane.showMessageDialog(null, "Format input salah... ini seharusnya pakai date input library.\n tapi sesuatu terjadi dan kita harus improv");
                get = false;
            }
            if(get){
                cs.insertStaff(s);
                new Menu_Admin();
                frame.hide();
            }
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
        new Tambah_Staff();
    }
}
