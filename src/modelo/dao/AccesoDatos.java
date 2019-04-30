package modelo.dao;

import java.util.ArrayList;

import control.UsoBD;
import modelo.Equipo;

public class AccesoDatos { 

	public static void main(String[] args) {
		// 29 de Marzo del 2019 --  Vamos a insertar todos los equipos dentro de nuestra base de datos ligafutbol
		ArrayList<Equipo> listaEquipos = new Equipo().crearListaEquiposConDatos("ficheros/equipos.txt", "#");
		

		new UsoBD().eliminarListaEquipo(listaEquipos);
		new UsoBD().insertarListaEquipo(listaEquipos);
		
		new UsoBD().eliminarEquipoDB();
		new UsoBD().insertarEquipoDatosBasicosDesdeFichero();
		
		

	}

}
