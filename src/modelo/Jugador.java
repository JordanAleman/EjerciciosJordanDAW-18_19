package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
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
	
	
	
	@Override
	public String toString() {
		return "Id jugador: " +getIdJugador() + ", Id equipo: " + getIdEquipo() 
		+ ", Dorsal: " + getDorsal() + ", Nombre jugador: " + getNombre() + "]";
	}

	// 23 de Febrero del 2019 -- Comprobar que los jugadores de "fichero/jugadores.txt" están todos correctos
	public void comprobarJugadores(String rutaFichero, String delimitador) {
		try {
			ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			int contador = 1;
			int linea = 1;
			
			ArrayList<Integer> lineasIncorrectas = new ArrayList<Integer>();
			
			while((registro = fichero.readLine()) != null){
				try {
					// Romper la cadena registro
					String[] campos = registro.split(delimitador);
					jugadores.add(new Jugador(Integer.parseInt(campos[0]),campos[1],Integer.parseInt(campos[2]),Integer.parseInt(campos[3])));
					
				} catch (NumberFormatException e) {
					// Ignorar líneas vacías del fichero. También evaluará las líneas que estén mal
					lineasIncorrectas.add(linea);
				}
				linea++;
			}
			
			fichero.close();
			
			for (int i = 0; i < jugadores.size(); i++) {
				System.out.println(contador + jugadores.get(i).toString());
				contador++;
			}
			
			if(lineasIncorrectas.size()>0) {
				System.out.println("\nHay líneas en el fichero [" + rutaFichero + "] que no son correctas. Esas líneas son las siguientes:");
				for (int i = 0; i < lineasIncorrectas.size(); i++) {
					System.out.println("Línea: " + lineasIncorrectas.get(i));
				}
			}
				
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
	}
	
	public ArrayList<Jugador> listaJugadoresDeUnEquipo(int idEquipo){
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("ficheros/jugadores.txt"));
			String registro;

			while ((registro = fichero.readLine()) != null) {
				// Romper la cadena registro
				String[] campos = registro.split("#");

				if(idEquipo == Integer.parseInt(campos[3])){
					jugadores.add(new Jugador(Integer.parseInt(campos[0]),campos[1],Integer.parseInt(campos[2]),Integer.parseInt(campos[3])));
				}
				
			}
			
			
			fichero.close();
			return jugadores;
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		
		return null;
	}
	
	
	public HashMap<Equipo, ArrayList<Jugador>> asignarJugadoresAEquipos(){
		HashMap<Equipo, ArrayList<Jugador>> equipoYJugadores = new HashMap<Equipo, ArrayList<Jugador>>();
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("ficheros/equipos.txt"));
			String registro;

			while ((registro = fichero.readLine()) != null) {
				try {
					// Romper la cadena registro
					String[] campos = registro.split("#");
					// Esta siguiente instrucción asigna como clave del mapa un equipo. El equipo que irá poniendo como clave viene definido
					// por el nombre corto del fichero "ficheros/equipos.txt". Su respectiva clase en la lista de jugadores de ese equipo.
					// Para identificar el equipo al cual pertenece los jugadores usamos el cuarto campo del fichero "ficheros/jugadores.txt".
					
					equipoYJugadores.put(new Equipo().crearEquipo(campos[1]), listaJugadoresDeUnEquipo(Integer.parseInt(campos[0])));
		
				} catch (ArrayIndexOutOfBoundsException e) {
					// Ignorar
				}
				
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
	
	public void mostrarEquiposYSuListaDeJugadoresOrdenadoPorIdEquipo() {
		HashMap<Equipo, ArrayList<Jugador>> equipoYJugadores = new Jugador().asignarJugadoresAEquipos();
		
		List<Entry<Equipo, ArrayList<Jugador>>> listaOrdenada = new LinkedList<>(equipoYJugadores.entrySet());

		listaOrdenada.sort(new Comparator<Entry<Equipo, ArrayList<Jugador>>>() {
			public int compare(Entry<Equipo, ArrayList<Jugador>> equipo1, Entry<Equipo, ArrayList<Jugador>> equipo2) {
				if(equipo2.getValue().get(0).getIdEquipo() < equipo1.getValue().get(0).getIdEquipo()) {
					return "1".compareTo("0");
				} else {
					return "0".compareTo("1");
				}
					
			}
		});
		
		equipoYJugadores = new LinkedHashMap<Equipo, ArrayList<Jugador>>();
		for (Iterator<Entry<Equipo, ArrayList<Jugador>>> it = listaOrdenada.iterator(); it.hasNext();) {
			Map.Entry<Equipo, ArrayList<Jugador>> entry = (Map.Entry<Equipo, ArrayList<Jugador>>) it.next();
			equipoYJugadores.put(entry.getKey(), entry.getValue());
		}
		
		Set<Equipo> clavesMapa = equipoYJugadores.keySet();
		
		for (Equipo equipo : clavesMapa) {
			int contador = 1;
			System.out.println("Lista de jugadores del " + equipo.getNombreEquipo() + ":\n");
			for (int i = 0; i < equipoYJugadores.get(equipo).size(); i++) {
				System.out.println(contador + ": " + equipoYJugadores.get(equipo).get(i).toString());
				contador++;	
			}
			System.out.println("");
		}
	}
	
	public void mostrarEquiposYSuListaDeJugadoresOrdenadoPorClasificacion() {
		HashMap<Equipo, ArrayList<Jugador>> equipoYJugadores = new Jugador().asignarJugadoresAEquipos();
		HashMap<String, ArrayList<String>> clasificacionTotal = new Equipo().clasificacionTotal("ficheros/partidos.txt", "#");
		
		Set<String> clavesMapaClasificacionTotal = clasificacionTotal.keySet();
		Set<Equipo> clavesMapaEquipoYJugadores = equipoYJugadores.keySet();
		
		for (String clasificacion : clavesMapaClasificacionTotal) {
			int contador = 1;
			for (Equipo equipo : clavesMapaEquipoYJugadores) {
				if (clasificacion.compareTo(equipo.getNombreCorto()) == 0) {
					System.out.println(equipo.toString());
					System.out.println("Lista de jugadores del " + equipo.getNombreEquipo() + ":\n");
					
					for (int i = 0; i < equipoYJugadores.get(equipo).size(); i++) {
						System.out.println(contador + ": " + equipoYJugadores.get(equipo).get(i).toString());
						contador++;	
					}
				}
			}

			System.out.println("----------------------------------------------------------------------------------------\n");
		}
	}
	
	public void listaJugadoresPorNombre(String rutaFichero, String delimitador) {
		try {
			ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			int contador = 1;
	
			while((registro = fichero.readLine()) != null){
				try {
					// Romper la cadena registro
					String[] campos = registro.split(delimitador);
					jugadores.add(new Jugador(Integer.parseInt(campos[0]),campos[1],Integer.parseInt(campos[2]),Integer.parseInt(campos[3])));
					
				} catch (NumberFormatException e) {
					// Ignorar líneas vacías del fichero.
				}

			}
			
			fichero.close();
			
			Collections.sort(jugadores, new Comparator<Persona>() {
				   public int compare(Persona obj1, Persona obj2) {
				      return obj1.getNombre().compareTo(obj2.getNombre());
				   }
			});
			
			for (int i = 0; i < jugadores.size(); i++) {
				System.out.println(contador + ": " + jugadores.get(i).toString());
				contador++;
			}
				
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
	}
	
	public ArrayList<Jugador> crearListaJugadores(String rutaFichero, String delimitador) {
		try {
			ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
	
			while((registro = fichero.readLine()) != null){
				try {
					// Romper la cadena registro
					String[] campos = registro.split(delimitador);
					jugadores.add(new Jugador(Integer.parseInt(campos[0]),campos[1],Integer.parseInt(campos[2]),Integer.parseInt(campos[3])));
					
				} catch (NumberFormatException e) {
					// Ignorar líneas vacías del fichero.
				}

			}
			
			fichero.close();
			return jugadores;
				
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		
		return null;
	}
}
