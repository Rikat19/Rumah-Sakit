
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Richard
 */
public class Jadwal_Dokter {
    
    public Jadwal_Dokter(){
        JFrame frame = new JFrame("Lihat Jadwal Dokter");
        frame.setSize(550,200);
        frame.setLocationRelativeTo(null);
        
//        Nama Pasien
        JLabel date = new JLabel();
        date.setText("Tanngal\t:");
        date.setBounds(15,15,175,25);
        date.setVisible(true);
        frame.add(date);
        
        JTextField textfieldDate = new JTextField();
        textfieldDate.setBounds(210, 15, 300, 25);
        textfieldDate.setBackground(Color.WHITE);
        frame.add(textfieldDate);
        
//        textfieldName.getDocument().addDocumentListener(new DocumentListener() {
//            public void inputName(DocumentEvent e){
//                System.out.println("");
//            }
//            
//        });

//        cari
        JButton cariId = new JButton("Cari dengan ID");
        cariId.setBounds(370, 55, 140, 25);
        Color green = new Color(0, 200, 0);
        cariId.setBackground(green);
        frame.add(cariId);
        cariId.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Lihat_Dokter();
            frame.hide();
        }
        });

//        back      
        JButton back = new JButton("Back");
        back.setBounds(370,95,140,25);
        Color red = new Color(250, 0, 0);
        back.setBackground(red);
        frame.add(back);
        back.addActionListener(new ActionListener() {
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
