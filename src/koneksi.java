/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author elsarsntna
 */

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    
    public static Connection koneksi;
    //Metode main untuk titik masuk program
    
     public static void main(String[] args) {

        Connection connection = getKoneksi();
    }
     
    public static Connection getKoneksi(){
        // cek apakah koneksi null
        if(koneksi == null){
            try{
                String url ="jdbc:mysql://localhost:3306/db_penjualan_barang_pas_xiia";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url,user,password);
                System.out.println("Berhasil Membuat Koneksi");
            }catch(SQLException t){
                System.out.println("Error Membuat Koneksi");
            }
        }
        return  koneksi;
    }
}
