package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Transacciones extends Producto implements Serializable{
	protected int idTransaccion;
	protected float totalCompra;
	protected LocalDateTime fechaHora;
	protected int idcliente;
	public Transacciones() {
		
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public float getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
}
