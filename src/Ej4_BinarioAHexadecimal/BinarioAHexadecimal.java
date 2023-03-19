package Ej4_BinarioAHexadecimal;

import java.util.Scanner;

import ListasEnlaceDoble.LinkedList;

/*
 * Desarrollar una rutina para cambiar entre sistemas numéricos binario a hexadecimal y
hexadecimal a binario, utilizando la técnica de 4 bits, para números muy largos.
 */
public class BinarioAHexadecimal {
	public static void main(String[] args) {
		LinkedList listaBinario= new LinkedList("Binario");
		LinkedList listaHexadecimal= new LinkedList("Hexadecimal");
		LinkedList listaEntrada= new LinkedList("");
		System.out.println("Desarrollar una rutina para cambiar entre sistemas numéricos binario a hexadecimal y hexadecimal a binario, utilizando la técnica de 4 bits, para números muy largos.");
		int repetir=0; int opcion=0;
		
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("DISPONIBILIDAD DE FUNCIONES :)\n "
					+ "1. Convertir de binario a hexadecimal\n"
					+ "2. Convertir de hexadecimal a binario\n"
					+ "3. Desea conocer las listas de numeros \n"
					+ "Ingrese su opcion de preferencia: ");
			opcion=sc.nextInt();
			//Long numero;
			//String numeroString;
			switch (opcion) {
			
			case 1:
				do {
				System.out.println("Ingrese el numero binario: ");
				listaEntrada.addFirst(sc.next());
				}while(verificarNumeroBinario(listaEntrada.getFirst().toString()));
				
				listaHexadecimal.addFirst(convertirBinarioAHexadecimal(listaEntrada.getFirst().toString()));
				System.out.println("El numero Hexadecimal es: " + listaHexadecimal.getFirst());
				break;
				
			case 2:
				do {
					//Long numeroH;
					System.out.println("Ingrese el numero hexadecimal: ");
					listaEntrada.addFirst(sc.next());
					}while(validarNumeroHexadecimal(listaEntrada.getFirst().toString())==false);
				
				listaBinario.addFirst(convertirHexadecimalABinario(listaEntrada.getFirst().toString()));
				
				System.out.println("El numero Binario es: " + listaBinario.getFirst());
				break;
				
			case 3:
				System.out.println("\nSu lista de numeros binarios ");
				System.out.println(listaBinario.toString());
				
				System.out.println("\nSu lista de numeros Hexadecimales ");
				System.out.println(listaHexadecimal.toString());
				break;

			default:
				System.out.println("No es posible realizar este proceso");
				break;
			}
			
			System.out.println("Si desea repetir el proceso, ingrese 1");
			repetir=sc.nextInt();
			
			
		}while(repetir==1);
		
