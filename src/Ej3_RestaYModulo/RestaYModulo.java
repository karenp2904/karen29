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
				"\n1. Resta" +
				"\n2. Modulo" +
				"\nIngrese su opcion: ");
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
				listaModulo.addLast(obtenerModulo(lista1,lista2));
				System.out.println("El resultado es: " + listaModulo.getLast());


				break;
			default:
				System.out.println("Esta opcion no esta disponible");
				break;
		}
	}
	public static LinkedList restarElementos(LinkedList listaARestar){

        String[] valoresSeparados = new String[listaARestar.size()];
            for (int i = 0; i <listaARestar.size() ; i++) {
				Object temp=listaARestar.popHead();
                 valoresSeparados[i]= String.valueOf(temp);
            }

            LinkedList listaValores = new LinkedList();

            // Convertimos el array de valores a una lista enlazada...
			for (int i = 0; i <valoresSeparados.length ; i++) {
				listaValores.add(valoresSeparados[i]);
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


	
	public static QueueArray obtenerModulo(LinkedList lista1, LinkedList lista2) {

		QueueArray resultados= new QueueArray(lista1.size()+ lista2.size());

		//tamaño extensoooo
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

		//se trabajaran con arrays de colas- se convierte la lista en un array
		QueueArray arrayLista1 = new QueueArray(lista1.size());
		for (int i = 0; i <lista1.size() ; i++) {
			arrayLista1.insert(lista1.popHead());
		}
		//se trabajaran con arrays de colas- se convierte la lista en un array
		QueueArray arrayLista2 = new QueueArray(lista2.size());
		for (int i = 0; i <lista2.size() ; i++) {
			arrayLista2.insert(lista2.popHead());
		}
		LinkedListNode temporal;
		if (tamañoLista1 > tamañoLista2) {// si la lista 1 es mayor a la lista 2 entonces la lista dos divirá a la lista
			resultados=dividirListas(arrayLista1,arrayLista2);//la lista  1 sera el dividendo y la lista 2 el divisor

		} else {// caso donde la lista 1 divide a la lista 2
			resultados=dividirListas(arrayLista2,arrayLista1); // la lista 2 sera el dividendo y la lista 1 el divisor
		}


		return resultados;

	}
	//probar
	public static QueueArray dividirListas(QueueArray dividendArray, QueueArray divisorArray) {


		// Verificar si el divisor es cero
		if (divisorEsCero(divisorArray)) {
			throw new ArithmeticException("División por cero no permitida");
		}

		// Inicializar el cociente y el residuo
		QueueArray cociente = new QueueArray(dividendArray.size());
		QueueArray residuo = dividendArray;

		// Realizar la división
		for (int i = 0; i < cociente.size(); i++) {
			int divisorDigito = (int) divisorArray.extract();
			int dividendDigito = (int) residuo.extract();
			cociente.insert(dividendDigito / divisorDigito);
			residuo.insert(dividendDigito%divisorDigito);
			/*
			if (i < cociente.length - 1) {
				residuo[i+1].insert(residuo[i + 1] + (residuo[i].extract() * 10));
				//residuo[i + 1]=(residuo[i+1] + residuo[i]* 10);
			}
			*/

		}
		return residuo;

	}

	public static boolean divisorEsCero(QueueArray array) {
		for (int i = 0; i < array.size(); i++) {
			if (array.extract()!= "0") {
				return false;
			}
		}
		return true;
	}

}
