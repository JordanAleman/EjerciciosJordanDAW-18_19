package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	private int numJornada;
	private String equipoLocal;
	private int golesLocal;
	private String equipoVisitante;
	private int golesVisitante;


	public Partido(int idPartido, int numJornada, String equipoLocal, int golesLocal, String equipoVisitante, int golesVisitante) {
		this.idPartido = idPartido;
		this.numJornada = numJornada;
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
			
			
			
			while ((registro = fichero.readLine()) != null) {
				try {// Romper la cadena registro
					String[] campos = registro.split(delimitador);

					// Creamos el mapa de equipos con un arraylist donde se recojan los valores de
					// victoria, empate y derrota
					if (!mapaResultadosEquipos.containsKey(campos[2])
							|| !mapaResultadosEquipos.containsKey(campos[4])) {
						for (int i = 2; i <= 4; i += 2) {
							if (!mapaResultadosEquipos.containsKey(campos[i])) {
								// Creamos el ArrayList dentro de este bucle for para que cada ArrayList tenga
								// su único identificador
								mapaResultadosEquipos.put(campos[i], new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
							}
						}
					}

					try {
						if (Integer.parseInt(campos[3]) > Integer.parseInt(campos[5])) {
							mapaResultadosEquipos.get(campos[2]).set(0,
									mapaResultadosEquipos.get(campos[2]).get(0) + 1); // Victoria para el equipo local
							
							mapaResultadosEquipos.get(campos[4]).set(2,
									mapaResultadosEquipos.get(campos[4]).get(2) + 1); // Derrota del equipo visitante

						} else if (Integer.parseInt(campos[3]) < Integer.parseInt(campos[5])) {
							mapaResultadosEquipos.get(campos[2]).set(2,
									mapaResultadosEquipos.get(campos[2]).get(2) + 1); // Derrota del equipo local
							
							mapaResultadosEquipos.get(campos[4]).set(0,
									mapaResultadosEquipos.get(campos[4]).get(0) + 1); // Victoria para el equipo visitante

						} else if (Integer.parseInt(campos[3]) == Integer.parseInt(campos[5])) {
							mapaResultadosEquipos.get(campos[2]).set(1,
									mapaResultadosEquipos.get(campos[2]).get(1) + 1); // Empate por parte del equipo local
							
							mapaResultadosEquipos.get(campos[4]).set(1,
									mapaResultadosEquipos.get(campos[4]).get(1) + 1); // Empate por parte del equipo visitante
						}
					} catch (NumberFormatException e) {
						break;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// Ignorar líneas vacías del fichero
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
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Línea vacía");
		}
		return null;
	}
	
	public HashMap<String, ArrayList<Integer>> numeroGolesMarcadosYRecibidos (String rutaFichero, String delimitador) {
		try {
			HashMap<String,ArrayList<Integer>> mapaGolesEquipos = new HashMap<String, ArrayList<Integer>>();
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			while((registro = fichero.readLine()) != null){
				try {
					// Romper la cadena registro
					String[] campos = registro.split(delimitador);
					
					// Creamos el mapa de equipos con un arraylist donde se recojan los valores de goles recibidos y marcados
					if(!mapaGolesEquipos.containsKey(campos[2]) || !mapaGolesEquipos.containsKey(campos[4])) {
						for(int i = 2; i<=4; i+=2) {
							if(!mapaGolesEquipos.containsKey(campos[i])){
								mapaGolesEquipos.put(campos[i], new ArrayList<Integer>(Arrays.asList(0,0)));		
							}
						} 
					}
					
					try {
						mapaGolesEquipos.get(campos[2]).set(0, mapaGolesEquipos.get(campos[2]).get(0)+Integer.parseInt(campos[3])); // Sumamos goles marcados por equipo local
						mapaGolesEquipos.get(campos[4]).set(0, mapaGolesEquipos.get(campos[4]).get(0)+Integer.parseInt(campos[5])); // Sumamos goles marcados por equipo visitante
						
						mapaGolesEquipos.get(campos[2]).set(1, mapaGolesEquipos.get(campos[2]).get(1)+Integer.parseInt(campos[5])); // Sumamos goles recibidos por equipo local
						mapaGolesEquipos.get(campos[4]).set(1, mapaGolesEquipos.get(campos[4]).get(1)+Integer.parseInt(campos[3])); // Sumamos goles recibidos por equipo visitante
						
					} catch (NumberFormatException e) {
						break;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// Ignorar líneas vacías del fichero
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
