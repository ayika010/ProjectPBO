/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Koneksi;
import view.Tambah;


/**
 *
 * @author Administrator
 */
public class DataSewa {
    Koneksi koneksi = new Koneksi();
       public String[][] readData(){
        try{
            int jumlah = 0;
            
            String data[][] = new String[getBanyakData()][5]; 
            
            String query = "Select * from sewa"; 
            ResultSet resultSet = koneksi.statement.executeQuery(query);
            while (resultSet.next()){
                data[jumlah][0] = resultSet.getString("id"); 
                data[jumlah][1] = resultSet.getString("nama");                
                data[jumlah][2] = resultSet.getString("tipe");
                data[jumlah][3] = resultSet.getString("pinjam");
                data[jumlah][4] = resultSet.getString("kembali");
                jumlah++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public void insert(String id, String nama, String tipe, String pinjam, String kembali){
        try {
           String query = "Select * from sewa"; 
           ResultSet resultSet = koneksi.statement.executeQuery(query);
           
           while (resultSet.next()){ 

            }
                query = "INSERT INTO sewa VALUES('"+id+"','"+nama+"','"+tipe+"','"+pinjam+"','"+kembali+"')";
                
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query); 
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
         catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            koneksi.statement = koneksi.koneksi.createStatement();
            String query = "Select * from sewa";
            ResultSet resultSet = koneksi.statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
                    }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
            }   
    }
           public void update(String id, String nama, String tipe, String pinjam, String kembali){
        int jumlah=0;
         try {
           String query = "Select * from sewa WHERE id=" + id; 
           ResultSet resultSet = koneksi.statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jumlah++;
            }
           
             if (jumlah==1) {
                query = "UPDATE sewa SET id='" + id + "', nama='" + nama + "', tipe='" + tipe + "', pinjam='" + pinjam + "' , kembali='" + kembali + "'WHERE id=" + id;
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query); //execute querynya
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
    public void delete (String id) {
        try{
            String query = "DELETE FROM sewa WHERE id = '"+id+"'";
            koneksi.statement = koneksi.koneksi.createStatement();
            koneksi.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
