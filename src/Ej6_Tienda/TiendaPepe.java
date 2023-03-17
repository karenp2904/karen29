package Ej6_Tienda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import ListasEnlaceDoble.LinkedListNode;
import ListasEnlaceDoble.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import APriorityQueue.PriorityQueue;
import ListasEnlaceDoble.LinkedList;

/*
 * La tienda de pepe el vendedor está desarrollando un sistema de pedidos es línea, donde los
pedidos se reciben en tiempo real y se deben procesar en el siguiente orden: los pedidos de
mayor importancia la van ganando por llegar primero. Además, depende del tipo de clientes (en
orden: premium, normal y promo). Los pedidos tienen los siguientes atributos: id, fecha y hora
de recepción, id del cliente, nivel de importancia y descripción del pedido. Usted es contratado
para crear una funcionalidad que permita determinar el orden de entrega de los pedidos.
Nota: La entrada y salida es por archivo de texto
 */
public class TiendaPepe {

	static LocalDateTime hora=LocalDateTime.now();
			// si es cliente premium sera prioridad 0, cliente normal 1, cliente promo a 2
	public static void main(String[] args) throws FileNotFoundException {
		LinkedList listaArchivo = new LinkedList();

		PriorityQueue<Pedido> prioridadPedidos = new PriorityQueue(3);

		Pedido PedidoDeArchivo = new Pedido("1111", "13", "11", "premium", "Salchipapa");//pedido de prueba
		String rutaArchivo = "src/Ej6_Tienda/archivoPedido.txt";
		// crearArchivo("rutaArchivo", PedidoDeArchivo);


		//Crear el archivo
		try {
			// Definir la ruta y el nombre del archivo de texto
			// String rutaArchivo = "src/Ej6_Tienda/archivoPedido.txt";
			// Crear un objeto File para el archivo de texto
			File archivo = new File(rutaArchivo);

			// Crear un objeto FisleWriter para escribir en el archivo
			FileWriter escritor = new FileWriter(archivo);

			// Escribir el contenido en el archivo

			escritor.write("idCliente:" + PedidoDeArchivo.getIdCliente());
			escritor.write("\n");
			escritor.write("FechaRecepcion:" + PedidoDeArchivo.getFecha());
			escritor.write("\n");
			escritor.write("HoraRecepcion:" + PedidoDeArchivo.getHora());
			escritor.write("\n");
			escritor.write("NivelImportancia:" + PedidoDeArchivo.getNivelImportancia());
			escritor.write("\n");
			escritor.write("Descripcion:" + PedidoDeArchivo.getDescripcion());
			escritor.write("\n");
			//modificando valores
			PedidoDeArchivo.setIdCliente("12232");
			PedidoDeArchivo.setFecha("11");
			PedidoDeArchivo.setHora("14");
			PedidoDeArchivo.setNivelImportancia("normal");
			PedidoDeArchivo.setDescripcion("Hamburguesas");

			// Escribir el contenido en el archivo
			escritor.write("idCliente:" + PedidoDeArchivo.getIdCliente());
			escritor.write("\n");
			escritor.write("FechaRecepcion:" + PedidoDeArchivo.getFecha());
			escritor.write("\n");
			escritor.write("HoraRecepcion:" + PedidoDeArchivo.getHora());
			escritor.write("\n");
			escritor.write("NivelImportancia:" + PedidoDeArchivo.getNivelImportancia());
			escritor.write("\n");
			escritor.write("Descripcion:" + PedidoDeArchivo.getDescripcion());
			escritor.write("\n");

			//modificando valores
			PedidoDeArchivo.setIdCliente("12232");
			PedidoDeArchivo.setFecha("11");
			PedidoDeArchivo.setHora("14");
			PedidoDeArchivo.setNivelImportancia("promo");
			PedidoDeArchivo.setDescripcion("Hamburguesas");

			// Escribir el contenido en el archivo
			escritor.write("idCliente:" + PedidoDeArchivo.getIdCliente());
			escritor.write("\n");
			escritor.write("FechaRecepcion:" + PedidoDeArchivo.getFecha());
			escritor.write("\n");
			escritor.write("HoraRecepcion:" + PedidoDeArchivo.getHora());
			escritor.write("\n");
			escritor.write("NivelImportancia:" + PedidoDeArchivo.getNivelImportancia());
			escritor.write("\n");
			escritor.write("Descripcion:" + PedidoDeArchivo.getDescripcion());
			escritor.write("\n");
			escritor.write("\n");


			// Cerrar el objeto FileWriter
			escritor.close();

			System.out.println("El archivo se ha creado y se ha escrito el contenido.");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al crear el archivo.");
			e.printStackTrace();
		}

		// Definir la ruta y el nombre del archivo de texto
	//Leer el archivo

		try {
			// Crear un objeto File para el archivo de texto
			File archivo = new File(rutaArchivo);

			// Crear un objeto FileReader para leer el contenido del archivo
			FileReader lector = new FileReader(archivo);

			// Crear un objeto BufferedReader para leer el contenido del archivo línea por línea
			BufferedReader buffer = new BufferedReader(lector);

			// Leer el contenido del archivo línea por línea
			String linea;
			while ((linea = buffer.readLine()) != null) {
				String[] datosPedido = linea.split(" ");
				listaArchivo.add(datosPedido);
			}
			System.out.println(listaArchivo.toString());

			buffer.close();
			lector.close();

			//Indico las variables del pedido y añado a la cola de prioridad
			Iterator<Node> iterator = listaArchivo.iterator();
			String pedidos = (String) iterator.next().getObject();
			while (iterator.hasNext()) {
				//pedidos = (String) iterator.next().getObject();
				String cliente = pedidos.toString();

				pedidos = (String) iterator.next().getObject();
				String fechaRecepcion = pedidos.toString();

				pedidos = (String) iterator.next().getObject();
				String horaRecepcion =pedidos.toString();

				pedidos = (String) iterator.next().getObject();
				String nivelImportancia = pedidos.toString();
				System.out.println(nivelImportancia);

				pedidos = (String) iterator.next().getObject();
				String descipcion = pedidos.toString();

				pedidos = (String) iterator.next().getObject();// para el siguiente ciclo

				Pedido pedido = new Pedido(cliente, fechaRecepcion, horaRecepcion, nivelImportancia, descipcion);
				prioridadPedidos.insert(pedido.getIdCliente()+" "+ pedido.getFecha()+" "+ pedido.getHora()+" "+  pedido.getNivelImportancia()+" "+ pedido.getDescripcion(),nivelPrioridad(nivelImportancia));
				System.out.println(nivelPrioridad(nivelImportancia));
			}

			//System.out.println("Ha ocurrido un error al leer el archivo.");
			//listaArchivo.print();
			System.out.println(prioridadPedidos.toString());


		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer el archivo.");
			e.printStackTrace();
		}

		//Generar el archivo de salida
		try {
			// Definir la ruta y el nombre del archivo de texto
			String rutaArchivoGenerado = "src/Ej6_Tienda/archivoPrioridad.txt";
			// Crear un objeto File para el archivo de texto
			File archivo = new File(rutaArchivoGenerado);

			// Crear un objeto FileWriter para escribir en el archivo
			FileWriter escritor = new FileWriter(archivo);
			String lista = " ";
			for (int i = 0; i <prioridadPedidos.size() ; i++) {
				lista+=prioridadPedidos.extract().toString();
				lista+= "\n";
			}
			escritor.write(lista);
			escritor.write("Holaaa");


			// Cerrar el objeto FileWriter
			escritor.close();

			System.out.println("El archivo se ha creado y se ha escrito el contenido.");

		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al crear el archivo.");
			e.printStackTrace();
		}
	}


