package DinamicQueue;

public class Main {
	public static void main(String[] args) {
		Queue cola= new Queue();
		cola.insert("holaaa");
		cola.insert("holaaa");
		cola.insert(3);
		cola.extract();
		System.out.println(cola.insert(2));
		System.out.println(cola.extract());
		System.out.println(cola.size());
		System.out.println(cola.isEmpty());
		cola.reverse();
		System.out.println(cola.toString());
	}
}
