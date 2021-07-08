package view;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import sewakendaraan.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class EditHapus extends JFrame {
     JLabel ljudul = new JLabel("Silahkan Edit atau Hapus Data Sewa");
    
    JLabel lid = new JLabel("ID Penyewa");
    public final JTextField fid = new JTextField(10);
    
    JLabel lnama = new JLabel("Nama");
    public final JTextField fnama= new JTextField(10);
    
    JLabel ltipe = new JLabel("Tipe Kendaraan");
    public final JTextField ftipe= new JTextField(10);
    
    JLabel lpinjam = new JLabel("Tanggal Pinjam");
    public final JTextField fpinjam = new JTextField(10);
    
    JLabel lkembali = new JLabel("Tanggal Kembali");
    public final JTextField fkembali= new JTextField(10);
    
    public JButton bupdate = new JButton("Update");
    public JButton bhapus = new JButton("Hapus");
    
    public JButton bback = new JButton("Kembali");
    
     public EditHapus(){
        setTitle("Tambah Data Sewa");
        setSize(640,384);
        setLayout(null);
        add(ljudul);
        add(lid);
        add(fid);
        add(lnama);
        add(fnama);
        add(ltipe);
        add(ftipe);
        add(lpinjam);
        add(fpinjam);
        add(lkembali);
        add(fkembali);       

        add(bupdate);
        add(bhapus); 
        add(bback);
        
        ljudul.setBounds(160,15,270,30);
        ljudul.setFont(new Font("Calibri", Font.BOLD, 18));   
        
        
        lnama.setBounds(160,60,170,30);
        fnama.setBounds(270,60,170,30);
        lnama.setFont(new Font("Calibri", Font.BOLD, 15));        

        ltipe.setBounds(160,100,170,30);
        ftipe.setBounds(270,100,170,30);
        ltipe.setFont(new Font("Calibri", Font.BOLD, 15));   
        
        lpinjam.setBounds(160,140,170,30);
        fpinjam.setBounds(270,140,170,30);
        lpinjam.setFont(new Font("Calibri", Font.BOLD, 15));  
        
        lkembali.setBounds(160,180,170,30);
        fkembali.setBounds(270,180,170,30);
        lkembali.setFont(new Font("Calibri", Font.BOLD, 15));   
        
        bupdate.setBounds(420,300,90,20);
        bhapus.setBounds(520,300,90,20);
        bback.setBounds(15,5,80,20);
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }


    public String getID(){
        return fid.getText();
    }
    
    public String getNama(){
        return fnama.getText();
    }
    
    public String getTipe(){
        return ftipe.getText();
    }
    
    public String getPinjam(){
        return fpinjam.getText();
    }
    
    public String getKembali(){
        return fkembali.getText();
    }
}
    