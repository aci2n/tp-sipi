package implementacion;

import java.sql.Date;
import java.util.Collection;



public class Diente {
	private String posicion;
	private String idProtesis;
	private String idPuente;
	private String estado;
	private Collection<Cara> caras;
	
	public boolean sosElDiente(String posicion) {
		return this.posicion==posicion;
	}
	
	public void modificarEstadoCara(String posicionCara, String estadoCara) {
		
	}
	
	public Cara buscarCara(String posicionCara) {
		return null;
	}
	
	public void setPuenteNuevo() {
		
	}
	
	public Collection<String> getSintomas() {
		return null;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getIdProtesis() {
		return idProtesis;
	}

	public void setIdProtesis(String idProtesis) {
		this.idProtesis = idProtesis;
	}

	public String getIdPuente() {
		return idPuente;
	}

	public void setIdPuente(String idPuente) {
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
	
	public Observacion generarObservacion(Odontograma odontograma) {
		Observacion observacion = new Observacion();
		observacion.setFecha(odontograma.getFecha());
		observacion.setDescripcion(estado);
		observacion.setOdontologo(odontograma.getOdontologo());
		return observacion;
	}
}
