package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

public class Equipo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEquipo;
	private String nombreCorto;
	private String nombreEquipo;
	private int Puntos;
	private int GolesFavor;
	private int GolesContra;
	private int Victoria;
	private int Empate;
	private int Derrota;
	
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

	public int getPuntos() {
		return Puntos;
	}

	public void setPuntos(int puntos) {
		Puntos = puntos;
	}

	public int getGolesFavor() {
		return GolesFavor;
	}

	public void setGolesFavor(int golesFavor) {
		GolesFavor = golesFavor;
	}

	public int getGolesContra() {
		return GolesContra;
	}

	public void setGolesContra(int golesContra) {
		GolesContra = golesContra;
	}

	public int getVictoria() {
		return Victoria;
	}

	public void setVictoria(int victoria) {
		Victoria = victoria;
	}

	public int getEmpate() {
		return Empate;
	}

	public void setEmpate(int empate) {
		Empate = empate;
	}

	public int getDerrota() {
		return Derrota;
	}

	public void setDerrota(int derrota) {
		Derrota = derrota;
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
	
//	Este método mostraba los resultados de los equipos sin orden y por tanto quedó obsoleto
//	public void muestraResultados(String rutaFichero, String delimitador) {
//		HashMap<String, Integer> clasificacionEquipos = new Equipo().clasificacionEquipos(rutaFichero, delimitador);
//		HashMap<String, ArrayList<Integer>> mapaResultadosEquipos = new Partido().resultadosEquipos(rutaFichero, delimitador);
//		HashMap<String, ArrayList<Integer>> mapaGolesEquipos = new Partido().numeroGolesMarcadosYRecibidos(rutaFichero, delimitador);
//		
//		Set<String> clavesMapa = clasificacionEquipos.keySet();
//		
//		System.out.println("El resultado de cada equipo es el siguiente:");
//		for(String clave: clavesMapa) {
//			System.out.println(clave + " [Puntos: " + clasificacionEquipos.get(clave) + "]" 
//			 		+ " - [GF:" + mapaGolesEquipos.get(clave).get(0) + ", GC:"
//			 		+ mapaGolesEquipos.get(clave).get(1) + "]"
//			 		+ " - [V:" + mapaResultadosEquipos.get(clave).get(0) + ", E:"
//					+ mapaResultadosEquipos.get(clave).get(1) + ", D:"
//					+ mapaResultadosEquipos.get(clave).get(2) + "]");
//		}
//	}

	
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
		
		ArrayList<Equipo> nombreEquipo = crearListaEquipos("ficheros/equipos.txt","#");
		
		Set<String> clavesMapa = clasificacionEquipos.keySet();

		System.out.println("El resultado de cada equipo es el siguiente:");
		for (String clave : clavesMapa) {
			for (int i = 0; i < nombreEquipo.size(); i++) {
				if (clave.compareTo(nombreEquipo.get(i).getnombreCorto()) == 0) {
					System.out.println(clave + " [Puntos: " + clasificacionEquipos.get(clave) + "]" + " - [GF:"
							+ mapaGolesEquipos.get(clave).get(0) + ", GC:" + mapaGolesEquipos.get(clave).get(1) + "]"
							+ " - [V:" + mapaResultadosEquipos.get(clave).get(0) 
							+ ", E:" + mapaResultadosEquipos.get(clave).get(1) 
							+ ", D:" + mapaResultadosEquipos.get(clave).get(2)
							+ "] Nombre completo: " + nombreEquipo.get(i).getNombreEquipo());
							
				}
			}
		}
	}

	// Obtener un ArrayList ordenado por el nombre largo de equipos a partir del fichero equipos.txt
