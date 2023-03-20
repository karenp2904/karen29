package Ej1_Polinomios;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

import DinamicQueue.Queue;
import ListasEnlaceDoble.LinkedList;
import QueueArray.QueueArray;

public class Polinomios {
	
	/*
	 * La comunidad de científicos locos tiene grandes cantidades de datos en archivos de caracteres.
Cada archivo representa un polinomio de grado n. Por Ejemplo: 12x^5+3x^3-x+6 es
representado como: <6, -1, 0, 3, 0, 12> Los científicos quieren aplicar operaciones entre ellos.
Pero se han encontrado con la dificultad que no pueden cargar los datos en ningún tipo de dato
disponible en el lenguaje de programación. Por lo tanto, le solicitan que por favor desarrolle
funciones con la capacidad para gestionar la cantidad de datos. Entre ellas, restar polinomios,
derivar un polinomio y evaluar un polinomio en un intervalo x = (a, b]. la salida debería ser un
archivo de resultados result.txt. 
	 */
	 public static void main(String[] args) throws IOException {
         Scanner sc = new Scanner(System.in);

         InputStreamReader streamReader = new InputStreamReader(System.in);
         BufferedReader bufferedReader = new BufferedReader(streamReader);

         int agregar;

         System.out.println("Polinomio 1\n");
         QueueArray polinomio1=new QueueArray(10000);
         do {
             System.out.println("Ingrese indice del polinomio: ");
             int numero = Integer.valueOf(bufferedReader.readLine());

             polinomio1.insert(numero);

             System.out.println("si desea agregar mas numeros al polinomio presione 1: ");
             agregar = Integer.parseInt(bufferedReader.readLine());

         } while (agregar == 1);

         System.out.println("Polinomio 2\n");

         QueueArray polinomio2=new QueueArray(100000);
         do {
             System.out.println("Ingrese indice del polinomio: ");
             int numero = Integer.valueOf(bufferedReader.readLine());

             polinomio2.insert(numero);

             System.out.println("si desea agregar mas numeros al polinomio presione 1: ");
             agregar = Integer.parseInt(bufferedReader.readLine());

         } while (agregar == 1);


         /*
         do {
             System.out.println("Ingrese indice del polinomio: ");
             int numero = Integer.valueOf(bufferedReader.readLine());

             polinomio1.insert(numero);

             System.out.println("si desea agregar mas numeros al polinomio presione 1: ");
             agregar = Integer.parseInt(bufferedReader.readLine());
         } while (agregar == 1);

         System.out.println("Polinomio 2\n");
         Queue polinomio2 = new Queue();
         do {
             System.out.println("Ingrese indice del polinomio: ");
             int numero = Integer.valueOf(bufferedReader.readLine());

             polinomio2.insert(numero);

             System.out.println("si desea agregar mas numeros al polinomio presione 1: ");
             agregar = Integer.parseInt(bufferedReader.readLine());
         } while (agregar == 1);

          */
/*
         QueueArray[] polinimio2Array=new QueueArray[polinomio2.size()];int i=0;
         while (!polinomio2.isEmpty()) {
             Integer elemento = (Integer) polinomio2.extract();
             if (elemento!=null){
                 polinimio2Array[i].insert(elemento);
                 i++;
             }

         }
         QueueArray[] polinimio1Array=new QueueArray[polinomio1.size()];int k=0;
         while (!polinomio1.isEmpty()) {
             Integer elemento = (Integer) polinomio1.extract();
             if (elemento!=null){
                 polinimio1Array[k].insert(elemento);
                 k++;
             }
         }

 */

         System.out.println("Ingrese la operación a realizar:" +
                 "\n1. Evaluar." +
                 "\n2. Derivar." +
                 "\n3. Restar. ");
         int operacion = Integer.parseInt(sc.nextLine().trim());



         switch (operacion) {

             case 1:
                 Scanner scanner=new Scanner(System.in);
                 LinkedList a= new LinkedList<>(0);
                 LinkedList b= new LinkedList<>(0);
                 System.out.println("Ingrese el valor de a: ");
                 String valorA = scanner.next();
                 a.add(valorA);
                 System.out.println("Ingrese el valor de b: ");
                 String valorB =scanner.next();
                 b.add(valorB);
                 //sc.nextLine();
                 Object result1 = evaluarPolinomio(polinomio1, a,b);
                 Object result2 = evaluarPolinomio(polinomio2, a,b);
                 System.out.println("El resultado de evaluar el primer polinomio es: " + result1.toString());
                 System.out.println("El resultado de evaluar el segundo polinomio es: " + result2.toString());
                 break;
             case 2:
                 QueueArray resultado1 = derivarPolinomio(polinomio1);
                 QueueArray resultado2 = derivarPolinomio(polinomio2);
                 System.out.println("El resultado de derivar el primer polinomio es: " + resultado1);
                 System.out.println("El resultado de derivar el segundo polinomio es: " + resultado2);
                 break;
             case 3:
                 QueueArray resultadoSuma = restarPolinomio(polinomio1, polinomio2);
                 System.out.println("El resultado de restar los polinomios es: " + resultadoSuma);
                 break;
             default:
                 System.out.println("Operación no válida.");
         }
     }


