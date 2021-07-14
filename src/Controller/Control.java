/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Alat;
import Model.Cabang;
import Model.Item;
import Model.Obat;
import Model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Richard
 */
public class Control {

    static DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Person> getAllPerson() {
        ArrayList<Person> persons = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Person";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Person user = new Person();
                user.setNama(rs.getString("Nama"));
                user.setAlamat(rs.getString("Alamat"));
                user.setGender(rs.getString("Gender"));
                user.setTanggalLahir(rs.getDate("TglLahir").toLocalDate());
                persons.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (persons);
    }

    void cariPersonDariId(Person subject, String id) {
        conn.connect();
        String query = "SELECT * FROM person WHERE IDPerson = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                subject.setNama(rs.getString("Nama"));
                subject.setGender(rs.getString("Gender"));
                subject.setAlamat(rs.getString("Alamat"));
                subject.setTanggalLahir(rs.getDate("TglLahir").toLocalDate());
                subject.setId(rs.getInt("IDPerson"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
    }
    int getIdPerson() {
        conn.connect();
        String query = "SELECT IDPerson FROM Person ORDER BY IDPerson DESC LIMIT 1;";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt("IDPerson");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void insertPerson(Person subject) {
        conn.connect();
        String query = "INSERT INTO person (Nama, TglLahir, Gender, Alamat) VALUES ('" + subject.getNama() + "','" + subject.getTanggalLahir().toString() + "','" + subject.getGender() + "','" + subject.getAlamat() + "');";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertItemToCabang(Item item, int idCabang) {
        conn.connect();
        String query = "INSERT INTO Item (IDCabang, Nama, Stok, Harga) VALUES(" + item.getIdCabang() + ",'" + item.getNama() + "'," + item.getHarga() + "," + item.getStock() + ");";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = getIdItem();
        if (item instanceof Obat) {
            Obat obat = (Obat) item;
            query = "INSERT INTO Obat (IDItem, Dosis) VALUES(" + id + ",'" + obat.getDosis() + "');";
            try {
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Alat alat = (Alat) item;
            query = "INSERT INTO Alat (IDItem, Jenis,kondisi) VALUES(" + id + ",'" + alat.getJenisAlat() + "'," + alat.isKondisi() + ");";
            try {
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void insertCabang(Cabang c){
        String query = "INSERT INTO Cabang (Nama, Alamat,Username,Password,Kapasitas) VALUES('" + c.getNama() + "','" + c.getAlamat() + "','" + c.getUsername() + "','" + c.getPassword() + "','" + c.getKapasitasDaerah() + "');";
            try {
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public int[] parseDaerahToInt(String x) {
        x = x.trim();
        String[] strArray = x.split(",");
        int[] hasil = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            hasil[i] = Integer.parseInt(strArray[i]);
        }
        return hasil;
    }

    public String parseDaerahToString(int[] x) {
        String y = "";
        for (int i = 0; i < x.length; i++) {
            y += x[i] + ",";
        }
        return y;
    }

    int getIdItem() {
        int x = 0;
        conn.connect();
        String query = "SELECT IDItem FROM Item ORDER BY IDItem DESC LIMIT 1";
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

    public Cabang getCabangDariId(int id) {
        Cabang subject = new Cabang();
        conn.connect();
        String query = "SELECT * FROM cabang WHERE IDCabang = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                subject.setNama(rs.getString("Nama"));
                subject.setAlamat(rs.getString("Alamat"));
                subject.setUsername(rs.getString("Username"));
                subject.setPassword(rs.getString("Password"));
                subject.setId(rs.getInt("IDCabang"));
                subject.setKapasitasDaerah(rs.getString("Kapasitas"));
                subject.setStorage(getItemDariIdCabang(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    public LinkedList<Cabang> getAllCabang() {
        LinkedList<Cabang> list = new LinkedList<>();
        conn.connect();
        String query = "SELECT IDCabang FROM cabang";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(getCabangDariId(rs.getInt("IDCabang")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public LinkedList<Item> getItemDariIdCabang(int id) {
        LinkedList<Item> list = getAllItem();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdCabang() != id) {
                list.remove(i);
            }
        }
        return list;
    }

    Boolean PolioToObat(Item item, int id) {
        conn.connect();
        String query = "SELECT * FROM obat WHERE IDItem = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Obat obat = (Obat) item;
                obat.setDosis(rs.getString("Dosis"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    Alat polioToAlat(Item item, int id) {
        Alat alat = (Alat) item;
        conn.connect();
        String query = "SELECT * FROM alat WHERE IDItem = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                alat.setJenisAlat(rs.getString("Jenis"));
                alat.setKondisi(rs.getBoolean("Kondisi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alat;
    }

    public LinkedList<Item> getAllItem() {
        LinkedList<Item> list = new LinkedList<>();
        conn.connect();
        String query = "SELECT * FROM item";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Item item;
                if (isObat(rs.getInt("IDItem"))) {
                    item = new Obat();
                    PolioToObat(item, rs.getInt("IDItem"));
                } else {
                    item = new Alat();
                    item = polioToAlat(item, rs.getInt("IDItem"));
                }

                item.setNama(rs.getString("Nama"));
                item.setStock(rs.getInt("Stok"));
                item.setHarga(rs.getInt("Harga"));
                item.setIdCabang(rs.getInt("IDCabang"));

                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    boolean isObat(int idItem) {
        conn.connect();
        String query = "SELECT IDItem FROM Obat";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (idItem == rs.getInt("IDItem")) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
