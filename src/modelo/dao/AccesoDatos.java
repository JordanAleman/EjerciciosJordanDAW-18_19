package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import control.BaseDatos;

public class AccesoDatos {

	private Connection conexion = null;
	    
    public AccesoDatos(){
        BaseDatos miConexion = new BaseDatos();
        conexion = miConexion.getConexion();
    }
	
    public void getActor(){
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexion.prepareStatement("select first_name from actor");
            rs = stmt.executeQuery(); // Al ejecutar la consulta, el resultado debe ser almacenado. Por eso s almacena en la variable rs.
            while(rs.next()){ // Se ejecuta tantas veces como filas tenga la consulta. 
            	System.out.println(rs.getString("first_name"));
            }

        } catch (SQLException ex) {
            System.out.println("Error al modificar un dato en la base de datos");

        }    
    }

}
