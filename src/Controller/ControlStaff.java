/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControlPasien.conn;
import Model.Pasien;
import Model.Staff;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ControlStaff {
    Control c = new Control();
    public ArrayList<Staff> getAllStaff() {
        ArrayList<Staff> staff = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM staff";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Staff s= new Staff();
                c.cariPersonDariId(s, rs.getString("IDPerson"));
                s.setAlamat(rs.getString("Alamat"));
                s.setGaji(rs.getInt("Gaji"));
                s.setTugas(rs.getString("Tugas"));
                s.setShift(parseStaffShiftToInt(rs.getString("Shift")));
                s.setTanggalKerja(rs.getDate("Tanggal").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (staff);
    }
    public ArrayList<Staff> getStaffDariIdCabang(int id) {
        ArrayList<Staff> list = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM staff WHERE IDCabang = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Staff s = new Staff();
                c.cariPersonDariId(s, rs.getString("IDPerson"));
                s.setAlamat(rs.getString("Alamat"));
                s.setGaji(rs.getInt("Gaji"));
                s.setTugas(rs.getString("Tugas"));
                s.setShift(parseStaffShiftToInt(rs.getString("Shift")));
                s.setTanggalKerja(rs.getDate("Tanggal").toLocalDate());
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Staff getStaffDariIdStaff(int id) {
        Staff s = new Staff();
        conn.connect();
        String query = "SELECT * FROM staff WHERE IDStaff = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                c.cariPersonDariId(s, rs.getString("IDPerson"));
                s.setAlamat(rs.getString("Alamat"));
                s.setGaji(rs.getInt("Gaji"));
                s.setTugas(rs.getString("Tugas"));
                s.setShift(parseStaffShiftToInt(rs.getString("Shift")));
                s.setTanggalKerja(rs.getDate("Tanggal").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    public int getBebanGaji(ArrayList<Staff> list,LocalDate tgl){
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTanggalKerja().isBefore(tgl)){
                total += list.get(i).getGaji();
            }
        }
        return total;
    }
    public void hapusStaffDariId(int id){
        String query = "DELETE FROM Staff WHERE IDStaff =" + id + ";";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertStaff(Staff subject){
        c.insertPerson(subject);
        conn.connect();;
        String query = "INSERT INTO Staff (IDPerson, IDCabang, Shift, Tanggal,Gaji,Tugas) VALUES (" + subject.getId() +"," + subject.getIdCabang() + ",'" + parseStaffShiftToString(subject.getShift()) + "','" + subject.getTanggalKerja().toString() + "','" + subject.getGaji() + "," + subject.getTugas() + "');";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int[] parseStaffShiftToInt(String x){
        String[] strArray = x.split(",");
        int[] hasil = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            hasil[i] = Integer.parseInt(strArray[i]);
        }
        return hasil;
    }
    public String parseStaffShiftToString(int[] x){
        String y = "";
        for (int i = 0; i < x.length - 1; i++) {
            y += x[i] + ",";
        }
        y += x[x.length - 1];
        return y;
    }
}
