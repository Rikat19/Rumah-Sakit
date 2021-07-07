/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dokter;
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
    static DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Dokter> getAllDokter() {
        Control c = new Control();
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
                subject.setJadwal(rs.getString("JamPraktek"));
                dokter.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dokter;
    }
    
    public Dokter cariDokterDariId(int id){
        Control c = new Control();
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
                subject.setJadwal(rs.getString("JamPraktek"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }
}
