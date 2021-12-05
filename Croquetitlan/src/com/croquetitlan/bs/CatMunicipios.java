package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.util.List;

public class CatMunicipios extends CatEstados implements Serializable{
	protected int idMunicipio;
	protected String Municipio;
	public int getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getMunicipio() {
		return Municipio;
	}
	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}
}
