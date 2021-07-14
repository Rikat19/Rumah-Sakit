package View;

import Controller.ControlDokter;
import Model.Dokter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class Jadwal_Dokter {
  
    Color green = new Color(0, 200, 0);
    Color red = new Color(250, 0, 0);
  
    public Jadwal_Dokter(){
        ControlDokter cd = new ControlDokter();
      
        JFrame frame = new JFrame("Lihat Jadwal Dokter");
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);

//        hari
        JLabel day = new JLabel();
        day.setText("Hari\t:");
        day.setBounds(15, 15, 75, 25);
        day.setVisible(true);
        frame.add(day);

        JTextField textfieldDay = new JTextField();
        textfieldDay.setBounds(100, 15, 300, 25);
        textfieldDay.setBackground(Color.WHITE);
        frame.add(textfieldDay);

//        textfieldDay.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });
//        cari

        JButton cari = new JButton("Cari");
        cari.setBounds(275, 55, 125, 25);
        cari.setBackground(green);
        frame.add(cari);
        cari.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            boolean get = true;
            LocalDate x = LocalDate.MIN;
            try{
                x = LocalDate.parse(textfieldDay.getText());
            }catch(Exception ec){
                JOptionPane.showMessageDialog(null, "Format input salah... ini seharusnya pakai date input library.\n tapi sesuatu terjadi dan kita harus improv");
                get = false;
            }
            if(get == true){
                ArrayList<Dokter> list = cd.getDokterByJadwal(x.getDayOfWeek().getValue() - 1);
                new Lihat_Dokter(list,x.getDayOfWeek().getValue() - 1);
            }
            frame.hide();
        }
        });

//        close      
        JButton close = new JButton("Close");
        close.setBounds(275, 95, 125, 25);
        close.setBackground(red);
        frame.add(close);

        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Jadwal_Dokter();
    }
}
