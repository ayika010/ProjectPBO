
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import controller.*;
import model.DataSewa;

/**
 *
 * @author Administrator
 */
public class Menu extends JFrame implements ActionListener{
    
    JLabel ljudul = new JLabel("Data Sewa Kendaraan");
    
    JButton btambah = new JButton("Tambah Data Sewa");
    JButton btampil = new JButton("Tampil Data Sewa");
    
    
    public Menu(){
        setSize(640,384);
        setLayout(null);
        add(ljudul);
        add(btampil);
        add(btambah);
        
        ljudul.setBounds(210,20,230,30);
        ljudul.setFont(new Font("Calibri", Font.BOLD, 25));
        btambah.setBounds(200,120,250,30);
        btampil.setBounds(200,160,250,30);
        
        
        btambah.addActionListener(this);
        btampil.addActionListener(this);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource() == btambah){
        Tambah tb =  new Tambah();
        dispose();  
        Tampil tp =  new Tampil();
        tp.dispose();
        EditHapus eh = new EditHapus();
        eh.dispose();
        DataSewa md = new DataSewa();
        Controll ct = new Controll(tp,tb,eh,md);
        }
        if(e.getSource() == btampil){
        Tampil tp =  new Tampil();
        dispose();  
        Tambah tb =  new Tambah();
        tb.dispose();
        EditHapus eh = new EditHapus();
        eh.dispose();
        DataSewa md = new DataSewa();
        Controll ct = new Controll(tp,tb,eh,md);
        }
    }
}  