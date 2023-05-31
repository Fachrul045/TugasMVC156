/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TampilanView extends JFrame {

    JTable tabel1 = new JTable();
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object kolom[] = {"ID","Nama","Harga","Stok"};

    public TampilanView(){

        dtm = new DefaultTableModel(kolom,0);
        tabel1 = new JTable(dtm);
        scrollPane = new JScrollPane(tabel1);

        setTitle("Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(700,500);

        add(scrollPane);
        scrollPane.setBounds(50,70,500,200);
    }


}

