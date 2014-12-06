package views;

import java.util.Collection;
import java.sql.Date;



public class OdontogramaView {
	private String idOdontograma;
	private Collection<DienteView> dientes;
	private Date fecha;
	private OdontologoView odontologo;
	
	public OdontogramaView(Date fecha) {
	
	}
	
	public OdontogramaView() {
	}

	public void altaProtesisDiente(int posicionDiente) {
	
	}
	
	public void modificarEstadoDiente(int posicionDiente, String estado) {
	
	}
	
	public DienteView obtenerDiente(int posicionDiente) {
		return null;
	}
	
	public void modificarEstadoCaraDiente(int posicionDiente, int posicionCara, String estadoCara) {
	
	}
	
	public void modificarPuenteDientes(int[] posicionesDientes) {
	
	}
	
	public int buscarPuenteDientes(int[] idDientes) {
		return 0;
	}
	
	public Collection<String> getSintomas() {
		return null;
	}

	public Collection<DienteView> getDientes() {
		return dientes;
	}

	public void setDientes(Collection<DienteView> dientes) {
		this.dientes = dientes;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public OdontologoView getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(OdontologoView odontologo) {
		this.odontologo = odontologo;
	}

	public String getIdOdontograma() {
		return idOdontograma;
	}

	public void setIdOdontograma(String idOdontograma) {
		this.idOdontograma = idOdontograma;
	}
}