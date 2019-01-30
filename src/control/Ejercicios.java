package control;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Equipo;
//import modelo.Equipo;
import modelo.Estudiante;
import modelo.Partido;

//import java.util.Arrays;

import modelo.Persona;
//import java.util.*;

public class Ejercicios {
	
	// ==================================
	// 				Método	
	// ==================================
	
	// 1º Prototipo / Cabecera (¿Qué va a hacer?)
	// 2º Implementación / Cuerpo (¿Cómo se hace?)
	// 3º Llamada / Invocación del método
	
	/* 04 de Octubre del 2018 -- ACTIVIDAD: BUSCAR EN LA API -------------------------------
						
				* 1. imprime por consola el valor de 2^3
				*	- Usa la clase estática Math y su método pow  (Cuando es estático no hace falta el new)
				* 2. Imprime un valor aleatorio entre 1 y 100
				*	- Usa la clase java.util.Random y el método rnd
				* 3. En la cadena "LAS PALMAS DE GRAN CANARIA", imprime "GRAN"
				*	-Usa el método substring de la clase java.lang.String */
	
	/*public void pruebaAPI() {
		
			// 1. Imprime por consola el valor de 2^3
			System.out.println("El valor de 2^3 es: " + (int)Math.pow(2, 3));
			
			// 2. Imprime un valor aleatorio entre 1 y 100
			System.out.println("Le muestro un valor aleatorio entre 1 y 100: " + new Random().nextInt(100));
			
			// 3. En la cadena "LAS PALMAS DE GRAN CANARIA", imprime "GRAN"
			String oracion = "LAS PALMAS DE GRAN CANARIA";
			String porcion;
			
			porcion = oracion.substring(14, 18);
			System.out.println(porcion); 
	} */
		
	
// --------------------------------------------------------------------------------------------------
		
	
	/* 04 de Octubre del 2018 -- ACTIVIDAD: Mostrar por consola los números comprendidos entre dos enteros, a y b 
				
			// 1. Parte método: prototipo o cabecera */
	
	/*public void intervaloEnteros(int numero1, int numero2){
				
			// 2. Parte método: cuerpo o implementación del método
			while(numero1 < numero2 + 1) {
				System.out.print(numero1 + " ");
				numero1++;
			}
	}*/
	
	
// --------------------------------------------------------------------------------------------------
	
	
	/* 10 de Octubre del 2018 -- ACTIVIDAD: Dado una “cadena” (String) devolver el valor en forma de número entero correspondiente. 
		 
			Ejempo String: “ab95f1”     */
		
	/*public static int converString(String cadena) {
		int numeros = Integer.parseInt(cadena);
		return numeros;
	}*/

	
// --------------------------------------------------------------------------------------------------
	
	
	// 11 de Octubre del 2018 -- ACTIVIDAD: Serie Fibonacci 
		
	/*public static void serieFibonacci(int posicion) {
	
			
		int auxiliar1 = 0;
		int auxiliar2 = 1;
		int resultadoPosicion = 1;
		
		System.out.println("La serie de Fibonacci de los primeros " + posicion + " números es la siguiente:");
		System.out.print(auxiliar1 + " " + auxiliar2 + " ");
		
		for(int i=3; i <= posicion; i++) {
			resultadoPosicion = auxiliar1 + auxiliar2;
			auxiliar1 = auxiliar2;
			auxiliar2 = resultadoPosicion;
			System.out.print(resultadoPosicion + " ");
		}
		
		// Extra conocer posición
		*if(posicion <= 1) {
		*	System.out.println("\nEn la posición " + posicion + " de la serie de Fibonacci el número resultante es: 0");
		*}else {
		*	System.out.println("\nEn la posición " + posicion + " de la serie de Fibonacci el número resultante es: " + resultadoPosicion);
		*}
	}*/
	

// --------------------------------------------------------------------------------------------------
	
	
	// 11 de Octubre del 2018 -- ACTIVIDAD: Factorial de un número
	/*public static void factorialNumero(int numero) {
		int acumulador = numero;
		
		if(numero == 0) {
			acumulador++;
		}
		
		for(int i=numero; i>1; i--) {
			acumulador = acumulador * (i - 1);
		}
		System.out.println("El factorial del número " + numero + " es: " + acumulador);
	}*/
	

// --------------------------------------------------------------------------------------------------
		
			
	/* 16 de Octubre del 2018 -- ACTIVIDAD: Devolver el número menor de tres
	 * Pasando por parámetro un array */
	/*public static int calcularNumeroMenor(int[] numeros) {
		int numMenor = numeros[0];
		
		for(int i = 1; i<numeros.length; i++) {
			if(numMenor > numeros[i]) {
				numMenor = numeros[i];
			}
		}
		return numMenor;
	}
	// Por medio de "if"
	public static int calcularNumeroMenor(int x, int y, int z) {
		int numMenor = x;
		
		if(numMenor > y) {numMenor = y;}
		if(numMenor > z) {numMenor = z;}
		return numMenor;
	}*/
	

// --------------------------------------------------------------------------------------------------
		
	
	// 16 de Octubre del 2018 -- ACTIVIDAD: Devolver el número menor de cuatro	- Con "if"
	/*public static int calcularNumeroMenor(int w, int x, int y, int z) {
		int numMenor = w;
		
		if(numMenor > x) {numMenor = x;}
		if(numMenor > y) {numMenor = y;}
		if(numMenor > z) {numMenor = z;}
		return numMenor;
	}*/
	

// --------------------------------------------------------------------------------------------------
			
	
	/* 16 de Octubre del 2018 -- ACTIVIDAD: Método Aleatorio + Array 
	 * Crear un método "aleatorio" , pasándole un elemento "n". Nos devuelva un array de enteros aleatorio. (1-1000)
	 	* Pasos:
	 		* - Declarar el array e Inicializarlo
	 		* - Recorrer el array (con un bucle)
	 		* - Generar un entero y ponerlo en la posicion
	 		* - Devolver array
	  */
	
