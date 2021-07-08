
    package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import sewakendaraan.*;

/**
 *
 * @author Administrator
 */
public class Tampil extends JFrame {
    

    JFrame frame = new JFrame("JDBC");
    JLabel ljudul = new JLabel("Data Sewa");
    public JTable tabel;
    DefaultTableModel model;
    JScrollPane scrollPanel;
    String data[][] = new String[500][4];
    public Object kolom[] = {"ID", "Nama", "Tipe Kendaraan", "Tanggal Pinjam","Tanggal Kembali"};
    
    public JButton bback = new JButton("KEMBALI");
    
    
    public Tampil(){
        setTitle("Data Sewa");
        setSize(740,384);
        setLayout(null);
        add(bback);
        add(ljudul);
        
        ljudul.setBounds(17,15,200,30);
        ljudul.setFont(new Font("Calibri", Font.BOLD, 20));   
        model = new DefaultTableModel(kolom, 0);
        tabel = new JTable(model);
        scrollPanel = new JScrollPane(tabel);
        
        scrollPanel = new JScrollPane(tabel);
        add(scrollPanel);
        
        scrollPanel.setBounds(15, 50, 700, 100);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        bback.setBounds(20, 300,100, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
