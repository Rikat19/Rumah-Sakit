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
    private String nama;
    private String alamat;
    private String username;
    private String password;
    public LinkedList<Item> storage;
    public ArrayList<Staff> staff;
    public ArrayList<Dokter> dokter;
    private int[] kapasitasDaerah;
    public ArrayList<Pasien> pasien;
}
