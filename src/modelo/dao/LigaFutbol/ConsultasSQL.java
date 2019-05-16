package modelo.dao.LigaFutbol;

import modelo.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.BaseDatos;

public class ConsultasSQL {
	private static Connection con = null;

	public ConsultasSQL() {
		BaseDatos conexion = new BaseDatos("localhost", "ligafutbol", "Jordan", "Jordan");
		con = conexion.getConnection();
	}
	
	public static ArrayList<Equipo> getAllTeams() {
		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("select * from equipo;");
			rs = stmt.executeQuery();

			while (rs.next()) { // devuelve una linea de la consulta, es decir, una fila de la tabla
				Equipo equipo = new Equipo(rs.getInt("idEquipo"), rs.getString("nombreCorto"), rs.getString("nombreEquipo"), rs.getInt("Puntos"), rs.getInt("GolesFavor"), rs.getInt("GolesContra"), 
						+ rs.getInt("Victoria"), rs.getInt("Empate"), rs.getInt("Derrota"));

				listaEquipos.add(equipo);
			}

			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		return listaEquipos;
	}
	

}
