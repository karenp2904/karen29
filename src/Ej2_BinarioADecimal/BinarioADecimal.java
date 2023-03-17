package Ej2_BinarioADecimal;

import java.math.BigInteger;
import java.util.Scanner;

import ListasEnlaceDoble.LinkedList;


public class BinarioADecimal {
	public static void main(String[] args) {
		LinkedList listaBinario= new LinkedList("Binario");
		LinkedList listaDecimal= new LinkedList("Hexadecimal");
		LinkedList listaEntradas=new LinkedList("Entradas");
		
		
		System.out.println("Desarrollar una rutina para cambiar entre sistemas numéricos binario a hexadecimal y hexadecimal a binario, utilizando la técnica de 4 bits, para números muy largos.");
		int repetir=0; int opcion=0;
		
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("DISPONIBILIDAD DE FUNCIONES :)\n "
					+ "1. Convertir de binario a Decimal\n"
					+ "2. Convertir de Decimal a binario\n"
					+ "3. Desea conocer las listas de numeros ??\n"
					+ "Ingrese su opcion de preferencia: ");
			opcion=sc.nextInt();
			Long numero;
			String numeroString;
			
			switch (opcion) {
			
			case 1:
				do {
					System.out.println("Ingrese el numero binario: ");
					listaEntradas.addFirst(sc.next());//guarda el numero ingresad0
				
				}while(verificarNumeroBinario(listaEntradas.getFirst().toString()));
				
				listaDecimal.addFirst(convertirBinarioADecimal(listaEntradas.getFirst().toString()));
				System.out.println("El numero Decimal es: " + listaDecimal.getFirst());
				 
				break;
				
			case 2:
				boolean valorValido=false; Long numeroD; String decimalS; 
				do {
					System.out.println("Ingrese el numero Decimal: ");
					listaEntradas.addFirst(sc.next());
					decimalS=listaEntradas.getFirst().toString();// se convierte a string para verificacion
					if(decimalS.contains("ABCDEFGHIJKLMNOPQRSTVUXYZabcdefghijklmnoqprstvuxyz")) {
						valorValido=true;// el valor valido sera el que indique cuando repetir el ciclo de volver  ssolicitar numero
					}
				}while(valorValido);
				
				listaBinario.addFirst(convertirDecimalABinario(listaEntradas.getFirst().toString()));
				 System.out.println("El numero binario es: " + listaBinario.getFirst());
				
				break;
				
			case 3:
				System.out.println("\nSu lista de numeros binarios ");
				System.out.println(listaBinario.toString());
				
				System.out.println("\nSu lista de numeros Decimales ");
				System.out.println(listaDecimal.toString());
				break;

			default:
				System.out.println("No es posible realizar este proceso");
				break;
			}
			
			System.out.println("\nSi desea repetir el proceso, ingrese 1");
			repetir=sc.nextInt();
			
		}while(repetir==1);// cuando repetir sea 1, vuelve e inicia el proceso
		
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
	
	public static String convertirBinarioADecimal(String numeroBinario) {
        
		char[] arrayBinario = numeroBinario.toCharArray();// El binario ingresara como string entonces se definara un arreglo para su conversion

        int valorDecimal = 0;

        for (int i = arrayBinario.length - 1; i >= 0; i--) {//se usara el metodo de recorrer de derecha a izquiereda
            if (arrayBinario[i] == '1') {
                valorDecimal += Math.pow(2, arrayBinario.length - 1 - i);// para pasar de binario a decial se hace con base 2 y elevaciones segun el numero de digitos que contenga inicando desde el cero
            }
        }
        String decimal=String.valueOf(valorDecimal);
        return decimal;
    }

	public static String convertirDecimalABinario(String decimal) {
		 // Parsear el string decimal como un BigInteger
        BigInteger decimalNum = new BigInteger(decimal);

        // Crear un string vacío para almacenar el número binario
        String binary = "";

        // Realizar divisiones sucesivas del número decimal entre 2
        while (decimalNum.compareTo(BigInteger.ZERO) > 0) {
            // Guardar el residuo de la división en el string binario
            binary += decimalNum.mod(BigInteger.valueOf(2)).toString();
            // Dividir el número decimal entre 2
            decimalNum = decimalNum.divide(BigInteger.valueOf(2));
        }

        // Invertir el string binario para obtener el número en el orden correcto
        binary = new StringBuilder(binary).reverse().toString();

        // Retornar el número binario resultante
        return binary;
		}
}
