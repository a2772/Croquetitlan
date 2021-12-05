package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.util.List;

public class CatProducto  implements Serializable{
	protected int idProducto;
	protected String nombre;
	protected String descripcion;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
