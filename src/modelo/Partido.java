package modelo;

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

}
