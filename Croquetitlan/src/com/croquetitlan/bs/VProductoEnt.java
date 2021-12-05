package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class VProductoEnt extends Transacciones implements Serializable{
	protected int idvproductoent;
	protected int cantidad;
	protected int idprod;
	protected int idtransaccion;
	public int getIdvproductoent() {
		return idvproductoent;
	}
	public void setIdvproductoent(int idvproductoent) {
		this.idvproductoent = idvproductoent;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdprod() {
		return idprod;
	}
	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}
	public int getIdtransaccion() {
		return idtransaccion;
	}
	public void setIdtransaccion(int idtransaccion) {
		this.idtransaccion = idtransaccion;
	}
}
