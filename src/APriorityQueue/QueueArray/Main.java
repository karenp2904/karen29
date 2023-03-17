package APriorityQueue.QueueArray;

import QueueArray.QueueArray;

public class Main {
	public static void main(String[] args) {
		QueueArray array= new QueueArray(20);
		array.insert("Buenasss");
		array.insert(9);
		array.insert("Holaaaa");
		array.insert(8);
		array.insert(7);
		array.insert(555);
		//System.out.println(array.extract());
		System.out.println("Cola normal ");
		System.out.println(array.toString());
		
		System.out.println("\nCola con 1 elemento menos ");
		System.out.println(array.extract());
		System.out.println(array.toString());
		//System.out.println(array.search(9));
		
	}
	

}
