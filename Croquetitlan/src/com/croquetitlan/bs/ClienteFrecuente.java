package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ClienteFrecuente extends Datos implements Serializable{
	protected int idCliente;
	protected int idEstatus;
	protected float saldo;
	protected CatEstatus catEstatus;
	
	public ClienteFrecuente	() {
		catEstatus= new CatEstatus();
	}
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public CatEstatus getCatEstatus() {
		return catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public int getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
}
