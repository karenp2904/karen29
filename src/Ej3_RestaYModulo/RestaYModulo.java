package Ej3_RestaYModulo;

import java.util.Iterator;

import ListasEnlaceDoble.LinkedList;
import ListasEnlaceDoble.LinkedListNode;
/*
Desarrollar una calculadora que permita restar y módulo de números enteros muy largos.

 */
public class RestaYModulo {
	public static void main(String[] args) {
		
	}
	public static void restarElementos(LinkedList listaARestar){

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
        }


	
	public static String obtenerModulo(LinkedList lista1, LinkedList lista2) {
		
		LinkedList resultado=new LinkedList();
		
		//Aqui se itera en la primera lista y un contador ira aumentando
		Iterator iterator1=lista1.iterator();
		LinkedListNode nodo1=(LinkedListNode) iterator1.next();
		int tamañoLista1=1;//contador de la lista 1
		while (iterator1.hasNext()) {
			nodo1=(LinkedListNode) iterator1.next();
			tamañoLista1++;
		}
		
		//Aqui se itera en la segunda lista y un contador ira aumentando
		Iterator iterator2=lista2.iterator();
		LinkedListNode nodo2=(LinkedListNode) iterator2.next();
		int tamañoLista2=1;//contador de la lista 2
		while (iterator1.hasNext()) {
			nodo2=(LinkedListNode) iterator2.next();
			tamañoLista1++;
		}
		
		LinkedListNode temporal;
		if(tamañoLista1>tamañoLista2) {// si la lista 1 es mayor a la lista 2 entonces la lista dos divirá a la lista 1
			
			for (Integer i = 1; i < tamañoLista1; i++) {
				//temporal=i*lista2.getFirst();
			}
			
		}else {// caso donde la lista 1 divide a la lista 2
			
		}
		
		
		
		
		return null;
		
	}

}
