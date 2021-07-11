/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Controller.Control;
import Controller.ControlDokter;
import Controller.ControlPasien;
import Controller.ControlStaff;
import Model.Cabang;
import Model.Dokter;
import Model.Item;
import Model.Pasien;
import Model.Penyakit;
import Model.Person;
import java.util.ArrayList;
import java.util.LinkedList;
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
        
        ArrayList<Pasien> list = cp.getAllPasien();
        Penyakit p = new Penyakit();
        p.setNama("korona");
        p.setInfectious(10);
        p.setLethality(10);
        cp.insertPenyakitKePasien(list.get(0), p);
    }
}
