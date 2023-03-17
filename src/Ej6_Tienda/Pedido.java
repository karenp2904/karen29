package Ej6_Tienda;

import java.time.LocalDateTime;

public class Pedido {
	
	private String fecha;
	private String hora;
    private String idCliente;
    private String nivelImportancia;
    private String descripcion;
    
	public Pedido( String idCliente,String fecha, String hora, String nivelImportancia, String descripcion) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.idCliente = idCliente;
		this.nivelImportancia = nivelImportancia;
		this.descripcion = descripcion;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNivelImportancia() {
		return nivelImportancia;
	}

	public void setNivelImportancia(String nivelImportancia) {
		this.nivelImportancia = nivelImportancia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	

	
	
    
    

}
