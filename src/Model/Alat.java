/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author User
 */
public class Alat extends Item{
    private String jenisAlat;
    private boolean kondisi;

    public String getJenisAlat() {
        return jenisAlat;
    }

    public void setJenisAlat(String jenisAlat) {
        this.jenisAlat = jenisAlat;
    }

    public boolean isKondisi() {
        return kondisi;
    }

    public void setKondisi(boolean kondisi) {
        this.kondisi = kondisi;
    }
    
    
}
