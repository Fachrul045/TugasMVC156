/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author ACER
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelAdmin {
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

    public void insertabel(String id, String nama, String harga, String stok){
        int jmldata = 0;
        try {
            String query = "Select * from barang WHERE id=" + id;
            ResultSet rs = conn.statement.executeQuery(query);

            while (rs.next()){
                jmldata++;
            }

            if (jmldata==0) {
                query = "INSERT INTO barang VALUES('"+id+"','"+nama+"','"+harga+"','"+stok+"')";

                conn.statement = (Statement) conn.konek.createStatement();
                conn.statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil diinsert");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateTabel(String id, String nama, String harga, String stok){
        int jmlData=0;
        try {
            String query = "Select * from barang WHERE id=" + id;
            ResultSet resultSet = conn.statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) {
                query = "UPDATE barang SET nama='" + nama + "', harga='" + harga + "', stok='" + stok + "' WHERE id=" + id;
                conn.statement = (Statement) conn.konek.createStatement();
                conn.statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void deleteTabel (String id) {
        try{
            String query = "DELETE FROM barang WHERE id = '"+id+"'";
            conn.statement = conn.konek.createStatement();
            conn.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}

