package PilasDinamicas;


import ListasEnlaceDoble.LinkedList;
import ListasEnlaceDoble.LinkedListNode;

public class Stacks<T> implements StackInterface<T>{

	LinkedList top=new LinkedList();
	 
	public Stacks(Object object) {
		 top.head = new LinkedListNode(object);
	}
	public Stacks() {
		
	}

	@Override
	public void clear() {// desapila la pila y los nodos se pierden, entonces la pila queda limpia
		top.clear();
	}

	@Override
	public boolean isEmpty() {//se  verifica que este vacia la pila
		try {
			boolean vacia=false;
			if(size()<1) {
				vacia=true;
			}else {
				return false;
			}
			return vacia;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	//retorna el ultimo elemento ingresado
	@Override
	public Object peek() {//la cima de la pila sera la cola de la lista
		try {
			if(size()>=1) {
				return top.head.getObject();
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object pop() {//se elimina el ultimo elemento y se retrona el objeto
		if(size()>1) {
			return top.popHead();
		}else {
			return null;
		}
	}

	@Override
	public boolean push(Object object) {//se añade un elemento a la pila
		boolean añadido=false;
		try {
			if(object!=null) {
				top.addFirst(object);//se añade un objeto al final de la lista, en la cima de la pila
				añadido=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return añadido;
		}
	}

	@Override
	public int size() {
		int tamaño=0;
		tamaño=top.size();
		return tamaño;
	}

	@Override
	public boolean search(Object object) {
		boolean buscar=false;
		try {

			Stacks pila= new Stacks();
	
			for(int i=0; i<size();i++) {//se desapila la orginal y apila en un temporal hasta que encuentre en objeto o mientras tenga tamaño disponible
				if(peek()!=object) {
					this.pop();
					pila.push(object);
				}
			}
			for(int i = 0; i <pila.size(); i++) {
				if(peek()==object) {//si encuentra el objeto vuelve y apilar y retorna un true
					this.push(pila.peek());
					pila.pop();
					buscar=true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return buscar;
		}
	}

	@Override
	public void sort() {
		try {
		Stacks <T>pilaOrdenada=new Stacks<>();
		while(this.peek()!=null) {
			T objeto=(T) this.pop();
			situarEnOtraPila(objeto,pilaOrdenada,new Stacks<T>());//llama a un metood adicional para que sea un bucle
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void situarEnOtraPila(T objeto,Stacks<T> ordenadaTemporal,Stacks<T> PilaAux){
		try {
			if(ordenadaTemporal.peek()==null) {// la pila temporal almacenara  los objetos ordenados
				ordenadaTemporal.push(objeto);
				ordenadaTemporal.clear();
				PilaAux.clear();
			}else {
				
				if(objeto.toString().compareTo(ordenadaTemporal.peek().toString())<=0) {// compara parametro 
					ordenadaTemporal.push(objeto);
					PilaAux.clear();
				}else {
					PilaAux.push(ordenadaTemporal.pop());
					situarEnOtraPila(objeto, ordenadaTemporal, PilaAux);
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void reverse() {
		try {
			/*
			//revisar.- La pila queda vacia
			while(!isEmpty()) {
				LinkedList<Object> listaAux=new LinkedList();
				for (int i = 0; i < size(); i++) {
					listaAux.addFirst(pop());
				
			}
				top=listaAux;// la lista(con la pila como contenedor) sera iguala  la nueva lista la cual sera el revero porque se desapilo
		}
			
				*/
				// forma apilando y desapilando
				Stacks pilaTemporal= new Stacks();
				if(size()>1) {
					for (int i = 0; i < size(); i++) {//se desapila la orginal y apila inversa la temporal
						pilaTemporal.push(peek());
						this.pop();
					}
					Stacks pilaAux= new Stacks();
					for (int i = 0; i < size(); i++) {//se apila un auxiliar con el orden original y luego se desapila la temporal
						pilaAux.push(pilaTemporal.peek());
						pilaTemporal.pop();
					}
					for (int i = 0; i < size(); i++) {//se apila en inverso la pila original y se desapila la auciliar
						this.push(pilaAux.peek());
						pilaAux.pop();
					}
				}
				

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	
	@Override
	public String toString() {
		String print="";
		Stacks temporal= new Stacks();
		int size=this.size();
		print+="Stacks[  ";
		for (int i = 0; i < size; i++) {
			print+="{"+this.peek()+"} -- ";
			temporal.push(this.peek());
			this.pop();
		}
		print+=" ]";
		for (int i = 0; i < size; i++) {
			push(temporal.peek());
			temporal.pop();
		}
		return print;
	}

}
