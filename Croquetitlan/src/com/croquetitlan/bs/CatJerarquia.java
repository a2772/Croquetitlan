package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.util.List;

public class CatJerarquia  implements Serializable{
	protected int idJerarquia;
	protected String jerarquia;
	public int getIdJerarquia() {
		return idJerarquia;
	}
	public void setIdJerarquia(int idJerarquia) {
		this.idJerarquia = idJerarquia;
	}
	public String getJerarquia() {
		return jerarquia;
	}
	public void setJerarquia(String jerarquia) {
		this.jerarquia = jerarquia;
	}
	
}
