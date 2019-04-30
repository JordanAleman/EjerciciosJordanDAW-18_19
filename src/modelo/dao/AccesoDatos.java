package modelo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import control.BaseDatos;
import control.UsoBD;
import modelo.Equipo;

public class AccesoDatos { 

	public static void main(String[] args) {
		// 29 de Marzo del 2019 --  Vamos a insertar todos los equipos dentro de nuestra base de datos ligafutbol
		ArrayList<Equipo> listaEquipos = new Equipo().crearListaEquiposConDatos("ficheros/equipos.txt", "#");
		

		new UsoBD().eliminarListaEquipo(listaEquipos);
		new UsoBD().insertarListaEquipo(listaEquipos);
		
		

	}

}