		System.out.println("Gracias :)))");
	
	}
	
	
	public static String convertirBinarioAHexadecimal(String binario) {
	    // Se declara una matriz para almacenar los valores hexadecimales
	    char[] numeroHexadecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	    
	    // Crea una cadena para almacenar el resultado de la conversión
	    String hexadecimal = "";
	    
	    // Añadi ceros a la izquierda para que la cadena de binario tenga una longitud múltiplo de 4
	    while (binario.length() % 4 != 0) {
	        binario = "0" + binario;
	    }
	    
	    // Recorrer la cadena de binario en grupos de 4 bits
	    for (int i = 0; i < binario.length(); i += 4) {
	        // Extraemos los cuatro bits de cada grupo
	        String seccionesDeBinario = binario.substring(i, i + 4);
	        
	        // Convertimos los cuatro bits en un valor hexadecimal
	        Integer valor = Integer.parseInt(seccionesDeBinario, 2);
	        
	        // Añadimos el valor hexadecimal correspondiente a la cadena resultado
	        hexadecimal += numeroHexadecimales[valor];
	    }
	    
	    // Devolvemos la cadena hexadecimal
	    return hexadecimal;
	}
	
	
	public static String convertirHexadecimalABinario(String hexadecimal) {
	    // Declaramos una matriz para almacenar los valores binarios
	    String[] binario = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
	    
	    // Creamos una cadena para almacenar el resultado de la conversión
	    String bin = "";
	    
	    // Recorremos la cadena de hexadecimal
	    for (int i = 0; i < hexadecimal.length(); i++) {
	        // Buscamos el valor binario correspondiente al dígito hexadecimal
	        char c = hexadecimal.charAt(i);
	        int valor = Character.digit(c, 16);
	        String valorBinario = binario[valor];
	        
	        // Añadimos el valor binario a la cadena resultado
	        bin += valorBinario;
	    }
	    
	    // Devolvemos la cadena binaria
	    return bin;
	}
	
	
	public static boolean verificarNumeroBinario(String numeroBinario) {
		boolean numeroValido=false;
		for (int i = 0; i < numeroBinario.length(); i++) {
	        char caracter = numeroBinario.charAt(i);
	        if (caracter != '0' && caracter != '1') {
	        	numeroValido=true;
	        	break;
	        
	        }
	    }
		return numeroValido;
		
	}
	public static boolean validarNumeroHexadecimal(String numeroHexadecimal) {
		// Expresión regular que comprueba si la cadena contiene únicamente dígitos hexadecimales
	    String patron = "[0123456789AaBbCcdDeEFf]+";

	    // Comprobamos si la cadena de entrada coincide con el patrón
	    return numeroHexadecimal.matches(patron);
	}
	
	
	
	
	
	
	
	
	
	
	
	//Metodos cuando hacia conversion Binario-Decimal-Hexadecimal y viceversa

	public static int conventirHexaADecimal(String numeroHexadecimal){
		final String digitosValidos="0123456789ABCDEF";// caracteres permitidos en sistema numerico hexadecimal
		numeroHexadecimal=numeroHexadecimal.toUpperCase();
		
		int numeroDecimal=0;
		for (int i = 0; i < numeroHexadecimal.length(); i++) {
			char caracter= numeroHexadecimal.charAt(i);
			int digito= digitosValidos.indexOf(caracter);
			
			numeroDecimal=16*numeroDecimal+digito;
	
	}
		return numeroDecimal;
	
	
	}
	

	public static String convertirDecimalAHexadecimal(Object numeroooDecimal) {
		int residuo;
		String hexadecimal = "" ;
		char[] hexadecimales= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		Long numeroDecimal=Long.parseLong(numeroooDecimal.toString());
		while(numeroDecimal>0) {
			residuo=(int) (numeroDecimal%16);
			char NumerosHexadecimales= hexadecimales[residuo];
			hexadecimal=NumerosHexadecimales+hexadecimal;
	
			numeroDecimal=numeroDecimal/16;
		
		}

		return hexadecimal;
	}
	
	public static Long convertirBinarioADecimal(String numeroBinario) {
        
        char[] arrayBinario = numeroBinario.toCharArray();// El binario ingresara como string entonces se definara un arreglo para su conversion

        int valorDecimal = 0;

        for (int i = arrayBinario.length - 1; i >= 0; i--) {//se usara el metodo de recorrer de derecha a izquiereda
            if (arrayBinario[i] == '1') {
                valorDecimal += Math.pow(2, arrayBinario.length - 1 - i);// para pasar de binario a decial se hace con base 2 y elevaciones segun el numero de digitos que contenga inicando desde el cero
            }
        }
        Long decimal=(long) valorDecimal;
        return decimal;
    }

	public static String convertirDecimalABinario(int Decimal) {
        String numeroBinario = "";// variable retornada
        while (Decimal != 0) { // el numero decimal se ira reduciendo
            numeroBinario = (Decimal % 2) + numeroBinario;
            Decimal /= 2; // se divide el decimal de forma que en binarios se maneja 0000 y asi por cada secuencia se ira almacenando un numero deciaml con su corresppondiente binario
        }
        if (numeroBinario.equals("")) {// cuando el decimal ya no tenga numero
            numeroBinario = "0";
        }
        return numeroBinario;
    }


}
