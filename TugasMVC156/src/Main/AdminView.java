/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author ACER
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminView extends JFrame {
    JLabel lid = new JLabel("ID");
    JLabel lnama = new JLabel("NAMA");
    JLabel lharga = new JLabel("HARGA");
    JLabel lstok = new JLabel("STOK");

    JTextField tf_id = new JTextField();
    JTextField tf_nama = new JTextField();
    JTextField tf_harga = new JTextField();
    JTextField tf_stok = new JTextField();

    JButton btn_tambah = new JButton("Tambah");
    JButton btn_update = new JButton("Update");
    JButton btn_hapus = new JButton("Hapus");
    JButton btn_reset = new JButton("Reset");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object kolom[] = {"ID","Nama","Harga","Stok"};

    public AdminView(){
        dtm = new DefaultTableModel(kolom,0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Tes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,500);

        add(scrollPane);
        scrollPane.setBounds(20,20,500,400);

        add(lid);
        add(lharga);
        add(lnama);
        add(lstok);

        add(tf_id);
        add(tf_harga);
        add(tf_nama);
        add(tf_stok);

        add(btn_tambah);
        add(btn_update);
        add(btn_hapus);
        add(btn_reset);


        lid.setBounds(550,20,100,50);
        tf_id.setBounds(610,35,100,20);

        lnama.setBounds(550,50,100,50);
        tf_nama.setBounds(610,65,100,20);

        lharga.setBounds(550,80,100,50);
        tf_harga.setBounds(610,95,100,20);

        lstok.setBounds(550,110,100,50);
        tf_stok.setBounds(610,125,100,20);

        btn_tambah.setBounds(610, 220,100,20);
        btn_update.setBounds(720,220,100,20);
        btn_hapus.setBounds(610,250,100,20);
        btn_reset.setBounds(720,250,100,20);
    }

    public String getId(){
        return tf_id.getText();
    }

    public String getNama(){
        return tf_nama.getText();
    }

    public String getHarga(){
        return tf_harga.getText();
    }

    public String getstok(){
        return tf_stok.getText();
    }


}