	/*public static int[] numAleatorios(int n) {
		int[] numerosRandom = new int[n];
		Random rnd = new Random();
		
		for(int i = 0; i<numerosRandom.length; i++) {
			numerosRandom[i] = rnd.nextInt(999) + 1;
		}
		
		return numerosRandom;
		
	}*/
	

// --------------------------------------------------------------------------------------------------
				
		
	// 17 de Octubre del 2018 -- ACTIVIDAD: IMPRIME POR CONSOLA n números enteros aleatorios entre 1-100
	/*public static int[] numAleatorios(int n) {
		int[] numerosRandom = new int[n];
		Random rnd = new Random();
		
		for(int i = 0; i<numerosRandom.length; i++) {
			numerosRandom[i] = rnd.nextInt(99) + 1;
		}
		
		return numerosRandom;
		
	}*/
	

// --------------------------------------------------------------------------------------------------
					
		
	/* 17 de Octubre del 2018 -- ACTIVIDAD: Devolver un array con 'n' numeros aleatorios entre 
	 * 'inferior' y 'superior'. Entre 100 y 500
	 */
	
	/*public static int[] generaNumerosAleatorios(int n) {
		int[] numerosRandom = new int[n];
		Random rnd = new Random();
		
		for(int i=0; i<numerosRandom.length; i++) {
			numerosRandom[i] = rnd.nextInt(400) + 100;
		}
		
		return numerosRandom;
	}*/
	
	

// --------------------------------------------------------------------------------------------------
						
	
	/* 18 de Octubre del 2018 -- ACTIVIDAD: devolver la cantidad de veces que se repiten los números 
	 * en 10 veces que se genera los números aleatorios. Rango numeros 1-6
	 */
	
	/*public static int[] generaEstadisticaAparicion (int n, int inferior, int superior) {
		int[] calcularRepeticiones = new int[superior - inferior + 1];
		Random rnd = new Random();
		int numeroAleatorio;
		
		for(int i=0; i<n; i++) {
			numeroAleatorio = rnd.nextInt(superior - inferior + 1) + inferior;
			calcularRepeticiones[numeroAleatorio - 1]++; 
		}
		return calcularRepeticiones;
	}*/
		

// --------------------------------------------------------------------------------------------------
							
			
	/* 24 de Octubre del 2018 -- ACTIVIDAD: crearListaPersonas [Array] (Constructor Vacío) 
	 * crear un método que devuelva una lista de 'n' personas. 
	 * Se crean las personas con el constructor Persona().
	 */
	/*public Persona[] crearListaPersona (int n){
		Persona[] listaPersonas = new Persona[n];
		
		for(int i=0; i<listaPersonas.length; i++) {
			listaPersonas[i] = new Persona();
		}
		
		return listaPersonas;
	}*/
		

// --------------------------------------------------------------------------------------------------
									
				
	/* 25 de Octubre del 2018 -- ACTIVIDAD: Dado una String pasada por parámetros 
	 * mostrar por pantalla caracter a caracter el String (Método CharAt) 
	 */
	/*public void muestraCaracter(String caracteres){
		for(int i=0; i<caracteres.length(); i++) {
			System.out.print(caracteres.charAt(i) + " ");
		}
	}*/
	

// --------------------------------------------------------------------------------------------------
										
	
	/* 25 de Octubre del 2018 -- ACTIVIDAD: Dan dos cadenas de caracteres por parámetros 
	 * que hay que comparar entre sí (CompareTo)
	 */
	/*public void comparaCadenaOrdenAlf(String cadena1, String cadena2){	
		if(cadena1.compareToIgnoreCase(cadena2)==0) {
			System.out.println("El String \"" + cadena1 + "\" es léxicamente IGUAL que el String \"" + cadena2 + "\"");
		}else {
			if(cadena1.compareToIgnoreCase(cadena2)<0) {
				System.out.println("El tamaño del String \"" + cadena1 + 
						"\" es léxicamente MENOR que el String \"" + cadena2 + "\"");
			}else {
				System.out.println("El tamaño del String \"" + cadena1 + 
						"\" es léxicamente MAYOR que el String \"" + cadena2 + "\"");
			}
		}
	}*/
	
	
// --------------------------------------------------------------------------------------------------
	
		
	/* 31 de Octubre del 2018 -- ACTIVIDAD: Hacer un método que recorra y devuelva 
	 * un acumulado de ventas por vendedor.
	 */
	/*public float[] resumenVendedor(float[][] ventas) {
		float[] resultado = new float[ventas.length];
		
		for(int i=0; i<ventas.length; i++) {
			resultado[i] = 0;
			for(int j=0; j<ventas[i].length; j++) {
				resultado[i] += ventas[i][j];
			}
						
		}
		return resultado;
	}*/
	

// ------------------------------------------------------------------	

	
	// 6 de Noviembre del 2018 -- ACTIVIDAD ANTERIOR EXTENDIDA: Mostrar nombre de los vendedores
	/*public void mostrarVentasVendedor(){
		String[] nombres = {"May Jonhson", "Phil Caul", "Rebert Smith"};
		Ejercicios ventas = new Ejercicios();
		float[][] ventasAnual = {
				// hay tres filas (vendedores) y 12 columnas (meses)	
				{12.5f,13.5f,8.5f,5.0f,10.5f,9.5f,20.5f,10.5f,4.0f,6.5f,5.5f,6.05f},
				{12.5f,13.5f,5.5f,5.0f,10.5f,4.5f,20.5f,1.5f,3.0f,6.5f,5.5f,6.05f},
				{12.5f,18.5f,8.5f,5.0f,2.5f,9.5f,20.5f,10.5f,9.0f,6.5f,5.5f,6.05f}
			};
		
		float[] ventasPorVendedor = ventas.resumenVendedor(ventasAnual);
		
		for(int i=0; i<nombres.length; i++) {
			System.out.println("Vendedor: " + nombres[i] + "   Ventas: " + ventasPorVendedor[i]);
		}
		
	}*/
	

// ------------------------------------------------------------------	

			
	/* 6 de Noviembre del 2018 -- ACTIVIDAD: Dado un array de cadenas, devolver la lista como números.
	 * En caso de que no pueda devolver el valor -1
	 * El array de salida tiene el MISMO número de elementos que el de entrada
	 */
	
