package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Jugador extends Persona {
	private int idJugador;
	private int dorsal;
	private int idEquipo;

	public Jugador() {
	}

	/*public Jugador(String nif, String nombre, int longitudPaso, String fecha_nac, char sexo, int idJugador, int dorsal, int idEquipo) {
		super(nif, nombre, longitudPaso, fecha_nac, sexo);
		this.idJugador = idJugador;
		this.dorsal = dorsal;
		this.idEquipo = idEquipo;
	}*/

	public Jugador(int idJugador, String nombre, int dorsal, int idEquipo) {
		super(nombre);
		this.idJugador = idJugador;
		this.dorsal = dorsal;
		this.idEquipo = idEquipo;
	}
	
	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	public HashMap<Equipo, ArrayList<Jugador>> asignarJugadoresAEquipos(Equipo equipo){
		HashMap<Equipo, ArrayList<Jugador>> equipoYJugadores = new HashMap<Equipo, ArrayList<Jugador>>();
		
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("ficheros/jugadores.txt"));
			String registro;

			while ((registro = fichero.readLine()) != null) {
				// Romper la cadena registro
				String[] campos = registro.split("#");
				
				
			}

			fichero.close();
			return equipoYJugadores;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		
		return null;
	}
}
