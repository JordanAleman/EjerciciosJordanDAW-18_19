package modelo;

import java.io.File;

public class Recorrido2 {

    public static void main(String[] args) {
        File inputFolder = new File("C:\\Users\\Jordan\\Documents");
        recorrerArchivos(inputFolder, "");
    }

    public static void recorrerArchivos(File parentNode, String identar) {
        if (parentNode.isDirectory()) {
            System.out.println(identar + parentNode.getName());

            identar += "     ";

            File childNodes[] = parentNode.listFiles();
            for (File childNode : childNodes) {
            	recorrerArchivos(childNode, identar);
            }
        } else {

            System.out.println(identar +"|   --> "+ parentNode.getName());

        }
    }
}
