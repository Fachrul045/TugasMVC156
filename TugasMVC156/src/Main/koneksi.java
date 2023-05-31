/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author ACER
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class koneksi {
    String dbUrl = "jdbc:mysql://localhost/kedaikelontong";
    String dbUsername = "root";
    String dbPassword = "";
    static final String driver = "com.mysql.cj.jdbc.Driver"; //newer version includes cj
    PreparedStatement pst;
    Connection konek;
    Statement statement; //untuk melakukan eksekusi query
    public koneksi() {
        try{
            Class.forName(driver); //load driver
            //membuka koneksi ke database
            konek = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
}
