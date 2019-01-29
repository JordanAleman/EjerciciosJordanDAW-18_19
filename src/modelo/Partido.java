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
	
	// 23 de Enero del 2019 -- Actividad: Mostrar número de partidos jugados
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
	
	// 24 de Enero del 2019 -- Actividad: Mostrar número de partidos jugados a través 
	// de un integer que controle los partidos jugados.
	public void mostrarNumeroPartidosJugadosTry(String rutaFichero, String delimitador) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			int contador = 0;
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				try {
					Integer.parseInt(campos[3]); // Si el campo 3 es un integer se sumará a uno el contador.
					contador++;
				} catch (NumberFormatException ex) {
					// Si el campo 3 del array "campos" no es un integer, a partir de entonces ya no se
					// juegan más partidos y por tanto acabamos con el bucle.
					break; 
				}
			}

			fichero.close();
			System.out.println("Se ha jugado un total de " + contador + " partidos.");
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
	}
	
	//24 de Enero del 2019 -- Actividad: Obtener un mapa con los resultados de cada equipo
	public HashMap<String, ArrayList<Integer>> resultadosEquipos(String rutaFichero, String delimitador){
		try {
			HashMap<String,ArrayList<Integer>> mapaResultadosEquipos = new HashMap<String, ArrayList<Integer>>();
			
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				// Creamos el mapa de equipos con un arraylist donde se recojan los valores de victoria, empate y derrota
				if(!mapaResultadosEquipos.containsKey(campos[2]) || !mapaResultadosEquipos.containsKey(campos[4])) {
					for(int i = 2; i<=4; i+=2) {
						if(!mapaResultadosEquipos.containsKey(campos[i])){
							// Creamos el ArrayList dentro de este bucle for para que cada ArrayList tenga su único identificador
							ArrayList<Integer> base = new ArrayList<Integer>();
							base.add(new Integer(0)); // Victorias
							base.add(new Integer(0)); // Empates
							base.add(new Integer(0)); // Derrotas
							mapaResultadosEquipos.put(campos[i], base);	
						}
					} 
				}
				
				try {
					if(Integer.parseInt(campos[3]) > Integer.parseInt(campos[5])) {
						ArrayList<Integer> equipoLocalVictoria = mapaResultadosEquipos.get(campos[2]);
						ArrayList<Integer> equipoVisitanteDerrota = mapaResultadosEquipos.get(campos[4]);
						
						equipoLocalVictoria.set(0, equipoLocalVictoria.get(0)+1);
						equipoVisitanteDerrota.set(2, equipoVisitanteDerrota.get(2)+1);
						
						mapaResultadosEquipos.replace(campos[2], equipoLocalVictoria);
						mapaResultadosEquipos.replace(campos[4], equipoVisitanteDerrota);
						
					} else if (Integer.parseInt(campos[3]) < Integer.parseInt(campos[5])) {
						ArrayList<Integer> equipoLocalDerrota = mapaResultadosEquipos.get(campos[2]);
						ArrayList<Integer> equipoVisitanteVictoria = mapaResultadosEquipos.get(campos[4]);
						
						equipoLocalDerrota.set(2, equipoLocalDerrota.get(2)+1);
						equipoVisitanteVictoria.set(0, equipoVisitanteVictoria.get(0)+1);
						
						mapaResultadosEquipos.replace(campos[2], equipoLocalDerrota);
						mapaResultadosEquipos.replace(campos[4], equipoVisitanteVictoria);
						
					} else if (Integer.parseInt(campos[3]) == Integer.parseInt(campos[5])) {
						ArrayList<Integer> equipoLocalEmpate = mapaResultadosEquipos.get(campos[2]);
						ArrayList<Integer> equipoVisitanteEmpate = mapaResultadosEquipos.get(campos[4]);
						
						equipoLocalEmpate.set(1, equipoLocalEmpate.get(1)+1);
						equipoVisitanteEmpate.set(1, equipoVisitanteEmpate.get(1)+1);
						
						mapaResultadosEquipos.replace(campos[2], equipoLocalEmpate);
						mapaResultadosEquipos.replace(campos[4], equipoVisitanteEmpate);
					}
				} catch (NumberFormatException e) {
					break;
				}
			}

			fichero.close();
			
			
			/*
			 * Set<String> clavesMapa = mapaResultadosEquipos.keySet();
			 * 
			 * System.out.println("El resultado de los equipos es el siguiente:");
			 * for(String claves: clavesMapa) { System.out.println((claves + ": [V:" +
			 * mapaResultadosEquipos.get(claves).get(0)) + ", E:" +
			 * mapaResultadosEquipos.get(claves).get(1) + ", D:" +
			 * mapaResultadosEquipos.get(claves).get(2) + "]"); }
			 */
			 

			return mapaResultadosEquipos;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		return null;
	}
	
	public HashMap<String, ArrayList<Integer>> numeroGolesMarcadosYRecibidos (String rutaFichero, String delimitador) {
		try {
			HashMap<String,ArrayList<Integer>> mapaGolesEquipos = new HashMap<String, ArrayList<Integer>>();
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				// Creamos el mapa de equipos con un arraylist donde se recojan los valores de goles recibidos y marcados
				if(!mapaGolesEquipos.containsKey(campos[2]) || !mapaGolesEquipos.containsKey(campos[4])) {
					for(int i = 2; i<=4; i+=2) {
						if(!mapaGolesEquipos.containsKey(campos[i])){
							ArrayList<Integer> base = new ArrayList<Integer>();
							base.add(new Integer(0)); // Goles marcados
							base.add(new Integer(0)); // Goles recibidos
							mapaGolesEquipos.put(campos[i], base);	
						}
					} 
				}
				
				try {
					ArrayList<Integer> equipoLocalGoles = mapaGolesEquipos.get(campos[2]);
					ArrayList<Integer> equipoVisitanteGoles = mapaGolesEquipos.get(campos[4]);
					
					equipoLocalGoles.set(0, equipoLocalGoles.get(0)+Integer.parseInt(campos[3])); // Sumamos goles marcados
					equipoLocalGoles.set(1, equipoLocalGoles.get(1)+Integer.parseInt(campos[5])); // Sumamos goles recibidos
					
					equipoVisitanteGoles.set(0, equipoVisitanteGoles.get(0)+Integer.parseInt(campos[5])); // Sumamos goles marcados
					equipoVisitanteGoles.set(1, equipoVisitanteGoles.get(1)+Integer.parseInt(campos[3])); // Sumamos goles recibidos
					
					mapaGolesEquipos.replace(campos[2], equipoLocalGoles);
					mapaGolesEquipos.replace(campos[4], equipoVisitanteGoles);
					
				} catch (NumberFormatException e) {
					break;
				}
			}

			fichero.close();

			return mapaGolesEquipos;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		return null;
	}
}
