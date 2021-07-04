/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Staff extends Person{
    private String tugas;
    private int[] shift;
    int gaji;
    private LocalDate tanggalKerja;

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public int[] getShift() {
        return shift;
    }

    public void setShift(int[] shift) {
        this.shift = shift;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public LocalDate getTanggalKerja() {
        return tanggalKerja;
    }

    public void setTanggalKerja(LocalDate tanggalKerja) {
        this.tanggalKerja = tanggalKerja;
    }
    
    
}
