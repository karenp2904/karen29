package Ej7_BadRobotUPB;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ListasEnlaceDoble.LinkedList;
import QueueArray.QueueArray;

public class BadRobot {
	private static final int obstaculo=1;
	private static final int espacioLibre=0;
	private static final int lugarVisitado=2;
	
	private QueueArray[] mapa;
	private QueueArray[] inicio;
	private QueueArray[] fin;
	/*
	public BadRobot(int[][] mapa, QueueArray[] inicio, QueueArray[] fin) {
		super();
		this.mapa = mapa;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public LinkedList<QueueArray[]> calcularLaRuta(){
		LinkedList<QueueArray[]> rutaCreada=new LinkedList<>();
		QueueArray[] espacioActual=inicio;
		while(!Arrays.equals(espacioActual, fin)){
			rutaCreada.add(espacioActual);
			QueueArray[] siguiente=siguientePosicion(espacioActual);
			if(siguiente==null) {
				return null;
			}
			espacioActual=siguiente;
		}
		rutaCreada.add(fin);
		return rutaCreada;
	}
	public QueueArray[] siguientePosicion(QueueArray[] posicionActual) {
		LinkedList<QueueArray[]> listaCola= new LinkedList<>();
		Map<QueueArray[], QueueArray[]> mapPadres=new HashMap<>();
		listaCola.add(posicionActual);
		mapPadres.put(posicionActual, null);
		while(!listaCola.isEmpty()) {
			QueueArray[] nodoTemp=listaCola.pop();
			if(Arrays.equals(nodoTemp, fin)) {
				return actualizarRuta(mapPadres,nodoTemp);
			}
			for (QueueArray[] espacioCercano : espaciosCercanos(nodoTemp).toArray()) {
				if(mapa[espacioCercano[0]][espacioCercano[1]]==espacioLibre) {
					listaCola.add(espacioCercano);
					mapa[espacioCercano[0]][espacioCercano[1]]=lugarVisitado;
					mapPadres.put(espacioCercano, nodoTemp);
					
				}
			}
		}
		return posicionActual;//revisar el for each y el return
		
	
	}
	
	public LinkedList<QueueArray[]> espaciosCercanos(QueueArray[] nodo){
		LinkedList<int[]> espaciosCercanos=new LinkedList<>();
		QueueArray k=nodo[0];
		QueueArray l=nodo[1];
		if(k>0) {
			espaciosCercanos.add(new int[] {
					k--,l
			});
		}
		if(l>0) {
			espaciosCercanos.add(new int[] {
					k,l--
			});
		}
		if (k<mapa.length-1) {
			espaciosCercanos.add(new int[] {
					k++,l
			});
		}
		if (l<mapa.length-1) {
			espaciosCercanos.add(new int[] {
					k,l++
			});
		}
		
		return espaciosCercanos;
	}
	public int[] actualizarRuta(Map<int[], int[]> mapPadres, int[] nodo) {
		LinkedList<int[]> rutaNueva=new LinkedList<>();
		while(nodo!=null) {
			rutaNueva.add(nodo);
			nodo=mapPadres.get(nodo);
		}
		Collections.reverse((List<?>)rutaNueva);
		rutaNueva.remove(nodo);
		return nodo;
	}
	
	*/
}
