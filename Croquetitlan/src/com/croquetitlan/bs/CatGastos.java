package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.util.List;

public class CatGastos  implements Serializable{
	protected int idGasto;
	protected String gasto;
	public int getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}
	public String getGasto() {
		return gasto;
	}
	public void setGasto(String gasto) {
		this.gasto = gasto;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("{ idGasto:");
		sb.append(this.idGasto);
		sb.append(", gasto;");
		sb.append(this.gasto);
		sb.append("}");
		
		return sb.toString();
	}
}
