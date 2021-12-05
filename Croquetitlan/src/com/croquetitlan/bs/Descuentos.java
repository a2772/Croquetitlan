package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Descuentos extends CatProducto implements Serializable{
	int idDescuento;
	LocalDate fechaInicio;
	LocalDate fechaFin;
	String soloCliente;
	float porcentaje;
	float precioDesc;
	int cantidadUnit;
	float cantidadGram;
	public int getIdDescuento() {
		return idDescuento;
	}
	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getSoloCliente() {
		return soloCliente;
	}
	public void setSoloCliente(String soloCliente) {
		this.soloCliente = soloCliente;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public float getPrecioDesc() {
		return precioDesc;
	}
	public void setPrecioDesc(float precioDesc) {
		this.precioDesc = precioDesc;
	}
	public int getCantidadUnit() {
		return cantidadUnit;
	}
	public void setCantidadUnit(int cantidadUnit) {
		this.cantidadUnit = cantidadUnit;
	}
	public float getCantidadGram() {
		return cantidadGram;
	}
	public void setCantidadGram(float cantidadGram) {
		this.cantidadGram = cantidadGram;
	}
	
}
