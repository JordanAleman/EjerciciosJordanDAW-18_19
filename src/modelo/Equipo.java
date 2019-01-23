package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Equipo {
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
}
