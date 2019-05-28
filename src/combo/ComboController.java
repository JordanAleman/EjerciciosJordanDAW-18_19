package combo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import modelo.Equipo;
import modelo.Jugador;
import modelo.dao.LigaFutbol.AccesoDatos;

public class ComboController {
	AccesoDatos acc = new AccesoDatos();
	
	@FXML
	private ComboBox<Equipo> teamCombo;
	@FXML
	private ListView<Jugador> lista;
	

	public void cargaEquipos() {
		teamCombo.getItems().clear();
		// miCombo.getItems().addAll(Ejercicios.crearListaEquipos("ficheros/equipos.txt"));
		teamCombo.getItems().addAll(acc.getAllTeams());

	}
	
	public void muestraEquipo() {
		System.out.println("Ha seleccionado un equipo...");
		System.out.println(teamCombo.getValue().getIdEquipo());
	}
	
	
	public void cargaJugadoresEquipo() {
		lista.getItems().clear();
		lista.getItems().addAll(acc.getPlayersByTeam(teamCombo.getValue().getIdEquipo()));
	}
}
