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
		BaseDatos conexion = new BaseDatos("localhost", "ligafutbol", "Jordan", "Jordan");
		con = conexion.getConnection();
		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("select * from equipo;");
			rs = stmt.executeQuery();

			while (rs.next()) { // devuelve una linea de la consulta, es decir, una fila de la tabla
				Equipo equipo = new Equipo(rs.getInt("idEquipo"), rs.getString("nombreCorto"), rs.getString("nombreEquipo"));

				listaEquipos.add(equipo);
			}

			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Te quedas con las ganas");
		} catch (NullPointerException e) {
			System.out.println("Va a ser que no");
		}
		
		return listaEquipos;
	}
	
	public ArrayList<Jugador> getPlayersByTeam(int idEquipo) {
		// Volvemos a realizar la conexión hacia la base de datos aunque la tuviéramos como constructor porque querremos que la conexión a este método sea 
		// constante para poder así usar para nuestro JavaFX en nuestro ComboController y ComboExecute
		BaseDatos conexion = new BaseDatos("localhost", "ligafutbol", "Jordan", "Jordan");
		con = conexion.getConnection();
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
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		return listaJugadores;
	}
	
	public ArrayList<Equipo> getScore() {
		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("select * from clasificacion order by Puntos desc;");
			rs = stmt.executeQuery();

			while (rs.next()) { // devuelve una linea de la consulta, es decir, una fila de la tabla
				Equipo equipo = new Equipo(rs.getInt("idEquipo"), rs.getString("nombreCorto"), rs.getString("nombreEquipo"), rs.getInt("Puntos"), rs.getInt("GolesFavor"), rs.getInt("GolesContra"), 
						+ rs.getInt("Victoria"), rs.getInt("Empate"), rs.getInt("Derrota"));

				listaEquipos.add(equipo);
			}

			rs.close();
			stmt.close();
//			con.close();
			
		} catch (SQLException e) {
			System.out.println("Te quedas con las ganas");
		} catch (NullPointerException e) {
			System.out.println("Va a ser que no");
		}
		
		return listaEquipos;
	}

	
	public static void main(String[] args) {
		ArrayList<Equipo> equipo = new AccesoDatos().getAllTeams();
		ArrayList<Jugador> jugador = new AccesoDatos().getPlayersByTeam(1);
		ArrayList<Equipo> clasificacion = new AccesoDatos().getScore();

		
		for (int i = 0; i < equipo.size(); i++) {
			System.out.println("IdEquipo: " + equipo.get(i).getIdEquipo() + " NombreCorto: [" + equipo.get(i).getNombreCorto() + "]");
		}
		
		for (int i = 0; i < jugador.size(); i++) {
			System.out.println("IdEquipo: " + jugador.get(i).getIdJugador() + " NombreCorto: [" + jugador.get(i).getNombre() + "]");
		}
		
		for (int i = 0; i < clasificacion.size(); i++) {
			System.out.println("Nombre: [" + clasificacion.get(i).getNombreCorto() + "] Puntos: [" + clasificacion.get(i).getPuntos() 
					+ "] GF: [" + clasificacion.get(i).getGolesFavor() + "] GC: [" + clasificacion.get(i).getGolesContra()
					+ "] Victoria: [" + clasificacion.get(i).getVictoria() + "] Empate: [" + clasificacion.get(i).getEmpate() + "] Derrota: [" + clasificacion.get(i).getDerrota() + "]");
		}
		
	}

}
