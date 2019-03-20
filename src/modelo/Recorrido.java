package modelo;

import java.io.File;

public class Recorrido {
    private static int numDir;

    public static void main(String[] args) {
        try {

        	numDir = 0;
            String identar = "";
            walkin(new File("C:\\Users\\Jordan"), identar); // Directorio raíz, modificar para pruebas..
            System.out.println("\nSe han encontrado: " + numDir + " directorios");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void walkin(File dir, String identar ) {

        File listFile[] = dir.listFiles();
        
        if (listFile != null && listFile.length > 0) {
        	
            for (File file : listFile) {
                if (file.isDirectory()) {
                	System.out.println(identar + file.getName());
                	identar += "     ";
                    walkin(file, identar);
            	} else {
            		numDir++;
            		System.out.print(identar +"|   --> "+ file.getName() + "\n"); // Por Debug, pare ver los directorios que va encontrando.
            	}
            }
            
        }
    }
}