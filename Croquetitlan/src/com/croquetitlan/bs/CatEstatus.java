package src.com.croquetitlan.bs;

import java.io.Serializable;

public class CatEstatus implements Serializable{
	protected int idStatus;
	protected String estatus;
	protected float porcentaje;
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	
	public int getIdStatus() {
		return idStatus;
	}

	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("{ idStatus:");
		sb.append(this.idStatus);
		sb.append(", estatus;");
		sb.append(this.estatus);
		sb.append(", porcentaje;");
		sb.append(this.porcentaje);
		sb.append("}");
		
		return sb.toString();
	}
}
