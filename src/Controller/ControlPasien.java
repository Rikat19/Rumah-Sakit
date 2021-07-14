/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Alat;
import Model.InterfaceConstantDaerah;
import Model.Item;
import Model.Obat;
import Model.Pasien;
import Model.Penyakit;
import Model.Perawatan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class ControlPasien {

    Control c = new Control();

    static DatabaseHandler conn = new DatabaseHandler();
    
    public Pasien getPasienDariAtribut(String nama,String ttl,String alamat){
        ArrayList<Pasien> list = getAllPasien();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNama().equals(nama) && list.get(i).getTanggalLahir() == (LocalDate.parse(ttl)) && list.get(i).getAlamat().equals(alamat)){
                return list.get(i);
            }
        }
        return null;
    }

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
                c.cariPersonDariId(user, rs.getString("IDPerson"));

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
                try{
                    user.setTanggalKeluar(rs.getDate("TglKeluar").toLocalDate());
                }catch(Exception e){
                    user.setTanggalKeluar(LocalDate.MIN);
                }
                user.setIdCabang(rs.getInt("IDCabang"));
                pasien.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pasien);
    }

    public ArrayList<Pasien> getPasienByCabang(int idCabang) {
        ArrayList<Pasien> list = getAllPasien();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdCabang() != idCabang) {
                list.remove(i);
            }
        }
        return list;
    }

    public int[] getIsiKamar(int idCabang) {
        ArrayList<Pasien> subject = getPasienByCabang(idCabang);
        int[] isi = new int[9];
        for (int i = 0; i < subject.size(); i++) {
            if (null != subject.get(i).getDaerahPerawatan()) {
                switch (subject.get(i).getDaerahPerawatan()) {
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
        }
        return isi;
    }
    public static void main(String[] args) {
        
    }
    public void insertPasien(Pasien subject) {
        c.insertPerson(subject);
        subject.setId(c.getIdPerson());
        conn.connect();
        String query = "INSERT INTO pasien (IDPerson, IDCabang, Daerah, TglMasuk,TglKeluar,dibayar) VALUES (" + subject.getId() + ","+ subject.getIdCabang() + ",'" + subject.getDaerahPerawatan() + "','" + subject.getTanggalMasuk().toString() + "'," + null + "," + subject.isDibayar() + ");";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    int cariIdItemDariIdObat(int idObat) {
        int x = 0;
        conn.connect();
        String query = "SELECT IDItem FROM Obat WHERE IDObat = " + idObat;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                x = rs.getInt("IDItem");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }
    
    public int getJumlahHari(LocalDate dari,LocalDate sampai){
        int lamaTinggal = (int) ChronoUnit.DAYS.between(dari, sampai);
        return lamaTinggal;
    }
    
    public int getBill(Pasien p){
        int total = 0;
        int lamaTinggal = getJumlahHari(p.getTanggalMasuk(),p.getTanggalKeluar());
        
        total += (lamaTinggal * p.getHargaKamar(p.getDaerahPerawatan()));
        for (int i = 0; i < p.perawatan.size(); i++) {
            for (int j = 0; j < p.perawatan.get(i).idAlat.size(); j++) {
                Alat alat = cariAlatDariIdAlat(p.perawatan.get(i).idAlat.get(j));
                total += alat.getHarga();
            }
            for (int j = 0; j < p.perawatan.get(i).idObat.size(); j++) {
                Obat obat = cariObatDariIdObat(p.perawatan.get(i).idObat.get(j));
                total += obat.getHarga();
            }
            total += p.perawatan.get(i).getDokter().getBiayaJasa();
        }
        return total;
    }
    
    int cariIdItemDariIdAlat(int idAlat) {
        int x = 0;
        conn.connect();
        String query = "SELECT IDItem FROM Alat WHERE IDAlat = " + idAlat;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                x = rs.getInt("IDItem");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    private void insertObatKePerawatan(int idPerawatan, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            conn.connect();
            String query = "INSERT INTO relasiperaoba (IDPerawatan,IDObat) VALUES ('" + idPerawatan + "'," + list.get(i) + ");";
            try {
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Obat obat = cariObatDariIdObat(list.get(i));
            int x = cariIdItemDariIdObat(list.get(i));
            decrementItem(obat, x);
        }
    }

    private void decrementItem(Item item, int idItem) {
        int x = item.getStock() - 1;
        conn.connect();
        String query = "UPDATE Item SET Stok=" + x + " WHERE IDItem=" + idItem + ";";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateTanggalKeluar(int idPerson,LocalDate tgl){
        conn.connect();
        String query = "UPDATE Pasien SET TglKeluar='" + tgl.toString() + "' WHERE IDPerson=" + idPerson + ";";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertRelasiPeraPasi(Pasien pasien, int idPerawatan) {
        int x = cariIdPasien(pasien);
        conn.connect();
        String query = "INSERT INTO relasiperapasi (IDPerawatan,IDPasien) VALUES (" + idPerawatan + "," + x + ");";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertAlatKePerawatan(int idPerawatan, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            conn.connect();
            String query = "INSERT INTO relasiperaala (IDPerawatan,IDAlat) VALUES ('" + idPerawatan + "'," + list.get(i) + ");";
            try {
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Alat alat = cariAlatDariIdAlat(list.get(i));
            int x = cariIdItemDariIdAlat(list.get(i));
            decrementItem(alat, x);
        }
    }

    public void insertPerawatanKePasien(Pasien pasien, Perawatan perawatan) {
        ControlDokter cd = new ControlDokter();
        conn.connect();
        int idDokter = cd.cariIdDokterDariIdPerson(perawatan.getDokter().getId());
        String query = "INSERT INTO perawatan (Nama,IDDokter) VALUES ('" + perawatan.getNama() + "'," + idDokter + ");";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        insertObatKePerawatan(getIdPerawatanTerbaru(), perawatan.idObat);
        insertAlatKePerawatan(getIdPerawatanTerbaru(),perawatan.idAlat);
        insertRelasiPeraPasi(pasien, getIdPerawatanTerbaru());
    }

    public int getIdPerawatanTerbaru() {
        conn.connect();
        int id = 0;
        String query = "SELECT IDPerawatan FROM perawatan ORDER BY IDPerawatan DESC LIMIT 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("IDPerawatan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void insertPenyakitKePasien(Pasien pasien, Penyakit penyakit) {
        conn.connect();
        String query = "INSERT INTO penyakit (Nama, Lethality, Infectious) VALUES ('" + penyakit.getNama() + "'," + penyakit.getLethality() + "," + penyakit.getInfectious() + ");";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        buatRelasiPenyaPasi(cariIdPasien(pasien), getIdPenyakitTerbaru());
    }

    private int getIdPenyakitTerbaru() {
        conn.connect();
        int id = 0;
        String query = "SELECT IDPenyakit FROM penyakit ORDER BY IDPenyakit DESC LIMIT 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("IDPenyakit");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    
    private int cariIdPasien(Pasien pasien) {
        conn.connect();
        int id = 0;
        String query = "SELECT IDPasien FROM Pasien WHERE IDPerson = " + pasien.getId();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("IDPasien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private void buatRelasiPenyaPasi(int idPasien, int idPenyakit) {
        conn.connect();
        String query = "INSERT INTO relasipenyapasi (IDPasien, IDPenyakit) VALUES (" + idPasien + "," + idPenyakit + ");";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pasien getPasienDariId(int id) {
        Pasien pasien = new Pasien();
        conn.connect();
        String query = "SELECT * FROM Pasien WHERE IDPasien = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pasien user = new Pasien();
                c.cariPersonDariId(user, rs.getString("IDPerson"));

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

    LinkedList<Integer> cariIdPerawatanDariIdPasien(int id) {
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

    Perawatan cariPerawatanDariIdPerawatan(int id) {
        ControlDokter cd = new ControlDokter();
        Perawatan perawatan = new Perawatan();
        conn.connect();
        String query = "SELECT * FROM perawatan WHERE IDPerawatan = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                perawatan.setNama(rs.getString("nama"));
                perawatan.setDokter(cd.cariDokterDariIdDokter(rs.getInt("IDDokter")));

                perawatan.idAlat = new ArrayList<>();
                LinkedList<Integer> list = cariIdAlatDariIdPerawatan(rs.getInt("IDPerawatan"));
                for (int i = 0; i < list.size(); i++) {
                    perawatan.idAlat.add(list.get(i));
                }

                perawatan.idObat = new ArrayList<>();
                list = cariIdObatDariIdPerawatan(rs.getInt("IDPerawatan"));
                for (int i = 0; i < list.size(); i++) {
                    perawatan.idObat.add(list.get(i));
                }

                //pending details
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perawatan;
    }

    LinkedList<Integer> cariIdObatDariIdPerawatan(int id) {
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

    Alat cariAlatDariIdAlat(int id) {
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

    public Obat cariObatDariIdObat(int id) {
        Obat obat = new Obat();
        conn.connect();
        String query = "SELECT * FROM Obat WHERE IDObat = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cariItemDariIdItem(obat, rs.getInt("IDItem"));
                obat.setDosis("Dosis");
            }
        } catch (SQLException e) {
        }
        return obat;
    }

    void cariItemDariIdItem(Item item, int id) {
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

    LinkedList<Integer> cariIdAlatDariIdPerawatan(int id) {
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