    public static QueueArray restarPolinomio(QueueArray polinomio1, QueueArray polinomio2) {
        int tamaño1 = polinomio1.size();
        int tamaño2 = polinomio2.size();
        int n = Math.max(tamaño1, tamaño2);
        QueueArray resultado = new QueueArray(n);
        for (int i = 0; i < n; i++) {
            Object coef1 = (i < tamaño1) ? polinomio1.extract() : 0;
            Object coef2 = (i < tamaño2) ? polinomio2.extract() : 0;
            Integer coeficiente1=Integer.parseInt(String.valueOf(coef1));
            Integer coeficiente2=Integer.parseInt(String.valueOf(coef2));
            resultado.insert(coeficiente1 - coeficiente2);
        }
        try {
            FileWriter writer = new FileWriter("src/Ej1_Polinomios/ResultadoRestar.txt");
            String guardar="";
            while (resultado.size()==0){
                guardar+=resultado.extract();
            }
            writer.write(guardar);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static QueueArray derivarPolinomio(QueueArray polinomio) {
        int n = polinomio.size();
        QueueArray resultado = new QueueArray(n-1);
        for (int i = 0; i < n - 1; i++) {
            Integer valor= (Integer) polinomio.extract();
            resultado.insert(valor * (n - i - 1));
        }
        try {
            FileWriter writer = new FileWriter("src/Ej1_Polinomios/ResultadoDerivada.txt");
            String derivada="";
            for (int i = 0; i <resultado.size() ; i++) {
                derivada+=resultado.extract();
            }
            writer.write((derivada));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static String evaluarPolinomio(QueueArray polinomio, LinkedList<Integer> a, LinkedList<Integer> b) {
        int n = polinomio.size();
        double suma = 0;  String evaluar = "";
        Integer valorDeB = null;
        Integer valorDeA = null;
        valorDeA = Integer.parseInt(String.valueOf(a.getLast()));
        valorDeB = Integer.parseInt(String.valueOf(b.getLast()));

        for (int i = 0; i < n; i++) {
            Integer valorActual = (Integer) polinomio.extract();
            suma += valorActual * ((Math.pow(valorDeB, n - i)) - (Math.pow(valorDeA, n - i)));
        }
        LinkedList<Integer> resultado = new LinkedList<>();
        resultado.addFirst((int) (suma / (n * (valorDeB - valorDeA))));
        try {
            FileWriter writer = new FileWriter("src/Ej1_Polinomios/ResultadoEvaluar.txt");

            while (resultado.size() != 0) {
                evaluar += resultado.popHead();

            }
            writer.write(evaluar);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return evaluar;
    }
}
