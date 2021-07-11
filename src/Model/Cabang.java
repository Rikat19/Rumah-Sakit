/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Cabang {
    private int id;
    private String nama;
    private String alamat;
    private String username;
    private String password;
    public LinkedList<Item> storage;
    public ArrayList<Staff> staff;
    public ArrayList<Dokter> dokter;
    private String kapasitasDaerah;
    public ArrayList<Pasien> pasien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LinkedList<Item> getStorage() {
        return storage;
    }

    public void setStorage(LinkedList<Item> storage) {
        this.storage = storage;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }

    public ArrayList<Dokter> getDokter() {
        return dokter;
    }

    public void setDokter(ArrayList<Dokter> dokter) {
        this.dokter = dokter;
    }

    public String getKapasitasDaerah() {
        return kapasitasDaerah;
    }

    public void setKapasitasDaerah(String kapasitasDaerah) {
        this.kapasitasDaerah = kapasitasDaerah;
    }

    
    public ArrayList<Pasien> getPasien() {
        return pasien;
    }

    public void setPasien(ArrayList<Pasien> pasien) {
        this.pasien = pasien;
    }
    
    
}
