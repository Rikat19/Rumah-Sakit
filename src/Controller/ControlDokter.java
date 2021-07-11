/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControlPasien.conn;
import Model.Dokter;
import Model.Pasien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class ControlDokter {
    Control c = new Control();
    static DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Dokter> getAllDokter() {
        ArrayList<Dokter> dokter = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Dokter";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Dokter subject = new Dokter();
                c.cariPersonDariId(subject, rs.getString("IDPerson"));
                subject.setBiayaJasa(rs.getInt("BiayaJasa"));
                subject.setSpecialist(rs.getString("Specialist"));
                subject.setJadwal(parseJadwalToInt(rs.getString("JadwalPraktek")));
                dokter.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dokter;
    }
    
    public int[][] parseJadwalToInt(String x){
        String[] strArray = x.split(",");
        int[][] hasil = new int[7][4];
        int y = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++,y++) {
                hasil[j][i] = Integer.parseInt(strArray[y]);
            }
        }
        return hasil;
    }
    
    public String parseJadwalToString(int[][] x){
        String y = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                y += x[j][i] + ",";
            }
        }
        return y;
    }
    
    public void insertDokter(Dokter subject){
        c.insertPerson(subject);
        conn.connect();;
        String query = "INSERT INTO dokter (IDPerson, BiayaJasa, Specialist, JamPraktek) VALUES (" + subject.getId() +"," + subject.getBiayaJasa() + ",'" + subject.getSpecialist() + "','" + parseJadwalToString(subject.getJadwal()) + "');";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Dokter> getDokterByJadwal(int hari,int jam){
        ArrayList<Dokter> list = getAllDokter();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getJadwal()[hari][0] > jam || list.get(i).getJadwal()[hari][1] < jam){
                list.remove(i);
            }
        }
        return list;
    }
    
    public Dokter cariDokterDariId(int id){
        Dokter subject = new Dokter();
        conn.connect();
        String query = "SELECT * FROM Dokter WHERE IDDokter = " + id;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                c.cariPersonDariId(subject, rs.getString("IDPerson"));
                subject.setBiayaJasa(rs.getInt("BiayaJasa"));
                subject.setSpecialist(rs.getString("Specialist"));
                subject.setJadwal(parseJadwalToInt(rs.getString("JadwalPraktek")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }
}
