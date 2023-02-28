/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author L
 */
public class conexion {
    Connection con;
    String url = "jdbc:mysql://localhost/tienda";
    String usr = "root";
    String pass = "12345";

    public Connection getConnection() {

        try {
            //se carga el driver mysql
            Class.forName("com.mysql.jdbc.Driver");
            //se hace la autentificacion de la bd
            con = DriverManager.getConnection(url, usr, pass);
            if (con != null) {
                System.out.println("Conexión establecida");
                return con;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void main(String[] args) {
        conexion miCone = new conexion();
        miCone.getConnection();
    }

}

