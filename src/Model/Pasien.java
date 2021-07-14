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

    private int idCabang;
    private String daerahPerawatan;
    private LocalDate tanggalMasuk;
    private LocalDate tanggalKeluar;
    private boolean dibayar;
    public LinkedList<Penyakit> penyakit;
    public LinkedList<Perawatan> perawatan;

    public int getHargaKamar(String x) {
        switch (x) {
            case "VVIP":
                return InterfaceConstantDaerah.VVIP;
            case "VIP":
                return InterfaceConstantDaerah.VIP;
            case "I":
                return InterfaceConstantDaerah.I;
            case "II":
                return InterfaceConstantDaerah.II;
            case "III":
                return InterfaceConstantDaerah.III;
            case "UGD":
                return InterfaceConstantDaerah.UGD;
            case "ICU":
                return InterfaceConstantDaerah.ICU;
            case "KARANTINA":
                return InterfaceConstantDaerah.KARANTINA;
            case "ANAK":
                return InterfaceConstantDaerah.ANAK;
        }
        return 0;
    }
    public int getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
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

    public static class Builder {

    }
}