	/*public int[] convierteCadenas (String[] cadenas) {
		int[] listaNumeros = new int[cadenas.length];
		
		for(int i=0; i<cadenas.length; i++) {
			try {
				listaNumeros[i] = Integer.parseInt(cadenas[i]);
			}
			catch (NumberFormatException ex) {
				listaNumeros[i] = -1;
			}
		}
		return listaNumeros;
	}*/
	

// ------------------------------------------------------------------	

			
	// 7 de Noviembre del 2018 -- ACTIVIDAD: Realizar un reloj
	/*public void mostrarReloj(){
		//Recorrer horas
		for (int h = 0; h < 1; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException exception) {   // objeto 'e' o 'ex' excepción es lo mismo
						exception.printStackTrace();
					}
					System.out.println(h + ":" + m + ":" + s);
				}
			}
		}
	}*/
	

// ------------------------------------------------------------------	

	
	// 8 de Noviembre del 2018 -- ACTIVIDAD: Mostrar si el número es primo
	/*public boolean esPrimo(int numero) {
		boolean Primo = true;
		//numero = Math.abs(numero); //Para que el número que nos pase sea siempre positivo
		
		for(int i=numero-1; i>1; i--) {
			if((numero % i) == 0){
				Primo = false;
			}
		}
		return Primo;
	}*/
	

// ------------------------------------------------------------------	

	
	/* 8 de Noviembre del 2018 -- ACTIVIDAD: Listar los números primos del 1 hasta el 300 
	 * (usando tambíen el método 'esPrimo')
	 */
	/*public void listarPrimos(int desde , int hasta) {
		System.out.println("Los números primos desde " + desde + " hasta " + hasta + " son:\n");
		
		for(int i=desde; i<hasta; i++) {
			if(esPrimo(i) == true) {
				System.out.print(i + " ");
			}
		}
	}*/
	
	
// ------------------------------------------------------------------	

		
	/* 8 de Noviembre del 2018 -- ACTIVIDAD: Listar los x números primos
	 * (usando tambíen el método 'esPrimo')
	 */
	/*public void listarPrimos2(int desde, int cuantos) {
		System.out.println("Los primeros " + cuantos + " números primos desde el número " + desde + " son:");
		while(cuantos>0) {
			if(esPrimo(desde) == true) {
				System.out.print(desde + " ");
				cuantos--;
			}
			desde++;
		}
	}*/
	
	
// ------------------------------------------------------------------	

		
	/* 8 de Noviembre del 2018 -- ACTIVIDAD: Meter en una lista los x números primos
	 * (usando tambíen el método 'esPrimo') 
	 */
	/*public int[] listarPrimos3(int desde, int cuantos) {
		int[] listaPrimos = new int[cuantos];
		int posicion = 0;
		
		// La variable "posicion" solo incrementará su valor en 1 cada vez que se encuentre un primo
		while(posicion<cuantos) { 
			if(esPrimo(desde) == true) {
				listaPrimos[posicion] = desde;
				posicion++;
			}
			desde++;
		}
		return listaPrimos;
	}*/
	
	
// ------------------------------------------------------------------	
	
	
	// 14 de Noviembre del 2018 -- ACTIVIDAD: Pasar una lista de números desordenados y mostrarlos ordenados
	/*public void ordenarArray(int[] numeros) {
		int memoria;
		
		for(int i=0; i<numeros.length; i++) {
			for(int j=i+1; j<numeros.length; j++) {
				if(numeros[i]>numeros[j]) {
					memoria = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = memoria;
				}
			}
		}
		System.out.println(Arrays.toString(numeros));
	}*/
	
	
// ------------------------------------------------------------------	
		
	
	/* 14 de Noviembre del 2018 -- ACTIVIDAD: Ordenar un array de cadenas
	 * ¿Qué devuelve compareTo?	 
	 * devuelve < 0, entonces la cadena que llama al método es primero lexicográficamente
	 * devuelve == 0 entonces las dos cadenas son lexicográficamente equivalentes
	 * devuelve > 0, entonces el parámetro pasado al método compareTo es lexicográficamente el primero.
	 */
	/*public void ordenarCadena(String[] cadenas ) {
		String memoria;
		
		for(int i=0; i<cadenas.length; i++) {
			for(int j=i+1; j<cadenas.length; j++) {
				if(cadenas[i].compareTo(cadenas[j]) > 0) {
					memoria = cadenas[i];
					cadenas[i] = cadenas[j];
					cadenas[j] = memoria;
				}
			}
		}
		System.out.println(Arrays.toString(cadenas));		
	}*/
	
		
// ------------------------------------------------------------------	
			
	
	/* 14 de Noviembre del 2018 -- ACTIVIDAD: Usar el método "generarListaAleatorios" y ordenar los números
	 * Explicación :El método generarListaAleatorios está creado en esta misma clase
	 * pero con unos cambios es por ello que decidí copiar y pegar con las variaciones
	 * justo encima del método que lo va a llamar para mayor claridad.
	 */
	/*public static int[] generaListaAleatorios (int n, int inferior, int superior) {
		int[] calcularRepeticiones = new int[superior - inferior + 1];
		Random rnd = new Random();
		int numeroAleatorio;
		
		for(int i=0; i<n; i++) {
			numeroAleatorio = rnd.nextInt(superior - inferior + 1) + inferior;
			calcularRepeticiones[numeroAleatorio - 1]++; 
		}
		return calcularRepeticiones;
	}
	
	public void ordenarArray() {
		int[] ordenarArray = Ejercicios.generaListaAleatorios(10, 1, 6);
		System.out.println(Arrays.toString(ordenarArray) + " Número aleatorios");
		int memoria;
		
		for(int i=0; i<ordenarArray.length; i++) {
			for(int j=i+1; j<ordenarArray.length; j++) {
				if(ordenarArray[i]>ordenarArray[j]) {
					memoria = ordenarArray[i];
					ordenarArray[i] = ordenarArray[j];
					ordenarArray[j] = memoria;
				}
			}
		}
		System.out.println(Arrays.toString(ordenarArray) + " Número aleatorios ordenados");
	}*/
	
	
// ------------------------------------------------------------------	
	
	
	// 14 de Noviembre del 2018 -- ACTIVIDAD: Recorrer matriz irregular. Sumar las columnas de un matriz heterogénea o irregular
	/*public int[] sumaColumnasMatrizHeterogenea(int[][]matriz) {
		int[] resultado = new int[matriz.length];
		
		for(int i=0; i<matriz.length; i++) {
			resultado[i] = 0;
			
			for(int j=0; j<matriz[i].length; j++) {
				resultado[i] += matriz[i][j];
			}
		}
		return resultado;
	}*/
	
	
// ------------------------------------------------------------------	
		
	
	// 20 de Noviembre del 2018 -- ACTIVIDAD: Invertir elementos de una lista
	/*public void invertirLista(int[] lista) {
		System.out.println(Arrays.toString(lista) + " Lista sin invertir");
		int[] listaInvertida = new int[lista.length];
		
		for(int i=0; i<lista.length; i++) {
			listaInvertida[lista.length-i-1] = lista[i];
		}
		System.out.println(Arrays.toString(listaInvertida) + " Lista invertida");
	}*/
		
	
// ------------------------------------------------------------------	
			
		
	/* 20 de Noviembre del 2018 -- ACTIVIDAD: Dadas dos listas PREVIAMENTE ORDENADAS, 
	 * se pide obtener la lista MEZCLADA de ambas .(Mezclar listas)
	 * En esta actividad hemos llamado al método "ordenarArray".
	 * Copiaremos este método que ya habíamos hecho antes aquí con un pequeño cambio.
	 * Esta vez devolverá el resultado del array ordenado.
	 */
	/*public int[] ordenarArray2(int[] numeros) {
		int memoria;
		
		for(int i=0; i<numeros.length; i++) {
			for(int j=i+1; j<numeros.length; j++) {
				if(numeros[i]>numeros[j]) {
					memoria = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = memoria;
				}
			}
		}
		return numeros;
	}
	
	public int[] mezclaListaOrdenadas(int[] l1, int[] l2) {
		l1 = ordenarArray2(l1);
		l2 = ordenarArray2(l2);
		int[] arrayMezclado = new int[l1.length + l2.length];

		
		for(int i = 0; i<l1.length; i++) {
			arrayMezclado[i] = l1[i];
		}
		
		for(int j = 0; j<l2.length; j++) {
			arrayMezclado[l1.length + j] = l2[j];
		}		
		
		return ordenarArray2(arrayMezclado);
	}*/
	
	
// ------------------------------------------------------------------	
				
		
	/* 20 de Noviembre del 2018 -- ACTIVIDAD: Dada una cadena, obtener la cadena 
	 * INVIRTIENDO sus caracteres(usar charAt() o toCharArray()
	 * Invertir caracteres de una cadena ( Extension - hacer método saber si es palíndromo) 
	 */
	/*public String invertirCaracteres(String cadena) {
		String invertido = "";
		
		for(int i=0; i<cadena.length(); i++) {
			invertido += cadena.charAt(cadena.length()-i-1);
		}
		return invertido;
	}
	
	public void saberPalindromo(String cadena) {
		cadena = cadena.replace(" ", ""); // Elimanos los espacios en blanco para evaluar mejor si es palíndromo
		String invertido = "";
		
		for(int i=0; i<cadena.length(); i++) {
			invertido += cadena.charAt(cadena.length()-i-1);
		}
		
		if(invertido.compareToIgnoreCase(cadena) == 0) {
			System.out.println("La cadena \"" + cadena + "\" SÍ es un palíndromo");
		}else {
			System.out.println("La cadena \"" + cadena + "\" NO es un palíndromo");
		}

	}*/
	
	
// ------------------------------------------------------------------	
					
		
	/* 21 de Noviembre del 2018 -- ACTIVIDAD: Ordenar cada array de la matriz (usando el método ordenarArray)
	 * En esta actividad hemos llamado al método "ordenarArray".
	 * Copiaremos este método que ya habíamos hecho antes aquí con un pequeño cambio.
	 * Esta vez devolverá el resultado del array ordenado. */
	/*public int[] ordenarArray3(int[] numeros) {
		int memoria;
		
		for(int i=0; i<numeros.length; i++) {
			for(int j=i+1; j<numeros.length; j++) {
				if(numeros[i]>numeros[j]) {
					memoria = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = memoria;
				}
			}
		}
		return numeros;
	}
	
	public void ordenaFilaMatriz (int[][] matriz) {
		for(int i=0; i<matriz.length; i++) {
			ordenarArray3(matriz[i]);
			System.out.println(Arrays.toString(matriz[i]));
		}
		
	}*/
	
	
	
// ------------------------------------------------------------------	
						
		
	/* 22 de Noviembre del 2018 -- ACTIVIDAD: Una vez ordenado cada arrays 
	 * de la matriz ahora hay que ORDENAR TODA la matriz comparando con los array
	 */
	/*public int[] matrizToArrayOrdenado(int[][] matriz) {
		int[] resultado = new int[0];
		
		for(int i=0; i<matriz.length; i++) {
			resultado = mezclaListaOrdenadas(resultado, matriz[i]) ;
		}
		return resultado;

	}*/
	
	
// ------------------------------------------------------------------	
							
	
	/* 28 de Noviembre del 2018 -- Ejercicios
	 * 1) Declarar en la clase "Ejercicios" un array de personas
	 * 2) En la clase "Persona" declara un array de "Persona" que representa los hijos biológicos que tiene
	 	* (HECHO. Está completado en la clase "Persona", en el paquete "modelo" de este mismo proyecto
	 */
	

// ------------------------------------------------------------------	
								
	
	// 28 de Noviembre del 2018 -- ACTIVIDAD: Mostrar nombre progenitor sus padres y sus hijos
	/*private Persona[] personas; //1.- Declarar en la clase "Ejercicios" un array de persona
	
	public void hijosPersona() {
		for(int i=0; i<personas.length; i++) {
			System.out.println("Los progenitores de " + personas[i].getNombre() + ", con NIF " + personas[i].getNif() + " son");
			
			try{System.out.println("   Padre: " + (personas[i].getPadre()).getNombre());}
			catch(NullPointerException ex) {System.out.println("   Padre: no tiene");}
			
			try{System.out.println("   Madre: " + (personas[i].getMadre()).getNombre());}
			catch(NullPointerException ex) {System.out.println("   Madre: no tiene");}		
			
			if((personas[i].getHijosBiologicos()) == null) {
				System.out.println("La persona " + personas[i].getNombre() + " no tiene hijos");
			}else {
				System.out.println("La persona " + personas[i].getNombre() + " tiene los siguientes hijos:");
				for(int j=0; j<(personas[i].getHijosBiologicos()).length; j++) {
					System.out.println((personas[i].getHijosBiologicos())[j].toString());
				}
			}
			System.out.println("");
		}
	}*/
	
// ============================================
// 				2ª Evaluación
// ============================================
	
