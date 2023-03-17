package PilasDinamicas;

public class Main {
	
	public static void main(String[] args) {
		Stacks pruebas= new Stacks(1);
		
		pruebas.push("nelson");
		pruebas.push("santiago");
		pruebas.push("manuel");
		pruebas.push(2);
		pruebas.reverse();

		System.out.println(pruebas.toString());
		
	}

}

