package modelo.dao.LigaFutbol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import control.BaseDatos;
import modelo.Equipo;
import modelo.Jugador;

public class TablasLigaFutbol {
	
	private Connection con = null;

	public TablasLigaFutbol() {
		BaseDatos conexion = new BaseDatos("localhost", "ligafutbol", "Jordan", "Jordan");
		con = conexion.getConnection();
	}
	
	
// --------------------------------------------------- Tabla Equipo ---------------------------------------------------------------------------------------------------------------

	
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
			con.close();
			
			System.out.println("El elemento de la tabla 'Equipo' ha sido insertado correctamente");

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
//					stmt = con.prepareStatement("insert into equipo (idEquipo, nombreCorto, nombreEquipo, Puntos, GolesFavor, GolesContra, Victoria, Empate, Derrota) values (?,?,?,?,?,?,?,?,?)");

					stmt = con.prepareStatement("insert into equipo (idEquipo, nombreCorto, nombreEquipo) values (?,?,?)");
					
					stmt.setInt(1, listaEquipo.get(i).getIdEquipo());		
					stmt.setString(2, listaEquipo.get(i).getNombreCorto());
					stmt.setString(3, listaEquipo.get(i).getNombreEquipo());
//					stmt.setInt(4, listaEquipo.get(i).getPuntos());
//					stmt.setInt(5, listaEquipo.get(i).getGolesFavor());
//					stmt.setInt(6, listaEquipo.get(i).getGolesContra());
//					stmt.setInt(7, listaEquipo.get(i).getVictoria()); 
//					stmt.setInt(8, listaEquipo.get(i).getEmpate());
//					stmt.setInt(9, listaEquipo.get(i).getDerrota());
					stmt.executeUpdate();
					
					System.out.println("Insertado: IdEquipo [" + listaEquipo.get(i).getIdEquipo() + "] NombreCorto [" + listaEquipo.get(i).getNombreCorto() + "]");
				}
				
				con.close();
				System.out.println("Todos los elementos de la tabla 'Equipo' han sido insertados correctamente");

				
			} catch (SQLException ex) {
				System.out.println("Error al insertar un dato en la tabla 'Equipo' de la base de datos");

			} catch (NullPointerException ex) {
				System.out.println("Fuera de rango");
			}
			
		}
	
	public void insertarEquipoDatosBasicosDesdeFichero() {
		PreparedStatement stmt = null;
		
		try {	
			BufferedReader fichero = new BufferedReader(new FileReader("ficheros/equipos.txt"));
			String registro;
			
			try {
				while((registro = fichero.readLine()) != null){
					// Romper la cadena registro
					String[] campos = registro.split("#");
					
					stmt = con.prepareStatement("insert into equipodb (idEquipo, nombreCorto, nombreEquipo) values (?,?,?)");

					stmt.setInt(1, Integer.parseInt(campos[0]));		
					stmt.setString(2, campos[1]);
					stmt.setString(3, campos[2]);
					stmt.executeUpdate();
		
				}
				
				con.close();
				
			} catch (SQLException ex) {
				System.out.println("Error al insertar un dato en la base de datos");

			} catch (NullPointerException ex) {
				System.out.println("Fuera de rango");
			}	

			fichero.close();

			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
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
				stmt.executeUpdate();
			}
			
			con.close();
			
		} catch (SQLException ex) {
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
	}
	
	public void eliminarEquipoDB() {
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("delete from equipodb");
			stmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
	}

	
