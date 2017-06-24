/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author educacionit
 */
public class ConexionBD {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso1","root","");
        
        //pull de colecciones
        
        String q = "select * from clientes";
        
        Statement stm = c.createStatement();
        
        ResultSet rs = stm.executeQuery(q);
        
        while(rs.next()){
            int id= rs.getInt("id_cliente");
            String nom= rs.getString("nombre");
            String ape= rs.getString("apellido");
            
            System.out.println(id+"  "+nom+" "+ape);
        }
      
    }
    
}
