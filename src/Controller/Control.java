/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
