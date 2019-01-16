package modelo;

public class Equipo {
	private int idEquipo;
	private String codigoAlfabeticoEquipo;
	private String nombreEquipo;
	
	public Equipo() {
		
	}

	public Equipo(int idEquipo, String codigoAlfabeticoEquipo, String nombreEquipo) {
		super();
		this.idEquipo = idEquipo;
		this.codigoAlfabeticoEquipo = codigoAlfabeticoEquipo;
		this.nombreEquipo = nombreEquipo;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getCodigoAlfabeticoEquipo() {
		return codigoAlfabeticoEquipo;
	}

	public void setCodigoAlfabeticoEquipo(String codigoAlfabeticoEquipo) {
		this.codigoAlfabeticoEquipo = codigoAlfabeticoEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

}
