/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author educacionit
 */
public class IdGenerico {
    
        public static void main(String[] args) throws SQLException {
       
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso1","root","");
        
        //pull de colecciones
        
        int id= 2; 
        String q = "select * from clientes where id_cliente= ?";

        PreparedStatement ps = c.prepareStatement(q);
        
        ps.setInt(1,id);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            int ids= rs.getInt("id_cliente");
            String nom= rs.getString("nombre");
            String ape= rs.getString("apellido");
            
            System.out.println(ids+"  "+nom+" "+ape);
        }
        else{
            System.out.println("ID no encontrado");
        }
        
    }
        

    
}
