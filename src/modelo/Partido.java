package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class Contador{
	protected int contador;
	
	
	
	public Contador() {
		contador = 0;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

}

public class Partido {
	private int idPartido;
	private String equipoLocal;
	private int golesLocal;
	private String equipoVisitante;
	private int golesVisitante;


	public Partido(int idPartido, String equipoLocal, int golesLocal, String equipoVisitante, int golesVisitante) {
		this.idPartido = idPartido;
		this.equipoLocal = equipoLocal;
		this.golesLocal = golesLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesVisitante = golesVisitante;
	}


	public Partido() {

	}


	public int getIdPartido() {
		return idPartido;
	}


	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}


	public String getEquipoLocal() {
		return equipoLocal;
	}


	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}


	public int getGolesLocal() {
		return golesLocal;
	}


	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}


	public String getEquipoVisitante() {
		return equipoVisitante;
	}


	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}


	public int getGolesVisitante() {
		return golesVisitante;
	}


	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	// 22 de Enero del 2019 -- Actividad: A partir del fichero partidos.txt comprobar que todos
	// los partidos escritos en el fichero son correcto. Puesto que cada equipo juega hasta 
	// 38 partidos, debemos comprobar que cada equipo ha jugado 38 partidos.
	public HashMap<String, Integer> comprobarPartidos(String rutaFichero, String delimitador){
		try {
			HashMap<String,Integer> mapaEquipos = new HashMap<String, Integer>();
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			ArrayList<String> equipos = new ArrayList<String>();
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				
				// Comprobar si el equipo local ya está incluído en el mapa
				for(int i = 2; i<=4; i+=2) {
					if(!mapaEquipos.containsKey(campos[i])) {
						mapaEquipos.put(campos[i], new Integer(1));
						equipos.add(campos[i]);
					} else {
						mapaEquipos.replace(campos[i], Integer.sum(mapaEquipos.get(campos[i]), 1));				
					}
				}
				
			}

			fichero.close();
			
			Set<String> clavesMapa = mapaEquipos.keySet();
			int contador = 0;
			
			for(String claves: clavesMapa) {
				System.out.println((contador+1) + " "  + equipos.get(contador) + ": " + mapaEquipos.get(claves));
				contador++;
			}
			System.out.println("Fin de la lectura");

			return mapaEquipos;
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		return null;
	}
	
	public void mostrarNumeroPartidosJugados(String rutaFichero, String delimitador) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			int contador = 0;
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				if (campos[3].compareTo("") == 0) {
					break;
				}
				
				// Opción 2
				/*if (campos[3].equals("")) {
					break;
				}*/
				
				contador++;
				
			}

			fichero.close();

			System.out.println("Se ha jugado un total de " + contador + " partidos.");
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
	}
}
