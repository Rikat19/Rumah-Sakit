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
    void cariPersonDariId(Person subject,String id){
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
    public void insertPerson(Person subject){
        conn.connect();
        String query = "INSERT INTO person (Nama, TglLahir, Gender, Alamat) VALUES ('" + subject.getNama() + "','" + subject.getTanggalLahir().toString() + "','" +  subject.getGender() + "','" + subject.getAlamat() + "');";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Cabang getCabangDariId(int id){
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
    
    public LinkedList<Cabang> getAllCabang(){
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
    
    LinkedList<Item> getItemDariIdCabang(int id){
        LinkedList<Item> list = getAllItem();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getIdCabang() != id){
                list.remove(i);
            }
        }
        return list;
    }
    
    Boolean PolioToObat(Item item,int id){
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
    
    Boolean polioToAlat(Item item,int id){
        conn.connect();
        String query = "SELECT * FROM alat WHERE IDItem = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Alat alat = (Alat) item;
                alat.setJenisAlat(rs.getString("Jenis"));
                alat.setKondisi(rs.getBoolean("Kondisi"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    LinkedList<Item> getAllItem(){
        LinkedList<Item> list = new LinkedList<>();
        conn.connect();
        String query = "SELECT * FROM item";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Item item = new Item();
                PolioToObat(item,rs.getInt("IDItem"));
                PolioToObat(item,rs.getInt("IDItem"));
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
}
