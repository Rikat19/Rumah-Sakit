/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Controller.Control;
import Controller.ControlPasien;
import Model.Pasien;
import Model.Person;
import java.util.ArrayList;
/**
 *
 * @author Richard
 */
public class TUBES_RumahSakit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlPasien cp = new ControlPasien();
        ArrayList<Pasien> subject = cp.getAllPasien();
        
        for (int i = 0; i < subject.size(); i++) {
            System.out.println(subject.get(i).getNama());
            System.out.println(subject.get(i).getTanggalMasuk());
            System.out.println(subject.get(i).getTanggalKeluar());
        }
    }
    
}