	// 8 de Enero del 2019 -- Actividad: Crear una lista de personas
	public void introListaPersona() {
		ArrayList<Persona> lista;  //Declaración
		lista = new ArrayList<Persona>();  // Inicialización
		
		lista.add(new Persona());
		lista.add(new Persona("45351504F", "Carlos", 14 , "", 'M', null));
		lista.add(new Persona());
		
		System.out.println(lista.get(1).getNombre());
		

	}

	
// ------------------------------------------------------------------	
									
	
	/* 9 de Enero del 2019 -- Actividad: Crear un mapa
	 * Declarar un mapa (HashMap) que almacena
	 * objetos de la clase Estudiante. La clave es Estudiante.nif
	 	* Inicializar el mapa.
	 	* Insertar(put) una serie de estudiantes.	 
	 */
	public void introMapa() {
		HashMap<String,Estudiante> mapaPersona = new HashMap<String, Estudiante>();
		Estudiante estMapa1 = new Estudiante("45667386S", "Pepito", 30, null, 'F');
		Estudiante estMapa2 = new Estudiante();
	
		mapaPersona.put(estMapa1.getNif(),estMapa1);
		mapaPersona.put(estMapa2.getNif(),estMapa2);
		mapaPersona.put("45321436M",new Estudiante());
		
		System.out.println("Nada");
		
		// Recorrer mapa
		Set<String> clavesMapa = mapaPersona.keySet();
		
		for(String claves: clavesMapa) {
			System.out.println(mapaPersona.get(claves).getNombre());
		}
		
		System.out.println(mapaPersona.size());			
		
	}

	
// ------------------------------------------------------------------	
		
	
	// ==========================================================
	//			Manejar ficheros - 10 de Enero del 2019
	// ==========================================================
	
