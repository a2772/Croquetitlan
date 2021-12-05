package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Gastos extends CatGastos implements Serializable{
	int idGastMens;
	int idGasto;
	LocalDate fechaPago;
	String pagado;
	public String getPagado() {
		return pagado;
	}
	public void setPagado(String pagado) {
		this.pagado = pagado;
	}
	float total;
	public int getIdGastMens() {
		return idGastMens;
	}
	public void setIdGastMens(int idGastMens) {
		this.idGastMens = idGastMens;
	}
	public int getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
}
