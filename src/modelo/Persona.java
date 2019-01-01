package modelo;

import java.time.LocalDate;

public class Persona {
	
	private String nif;
	private String nombre;
	private int longitudPaso;
	private LocalDate fecha_nac; // Clase "LocalDate" manejar fechas
	private char sexo; // 'M' 'F'
	private Persona[] hijosBiologicos;  // 2.- En la clase "Persona" declara un array de "Persona" que representa los hijos biológicos que tiene    28/11/2018
	private Persona padre;
	private Persona madre;

	public Persona() {
		this.nif = "12345678F";
		this.nombre="Anónimo";
		this.fecha_nac=LocalDate.now();
		this.longitudPaso=33;
		
	}

	public Persona(String nif, String nombre, int longitudPaso, LocalDate fecha_nac , char sexo , Persona[] hijosBiologicos ) {
		this.nif = nif;
		this.nombre = nombre;
		this.longitudPaso = longitudPaso;
		this.fecha_nac = null;
		this.sexo = sexo;
		this.hijosBiologicos = hijosBiologicos;

	}
	 
	 public int caminar (int numPasos) {	 
		 return numPasos * longitudPaso / 100; 
	 }

	public String getNif() {return nif;}

	public void setNif(String nif) {this.nif = nif;}
	

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	

	public int getLongitudPaso() {return longitudPaso;}

	public void setLongitudPaso(int longitudPaso) {this.longitudPaso = longitudPaso;}
	

	public LocalDate getFecha_nac() {return fecha_nac;}

	public void setFecha_nac(LocalDate fecha_nac) {this.fecha_nac = fecha_nac;}
	
	
	public char getSexo() {return sexo;}

	public void setSexo(char sexo) {this.sexo = sexo;}
	

	public Persona[] getHijosBiologicos() {return hijosBiologicos;}

	public void setHijosBiologicos(Persona[] hijosBiologicos) {this.hijosBiologicos = hijosBiologicos;}
	

	public Persona getPadre() {return padre;}

	public void setPadre(Persona padre) {this.padre = padre;}
	

	public Persona getMadre() {return madre;}

	public void setMadre(Persona madre) {this.madre = madre;}

	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", longitudPaso=" + longitudPaso + ", fecha_nac="
				+ fecha_nac + ", sexo=" + sexo + "]";
	}
	
	
	
}