/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pasien;
import Model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ControlPasien {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public ArrayList<Pasien> getAllPasien() {
        ArrayList<Pasien> pasien = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Pasien";
        try {
            Statement stmt = conn.con.createStatement();
            Statement stmt2 = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pasien user = new Pasien();
                String personId = rs.getString("IDPerson");
                String query2 = "SELECT * FROM person WHERE IDPerson = " + personId;
                ResultSet rs2 = stmt2.executeQuery(query2);
                while (rs2.next()) {
                    user.setNama(rs2.getString("Nama"));
                }
                user.setDaerahPerawatan(rs.getString("Daerah"));
                user.setTanggalMasuk(rs.getDate("TglMasuk").toLocalDate());
                user.setTanggalKeluar(rs.getDate("TglKeluar").toLocalDate());
                pasien.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pasien);
    }
}
