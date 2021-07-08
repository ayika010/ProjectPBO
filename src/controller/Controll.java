/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DataSewa;
import view.*;
/**
 *
 * @author Administrator
 */
public class Controll {
    Tampil tampil;
    Tambah tambah;
    EditHapus edit;
    DataSewa sewa;
    
    public Controll( Tampil tampild, Tambah tambahd,EditHapus edith,DataSewa sewad){

        this.tampil = tampild;
        this.tambah = tambahd;
        this.edit = edith;
        this.sewa = sewad;
 
        
        if(sewa.getBanyakData()!=0){
            String dataSewa[][] = sewa.readData();
            tampil.tabel.setModel((new JTable(dataSewa, tampil.kolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        tambah.bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String id = tambah.getID();
                String nama = tambah.getNama();
                String tipe = tambah.getTipe();
                String pinjam = tambah.getPinjam();
                String kembali = tambah.getKembali();
                sewa.insert(id, nama, tipe,pinjam,kembali);
         
                String dataSewa[][] = sewa.readData();
                tampil.tabel.setModel((new JTable(dataSewa, tampil.kolom)).getModel());
                tambah.dispose();
                Menu m = new Menu();
            }
        });
        tambah.bback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambah.dispose();
                Menu m = new Menu();
                   
            }
        });
        tambah.breset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambah.fid.setText(null);
                tambah.fnama.setText(null);  
                tambah.ftipe.setText(null);
                tambah.fpinjam.setText(null);
                tambah.fkembali.setText(null);
            }
        });        
        tampil.bback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampil.dispose();
                Menu m = new Menu();
                   
            }
        });
        edit.bupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = edit.getID();
                String nama = edit.getNama();
                String tipe = edit.getTipe();
                String pinjam = edit.getPinjam();
                String kembali = edit.getKembali();
                sewa.update(id, nama, tipe,pinjam,kembali);
                edit.dispose();
                Menu m = new Menu();
            }
        });
        edit.bhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = edit.getID();
                sewa.delete(id);
                edit.dispose();
                Menu m = new Menu();
            }
        });
        edit.bback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.dispose();
                Menu m = new Menu(); 
            }
        });
      tampil.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = tampil.tabel.getSelectedRow();
                
                String id = tampil.tabel.getValueAt(baris, 0).toString();
                String nama = tampil.tabel.getValueAt(baris, 1).toString();
                String tipe = tampil.tabel.getValueAt(baris, 2).toString();
                String pinjam = tampil.tabel.getValueAt(baris, 3).toString();
                String kembali = tampil.tabel.getValueAt(baris, 4).toString();
                
                tampil.dispose();
                EditHapus ed = new EditHapus();
                ed.fid.setText(id);
                ed.fnama.setText(nama);
                ed.ftipe.setText(tipe);
                ed.fpinjam.setText(pinjam);
                ed.fkembali.setText(kembali);
                Tampil tp = new Tampil();
                tp.dispose();
                Tambah tb = new Tambah();
                tb.dispose();
                DataSewa md = new DataSewa();
                Controll ct = new Controll(tp,tb,ed,md);
            }
        }
        );
    }
}