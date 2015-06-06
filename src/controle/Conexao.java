/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ernani
 */
public class Conexao {

    private static Connection con;

    public static Connection getConexao() {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            String serverName = "localhost";
            String mydatabase ="bd_gfire";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado: " + e.getMessage(), "ERRO", 0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro abrindo conexao: " + e.getMessage(), "ERRO", 0);
        }
        return con;
    }
}
