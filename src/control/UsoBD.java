package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Equipo;

public class UsoBD {
	
	private Connection con = null;

	public UsoBD() {
		BaseDatos conexion = new BaseDatos("localhost", "ligafutbol", "Jordan", "Jordan");
		con = conexion.getConnection();
	}
	

	public void insertarEquipo(Equipo equipo) {
	// Este método insertará todos los equipos de la liga de fútbol que se pasen por parámetro
	// La idea es insertar cada uno de los atributos de Equipo dentro de la tabla Equipo que tenemos creada en nuestra Base de Datos MySQL llamada "ligafutbol".
	// Por cada equipo que pasemos como parámetro separaremos cada uno de sus atributos y los insertando en la tabla.
		
		PreparedStatement stmt = null;
		// Crearemos un objeto de la clase PreparedStatement para poder ejecutar sentencias SQL en nuestra base de datos desde nuestro programa Java.
		
		try {
		// Incluiremos las siguientes líneas dentro de un control de excepciones para controlar que no haya 
		// ningún error al ejecutar la sentencia SQL.
			
			stmt = con.prepareStatement("insert into equipo (idEquipo, nombreCorto, nombreEquipo, Puntos, GolesFavor, GolesContra, Victoria, Empate, Derrota) values (?,?,?,?,?,?,?,?,?)");
			// El objeto "con" esta estableciendo una coneción con todos los elementos de nuestra base de datos 'ligafutbol'.
			// El método "prepareStatement" está preparando la sentencia SQL de insertar un nuevo equipo. Ahora tendremos que especificarle en
			// cada sugno de interrogación el valor que querremos darle a cada uno de estos elementos.
			// Para acceder a cada '?' tendremos que hacerlo desde su posición ordinal.
			
			stmt.setInt(1, equipo.getIdEquipo());
			// El número indica la posición del interrogante dentro del value.
			// Para establece una String en la primera posición del interrogante, tenemos que usar el método que llama a un Integer, el "setInt".
			// Pasamos por argumento primero la posición del interrogante y después el valor que queremos que tome en esa posición.
			// En este caso queremos que tome el valor de la id del equipo que está siendo pasado por parámetro en este método de insertar un equipo.
			
			stmt.setString(2, equipo.getNombreCorto());
			stmt.setString(3, equipo.getNombreEquipo());
			stmt.setInt(4, equipo.getPuntos());
			stmt.setInt(5, equipo.getGolesFavor());
			stmt.setInt(6, equipo.getGolesContra());
			stmt.setInt(7, equipo.getVictoria()); 
			stmt.setInt(8, equipo.getEmpate());
			stmt.setInt(9, equipo.getDerrota());
			
			stmt.executeUpdate();
			// Para que la sentencia se pueda ejecutar, al tratarse de una sentencia INSERT, tenemos que finalizar con el método "executeUpdate()".
			

		} catch (SQLException ex) {
		// En el caso de que se produzca algún error al ejecutar la sentencia SQL, nos aparecerá por pantalla de esta misma consola el siguiente mensaje de error.
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
		
	}
	
	public void insertarListaEquipo(ArrayList<Equipo> listaEquipo) {
			// En el caso de que se mande directamente una lista con todos los equipos, haremos todas las inserciones directamente desde un sólo método.
			
			PreparedStatement stmt = null;

			try {
				for (int i = 0; i < listaEquipo.size(); i++) {
					stmt = con.prepareStatement("insert into equipo (idEquipo, nombreCorto, nombreEquipo, Puntos, GolesFavor, GolesContra, Victoria, Empate, Derrota) values (?,?,?,?,?,?,?,?,?)");

					stmt.setInt(1, listaEquipo.get(i).getIdEquipo());		
					stmt.setString(2, listaEquipo.get(i).getNombreCorto());
					stmt.setString(3, listaEquipo.get(i).getNombreEquipo());
					stmt.setInt(4, listaEquipo.get(i).getPuntos());
					stmt.setInt(5, listaEquipo.get(i).getGolesFavor());
					stmt.setInt(6, listaEquipo.get(i).getGolesContra());
					stmt.setInt(7, listaEquipo.get(i).getVictoria()); 
					stmt.setInt(8, listaEquipo.get(i).getEmpate());
					stmt.setInt(9, listaEquipo.get(i).getDerrota());
				}
				
				stmt.executeUpdate();
				
			} catch (SQLException ex) {
				System.out.println("Error al insertar un dato en la base de datos");

			} catch (NullPointerException ex) {
				System.out.println("Fuera de rango");
			}
			
		}
	
	public void eliminarListaEquipo(ArrayList<Equipo> listaEquipo) {
		// Este método eliminará una lista completa de equipos siempre y cuando cada uno de esos equipos ya estén incluidos en la base de datos.
		// Si uno de los equipos de la lista pasado por parámetro no está en la base de datos, sin más lo ignora 
		// y pasa a intentar el siguiente equipo de la lista hasta que no queden más equipos en la lista.
		
		PreparedStatement stmt = null;
		
		try {
			for (int i = 0; i < listaEquipo.size(); i++) {
				stmt = con.prepareStatement("delete from equipo where idEquipo=?");
				
				stmt.setInt(1, listaEquipo.get(i).getIdEquipo());
			}
			
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
	}

}
