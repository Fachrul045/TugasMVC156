/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TampilanController {
    TampilanView view;
    TampilanModel model;
    public TampilanController(TampilanView TampilanView,TampilanModel TampilanModel){
        this.view = TampilanView;
        this.model = TampilanModel;

        if(model.getdata()!=0){
            String datatabel[][] = model.readTabel();
            view.tabel1.setModel((new JTable(datatabel, view.kolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"DATA KOSONG");
        }


    }
}

