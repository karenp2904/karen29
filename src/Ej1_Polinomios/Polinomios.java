package Ej1_Polinomios;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

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
	 public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         System.out.println("Ingrese el primer polinomio separando los coeficientes por coma: ");
         String[] input1 = sc.nextLine().split(",");
         QueueArray[] polinomio1 = new QueueArray[input1.length];
         for (int i = 1; i <input1.length ; i++) {
             String coef = null;
             polinomio1[i].insert( Integer.parseInt(coef.trim()));
         }

         System.out.println("Ingrese el segundo polinomio separando los coeficientes por coma: ");
         String[] input2 = sc.nextLine().split(",");
         QueueArray[] polinomio2 = new QueueArray[input2.length];
         for (int i = 1; i <input2.length ; i++) {
             String coef = null;
             polinomio2[i].insert( Integer.parseInt(coef.trim()));
         }

         System.out.println("Ingrese la operación a realizar:" +
                 "1. Evaluar." +
                 "2. Derivar." +
                 "3. Restar. ");
         int operacion = Integer.parseInt(sc.nextLine().trim());

         sc.close();

         switch (operacion) {
             case 1:
                 LinkedList a= new LinkedList<>();
                 LinkedList b= new LinkedList<>();
                 System.out.println("Ingrese el valor de a: ");
                 a.add(sc.nextInt());
                 System.out.println("Ingrese el valor de b: ");
                 b.add(sc.nextInt());
                 //sc.nextLine();
                 LinkedList result1 = evaluarPolinomio(polinomio1, a,b);
                 LinkedList result2 = evaluarPolinomio(polinomio2, a,b);
                 System.out.println("El resultado de evaluar el primer polinomio es: " + result1);
                 System.out.println("El resultado de evaluar el segundo polinomio es: " + result2);
                 break;
             case 2:
                 QueueArray[] resultado1 = derivarPolinomio(polinomio1);
                 QueueArray[] resultado2 = derivarPolinomio(polinomio2);
                 System.out.println("El resultado de derivar el primer polinomio es: " + resultado1);
                 System.out.println("El resultado de derivar el segundo polinomio es: " + resultado2);
                 break;
             case 3:
                 QueueArray[] resultadoSuma = restarPolinomio(polinomio1, polinomio2);
                 System.out.println("El resultado de restar los polinomios es: " + resultadoSuma);
                 break;
             default:
                 System.out.println("Operación no válida.");
         }
     }


    public static QueueArray[] restarPolinomio(QueueArray[] polinomio1, QueueArray[] polinomio2) {
        int tamaño1 = polinomio1.length;
        int tamaño2 = polinomio2.length;
        int n = Math.max(tamaño1, tamaño2);
        QueueArray[] resultado = new QueueArray[n];
        for (int i = 0; i < n; i++) {
            Object coef1 = (i < tamaño1) ? polinomio1[i] : 0;
            Object coef2 = (i < tamaño2) ? polinomio2[i] : 0;
            Integer coeficiente1=Integer.parseInt((String) coef1);
            Integer coeficiente2=Integer.parseInt((String) coef2);
            resultado[i].insert(coeficiente1 - coeficiente2);
        }
        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(Arrays.toString(resultado));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static QueueArray[] derivarPolinomio(QueueArray[] polinomio) {
        int n = polinomio.length;
        QueueArray[] resultado = new QueueArray[n - 1];
        for (int i = 0; i < n - 1; i++) {
            Integer valor= (Integer) polinomio[i].extract();
            resultado[i].insert(valor * (n - i - 1));
        }
        try {
            FileWriter writer = new FileWriter("/src/Ej1_Polinomios/ResultadoDerivada.txt");
            String derivada="";
            for (int i = 0; i <resultado.length ; i++) {
                derivada+=resultado[i].extract();
            }
            writer.write((derivada));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static LinkedList<Integer> evaluarPolinomio(QueueArray[] polinomio, LinkedList<Integer> a, LinkedList<Integer> b) {
        int n = polinomio.length;
        double suma = 0; Integer valorDeB = null;Integer valorDeA = null;
        for (int i = 0; i < n; i++) {
            Integer valorActual= (Integer) polinomio[i].extract();
            valorDeA=a.getLast();
            valorDeB=a.getLast();
            suma += valorActual * ((Math.pow(valorDeB, n - i)) - (Math.pow(valorDeA, n - i)));
        }
        LinkedList<Integer> resultado= new LinkedList<>();
        resultado.addLast((int) (suma/ (n * (valorDeB - valorDeA))));
        try {
            FileWriter writer = new FileWriter("Resultado.txt");
            String evaluar="";
            while (resultado.size()!=0){
                evaluar+=resultado.pop();
            }
            writer.write(evaluar);
            writer.close();
            return resultado;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
