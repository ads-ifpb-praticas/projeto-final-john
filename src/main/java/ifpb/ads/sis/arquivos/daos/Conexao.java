/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author john
 */
public class Conexao {
    
    private static String url = "jdbc:postgresql://localhost:5432/sisplace";
    private static String usuario = "john";
    private static String senha = "john";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection cone = DriverManager.getConnection(url,usuario, senha);
        return cone;
    }
}
