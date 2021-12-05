package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Gramaje extends CatGramaje implements Serializable{
	int idGram;
	int idGramaje;
	LocalDate fechaCaducidad;
	float cantidad;
	public int getIdGram() {
		return idGram;
	}
	public void setIdGram(int idGram) {
		this.idGram = idGram;
	}
	public int getIdGramaje() {
		return idGramaje;
	}
	public void setIdGramaje(int idGramaje) {
		this.idGramaje = idGramaje;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
}
