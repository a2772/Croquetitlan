package src.com.croquetitlan.bs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class VProductoGra extends Transacciones implements Serializable{
	protected int idvproductgra;
	protected float gramoscom;//Gramos comprados
	protected float idgram;
	protected int idtransaccion2;
	protected Gramaje gramaje;
	public Gramaje getGramaje() {
		return gramaje;
	}
	public void setGramaje(Gramaje gramaje) {
		this.gramaje = gramaje;
	}
	public VProductoGra() {
		gramaje = new Gramaje();
	}
	public int getIdvproductgra() {
		return idvproductgra;
	}
	public void setIdvproductgra(int idvproductgra) {
		this.idvproductgra = idvproductgra;
	}
	public float getGramoscom() {
		return gramoscom;
	}
	public void setGramoscom(float gramoscom) {
		this.gramoscom = gramoscom;
	}
	public float getIdGram() {
		return idgram;
	}
	public void setIdGram(float idgram) {
		this.idgram = idgram;
	}
	public int getIdtransaccion2() {
		return idtransaccion2;
	}
	public void setIdtransaccion2(int idtransaccion2) {
		this.idtransaccion2 = idtransaccion2;
	}
}
