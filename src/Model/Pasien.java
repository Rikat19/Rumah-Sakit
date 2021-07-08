/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Pasien extends Person implements InterfaceConstantDaerah {
    public Cabang cabang;
    private String daerahPerawatan;
    private LocalDate tanggalMasuk;
    private LocalDate tanggalKeluar;
    private boolean dibayar;
    public LinkedList<Penyakit> penyakit;
    public LinkedList<Perawatan> perawatan;

    public Cabang getCabang() {
        return cabang;
    }

    public void setCabang(Cabang cabang) {
        this.cabang = cabang;
    }

    public String getDaerahPerawatan() {
        return daerahPerawatan;
    }

    public void setDaerahPerawatan(String daerah) {
        this.daerahPerawatan = daerah;
    }

    public boolean isDibayar() {
        return dibayar;
    }

    public void setDibayar(boolean dibayar) {
        this.dibayar = dibayar;
    }

    public LocalDate getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(LocalDate tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public LocalDate getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(LocalDate tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }
    
    
}
