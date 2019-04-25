package control;

import java.util.Scanner;

import modelo.dao.AccesoDatos;

public class UsoBD {

	public static void main(String[] args) {
//		Scanner entrada = new Scanner(System.in);
//				
//		System.out.println("Usted va a conectarse a una base de datos local. Por favor, introduzca un nombre de usuario:");
//		String usuarioBD = entrada.nextLine();
//		
//		System.out.println("Introduzca a continuación la contraseña:");
//		String passwordBD = entrada.nextLine();
//		entrada.close();
		
		//BaseDatos bd = new BaseDatos("localhost:3306", "sakila", usuarioBD, passwordBD);
		new AccesoDatos().getActor();

	}

}