		public static int nivelPrioridad(String nivelImportancia) {
		int nivelPrioridad = 0;
		if(nivelImportancia.equals("NivelImportancia:premium")) {
			nivelPrioridad=0;
		}
		if(nivelImportancia.equals("NivelImportancia:normal")) {
			nivelPrioridad=1;
		}
		if(nivelImportancia.equals("NivelImportancia:promo")) {
			nivelPrioridad=2;
		}
		return nivelPrioridad;
	}


	/*
	//Revisar-No funciona
	public static void crearArchivo(String nombreArchivo, Pedido pedido) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            pw.println("idCliente: " + pedido.getIdCliente());
            pw.println("FechaHoraRecepcion: " + pedido.getFechaHoraRecepcion());
            pw.println("nivelImportancia: " + pedido.getNivelImportancia());
            pw.println("Descripcion: " + pedido.getDescripcion());
            
            pedido.setIdCliente("12232");
            pedido.setFechaHoraRecepcion(LocalDateTime.now());
            pedido.setNivelImportancia("normal");
            pedido.setDescripcion("Hamburguesas");
            
            pw.println("idCliente: " + pedido.getIdCliente());
            pw.println("FechaHoraRecepcion: " + pedido.getFechaHoraRecepcion());
            pw.println("nivelImportancia: " + pedido.getNivelImportancia());
            pw.println("Descripcion: " + pedido.getDescripcion());
            
                   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
	
}  

	
	/*
	 *    // Leer los datos de los pedidos desde un archivo de texto
	        try (FileInputStream fis = new FileInputStream("src/Ej6_Tienda/archivoPedido.txt");
	                InputStreamReader isr = new InputStreamReader(fis);
	                BufferedReader br = new BufferedReader(isr)) {
	               String linea;
	               while ((linea = br.readLine()) != null) {
	                   String[] datosPedido = linea.split(",");
	                   LocalDateTime fechaHoraRecepcion = LocalDateTime.parse(datosPedido[0]);
	                   String idCliente = datosPedido[1];
	                   String nivelImportancia = datosPedido[2];
	                   String descripcion = datosPedido[3];
	                   Pedido pedidoCliente=new Pedido(idCliente, fechaHoraRecepcion,nivelImportancia,descripcion);
	                   //se añade a la cola de prioridad el pedido del cliente(objeto) y el nivel de prioridad retornado por el metodo
	                   prioridadPedidos.insert(pedidoCliente, nivelPrioridad(nivelImportancia)); 
	                   System.out.println(prioridadPedidos.toString());
	               }
	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	 * 
	 * 
	        try {
	        	// Definir la ruta y el nombre del archivo de texto
	            String rutaArchivo = "src/Ej6_Tienda/archivoPedido.txt";
	            // Crear un objeto File para el archivo de texto
	            File archivo = new File(rutaArchivo);

	            // Crear un objeto FileWriter para escribir en el archivo
	            FileWriter escritor = new FileWriter(archivo);

	            // Escribir el contenido en el archivo
	            escritor.write("idCliente: " + PedidoDeArchivo.getIdCliente());
	            escritor.write("FechaHoraRecepcion: " + PedidoDeArchivo.getFechaHoraRecepcion());
	            escritor.write("NivelImportancia: " + PedidoDeArchivo.getNivelImportancia());
	            escritor.write("Descripcion: " + PedidoDeArchivo.getDescripcion());

	            // Cerrar el objeto FileWriter
	            escritor.close();

	            System.out.println("El archivo se ha creado y se ha escrito el contenido.");
	        } catch (IOException e) {
	            System.out.println("Ha ocurrido un error al crear el archivo.");
	            e.printStackTrace();
	        }
	 * 
	 * 
	 * 
	 * 
	 //Generar el archivo XML
	   public void generarArchivoXML(String nombreArchivo) {
	      try {
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

	         //Se crea un nuevo documento XML
	         Document newXML = dBuilder.newDocument();

	         //Crea el elemento raíz
	         Element rootElement = newXML.createElement("Archivo Resultado");
	         newXML.appendChild(rootElement);

	         //Crea los elementos correspondientes a la información del tiquete
	         //DATOS PASAJERO -------------------------------------------------------
	         Element nombre = newXML.createElement("Tipo CLiente");
	         nombre.appendChild(newXML.createTextNode(tipoCliente));
	         rootElement.appendChild(nombre);

	         Element apellido = newXML.createElement("Id");
	         apellido.appendChild(newXML.createTextNode(Id));
	         rootElement.appendChild(apellido);

	         Element direccion = newXML.createElement("Fecha");
	         direccion.appendChild(newXML.createTextNode(Fecha));
	         rootElement.appendChild(direccion);

	         Element identificacion = newXML.createElement("Hora");
	         identificacion.appendChild(newXML.createTextNode(Hora));
	         rootElement.appendChild(identificacion);


	         

	         // Transforma el documento en un archivo XML y lo escribe en el disco
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(newXML);
	         StreamResult result = new StreamResult(new File(nombreArchivo));
	         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	         transformer.transform(source, result);

	         System.out.println("Archivo XML generado correctamente.");

	      }
	      catch (ParserConfigurationException pce) {
	         pce.printStackTrace();
	      }
	      catch (TransformerConfigurationException tce) {
	         tce.printStackTrace();
	      }
	      catch (TransformerException te) {
	         te.printStackTrace();
	      }
	   }
	 */
	
	   
	   /*
	    * try {
		            File inputFile = new File("ArchivoPedidos.xml");

		            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		            Document doc = dBuilder.parse(inputFile);

		            doc.getDocumentElement().normalize();

		            NodeList nodeList = doc.getElementsByTagName("TipoCliente");

		            for (int i = 0; i < nodeList.getLength(); i++) {
		                Element element = (Element) nodeList.item(i);
		                
		                String tipoCliente=element.getElementsByTagName("Id").item(0).getTextContent();
		                String Id = element.getElementsByTagName("Id").item(0).getTextContent();
		                String Fecha = element.getElementsByTagName("Fecha").item(0).getTextContent();
		                String Hora = element.getElementsByTagName("Hora").item(0).getTextContent();
		                
		                System.out.println("Tipo de cliente: " + tipoCliente);
		                System.out.println("Id: " + Id);
		                System.out.println("Fecha: " + Fecha);
		                System.out.println("Hora: " + Hora);
		                System.out.println();
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	    */


