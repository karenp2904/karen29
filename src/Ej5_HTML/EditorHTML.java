package Ej5_HTML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ListasEnlaceDoble.LinkedList;
import ListasEnlaceDoble.LinkedListNode;
import ListasEnlaceDoble.Node;
import PilasDinamicas.Stacks;

public class EditorHTML {
	
	

	public static void main(String[] args) {
		  String archivoHTML = "src/Ej5_HTML/ArchivoHTML"; // Ruta del archivo a validar
	      //validarEtiquetas(archivoHTML);
	      
		  boolean esValido = validarHTML(archivoHTML);
		     if (esValido){
		         System.out.println("Es valido, el archivo HTML se encuentra con todas las eqtiquetas");
		     }
		     else{
		         System.out.println("Error: El archivo HTML contiene errores de etiquetas.");
		     }
	
	}
 
	public static boolean validarHTML(String archivo) {///Valida el HTML
     String contenido = extraerContenidoHTML(archivo); // se extrae el contenido del archivo
     try{
         BufferedReader br = new BufferedReader(new FileReader(archivo));
         String linea;
         while ((linea = br.readLine()) != null)
         {
             contenido += linea;
         }
         br.close();
     }
     catch (IOException e){
         System.out.println("Error al leer el archivo: " + e.getMessage());
         return false;
     }

     Stacks<String> pilaEtiquetas = new Stacks<>();

     for (int i = 0; i < contenido.length(); i++){
         char caracterApertura = contenido.charAt(i);
         if (caracterApertura == '<') {
             String etiqueta = "";
             int j = i + 1;
             while (j < contenido.length() && contenido.charAt(j) != '>') {
                 etiqueta += contenido.charAt(j);
                 j++;
             }
             if (etiqueta.charAt(0) == '/') { // Etiqueta de cierre
                 etiqueta = etiqueta.substring(1);

                 if (!pilaEtiquetas.isEmpty()) {
                     System.out.println("Error: "
                     		+ "\n" + etiqueta + " no tiene una etiqueta de apertura.");
                     return false;
                 }else{
                     String etiquetaApertura = (String) pilaEtiquetas.pop();
                     if (!etiqueta.equals(etiquetaApertura)) {
                         System.out.println("Error: "
                         		+ "\n" + etiquetaApertura + " no tiene una etiqueta de cierre.");
                         return false;
                     }
                 }
             } else { // Etiqueta de apertura
                 pilaEtiquetas.push(etiqueta);
             }
         }
     }

     if (!pilaEtiquetas.isEmpty())
     {
         System.out.println("Error: Hay etiquetas de apertura que no tienen su correspondiente etiqueta de cierre.");
         return false;
     }

     System.out.println("Termino el proceso");
     return true;
 }
 
 public static String extraerContenidoHTML(String archivo){
     StringBuilder contenido = new StringBuilder();
     try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
         String linea;
         while ((linea = br.readLine()) != null) {
             contenido.append(linea);
         }
     } catch (IOException e) {
         System.out.println("Error al leer el archivo: " + e.getMessage());
     }
     return contenido.toString();
 }

	
	 public static void validarEtiquetas(String nombreArchivo) {
	        try {
	            Scanner scanner = new Scanner(new File(nombreArchivo));
	            Stacks<String> pilaEtiquetas = new Stacks<String>();
	            int lineaActual = 0;
	            while (scanner.hasNextLine()) {
	                String linea = scanner.nextLine().trim();
	                if (linea.startsWith("<")) {
	                    int indiceEspacio = linea.indexOf(" ");
	                    int indiceCierre = linea.indexOf(">");
	                    String etiqueta = "";
	                    if (indiceEspacio == -1) {
	                        etiqueta = linea.substring(1, indiceCierre);
	                    } else {
	                        etiqueta = linea.substring(1, indiceEspacio);
	                    }
	                    if (!etiqueta.startsWith("/")) {
	                        pilaEtiquetas.push(etiqueta);
	                    } else {
	                        etiqueta = etiqueta.substring(1);
	                        if (pilaEtiquetas.isEmpty()) {
	                            System.out.println("Error de sintaxis en línea (" + lineaActual + ") : etiqueta de cierre -" + etiqueta + "- sin etiqueta de apertura correspondiente.");
	                        } else if (!pilaEtiquetas.pop().equals(etiqueta)) {
	                            System.out.println("Error de sintaxis en línea (" + lineaActual + ") : etiqueta de cierre -" + etiqueta + "- no coincide con la etiqueta de apertura correspondiente.");
	                        }
	                    }
	                }
	                lineaActual++;
	            }
	            if (!pilaEtiquetas.isEmpty()) {
	                System.out.println("Error de sintaxis: hay etiquetas de apertura sin etiqueta de cierre correspondiente.");
	            } else {
	                System.out.println("Todas las etiquetas del archivo " + nombreArchivo + " están correctamente cerradas.");
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Error: no se pudo abrir el archivo " + nombreArchivo + ".");
	        }
	    }

}
