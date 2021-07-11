/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Alat;
import Model.Item;
import Model.Obat;
import Model.Pasien;
import Model.Penyakit;
import Model.Perawatan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class ControlPasien {
    Control c = new Control();

    static DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Pasien> getAllPasien() {
        ArrayList<Pasien> pasien = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Pasien";
        try {
            Statement stmt = conn.con.createStatement();
            Statement stmtPerson = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pasien user = new Pasien();
                c.cariPersonDariId(user,rs.getString("IDPerson"));
                
                LinkedList<Integer> listId = cariIdPenyakitDariIdPasien(rs.getInt("IDPasien"));
                user.penyakit = new LinkedList<>();
                for (int i = 0; i < listId.size(); i++) {
                    user.penyakit.add(cariPenyakitDariId(listId.get(i)));
                }
                listId = cariIdPerawatanDariIdPasien(rs.getInt("IDPasien"));
                user.perawatan = new LinkedList<>();
                for (int i = 0; i < listId.size(); i++) {
                    user.perawatan.add(cariPerawatanDariIdPerawatan(listId.get(i)));
                }
                
                user.setDaerahPerawatan(rs.getString("Daerah"));
                user.setTanggalMasuk(rs.getDate("TglMasuk").toLocalDate());
                user.setTanggalKeluar(rs.getDate("TglKeluar").toLocalDate());
                user.setIdCabang(rs.getInt("IDCabang"));
                pasien.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pasien);
    }
    
    public ArrayList<Pasien> getPasienByCabang(int idCabang){
        ArrayList<Pasien> list = getAllPasien();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getIdCabang() != idCabang){
                list.remove(i);
            }
        }
        return list;
    }
    
    public int[] getIsiKamar(ArrayList<Pasien> subject){
        int[] isi = new int[9];
        for (int i = 0; i < subject.size(); i++) {
            if(null != subject.get(i).getDaerahPerawatan())switch (subject.get(i).getDaerahPerawatan()) {
                case "VVIP":
                    isi[0]++;
                    break;
                case "VIP":
                    isi[1]++;
                    break;
                case "I":
                    isi[2]++;
                    break;
                case "II":
                    isi[3]++;
                    break;
                case "III":
                    isi[4]++;
                    break;
                case "UGD":
                    isi[5]++;
                    break;
                case "ICU":
                    isi[6]++;
                    break;
                case "KARANTINA":
                    isi[7]++;
                    break;
                case "ANAK":
                    isi[8]++;
                    break;
                default:
                    break;
            }
        }
        return isi;
    }
    
    public void insertPasien(Pasien subject){
        c.insertPerson(subject);
        conn.connect();;
        String query = "INSERT INTO pasien (IDPerson, IDCabang, Daerah, TglMasuk,TglKeluar,dibayar) VALUES (" + subject.getId() +"," + subject.getIdCabang() + ",'" + subject.getTanggalMasuk().toString() + "','" + subject.getTanggalKeluar().toString() + "','" + subject.isDibayar() + "');";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Pasien getPasienDariId(int id){
        Pasien pasien = new Pasien();
        conn.connect();
        String query = "SELECT * FROM Pasien WHERE IDPasien = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            Statement stmtPerson = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pasien user = new Pasien();
                c.cariPersonDariId(user,rs.getString("IDPerson"));
                
                LinkedList<Integer> listId = cariIdPenyakitDariIdPasien(rs.getInt("IDPasien"));
                user.penyakit = new LinkedList<>();
                for (int i = 0; i < listId.size(); i++) {
                    user.penyakit.add(cariPenyakitDariId(listId.get(i)));
                }
                listId = cariIdPerawatanDariIdPasien(rs.getInt("IDPasien"));
                user.perawatan = new LinkedList<>();
                for (int i = 0; i < listId.size(); i++) {
                    user.perawatan.add(cariPerawatanDariIdPerawatan(listId.get(i)));
                }
                
                user.setDaerahPerawatan(rs.getString("Daerah"));
                user.setTanggalMasuk(rs.getDate("TglMasuk").toLocalDate());
                user.setTanggalKeluar(rs.getDate("TglKeluar").toLocalDate());
                user.setDibayar(rs.getBoolean("dibayar"));
                user.setIdCabang(rs.getInt("IDCabang"));
                pasien = user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pasien;
    }

    LinkedList<Integer> cariIdPenyakitDariIdPasien(int id) {
        conn.connect();
        LinkedList<Integer> list = new LinkedList<>();
        String query = "SELECT * FROM relasipenyapasi WHERE IDPasien = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                list.add(result.getInt("IDPenyakit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    LinkedList<Integer> cariIdPerawatanDariIdPasien(int id){
        conn.connect();
        LinkedList<Integer> list = new LinkedList<>();
        String query = "SELECT * FROM relasiperapasi WHERE IDPasien = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                list.add(result.getInt("IDPerawatan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    Perawatan cariPerawatanDariIdPerawatan(int id){
        ControlDokter cd = new ControlDokter();
        Perawatan perawatan = new Perawatan();
        conn.connect();
        String query = "SELECT * FROM perawatan WHERE IDPerawatan = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                perawatan.setNama(rs.getString("nama"));
                perawatan.setDokter(cd.cariDokterDariId(rs.getInt("IDDokter")));
                
                perawatan.alat = new ArrayList<>();
                LinkedList<Integer> list = cariIdAlatDariIdPerawatan(rs.getInt("IDPerawatan"));
                for (int i = 0; i < list.size(); i++) {
                    perawatan.alat.add(cariAlatDariIdAlat(list.get(i)));
                }
                
                perawatan.obat = new ArrayList<>();
                list = cariIdObatDariIdPerawatan(rs.getInt("IDPerawatan"));
                for (int i = 0; i < list.size(); i++) {
                    perawatan.obat.add(cariObatDariIdObat(list.get(i)));
                }
                
                //pending details
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perawatan;
    }
    
    Obat cariObatDariIdObat(int id){
        Obat obat = new Obat();
        conn.connect();
        String query = "SELECT * FROM obat WHERE IDObat = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cariItemDariIdItem(obat, rs.getInt("IDItem"));
                obat.setDosis(rs.getString("Dosis"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obat;
    }
    
    LinkedList<Integer> cariIdObatDariIdPerawatan(int id){
        LinkedList<Integer> list = new LinkedList<>();
        String query = "SELECT * FROM relasiperaoba WHERE IDPerawatan = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                list.add(result.getInt("IDObat"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    Alat cariAlatDariIdAlat(int id){
        Alat alat = new Alat();
        conn.connect();
        String query = "SELECT * FROM alat WHERE IDAlat = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cariItemDariIdItem(alat, rs.getInt("IDItem"));
                alat.setJenisAlat(rs.getString("Jenis"));
                alat.setKondisi(rs.getBoolean("Kondisi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alat;
    }
    
    void cariItemDariIdItem(Item item,int id){
        conn.connect();
        String query = "SELECT * FROM item WHERE IDItem = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                item.setNama(rs.getString("Nama"));
                item.setStock(rs.getInt("Stok"));
                item.setHarga(rs.getInt("Harga"));
                item.setIdCabang(rs.getInt("IDCabang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    LinkedList<Integer> cariIdAlatDariIdPerawatan(int id){
        LinkedList<Integer> list = new LinkedList<>();
        String query = "SELECT * FROM relasiperaala WHERE IDPerawatan = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                list.add(result.getInt("IDAlat"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    Penyakit cariPenyakitDariId(int id) {
        Penyakit penyakit = new Penyakit();
        conn.connect();
        String query = "SELECT * FROM penyakit WHERE IDPenyakit = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                penyakit.setNama(result.getString("Nama"));
                penyakit.setInfectious(result.getInt("Infectious"));
                penyakit.setLethality(result.getInt("Lethality"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penyakit;
    }
}
