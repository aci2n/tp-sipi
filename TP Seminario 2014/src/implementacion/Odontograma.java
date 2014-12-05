package implementacion;

import java.util.Collection;
import java.util.Date;



public class Odontograma {
	private Collection<Diente> dientes;
	private Date fecha;
	private Odontologo odontologo;
	
	public Odontograma(Date fecha) {
	
	}
	
	public void altaProtesisDiente(int posicionDiente) {
	
	}
	
	public void modificarEstadoDiente(int posicionDiente, String estado) {
	
	}
	
	public Diente obtenerDiente(int posicionDiente) {
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

	public Collection<Diente> getDientes() {
		return dientes;
	}

	public void setDientes(Collection<Diente> dientes) {
		this.dientes = dientes;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Odontologo getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(Odontologo odontologo) {
		this.odontologo = odontologo;
	}
}