/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TampilanModel {
    koneksi conn = new koneksi();

    public int getdata(){
        int jmldata = 0;
        try{
            conn.statement = conn.konek.createStatement();
            String query = "SELECT*FROM barang";
            ResultSet rs = conn.statement.executeQuery(query);
            while (rs.next()){
                jmldata++;
            }
            return jmldata;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return 0;
        }
    }

    public String[][] readTabel(){
        try{
            int jmldata = 0;
            String[][] data;
            data = new String[getdata()][4];

            String query = "SELECT*FROM barang";
            ResultSet rs;
            rs = conn.statement.executeQuery(query);
            while (rs.next()){
                data[jmldata][0] = rs.getString("id");
                data[jmldata][1] = rs.getString("nama");
                data[jmldata][2] = String.valueOf(rs.getInt("harga"));
                data[jmldata][3] = String.valueOf(rs.getInt("stok"));
                jmldata++;
            }
            return data;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return null;
        }
    }

    public void insertabel(String nama, String nama_barang, String jumlah, String total){
        int jmldata = 0;
        try {
            String query = "INSERT INTO pembeli VALUES('"+nama+"','"+nama_barang+"','"+jumlah+"','"+total+"')";

            conn.statement = (Statement) conn.konek.createStatement();
            conn.statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil diinsert");

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updatetabel(String id,String stok){
        int jmldata = 0;
        try {
            String query = "Select * from barang WHERE id=" + id;
            ResultSet resultSet = conn.statement.executeQuery(query);

            while (resultSet.next()){
                jmldata++;
            }

            if (jmldata==1) {
                query = "UPDATE barang SET stok='" +  stok + "' WHERE id=" + id;
                conn.statement = (Statement) conn.konek.createStatement();
                conn.statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        }


    }