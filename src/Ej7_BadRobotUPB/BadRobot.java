package Ej7_BadRobotUPB;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ListasEnlaceDoble.LinkedList;

public class BadRobot {
	private static final int obstaculo=1;
	private static final int espacioLibre=0;
	private static final int lugarVisitado=2;
	
	private int[][] mapa;
	private int[] inicio;
	private int[] fin;
	
	public BadRobot(int[][] mapa, int[] inicio, int[] fin) {
		super();
		this.mapa = mapa;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public LinkedList<int[]> calcularLaRuta(){
		LinkedList<int[]> rutaCreada=new LinkedList<>();
		int[] espacioActual=inicio;
		while(!Arrays.equals(espacioActual, fin)){
			rutaCreada.add(espacioActual);
			int[] siguiente=siguientePosicion(espacioActual);
			if(siguiente==null) {
				return null;
			}
			espacioActual=siguiente;
		}
		rutaCreada.add(fin);
		return rutaCreada;
	}
	public int[] siguientePosicion(int[] posicionActual) {
		LinkedList<int[]> listaCola= new LinkedList<>();
		Map<int[], int[]> mapPadres=new HashMap<>();
		listaCola.add(posicionActual);
		mapPadres.put(posicionActual, null);
		while(!listaCola.isEmpty()) {
			int[] nodoTemp=listaCola.pop();
			if(Arrays.equals(nodoTemp, fin)) {
				return actualizarRuta(mapPadres,nodoTemp);
			}
			for (int[] espacioCercano : espaciosCercanos(nodoTemp).toArray()) {
				if(mapa[espacioCercano[0]][espacioCercano[1]]==espacioLibre) {
					listaCola.add(espacioCercano);
					mapa[espacioCercano[0]][espacioCercano[1]]=lugarVisitado;
					mapPadres.put(espacioCercano, nodoTemp);
					
				}
			}
		}
		return posicionActual;//revisar el for each y el return
		
	
	}
	
	public LinkedList<int[]> espaciosCercanos(int[] nodo){
		LinkedList<int[]> espaciosCercanos=new LinkedList<>();
		int k=nodo[0];
		int l=nodo[1];
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
	
	
}
