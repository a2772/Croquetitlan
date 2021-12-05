package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.util.List;

public class CatGramaje extends CatProducto  implements Serializable{
	protected int idGramaje;
	protected float precioKg;
	protected float gramajeMin;
	public int getIdGramaje() {
		return idGramaje;
	}
	public void setIdGramaje(int idGramaje) {
		this.idGramaje = idGramaje;
	}
	public float getPrecioKg() {
		return precioKg;
	}
	public void setPrecioKg(float precioKg) {
		this.precioKg = precioKg;
	}
	public float getGramajeMin() {
		return gramajeMin;
	}
	public void setGramajeMin(float gramajeMin) {
		this.gramajeMin = gramajeMin;
	}
	
}