// 	Este método se trataba de una prueba de funcionamiento, pero no es en absoluto necesario
//	public void mostrarNombresEquiposOrdenados(String rutaFichero, String delimitador) {
//		ArrayList<Equipo> listaEquipos = crearListaEquipos(rutaFichero, delimitador);
//		
//		listaEquipos.sort(new Comparator<Equipo>() {
//			   public int compare(Equipo obj1, Equipo obj2) {
//				   if(obj2.getIdEquipo()>obj1.getIdEquipo()) {
//					   return 1;
//				   } else if(obj2.getIdEquipo()<obj1.getIdEquipo()) {
//					   return -1;
//				   } else if(obj2.getIdEquipo()==obj1.getIdEquipo()) {
//					   return 0;
//				   }
//				return idEquipo;
//				   //return Integer.toString(obj2.getIdEquipo()).compareTo(Integer.toString(obj1.getIdEquipo()));
//			      
//			   }
//		});
//		
//		for(Equipo temp: listaEquipos){
//		    System.out.println(temp.getIdEquipo() + ": " + temp.getNombreEquipo());
//		}
//		System.out.println("");
//	}
	
	public HashMap<String, ArrayList<String>> clasificacionTotal(String rutaFichero, String delimitador){
		// Estos tres primeros mapas son contendrán todos los datos que querré meter en un solo mapa
		HashMap<String, Integer> clasificacionEquipos = new Equipo().clasificacionEquipos(rutaFichero, delimitador);
		HashMap<String, ArrayList<Integer>> mapaResultadosEquipos = new Partido().resultadosEquipos(rutaFichero, delimitador);
		HashMap<String, ArrayList<Integer>> mapaGolesEquipos = new Partido().numeroGolesMarcadosYRecibidos(rutaFichero, delimitador);
		
		// Esta lista la creo porque ningún mapa tiene como dato el nombre completo de los equipos 
		// y es otro dato que querré meter en el mapa definitivo
		ArrayList<Equipo> nombreEquipo = crearListaEquipos("ficheros/equipos.txt","#");
		
		// En este mapa meteré todos los datos
		HashMap<String, ArrayList<String>> clasificacionTotal = new HashMap<String, ArrayList<String>>();
		
		Set<String> clavesMapa = clasificacionEquipos.keySet();

		for (String clave : clavesMapa) {
			for (int i = 0; i < nombreEquipo.size(); i++) {
				if (clave.compareTo(nombreEquipo.get(i).getnombreCorto()) == 0) {
					clasificacionTotal.put(clave, new ArrayList<String>(Arrays.asList(
							nombreEquipo.get(i).getNombreEquipo()
							,Integer.toString(clasificacionEquipos.get(clave))
							,Integer.toString(mapaGolesEquipos.get(clave).get(0))
							,Integer.toString(mapaGolesEquipos.get(clave).get(1))
							,Integer.toString(mapaResultadosEquipos.get(clave).get(0))
							,Integer.toString(mapaResultadosEquipos.get(clave).get(1)) 
							,Integer.toString(mapaResultadosEquipos.get(clave).get(2))
							)));
				}
					
			}
		}
		
		// Una vez creado el mapa vamos a ordenarlo por por su clasificación
		List<Entry<String, ArrayList<String>>> listaOrdenada = new LinkedList<>(clasificacionTotal.entrySet());

		listaOrdenada.sort(new Comparator<Entry<String, ArrayList<String>>>() {
			public int compare(Entry<String, ArrayList<String>> equipo1, Entry<String, ArrayList<String>> equipo2) {
				// Ordenaremos por el número de puntos. En caso de empate por la diferencia de goles.
				// Y si están empate y con la misma diferencia de goles, por quien haya marcado más goles.
				int diferenciaO1 = Integer.parseInt(equipo1.getValue().get(2))-Integer.parseInt(equipo1.getValue().get(3)); // Diferencia de goles del primer equipo a comparar.
				int diferenciaO2 = Integer.parseInt(equipo2.getValue().get(2))-Integer.parseInt(equipo2.getValue().get(3)); // Diferencia de goles del siguiente equipo a comparar.
				
				if(equipo2.getValue().get(1).compareTo(equipo1.getValue().get(1)) == 0) { // En el caso de que la comparación de dos equipos sean empate en puntos, entramos por aquí.
					
					if ((diferenciaO2 == diferenciaO1)) {  // Si están empatados a puntos y tienen la misma diferencia de goles, se ordenada por quien haya marcado más goles.
						return equipo2.getValue().get(2).compareTo(equipo1.getValue().get(2));
						
					} else if(diferenciaO2 > diferenciaO1) { 
						return "1".compareTo("0"); // Esta instrucción indicará que el el equipo2 estará por encima en la ordenación.
					} else {
						return "0".compareTo("1");
					}
					
				} else { // En el caso de que no estén empatados, ordenar por puntos de clasificación.
					return equipo2.getValue().get(1).compareTo(equipo1.getValue().get(1));
				}

			}
		});
		
		clasificacionTotal = new LinkedHashMap<String, ArrayList<String>>();
		for (Iterator<Entry<String, ArrayList<String>>> it = listaOrdenada.iterator(); it.hasNext();) {
			Map.Entry<String, ArrayList<String>> entry = (Map.Entry<String, ArrayList<String>>) it.next();
			clasificacionTotal.put(entry.getKey(), entry.getValue());
		}
				
		return clasificacionTotal;
	}
	
	// Este siguiente método guarda en uuna lista los datos de la clasificación total que está en un mapa
	public static ArrayList<String[]> obtenerListaClasificacionTotal(HashMap<String, ArrayList<String>> mapaOrdenado, ArrayList<String[]> camposMapa) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("ficheros/equipos.txt"));
			String registro;

			while ((registro = fichero.readLine()) != null) {
				// Romper la cadena registro
				String[] campos = registro.split("#");

				if (mapaOrdenado.size() > 0) {
					String clave = (String) mapaOrdenado.keySet().toArray()[0];
					if (campos[1].compareTo(clave) == 0) {
						// Incluir cada elemento del array como elementos del ArrayList de Equipo
						String[] nuevo = {mapaOrdenado.get(clave).get(0),mapaOrdenado.get(clave).get(1),mapaOrdenado.get(clave).get(2)
								,mapaOrdenado.get(clave).get(3),mapaOrdenado.get(clave).get(4),mapaOrdenado.get(clave).get(5),mapaOrdenado.get(clave).get(6)};
						camposMapa.add(nuevo);
						mapaOrdenado.remove(mapaOrdenado.keySet().toArray()[0]);
						obtenerListaClasificacionTotal(mapaOrdenado, camposMapa);
					}

				}
			}

			fichero.close();
			return camposMapa;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		return null;
	}
	
	public Equipo crearEquipo(String nombreCorto) {
		HashMap<String, ArrayList<String>> clasificacionEquipos = new Equipo().clasificacionTotal("ficheros/partidos.txt", "#");
		
		// Este mapa, "mapaEquipos" contiene las id de los equipos, ya que el que acabo de crear de "clasificacionEquipos" no tiene este dato.
		HashMap<String,Equipo> mapaEquipos = crearMapaEquipos("ficheros/equipos.txt", "#"); 
		
		Equipo equipo = new Equipo();
		
		Set<String> clavesMapa = clasificacionEquipos.keySet();
		
		for (String clave : clavesMapa) {
			if(clave.compareTo(nombreCorto)==0) {
				equipo.setIdEquipo(mapaEquipos.get(clave).getIdEquipo());
				equipo.setnombreCorto(clave);
				equipo.setNombreEquipo(clasificacionEquipos.get(clave).get(0));
				equipo.setPuntos(Integer.parseInt(clasificacionEquipos.get(clave).get(1)));
				equipo.setGolesFavor(Integer.parseInt(clasificacionEquipos.get(clave).get(2)));
				equipo.setGolesContra(Integer.parseInt(clasificacionEquipos.get(clave).get(3)));
				equipo.setVictoria(Integer.parseInt(clasificacionEquipos.get(clave).get(4)));
				equipo.setEmpate(Integer.parseInt(clasificacionEquipos.get(clave).get(5)));
				equipo.setDerrota(Integer.parseInt(clasificacionEquipos.get(clave).get(6)));
				
				return equipo;
			}
		}
		System.out.println("No existe ningún equipo con ese nombre corto");
		return null;
	}
	
