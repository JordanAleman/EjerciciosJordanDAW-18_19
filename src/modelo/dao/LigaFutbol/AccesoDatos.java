package modelo.dao.LigaFutbol;

import modelo.Equipo;
import modelo.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.BaseDatos;

public class AccesoDatos {
	private static Connection con = null;

	public AccesoDatos() {
		BaseDatos conexion = new BaseDatos("localhost", "ligafutbol", "Jordan", "Jordan");
		con = conexion.getConnection();
	}

	public ArrayList<Equipo> getAllTeams() {
		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("select * from equipo where 1;");
			rs = stmt.executeQuery();

			while (rs.next()) { // devuelve una linea de la consulta, es decir, una fila de la tabla
				Equipo equipo = new Equipo(rs.getInt("idEquipo"), rs.getString("nombreCorto"), rs.getString("nombreEquipo"), rs.getInt("Puntos"), rs.getInt("GolesFavor"), rs.getInt("GolesContra"), 
						+ rs.getInt("Victoria"), rs.getInt("Empate"), rs.getInt("Derrota"));

				listaEquipos.add(equipo);
			}

			rs.close();
			stmt.close();
			//con.close();
			
		} catch (SQLException e) {
			System.out.println("Te quedas con las ganas");
		} catch (NullPointerException e) {
			System.out.println("Va a ser que no");
		}
		
		return listaEquipos;
	}
	
	public ArrayList<Jugador> getPlayersByTeam(int idEquipo) {
		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		
		
		try {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			stmt = con.prepareStatement("select * from jugador where idEquipo like '" +  idEquipo + "'");
			rs = stmt.executeQuery();

			while (rs.next()) { // devuelve una linea de la consulta, es decir, una fila de la tabla
				Jugador jugador = new Jugador(rs.getInt("idJugador"), rs.getString("nombre"), rs.getInt("dorsal"), rs.getInt("idEquipo"));
				listaJugadores.add(jugador);
			}

			rs.close();
			stmt.close();
			//con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		return listaJugadores;
	}

	
	public static void main(String[] args) {
		ArrayList<Equipo> equipo = new AccesoDatos().getAllTeams();
		ArrayList<Jugador> jugador = new AccesoDatos().getPlayersByTeam(1);
		
		for (int i = 0; i < equipo.size(); i++) {
			System.out.println("IdEquipo: " + equipo.get(i).getIdEquipo() + " NombreCorto: [" + equipo.get(i).getNombreCorto() + "]");
		}
		
		for (int i = 0; i < jugador.size(); i++) {
			System.out.println("IdEquipo: " + jugador.get(i).getIdJugador() + " NombreCorto: [" + jugador.get(i).getNombre() + "]");
		}
	}

}
