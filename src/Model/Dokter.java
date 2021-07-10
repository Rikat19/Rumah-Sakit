/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Dokter extends Person{
    private int biayaJasa;
    private String specialist;
    private int[][] jadwal;
    public ArrayList<String> cabang;

    public int getBiayaJasa() {
        return biayaJasa;
    }

    public void setBiayaJasa(int biayaJasa) {
        this.biayaJasa = biayaJasa;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public int[][] getJadwal() {
        return jadwal;
    }

    public void setJadwal(int[][] jadwal) {
        this.jadwal = jadwal;
    }

    
    
    
}
