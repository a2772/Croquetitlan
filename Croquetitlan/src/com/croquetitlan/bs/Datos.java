package src.com.croquetitlan.bs;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Datos extends CatMunicipios implements Serializable{
	int idDatos;
	String telefono;
	String email;
	String nombre;
	String apPat;
	String apMat;
	LocalDate fechaNac;
	String cp;
	int idMunicipio;
	String calle;
	String numero;
	String numInterior;
	public int getIdDatos() {
		return idDatos;
	}
	public void setIdDatos(int idDatos) {
		this.idDatos = idDatos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApPat() {
		return apPat;
	}
	public void setApPat(String apPat) {
		this.apPat = apPat;
	}
	public String getApMat() {
		return apMat;
	}
	public void setApMat(String apMat) {
		this.apMat = apMat;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public int getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumInterior() {
		return numInterior;
	}
	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}
	
}
