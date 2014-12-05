package implementacion;

import java.util.Collection;



public class Diente {
	private int posicion;
	private int idProtesis;
	private int idPuente;
	private String estado;
	private Collection<Cara> caras;
	
	public boolean sosElDiente(int posicion) {
		return this.posicion==posicion;
	}
	
	public void modificarEstadoCara(int posicionCara, String estadoCara) {
		
	}
	
	public Cara buscarCara(int posicionCara) {
		return null;
	}
	
	public void setPuenteNuevo() {
		
	}
	
	public Collection<String> getSintomas() {
		return null;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getIdProtesis() {
		return idProtesis;
	}

	public void setIdProtesis(int idProtesis) {
		this.idProtesis = idProtesis;
	}

	public int getIdPuente() {
		return idPuente;
	}

	public void setIdPuente(int idPuente) {
		this.idPuente = idPuente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Collection<Cara> getCaras() {
		return caras;
	}

	public void setCaras(Collection<Cara> caras) {
		this.caras = caras;
	}
}
