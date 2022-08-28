/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post_rian;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rian
 */
public class koneksi {

    private static Connection KoneksiDatabse;

    public static Connection koneksiDB() throws SQLException {
        try {
            String DB = "jdbc:mysql://localhost/ujian_visual";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            KoneksiDatabse = (Connection) DriverManager.getConnection(DB, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return KoneksiDatabse;
    }
}
