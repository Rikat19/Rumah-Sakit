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
public class Penyakit {
    private String nama;
    private int infectious;
    private int lethality;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getInfectious() {
        return infectious;
    }

    public void setInfectious(int infectious) {
        this.infectious = infectious;
    }

    public int getLethality() {
        return lethality;
    }

    public void setLethality(int lethality) {
        this.lethality = lethality;
    }
    
    
}
