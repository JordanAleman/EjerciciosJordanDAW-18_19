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
	// Este m�todo insertar� todos los equipos de la liga de f�tbol que se pasen por par�metro
	// La idea es insertar cada uno de los atributos de Equipo dentro de la tabla Equipo que tenemos creada en nuestra Base de Datos MySQL llamada "ligafutbol".
	// Por cada equipo que pasemos como par�metro separaremos cada uno de sus atributos y los insertando en la tabla.
		
		PreparedStatement stmt = null;
		// Crearemos un objeto de la clase PreparedStatement para poder ejecutar sentencias SQL en nuestra base de datos desde nuestro programa Java.
		
		try {
		// Incluiremos las siguientes l�neas dentro de un control de excepciones para controlar que no haya 
		// ning�n error al ejecutar la sentencia SQL.
			
			stmt = con.prepareStatement("insert into equipo (idEquipo, nombreCorto, nombreEquipo, Puntos, GolesFavor, GolesContra, Victoria, Empate, Derrota) values (?,?,?,?,?,?,?,?,?)");
			// El objeto "con" esta estableciendo una coneci�n con todos los elementos de nuestra base de datos 'ligafutbol'.
			// El m�todo "prepareStatement" est� preparando la sentencia SQL de insertar un nuevo equipo. Ahora tendremos que especificarle en
			// cada sugno de interrogaci�n el valor que querremos darle a cada uno de estos elementos.
			// Para acceder a cada '?' tendremos que hacerlo desde su posici�n ordinal.
			
			stmt.setInt(1, equipo.getIdEquipo());
			// El n�mero indica la posici�n del interrogante dentro del value.
			// Para establece una String en la primera posici�n del interrogante, tenemos que usar el m�todo que llama a un Integer, el "setInt".
			// Pasamos por argumento primero la posici�n del interrogante y despu�s el valor que queremos que tome en esa posici�n.
			// En este caso queremos que tome el valor de la id del equipo que est� siendo pasado por par�metro en este m�todo de insertar un equipo.
			
			stmt.setString(2, equipo.getNombreCorto());
			stmt.setString(3, equipo.getNombreEquipo());
			stmt.setInt(4, equipo.getPuntos());
			stmt.setInt(5, equipo.getGolesFavor());
			stmt.setInt(6, equipo.getGolesContra());
			stmt.setInt(7, equipo.getVictoria()); 
			stmt.setInt(8, equipo.getEmpate());
			stmt.setInt(9, equipo.getDerrota());
			
			stmt.executeUpdate();
			// Para que la sentencia se pueda ejecutar, al tratarse de una sentencia INSERT, tenemos que finalizar con el m�todo "executeUpdate()".
			

		} catch (SQLException ex) {
		// En el caso de que se produzca alg�n error al ejecutar la sentencia SQL, nos aparecer� por pantalla de esta misma consola el siguiente mensaje de error.
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
		
	}
	
	public void insertarListaEquipo(ArrayList<Equipo> listaEquipo) {
			// En el caso de que se mande directamente una lista con todos los equipos, haremos todas las inserciones directamente desde un s�lo m�todo.
			
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
		// Este m�todo eliminar� una lista completa de equipos siempre y cuando cada uno de esos equipos ya est�n incluidos en la base de datos.
		// Si uno de los equipos de la lista pasado por par�metro no est� en la base de datos, sin m�s lo ignora 
		// y pasa a intentar el siguiente equipo de la lista hasta que no queden m�s equipos en la lista.
		
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
