package Ej3_RestaYModulo;

import java.util.Iterator;
import java.util.Scanner;

import ListasEnlaceDoble.LinkedList;
import ListasEnlaceDoble.LinkedListNode;
import QueueArray.QueueArray;

/*
Desarrollar una calculadora que permita restar y módulo de números enteros muy largos.

 */
public class RestaYModulo {
	public static void main(String[] args) {
		LinkedList<Integer> lista1=new LinkedList();
		LinkedList<Integer> lista2= new LinkedList<>();
		int opcion;
		Scanner sc= new Scanner(System.in);

		System.out.println("Opciones disponibles" +
				"1. Resta" +
				"2. Modulo" +
				"Ingrese su opcion: ");
		opcion= sc.nextInt();

		switch (opcion){
			case 1:
				int cantidad;
				System.out.println("Ingrese la cantidad de numeros a restar: ");
				cantidad= sc.nextInt();
				for (int i = 1; i <=cantidad ; i++) {
					System.out.println("Ingrese el numero: " +i+"-");
					lista1.add(sc.nextInt());
				}
				LinkedList listaResultado=new LinkedList<>();
				listaResultado.add(restarElementos(lista1)) ;
				System.out.println("El resultado es: "+ listaResultado.getLast());
				break;
			case 2:
				System.out.println("Ingrese la cantidad de los numeros de la primera lista");
				cantidad=sc.nextInt();
				for (int i = 0; i <cantidad ; i++) {
					System.out.println("Ingrese el numero: ");
					lista1.addLast(sc.nextInt());
				}
				System.out.println("Ingrese la cantidad de los numeros de la segunda lista");
				cantidad=sc.nextInt();
				for (int i = 0; i <cantidad ; i++) {
					System.out.println("Ingrese el numero: ");
					lista2.addLast(sc.nextInt());
				}
				LinkedList listaModulo=new LinkedList<>();
				System.out.println("El resultado es: ");


				break;
			default:
				System.out.println("Esta opcion no esta disponible");
				break;
		}
	}
	public static LinkedList restarElementos(LinkedList listaARestar){

        String[] valoresSeparados = new String[0];
            for (int i = 0; i <listaARestar.size() ; i++) {
                 valoresSeparados[i]= listaARestar.pop().toString();
            }

            LinkedList listaValores = new LinkedList();

            // Convertimos el array de valores a una lista enlazada...
            for (String valor : valoresSeparados) {
                int valorEntero = Integer.parseInt(valor);
                listaValores.add(valorEntero);
            }

            // Restamos los valores de la lista enlazada...
            LinkedListNode actual = listaValores.head;
            LinkedListNode actualValores = listaValores.head;

            int temporal; int auxiliarLista;
            while (actual != null && actualValores != null) {
                temporal= (int) actual.getObject();// será el que tendra el valor entero del actual
                auxiliarLista= (int) actualValores.getObject();// será el que tendra el valor entero de la lsita de valores
                actual.setObject(temporal-auxiliarLista);
                actual = actual.getNext();
                actualValores = actualValores.getNext();
            }
			return listaValores;
        }


	
	public static String obtenerModulo(LinkedList lista1, LinkedList lista2) {

		LinkedList resultado = new LinkedList();

		//Aqui se itera en la primera lista y un contador ira aumentando
		Iterator iterator1 = lista1.iterator();
		LinkedListNode nodo1 = (LinkedListNode) iterator1.next();
		int tamañoLista1 = 1;//contador de la lista 1
		while (iterator1.hasNext()) {
			nodo1 = (LinkedListNode) iterator1.next();
			tamañoLista1++;
		}

		//Aqui se itera en la segunda lista y un contador ira aumentando
		Iterator iterator2 = lista2.iterator();
		LinkedListNode nodo2 = (LinkedListNode) iterator2.next();
		int tamañoLista2 = 1;//contador de la lista 2
		while (iterator1.hasNext()) {
			nodo2 = (LinkedListNode) iterator2.next();
			tamañoLista1++;
		}

		LinkedListNode temporal;
		if (tamañoLista1 > tamañoLista2) {// si la lista 1 es mayor a la lista 2 entonces la lista dos divirá a la lista 1

			for (Integer i = 1; i < tamañoLista1; i++) {
				//temporal=i*lista2.getFirst();
			}

		} else {// caso donde la lista 1 divide a la lista 2

		}


		return null;

	}
	//probar
	public static QueueArray[] divideLongNumbers(QueueArray[] dividendArray, QueueArray[] divisorArray) {


		// Verificar si el divisor es cero
		if (isZero(divisorArray)) {
			throw new ArithmeticException("División por cero no permitida");
		}

		// Inicializar el cociente y el residuo
		int[] quotient = new int[dividendArray.length];
		QueueArray[] remainder = dividendArray;

		// Realizar la división
		for (int i = 0; i < quotient.length; i++) {
			int divisorDigit = (int) divisorArray[0].extract();
			int dividendDigit = (int) remainder[i].extract();
			quotient[i] = dividendDigit / divisorDigit;
			remainder[i].insert(dividendDigit%divisorDigit);
			if (i < quotient.length - 1) {
				//remainder[i + 1]=(remainder[i+1] + remainder[i]* 10);
			}
		}
		return remainder;

	}

	public static int[] convertStringToArray(String number) {
		int[] array = new int[number.length()];
		for (int i = 0; i < number.length(); i++) {
			array[i] = Character.getNumericValue(number.charAt(i));
		}
		return array;
	}

	public static String convertArrayToString(int[] array) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			builder.append(array[i]);
		}
		return builder.toString();
	}

	public static boolean isZero(QueueArray[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].extract()!= "0") {
				return false;
			}
		}
		return true;
	}

}