	/* Algoritmo en mi propio idioma de cómo empezar a manejar ficheros
	 * <Abrir el Fichero> "Tener en cuenta posibles errores (Fichero no se abre, ya está abierto...)"
 	 	* mientras(existan registros / no fin de fichero)
 	 		* Evalúa REGISTRO{};
 	 		* Leer REGISTRO;	 
 		* FIN mientras;
 	 * <Cerrar Fichero>
	 */
	
	
	// 10 de Enero del 2019 -- Actividad: Acceso a un fichero	
	public void leerFichero(String rutaFichero) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			while((registro = fichero.readLine()) != null){
				System.out.println(registro);
			}

			fichero.close();
			System.out.println("Fin de la lectura");
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		
	}

	
// ------------------------------------------------------------------	
			
		
	// 15 de Enero del 2019 -- Actividad: Almacenar campos de un fichero en un ArrayList
	public ArrayList<Persona> creaListaPersonasDesdeFichero (String rutaFichero, String delimitador) {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		try {
			
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			
			
			while((registro = fichero.readLine()) != null){
				// System.out.println(registro);
				String[] campos = registro.split(delimitador);
				listaPersonas.add(new Persona(campos[0],campos[1],Integer.parseInt(campos[2]),campos[3],campos[4].charAt(0)));
			}
			
			fichero.close();
			System.out.println("Creada la lista de personas");		
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		
		return listaPersonas;
	}

	
// ------------------------------------------------------------------	
				
				
	// 15 de Enero del 2019 -- Actividad: Mostrar nombres ordenados por apellidos de una ficha con personas
	public void mostrarNombresOrdenadosPorApellidosDeListaPersonasDesdeFichero(String rutaFichero, String delimitador) {
		ArrayList<Persona> listaPersonas = creaListaPersonasDesdeFichero(rutaFichero, delimitador);
		
		Collections.sort(listaPersonas, new Comparator<Persona>() {
			   public int compare(Persona obj1, Persona obj2) {
			      return obj1.getNombre().substring(obj1.getNombre().indexOf(" ")).compareTo(
			    		  obj2.getNombre().substring(obj2.getNombre().indexOf(" ")));
			   }
		});
		
		for(Persona temp: listaPersonas){
		    System.out.println(temp.getNombre());
		}
	}
	

// ------------------------------------------------------------------	
					
				
	// 30 de Enero del 2019 -- Actividad: Pruebita de SWING
	public void pruebaSwing() {
		JFrame ventana = new JFrame("Mi primer SWING");
		JButton boton = new JButton("pulsaMe!");
		JPanel panel = new JPanel();
//		JComboBox lista = new JComboBox();
		
		ventana.add(panel);
		
//		ArrayList<Equipo> equipos = new Equipo().crearListaEquipos("ficheros/equipos.txt", "#");
//		Equipo[] arrayEquipos = equipos.toArray(new Equipo())
		
		panel.add(boton);
		
		
		ventana.pack();
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		// 30 de Enero del 2019 -- Actividad: Muestra todos los resultados de los equipos ordenados
		new Equipo().muestraResultadosOrdenados("ficheros/partidos.txt", "#");
		

	// ------------------------------------------------------------------	

	
		// 30 de Enero del 2019 -- Actividad: Muestyra la clasificación ordenada de los equipos
		/*HashMap<String, Integer> clasificacionEquipos = new Equipo().clasificacionEquipos("ficheros/partidos.txt", "#");
		clasificacionEquipos = Equipo.clasificacionOrdenada(clasificacionEquipos);
		
		Set<String> clavesMapa = clasificacionEquipos.keySet();

		System.out.println("La clasificación de los equipos es la siguientes");
		for (String claves : clavesMapa) {
			System.out.println(claves + " [Puntos: " + clasificacionEquipos.get(claves) + "]");
		}*/
			

	// ------------------------------------------------------------------	

		
		// 30 de Enero del 2019 -- Actividad: Pruebita de SWING
		//new Ejercicios().pruebaSwing();
		

	// ------------------------------------------------------------------	

		
		// 29 de Enero del 2019 -- Actividad: Mostrar resultado de los equipos con un método
		//new Equipo().muestraResultados("ficheros/partidos.txt", "#");
		

	// ------------------------------------------------------------------	

			
		// 29 de Enero del 2019 -- Actividad: Mostrar resultado de los equipos
		/*HashMap<String, Integer> clasificacionEquipos = new Equipo().clasificacionEquipos("ficheros/partidos.txt", "#");
		HashMap<String, ArrayList<Integer>> mapaResultadosEquipos = new Partido().resultadosEquipos("ficheros/partidos.txt", "#");
		HashMap<String, ArrayList<Integer>> mapaGolesEquipos = new Partido().numeroGolesMarcadosYRecibidos("ficheros/partidos.txt", "#");
		
		Set<String> clavesMapa = clasificacionEquipos.keySet();
		
		System.out.println("El resultado de cada equipo es el siguiente:");
		for(String claves: clavesMapa) {
			System.out.println(claves + " [Puntos: " + clasificacionEquipos.get(claves) + "]" 
			 		+ " - [GM:" + mapaGolesEquipos.get(claves).get(0) + ", GR:"
			 		+ mapaGolesEquipos.get(claves).get(1) + "]"
			 		+ " - [V:" + mapaResultadosEquipos.get(claves).get(0) + ", E:"
					+ mapaResultadosEquipos.get(claves).get(1) + ", D:"
					+ mapaResultadosEquipos.get(claves).get(2) + "]");
		}*/
		

	// ------------------------------------------------------------------	

		
		// 24 de Enero del 2019 -- Actividad: Mostrar goles marcados y recibidos de los equipos
		/*HashMap<String, ArrayList<Integer>> mapaGolesEquipos = new Partido().numeroGolesMarcadosYRecibidos("ficheros/partidos.txt", "#");
		
		Set<String> clavesMapa = mapaGolesEquipos.keySet();
		
		System.out.println("Los goles marcados por cada equipo son los siguientes:");
		for(String claves: clavesMapa) {
			System.out.println((claves + ": [GM:" + mapaGolesEquipos.get(claves).get(0)) + ", GR:"
					+ mapaGolesEquipos.get(claves).get(1) + "]");
		}*/
		
		
	// ------------------------------------------------------------------	

		
		//24 de Enero del 2019 -- Actividad: Mostrar resultados de los equipos
		/*HashMap<String, ArrayList<Integer>> mapaResultadosEquipos = new Partido().resultadosEquipos("ficheros/partidos.txt", "#");
		
		Set<String> clavesMapaResultadosEquipos = mapaResultadosEquipos.keySet();
		
		System.out.println("El resultado de los equipos es el siguiente:");
		for(String claves: clavesMapaResultadosEquipos) {
			System.out.println((claves + ": [V:" + mapaResultadosEquipos.get(claves).get(0)) + ", E:"
					+ mapaResultadosEquipos.get(claves).get(1) + ", D:"
					+ mapaResultadosEquipos.get(claves).get(2) + "]");
		}*/
		
	// ------------------------------------------------------------------	

			
		//24 de Enero del 2019 -- Actividad: Mostrar número de partidos jugados
		//new Partido().mostrarNumeroPartidosJugadosTry("ficheros/partidos.txt", "#");
		
		
	// ------------------------------------------------------------------	

			
		//23 de Enero del 2019 -- Actividad: Crear mapa equipos
		/*HashMap<String,Equipo> mapaEquipos = new Equipo().crearMapaEquipos("ficheros/equipos.txt", "#");
		
		Set<String> clavesMapa = mapaEquipos.keySet();

		for(String claves: clavesMapa) {
			System.out.println("ID: " + mapaEquipos.get(claves).getIdEquipo()
					+ " Nombre corto: " + mapaEquipos.get(claves).getnombreCorto()
					+ " Nombre equipo: " + mapaEquipos.get(claves).getNombreEquipo());
		} 
		System.exit(0);*/
		
		
	// ------------------------------------------------------------------	

			
		//23 de Enero del 2019 -- Actividad: Crear lista equipos
		/*ArrayList<Equipo> equipos = new Equipo().crearListaEquipos("ficheros/equipos.txt", "#");
		for (int i = 0; i < equipos.size(); i++) {
			System.out.println("ID: " + equipos.get(i).getIdEquipo()
					+ " NombreCorto: " + equipos.get(i).getnombreCorto() 
					+ " NombreEquipo: " + equipos.get(i).getNombreEquipo());
		}*/

		
	// ------------------------------------------------------------------	

		
		// 22 de Enero del 2019 -- Actividad: Comprobar partidos
		//HashMap<String,Integer> mapaEquipo = new Partido().comprobarPartidos("ficheros/partidos.txt", "#");
		

	// ------------------------------------------------------------------	

		
		// 15 de Enero del 2019 -- Actividad: Mostrar nombres ordenados por apellidos de una ficha con personas
		//new Ejercicios().mostrarNombresOrdenadosPorApellidosDeListaPersonasDesdeFichero("ficheros/personas.txt", "##");
		
		
	// ------------------------------------------------------------------	

		
		// 15 de Enero del 2019 -- Actividad: Almacenar campos de un fichero en un ArrayList
		/*ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		listaPersonas = new Ejercicios().creaListaPersonasDesdeFichero("ficheros/personas.txt", "##");
		
		for (int i = 0; i < listaPersonas.size(); i++) {
			System.out.println(listaPersonas.get(i).getNombre());
		}*/
		
		
	// ------------------------------------------------------------------	

		
		// 10 de Enero del 2019 -- Actividad: Acceso a un fichero
		//new Ejercicios().leerFichero("ficheros/datos.txt");
		
		
	// ------------------------------------------------------------------	

		
		// 9 de Enero del 2019 -- Actividad: Crear un mapa
		//new Ejercicios().introMapa();
		
	// ------------------------------------------------------------------	

				
		// 8 de Enero del 2019 -- Actividad: Crear una lista de personas
		//new Ejercicios().introListaPersona();
		
		
	// ------------------------------------------------------------------	

		
		// ============================================
		//		 			2ª Evaluación
		// ============================================
			
		
	// ------------------------------------------------------------------	

		
		// 28 de Noviembre del 2018 -- ACTIVIDAD: Mostrar nombre progenitor sus padres y sus hijos
		/*Persona jordan = new Persona("45678912Z", "Jordan", 40, null, 'M', new Persona[0]);
		Persona[] hijo = {jordan};
		
		Persona martha = new Persona("43125665B", "Martha", 25, null, 'F', hijo);
		
		jordan.setMadre(martha);
		jordan.setPadre(null);
		
		martha.setMadre(null);
		martha.setPadre(null);
		
		Ejercicios personasHijos = new Ejercicios();
		Persona[] comprobarHijos = {jordan, martha}; 
		personasHijos.personas = comprobarHijos;
		personasHijos.hijosPersona();*/	

		
	// ------------------------------------------------------------------	

			
		/* 22 de Noviembre del 2018 -- ACTIVIDAD: Una vez ordenado cada arrays 
		 * de la matriz ahora hay que ORDENAR TODA la matriz comparando con los array
		 */
		/*int matrizNum[][]= {
				{7,4,6},
				{6},
				{5,2,3},
				{4,2,5,1,9,0,3},
				{5,6,1,3}
		};
		int[] vector = new Ejercicios().matrizToArrayOrdenado(matrizNum);
		System.out.println(Arrays.toString(vector));*/
		
		
	// ------------------------------------------------------------------	

			
		// 21 de Noviembre del 2018 -- ACTIVIDAD: Ordenar cada array de la matriz (usando el método ordenarArray)
		/*int matrizNum[][]= {
				{7,4,6},
				{6},
				{5,2,3},
				{4,2,5,1,9,0,3},
				{5,6,1,3}
		};
		new Ejercicios().ordenaFilaMatriz(matrizNum);*/

		
	// ------------------------------------------------------------------	

				
		// 20 de Noviembre del 2018 -- ACTIVIDAD: Dada una cadena, obtener la cadena INVIRTIENDO sus caracteres
		/*System.out.println("Oración sin invertir: Soy una cadena cualquiera");
		System.out.println("Oración invertida: " + new Ejercicios().invertirCaracteres("Soy una cadena cualquiera"));
		new Ejercicios().saberPalindromo("No soy un palíndromo");
		new Ejercicios().saberPalindromo("Lavan esa base naval");*/
		
		
	// ------------------------------------------------------------------	

				
		/* 20 de Noviembre del 2018 -- ACTIVIDAD: Dadas dos listas PREVIAMENTE ORDENADAS, 
		 * se pide obtener la lista MEZCLADA de ambas .(Mezclar listas)
		 */
		/*int[] l1 = {2, 9 ,11, 41, 8, 10};
		int[] l2 = {99, 0, 25, 7};
		int[] listasMezcladas = new Ejercicios().mezclaListaOrdenadas(l1, l2);
		
		System.out.println("Lista 1: " + Arrays.toString(l1));
		System.out.println("Lista 2: " + Arrays.toString(l2));
		System.out.println("Lista mezclada: " + Arrays.toString(listasMezcladas));*/
		
			
// ------------------------------------------------------------------	

		
		// 20 de Noviembre del 2018 -- ACTIVIDAD: Invertir elementos de una lista
		/*int[] invertirLista = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		new Ejercicios().invertirLista(invertirLista);*/
		
		
	// ------------------------------------------------------------------	

		
		// 14 de Noviembre del 2018 -- ACTIVIDAD: Recorrer matriz irregular. Sumar las columnas de un matriz heterogénea o irregular
		/*int matrizNum[][]= {
				{7,4,6},
				{6},
				{5,2,3},
				{4,2,5,1,9,0,3},
				{5,6,1,3}
		};
		int[] matrizSumada = new Ejercicios().sumaColumnasMatrizHeterogenea(matrizNum);
		
		System.out.println(Arrays.toString(matrizSumada));*/
		
		
		
	// ------------------------------------------------------------------	

				
		// 14 de Noviembre del 2018 -- ACTIVIDAD: Usar el método "generarListaAleatorios" y ordenar los números
		/*Ejercicios ejercicioOrdenarArray = new Ejercicios();
		ejercicioOrdenarArray.ordenarArray();*/
		
		
	// ------------------------------------------------------------------	

				
		// 14 de Noviembre del 2018 -- ACTIVIDAD: Ordenar un array de cadenas
		/*String palabras[]= {"zorro","azul","abeja","pez"};
		new Ejercicios().ordenarCadena(palabras);*/
		
		
	// ------------------------------------------------------------------	

			
		// 14 de Noviembre del 2018 -- ACTIVIDAD: Pasar una lista de números desordenados y mostrarlos ordenados
		/*int[] ordenarArray= {40,8,2,1,30};
		new Ejercicios().ordenarArray(ordenarArray);*/

		

	// ------------------------------------------------------------------	

			
		/* 8 de Noviembre del 2018 -- ACTIVIDAD: Meter en una lista los x números primos
		 * (usando tambíen el método 'esPrimo')
		 */
		/*Ejercicios ejercicioListarPrimos = new Ejercicios();
		int[] listarPrimos = ejercicioListarPrimos.listarPrimos3(30, 20);
		
		System.out.println(Arrays.toString(listarPrimos));*/
		

	// ------------------------------------------------------------------	

		
		/* 8 de Noviembre del 2018 -- ACTIVIDAD: Listar los x números primos
		 * (usando tambíen el método 'esPrimo')
		 */
		/*Ejercicios primo = new Ejercicios();
		primo.listarPrimos2(30, 20);*/

		
	// ------------------------------------------------------------------	

		
		/* 8 de Noviembre del 2018 -- ACTIVIDAD: Listar los números primos del 1 hasta el 300 
		 * (usando tambíen el método 'esPrimo')
		 */
		/*Ejercicios primo = new Ejercicios();
		primo.listarPrimos(1, 300);*/
		

	// ------------------------------------------------------------------	

		
		// 8 de Noviembre del 2018 -- ACTIVIDAD: Mostrar si el número es primo
		/*Ejercicios primo = new Ejercicios();
		Random rnd = new Random();
		int numeroPrimo = rnd.nextInt(99) + 1;
		
		System.out.println("¿El número " + numeroPrimo + " es primo? " + primo.esPrimo(numeroPrimo));*/

	// ------------------------------------------------------------------	

			
		// 7 de Noviembre del 2018 -- ACTIVIDAD: Realizar un reloj
		/*Ejercicios reloj = new Ejercicios();
		reloj.mostrarReloj();*/
		

	// ------------------------------------------------------------------	

			
		/* 6 de Noviembre del 2018 -- ACTIVIDAD: Dado un array de cadenas, devolver la lista como números.
		 * En caso de que no pueda devolver el valor -1
		 * El array de salida tiene el MISMO numero de elementos que el de entrada
		 */
		/*Ejercicios ejercicioListaNumeros = new Ejercicios();
		String[] cadenaNumerica={"123","8k8","9811","xyz"};
		
		int[] listaNumeros = ejercicioListaNumeros.convierteCadenas(cadenaNumerica);
		System.out.println("La lista de números es la siguiente:\n" + Arrays.toString(listaNumeros));*/
		

	// ------------------------------------------------------------------	

			
		// 6 de Noviembre del 2018 -- ACTIVIDAD ANTERIOR EXTENDIDA: Mostrar nombre de los vendedores
		/*Ejercicios ventasNombres = new Ejercicios();
		ventasNombres.mostrarVentasVendedor();*/

	// ------------------------------------------------------------------	

		
		/* 31 de Octubre del 2018 -- ACTIVIDAD: Hacer un método que recorra y devuleva 
		 * un acumulado de ventas por vendedor.
		 */
		/*Ejercicios ventas = new Ejercicios();
		float[][] ventasAnual = {
				// hay tres filas (vendedores) y 12 columnas (meses)	
				{12.5f,13.5f,8.5f,5.0f,10.5f,9.5f,20.5f,10.5f,4.0f,6.5f,5.5f,6.05f},
				{12.5f,13.5f,5.5f,5.0f,10.5f,4.5f,20.5f,1.5f,3.0f,6.5f,5.5f,6.05f},
				{12.5f,18.5f,8.5f,5.0f,2.5f,9.5f,20.5f,10.5f,9.0f,6.5f,5.5f,6.05f}
			};
		
		float[] ventasPorVendedor = ventas.resumenVendedor(ventasAnual);
		
		System.out.println(Arrays.toString(ventasPorVendedor));*/
		

	// ------------------------------------------------------------------	

		
		/* 25 de Octubre del 2018 -- ACTIVIDAD: Dan dos cadenas de caracteres por parámetros 
		 * que hay que comparar entre sí (CompareTo)
		 */
		/*Ejercicios compararString = new Ejercicios();
		String cadenaIgual1 = "Soy igual que otra cadena";
		String cadenaIgual2 = "Soy igual que otra cadena";
		String cadenaDistinta = "Soy una cadena distinta";
		
		compararString.comparaCadenaOrdenAlf(cadenaIgual1, cadenaIgual2);
		compararString.comparaCadenaOrdenAlf(cadenaIgual1, cadenaDistinta);*/
		

	// ------------------------------------------------------------------	

					
		/* 25 de Octubre del 2018 -- ACTIVIDAD: Dado una String pasada por parámetros 
		 * mostrar por pantalla caracter a caracter el String (Método CharAt) 
		 */
		/*Ejercicios caracteres = new Ejercicios();
		caracteres.muestraCaracter("Soy una String cualquiera");*/	
		
		
	// ------------------------------------------------------------------	

					
		/* 24 de Octubre del 2018 -- ACTIVIDAD: crearListaPersonas [Array] (Constructor Vacío) 
		 * crear un método que devuelva una lista de 'n' personas. 
		 * Se crean las personas con el constructor Persona().
		 */
		/*Ejercicios personas = new Ejercicios();
		Persona[] listaPersonas = personas.crearListaPersona(5);*/
		

		
		
	// ------------------------------------------------------------------	

	
		/* 18 de Octubre del 2018 -- ACTIVIDAD: devolver la cantidad de veces que se repiten los números 
		 * en 10 veces que se genera los números aleatorios. Rango numeros 1-6
		 */
		/*int[] numerosRepetidosAleatorios = Ejercicios.generaEstadisticaAparicion(10,1,6);
		System.out.println(Arrays.toString(numerosRepetidosAleatorios));*/
				
	// ------------------------------------------------------------------	
		
					
		/* 17 de Octubre del 2018 -- ACTIVIDAD: Devolver un array con 'n' numeros aleatorios entre 
		 * 'inferior' y 'superior'. Entre 100 y 500
		 */
		/*int[] numerosAleatorios = Ejercicios.generaNumerosAleatorios(10);
		System.out.println(Arrays.toString(numerosAleatorios));*/
		
				
	// ------------------------------------------------------------------	
		
				
		// 17 de Octubre del 2018 -- ACTIVIDAD: IMPRIME POR CONSOLA n números enteros aleatorios entre 1-100
		/*int[] numerosRandom;
		numerosRandom = Ejercicios.numAleatorios(10);
		
		System.out.println(Arrays.toString(numerosRandom));*/
		
		
	// ------------------------------------------------------------------	
		
				
		// 16 de Octubre del 2018 -- ACTIVIDAD: Método Aleatorio + Array 
		/*int[] numerosRandom;
		numerosRandom = Ejercicios.numAleatorios(10);
		
		System.out.println(Arrays.toString(numerosRandom));*/
		
		
	// ------------------------------------------------------------------	
		
		
		// 16 de Octubre del 2018 -- ACTIVIDAD: Devolver el número menor de cuatro	- Con "if"
		/*int w = 6;
		int x = 4;
		int y = 1;
		int z = 8;
		
		int wxyzMenor = Ejercicios.calcularNumeroMenor(w, x, y, z);
		System.out.println("El numero menor de " + w + ", " + x + ", " + y + " y " + z + " es: " + wxyzMenor);*/
		
		
	// ------------------------------------------------------------------	
		
		
		// 11 de Octubre del 2018 -- ACTIVIDAD: Devolver el número menor de tres
		/*int[] calcularMenor = {2,1,9};
		int numeroMenor = Ejercicios.calcularNumeroMenor(calcularMenor);
		System.out.println("El numero menor de " + Arrays.toString(calcularMenor) + " es: " + numeroMenor );
		
		int xMenor = 6;
		int yMenor = 2;
		int zMenor = 8;
		
		int xyzMenor = Ejercicios.calcularNumeroMenor(xMenor, yMenor, zMenor);
		System.out.println("El numero menor de " + xMenor + ", " + yMenor + " y " + zMenor + " es: " + xyzMenor);*/
		
		
	// ------------------------------------------------------------------	
		
		
		// 11 de Octubre del 2018 -- ACTIVIDAD: Factorial de un número
		//Ejercicios.factorialNumero(0);
		
		
	// ------------------------------------------------------------------	
		
		
		// 11 de Octubre del 2018 -- ACTIVIDAD: Serie Fibonacci
		/*Random rnd = new Random();
		int posicionFibonacci = rnd.nextInt(9) + 1;*/
		
		//Ejercicios.serieFibonacci(5);	
		
		
	// ------------------------------------------------------------------
		
		
		// 10 de Octubre del 2018 -- ACTIVIDAD: Dado una “cadena” (String) devolver el valor en forma de número entero correspondiente.
		//System.out.println(Ejercicios.converString("1468"));
		
		
	// ------------------------------------------------------------------
		
		
		// 04 de Octubre del 2018 -- ACTIVIDAD: Mostrar por consola los números comprendidos entre dos enteros, a y b
		// new Ejercicios().intervaloEnteros(2, 9);
		
		
	// ------------------------------------------------------------------
		
		
		/* 04 de Octubre del 2018 -- ACTIVIDAD: BUSCAR EN LA API -------------------------------		 
		Ejercicios poo = new Ejercicios ();
		poo.pruebaAPI();
		
		new Ejercicios().pruebaAPI(); */
		

		
		
		
		
		
	}

}
