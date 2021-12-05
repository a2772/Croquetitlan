package src.com.croquetitlan.bs;
import java.io.Serializable;
import java.time.LocalDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Trabajadores extends Datos implements Serializable{
	int idTrabajador;
	int idDatos;
	int idJerarquia;
	String rfc;
	String curp;
	int horas;
	float sueldoHora;
	CatJerarquia catJerarquia;
	public Trabajadores() {
		catJerarquia = new CatJerarquia();
	}
	public CatJerarquia getCatJerarquia() {
		return catJerarquia;
	}
	public void setCatJerarquia(CatJerarquia catJerarquia) {
		this.catJerarquia = catJerarquia;
	}
	public Trabajadores(String email,String presuntoPass) {
		//Lo de persona
		this.email = email;
		this.nombre = presuntoPass;
	}
	public int getIdDatos() {
		return idDatos;
	}
	public void setIdDatos(int idDatos) {
		this.idDatos = idDatos;
	}
	public int getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public int getIdJerarquia() {
		return idJerarquia;
	}
	public void setIdJerarquia(int idJerarquia) {
		this.idJerarquia = idJerarquia;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public float getSueldoHora() {
		return sueldoHora;
	}
	public void setSueldoHora(float sueldoHora) {
		this.sueldoHora = sueldoHora;
	}
}
