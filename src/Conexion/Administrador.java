    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author educacionit
 */
public abstract class Administrador {
    
        public static Connection getConnection() throws Exception
        {
            String dbDriver = "com.mysql.jdbc.Driver";

            String dbConnString = "jdbc:mysql://localhost:3306/test";
            
            String dbUser = "root";
            
            String dbPassword = "";
            
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
        }

    
}
