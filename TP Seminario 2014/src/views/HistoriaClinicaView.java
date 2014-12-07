package views;

import java.util.Collection;
import java.util.Date;



public class HistoriaClinicaView {
	private PacienteView paciente;
	private FichaPeriodontalView ficha;
	private Collection<OdontogramaView> odontogramas;
	private Collection<ObservacionView> observaciones;
	private String descripcion;

	public void altaFichaPeriodontal() {
	
	}
	
	public void altaOdontograma(Date fecha) {
	
	}
	
	public void altaObservacion(OdontologoView odontologo, Date fecha, String descripcion) {
	
	}
	
	public void bajaOdontograma(Date fecha) {
	
	}
	
	public void bajaObservacion(OdontologoView odontologo, Date fecha) {
	
	}
	
	public void modificarSeccionFicha(String seccion, String sDiente, boolean sangrado, boolean placa, int margen) {
	
	}
	
	public OdontogramaView obtenerUltimoOdontograma() {
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
	
	public FichaPeriodontalView getFicha() {
		return ficha;
	}

	public void setFicha(FichaPeriodontalView ficha) {
		this.ficha = ficha;
	}

	public Collection<OdontogramaView> getOdontogramas() {
		return odontogramas;
	}

	public void setOdontogramas(Collection<OdontogramaView> odontogramas) {
		this.odontogramas = odontogramas;
	}

	public Collection<ObservacionView> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(Collection<ObservacionView> observaciones) {
		this.observaciones = observaciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PacienteView getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteView paciente) {
		this.paciente = paciente;
	}
	
	
}