// --------------------------------------------------- Tabla Jugador ---------------------------------------------------------------------------------------------------------------
	
	
	public void insertarListaJugadores(ArrayList<Jugador> listaJugador) {
		PreparedStatement stmt = null;
		int contador = 0;

		try {
			for (int i = 0; i < listaJugador.size(); i++) {
				stmt = con.prepareStatement("insert into jugador (idJugador, nombre, dorsal, idEquipo) values (?,?,?,?)");

				stmt.setInt(1, listaJugador.get(i).getIdJugador());		
				stmt.setString(2, listaJugador.get(i).getNombre());
				stmt.setInt(3, listaJugador.get(i).getDorsal());
				stmt.setInt(4, listaJugador.get(i).getIdEquipo());
				stmt.executeUpdate();
				contador++;
				
				if (contador % 100 == 0) {
					System.out.println("Insertando...");
				}
			}
			
			con.close();
			System.out.println("Todos los elementos de jugadores han sido insertado correctamente");
			
		} catch (SQLException ex) {
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}	
			
	}
	
	public void insertarJugadoresPorFichero(String rutaFichero, String delimitador) {
		try {
			// Al usar "InputStreamReader" también tenemos la opción de leer un fichero igual que "FileReader". Lo bueno de este que usamos ahora
			// es que podemos pasar por parámetro por medio de "FileInputStream" una ruta de fichero y su codificación.
			// Al ponerle codificación "utf-8" se puede conseguir leer tildes y 'ñ', entre otros caracteres.
			BufferedReader fichero = new BufferedReader(new InputStreamReader(new FileInputStream(rutaFichero), "utf-8"));
			String registro;
			PreparedStatement stmt = null;
			int contador = 0;
			
			try {
				while((registro = fichero.readLine()) != null){
					// Romper la cadena registro
					String[] campos = registro.split(delimitador);
					
					stmt = con.prepareStatement("insert into jugador (idJugador, nombre, dorsal, idEquipo) values (?,?,?,?)");

					stmt.setInt(1, Integer.parseInt(campos[0]));		
					stmt.setString(2, campos[1]);
					stmt.setInt(3, Integer.parseInt(campos[2]));
					stmt.setInt(4, Integer.parseInt(campos[3]));
					stmt.executeUpdate();
					contador++;
					
					if (contador % 100 == 0) {
						System.out.println("Insertando...");
					}
						
					
				}
				con.close();
				
			} catch (SQLException ex) {
				// En el caso de que se produzca algún error al ejecutar la sentencia SQL, nos aparecerá por pantalla de esta misma consola el siguiente mensaje de error.
				System.out.println("Error al insertar un dato en la base de datos");

			} catch (NullPointerException ex) {
				System.out.println("Fuera de rango");
			}

			fichero.close();		
			System.out.println("Tododos los elementos de jugadores han sido insertados correctamente");
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}	
			
	}
	
	
	public void eliminarListaJugadores(ArrayList<Jugador> listaJugadores) {
		
		PreparedStatement stmt = null;
		
		try {
			for (int i = 0; i < listaJugadores.size(); i++) {
				stmt = con.prepareStatement("delete from jugador where idJugador=?");
				
				stmt.setInt(1, listaJugadores.get(i).getIdJugador());
				stmt.executeUpdate();
			}
			
			con.close();
			
		} catch (SQLException ex) {
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
	}
	
	public void eliminarJugadores() {
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("delete from jugador");
			stmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
	}
	
	
// --------------------------------------------------- Tabla Partido ---------------------------------------------------------------------------------------------------------------
	
	
	public void insertarPartidos(String rutaFichero, String delimitador) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			PreparedStatement stmt = null;
			
			try {
				while((registro = fichero.readLine()) != null){
					// Romper la cadena registro
					String[] campos = registro.split(delimitador);
					
						stmt = con.prepareStatement("insert into partido (idPartido, numJornada, equipoLocal, golesLocal, equipoVisitante, golesVisitante) values (?,?,?,?,?,?)");
						stmt.setInt(1, Integer.parseInt(campos[0]));
						stmt.setInt(2, Integer.parseInt(campos[1]));
						stmt.setString(3, campos[2]);
						stmt.setString(5, campos[4]);
						
						// El siguiente if controlará si los partidos han jugado sus partidos o no. En el caso de que lo hayan jugado insertaremos sus datos tal y como están.
						// En el caso de que no se haya jugado, los datos de sus goles los dejaremos a null.
						if (!campos[3].equals("")) { 
							stmt.setInt(4, Integer.parseInt(campos[3]));
							stmt.setInt(6, Integer.parseInt(campos[5]));
						} else {
							stmt.setString(4, null);
							stmt.setString(6, null);
						}
						
						
						stmt.executeUpdate();
						// Para que la sentencia se pueda ejecutar, al tratarse de una sentencia INSERT, tenemos que finalizar con el método "executeUpdate()".
							
					
				}
				con.close();
				
			} catch (SQLException ex) {
				// En el caso de que se produzca algún error al ejecutar la sentencia SQL, nos aparecerá por pantalla de esta misma consola el siguiente mensaje de error.
				System.out.println("Error al insertar un dato en la base de datos");

			} catch (NullPointerException ex) {
				System.out.println("Fuera de rango");
			}

			fichero.close();		
			System.out.println("Tododos los elementos de partidos han sido insertados correctamente");
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		
	}
	
	public void eliminarPartido() {
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("delete from partido");
			stmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			System.out.println("Error al insertar un dato en la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
	}
	
	
// --------------------------------------------------- Tabla Clasificación ---------------------------------------------------------------------------------------------------------------
	
	
	public void insertarClasificacion(ArrayList<Equipo> listaEquipo) {
		// En el caso de que se mande directamente una lista con todos los equipos, haremos todas las inserciones directamente desde un sólo método.
		
		PreparedStatement stmt = null;
		
		Collections.sort(listaEquipo, new Comparator<Equipo>() {
			   public int compare(Equipo obj1, Equipo obj2) {
			      if(obj1.getPuntos() > obj2.getPuntos()) {
			    	  return "0".compareTo("1");
			      } else if(obj1.getPuntos() < obj2.getPuntos()) {
			    	  return "1".compareTo("0");
			      } else {
			    	  return Integer.toString(obj1.getPuntos()).compareTo(Integer.toString(obj1.getPuntos()));
			      }
			     
			   }
		});
		
//		for (int i = 0; i < listaEquipo.size(); i++) {
//			System.out.println("IdEquipo: " + listaEquipo.get(i).getIdEquipo() + " Puntos: [" + listaEquipo.get(i).getPuntos() + "] Nombre: [" + listaEquipo.get(i).getNombreCorto() + "] NombreEquipo: " + listaEquipo.get(i).getNombreEquipo());
//		}

		try {
			for (int i = 0; i < listaEquipo.size(); i++) {
				stmt = con.prepareStatement("insert into clasificacion (idEquipo, nombreCorto, nombreEquipo, Puntos, GolesFavor, GolesContra, Victoria, Empate, Derrota) values (?,?,?,?,?,?,?,?,?)");
				
				stmt.setInt(1, listaEquipo.get(i).getIdEquipo());		
				stmt.setString(2, listaEquipo.get(i).getNombreCorto());
				stmt.setString(3, listaEquipo.get(i).getNombreEquipo());
				stmt.setInt(4, listaEquipo.get(i).getPuntos());
				stmt.setInt(5, listaEquipo.get(i).getGolesFavor());
				stmt.setInt(6, listaEquipo.get(i).getGolesContra());
				stmt.setInt(7, listaEquipo.get(i).getVictoria()); 
				stmt.setInt(8, listaEquipo.get(i).getEmpate());
				stmt.setInt(9, listaEquipo.get(i).getDerrota());
				stmt.executeUpdate();
				
			}
			
			con.close();
			System.out.println("Todos los elementos de la tabla 'Clasificacion' han sido insertado correctamente");
			
			
		} catch (SQLException ex) {
			System.out.println("Error al insertar un dato en la tabla 'Clasificacion' de la base de datos");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
		
	}
	
	public void eliminarClasificacion() {
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("delete from clasificacion");
			stmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			System.out.println("Error al eliminar un dato en la base de datos. Puede que la tabla 'Clasificacion' ya estuviera vacía");

		} catch (NullPointerException ex) {
			System.out.println("Fuera de rango");
		}
	}

}
