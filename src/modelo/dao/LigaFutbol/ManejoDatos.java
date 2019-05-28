package modelo.dao.LigaFutbol;

import java.util.ArrayList;

import modelo.Equipo;
import modelo.Jugador;

public class ManejoDatos { 

	public static void main(String[] args) {
		// 29 de Marzo del 2019 --  Vamos a insertar todos los equipos dentro de nuestra base de datos ligafutbol
		ArrayList<Equipo> listaEquipos = new Equipo().crearListaEquiposConDatos("ficheros/equipos.txt", "#");
		ArrayList<Jugador> listaJugador = new Jugador().crearListaJugadores("ficheros/jugadores.txt", "#");
		
		for (int i = 0; i < listaJugador.size(); i++) {
			System.out.println("IdJugador: " + listaJugador.get(i).getIdJugador() + " Nombre: [" + listaJugador.get(i).getNombre() + "] Dorsal: " + listaJugador.get(i).getDorsal());
		}
		



		new TablasLigaFutbol().eliminarListaEquipo(listaEquipos);
		new TablasLigaFutbol().insertarListaEquipo(listaEquipos);
		
//		new TablasLigaFutbol().eliminarJugadores();
		
//		new TablasLigaFutbol().insertarListaJugadores(listaJugador);
//		new TablasLigaFutbol().insertarJugadoresPorFichero("ficheros/jugadores.txt","#");
		
//		new TablasLigaFutbol().eliminarPartido();
//		new TablasLigaFutbol().insertarPartidos("ficheros/partidos.txt","#");
		
		new TablasLigaFutbol().eliminarClasificacion();
		new TablasLigaFutbol().insertarClasificacion(listaEquipos);

	}

}
