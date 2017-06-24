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
import java.text.SimpleDateFormat;

/**
 *
 * @author educacionit
 */
public class TestPrepareStatement {

    private static void getById(PreparedStatement ps, int id) throws Exception {

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int ids = rs.getInt("id_cliente");
            String nom = rs.getString("nombre");
            String ape = rs.getString("apellido");

            System.out.println(ids + "  " + nom + " " + ape);
        } else {
            System.out.println("ID no encontrado");
        }

    }

    private static void actualizar(PreparedStatement ps, int id, String nombre, String apellido) throws Exception {
        ps.setInt(3, id);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.execute();
    }

    private static void insertar(PreparedStatement ps, String nombre, String apellido) throws Exception {
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.execute();
    }

    private static void eliminar(PreparedStatement ps,int id) throws Exception {
        ps.setInt(1,id);
        ps.execute();
    }

    public static void main(String[] args) throws SQLException, Exception {

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso1", "root", "");

        // insertar
        PreparedStatement psi = c.prepareStatement("insert into Clientes(nombre,apellido) values(?,?)");
        insertar(psi,"Michelle","Canciani");

        //actualizar
        PreparedStatement psa = c.prepareStatement("update Clientes set nombre=?, apellido=? where id_cliente=?");
        actualizar(psa, 1, "Fulano", "De Tal");

        //date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        java.util.Date date = sdf.parse("09/10/2010");

        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        String q = "select * from clientes where id_cliente= ?";
        
        //Eliminar
        PreparedStatement psd = c.prepareStatement("delete from clientes where id_cliente=?");
        
        eliminar(psd,1);
        

        
        //consultar
        PreparedStatement ps = c.prepareStatement(q);
        getById(ps, 1);
        
    }
}
