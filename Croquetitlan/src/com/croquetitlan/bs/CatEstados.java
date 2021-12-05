package src.com.croquetitlan.bs;

import java.io.Serializable;

public class CatEstados implements Serializable {
	protected int idEstado;
	protected String estado;
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("{ idEstado:");
		sb.append(this.idEstado);
		sb.append(", estado;");
		sb.append(this.estado);
		sb.append("}");
		
		return sb.toString();
	}
}
