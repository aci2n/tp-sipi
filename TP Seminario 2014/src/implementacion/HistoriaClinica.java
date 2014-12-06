package implementacion;

import java.util.Collection;
import java.util.Date;



public class HistoriaClinica {
	private Paciente paciente;
	private FichaPeriodontal ficha;
	private Collection<Odontograma> odontogramas;
	private Collection<Observacion> observaciones;
	private String descripcion;
	
	public HistoriaClinica(String dni) {
	
	}
	
	public HistoriaClinica() {
	}

	public void altaFichaPeriodontal() {
	
	}
	
	public void altaOdontograma(Date fecha) {
	
	}
	
	public void altaObservacion(Odontologo odontologo, Date fecha, String descripcion) {
	
	}
	
	public void bajaOdontograma(Date fecha) {
	
	}
	
	public void bajaObservacion(Odontologo odontologo, Date fecha) {
	
	}
	
	public void modificarSeccionFicha(String seccion, String sDiente, boolean sangrado, boolean placa, int margen) {
	
	}
	
	public Odontograma obtenerUltimoOdontograma() {
		return null;
	}
	
	public void modificarOdontogramaEstadoDiente(int idDiente, String estado) {
	
	}
	
	public void modificarOdontogramaProtesis(int idDiente) {
	
	}
	
	public void modificarOdontogramaEstadoCara(int idDiente, int idCara, String estadoCara) {
	
	}
	
	public void modificarOdontogramaPuenteDientes(int[] idDientes) {
	
	}
	
	public Collection<String> obtenerSintomasHistoria() {
		return null;
	}
	
	public Collection<String> obtenerSintomasObservaciones() {
		return null;
	}
	
	public Collection<String> obtenerSintomasOdontogramas() {
		return null;
	}
	
	public Collection<String> unirSintomas(Collection<String> sintomasObservacion, Collection<String> sintomasOdontograma) {
		return null;
	}
	
	public FichaPeriodontal getFicha() {
		return ficha;
	}

	public void setFicha(FichaPeriodontal ficha) {
		this.ficha = ficha;
	}

	public Collection<Odontograma> getOdontogramas() {
		return odontogramas;
	}

	public void setOdontogramas(Collection<Odontograma> odontogramas) {
		this.odontogramas = odontogramas;
	}

	public Collection<Observacion> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(Collection<Observacion> observaciones) {
		this.observaciones = observaciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}