//  Estos dos métodos que han quedado comentado existían antes de crear un método para crear directamente un equipo.
//	Así, a través de estos métodos, podía modificar el método toString de Equipo usando un mapa con los datos que
//	necesitaba en aquel momento.
//	public String toString(String rutaFichero, String delimitador, String nombreCorto) {
//		HashMap<String, Integer> clasificacionEquipos = new Equipo().clasificacionEquipos(rutaFichero, delimitador);
//		//clasificacionEquipos = clasificacionOrdenada(clasificacionEquipos);
//		HashMap<String, ArrayList<Integer>> mapaResultadosEquipos = new Partido().resultadosEquipos(rutaFichero, delimitador);
//		HashMap<String, ArrayList<Integer>> mapaGolesEquipos = new Partido().numeroGolesMarcadosYRecibidos(rutaFichero, delimitador);
//
//		return	nombreEquipo + " [Puntos: " + clasificacionEquipos.get(nombreCorto) + "]" 
//			 		+ " - [GF:" + mapaGolesEquipos.get(nombreCorto).get(0) + ", GC:"
//			 		+ mapaGolesEquipos.get(nombreCorto).get(1) + "]"
//			 		+ " - [V:" + mapaResultadosEquipos.get(nombreCorto).get(0) + ", E:"
//					+ mapaResultadosEquipos.get(nombreCorto).get(1) + ", D:"
//					+ mapaResultadosEquipos.get(nombreCorto).get(2) + "]";
//	}
//	
//	public String toString() {
//		return toString("ficheros/partidos.txt","#", this.getnombreCorto());
//	}
	
	public String toString() {
		return "Id: " + getIdEquipo() + " - " + getnombreCorto()
		+ " [Puntos: " + getPuntos() + "] [GF: " + getGolesFavor() + ", GC: " + getGolesContra()
		+ "] [V: " + getVictoria() + ", E: " + getEmpate() + ", D: " + getDerrota() + "]" + " Nombre largo: " + getNombreEquipo();
	}

	public ArrayList<Equipo> crearListaEquiposConDatos(String rutaFichero, String delimitador){
		try {
			ArrayList<Equipo> equipos = new ArrayList<Equipo>();	
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				// Incluir cada elemento del array como elementos del ArrayList de Equip
				equipos.add(new Equipo().crearEquipo(campos[1]));			
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
} 
