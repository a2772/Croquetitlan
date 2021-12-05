package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Producto extends CatProducto implements Serializable{
	int idProd;
	int idProducto;
	LocalDate fechaCaducidad;
	int cantidad;
	float precioUnit;
	float pesoCostal;
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecioUnit() {
		return precioUnit;
	}
	public void setPrecioUnit(float precioUnit) {
		this.precioUnit = precioUnit;
	}
	public float getPesoCostal() {
		return pesoCostal;
	}
	public void setPesoCostal(float pesoCostal) {
		this.pesoCostal = pesoCostal;
	}
	
}
