package combo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import modelo.Equipo;
import modelo.dao.LigaFutbol.ConsultasSQL;

public class ComboController {
	
	@FXML
	private ComboBox<Equipo> teamCombo;
//	@FXML
//	private ListView<Jugador> lv_jugadores;

	public void cargaEquipos() {
		teamCombo.getItems().clear();
		// miCombo.getItems().addAll(Ejercicios.crearListaEquipos("ficheros/equipos.txt"));
		teamCombo.getItems().addAll(ConsultasSQL.getAllTeams());

	}
	
	public void muestraEquipo() {
		System.out.println("Ha seleccionado un equipo...");
		System.out.println(teamCombo.getValue().getIdEquipo());
	}
}
