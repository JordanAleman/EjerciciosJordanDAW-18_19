package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Equipo implements Comparable<Equipo>{
	private int idEquipo;
	private String nombreCorto;
	private String nombreEquipo;
	
	public Equipo() {
		
	}

	public Equipo(int idEquipo, String nombreCorto, String nombreEquipo) {
		super();
		this.idEquipo = idEquipo;
		this.nombreCorto = nombreCorto;
		this.nombreEquipo = nombreEquipo;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getnombreCorto() {
		return nombreCorto;
	}

	public void setnombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	// 23 de Enero del 2019 -- Actividad: Obtener un ArrayList de todos los equipos a través de un fichero
	public ArrayList<Equipo> crearListaEquipos(String rutaFichero, String delimitador){
		try {
			ArrayList<Equipo> equipos = new ArrayList<Equipo>();	
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				// Incluir cada elemento del array como elementos del ArrayList de Equip
				equipos.add(new Equipo(Integer.parseInt(campos[0]), campos[1], campos[2]));			
			}

			fichero.close();
			return equipos;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		return null;
	}
	
	public HashMap<String,Equipo> crearMapaEquipos(String rutaFichero, String delimitador){
		try {
			HashMap<String,Equipo> mapaEquipos = new HashMap<String, Equipo>();
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				mapaEquipos.put(campos[1], new Equipo(Integer.parseInt(campos[0]), campos[1], campos[2]));
				
			}

			fichero.close();

			return mapaEquipos;
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		return null;
	}
	
	public HashMap<String, Integer> clasificacionEquipos(String rutaFichero, String delimitador){
		HashMap<String, ArrayList<Integer>> resultadosEquipos = new Partido().resultadosEquipos(rutaFichero, delimitador);
		HashMap<String, Integer> clasificacionEquipos = new HashMap<String, Integer>();
		
		//Set<String> clavesMapa = resultadosEquipos.keySet();
		
		for(String clave: resultadosEquipos.keySet()) {
			clasificacionEquipos.put(clave, (resultadosEquipos.get(clave).get(0)*3)+resultadosEquipos.get(clave).get(1));
		}
		
		return clasificacionEquipos;
	}
	
	public void muestraResultados(String rutaFichero, String delimitador) {
		HashMap<String, Integer> clasificacionEquipos = new Equipo().clasificacionEquipos(rutaFichero, delimitador);
		HashMap<String, ArrayList<Integer>> mapaResultadosEquipos = new Partido().resultadosEquipos(rutaFichero, delimitador);
		HashMap<String, ArrayList<Integer>> mapaGolesEquipos = new Partido().numeroGolesMarcadosYRecibidos(rutaFichero, delimitador);
		
		Set<String> clavesMapa = clasificacionEquipos.keySet();
		
		System.out.println("El resultado de cada equipo es el siguiente:");
		for(String clave: clavesMapa) {
			System.out.println(clave + " [Puntos: " + clasificacionEquipos.get(clave) + "]" 
			 		+ " - [GF:" + mapaGolesEquipos.get(clave).get(0) + ", GC:"
			 		+ mapaGolesEquipos.get(clave).get(1) + "]"
			 		+ " - [V:" + mapaResultadosEquipos.get(clave).get(0) + ", E:"
					+ mapaResultadosEquipos.get(clave).get(1) + ", D:"
					+ mapaResultadosEquipos.get(clave).get(2) + "]");
		}
	}

	
	public static HashMap<String, Integer> clasificacionOrdenada(HashMap<String, Integer> map) {
		List<Entry<String, Integer>> listaOrdenada = new LinkedList<>(map.entrySet());
		// Defined Custom Comparator here
		listaOrdenada.sort(new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		HashMap<String, Integer> mapaOrdenado = new LinkedHashMap<String, Integer>();
		for (Iterator<Entry<String, Integer>> it = listaOrdenada.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
			mapaOrdenado.put(entry.getKey(), entry.getValue());
		}
		return mapaOrdenado;
	}
	
	
	public void muestraResultadosOrdenados(String rutaFichero, String delimitador) {
		HashMap<String, Integer> clasificacionEquipos = new Equipo().clasificacionEquipos(rutaFichero, delimitador);
		clasificacionEquipos = clasificacionOrdenada(clasificacionEquipos);
		HashMap<String, ArrayList<Integer>> mapaResultadosEquipos = new Partido().resultadosEquipos(rutaFichero, delimitador);
		HashMap<String, ArrayList<Integer>> mapaGolesEquipos = new Partido().numeroGolesMarcadosYRecibidos(rutaFichero, delimitador);
		
		Set<String> clavesMapa = clasificacionEquipos.keySet();
		
		System.out.println("El resultado de cada equipo es el siguiente:");
		for(String clave: clavesMapa) {
			System.out.println(clave + " [Puntos: " + clasificacionEquipos.get(clave) + "]" 
			 		+ " - [GF:" + mapaGolesEquipos.get(clave).get(0) + ", GC:"
			 		+ mapaGolesEquipos.get(clave).get(1) + "]"
			 		+ " - [V:" + mapaResultadosEquipos.get(clave).get(0) + ", E:"
					+ mapaResultadosEquipos.get(clave).get(1) + ", D:"
					+ mapaResultadosEquipos.get(clave).get(2) + "]");
		}
	}
	
	public String toString(String rutaFichero, String delimitador, String nombreCorto) {
		HashMap<String, Integer> clasificacionEquipos = new Equipo().clasificacionEquipos(rutaFichero, delimitador);
		//clasificacionEquipos = clasificacionOrdenada(clasificacionEquipos);
		HashMap<String, ArrayList<Integer>> mapaResultadosEquipos = new Partido().resultadosEquipos(rutaFichero, delimitador);
		HashMap<String, ArrayList<Integer>> mapaGolesEquipos = new Partido().numeroGolesMarcadosYRecibidos(rutaFichero, delimitador);

		return	nombreCorto + " [Puntos: " + clasificacionEquipos.get(nombreCorto) + "]" 
			 		+ " - [GF:" + mapaGolesEquipos.get(nombreCorto).get(0) + ", GC:"
			 		+ mapaGolesEquipos.get(nombreCorto).get(1) + "]"
			 		+ " - [V:" + mapaResultadosEquipos.get(nombreCorto).get(0) + ", E:"
					+ mapaResultadosEquipos.get(nombreCorto).get(1) + ", D:"
					+ mapaResultadosEquipos.get(nombreCorto).get(2) + "]";
	}
	
	public String toString() {
		return toString("ficheros/partidos.txt","#", this.getnombreCorto());
	}
	
	// Obtener un ArrayList ordenado por el nombre largo de equipos a partir del fichero equipos.txt
	public void mostrarNombresEquiposOrdenados(String rutaFichero, String delimitador) {
		ArrayList<Equipo> listaEquipos = crearListaEquipos(rutaFichero, delimitador);
		
		listaEquipos.sort(new Comparator<Equipo>() {
			   public int compare(Equipo obj1, Equipo obj2) {
				   if(obj2.getIdEquipo()>obj1.getIdEquipo()) {
					   return 1;
				   } else if(obj2.getIdEquipo()<obj1.getIdEquipo()) {
					   return -1;
				   } else if(obj2.getIdEquipo()==obj1.getIdEquipo()) {
					   return 0;
				   }
				return idEquipo;
				   //return Integer.toString(obj2.getIdEquipo()).compareTo(Integer.toString(obj1.getIdEquipo()));
			      
			   }
		});
		
		for(Equipo temp: listaEquipos){
		    System.out.println(temp.getIdEquipo() + ": " + temp.getNombreEquipo());
		}
		System.out.println("");
	}

	@Override
	public int compareTo(Equipo arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
