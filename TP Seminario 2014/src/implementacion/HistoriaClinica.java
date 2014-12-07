package implementacion;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import persistencia.AdministradorPersistenciaHistoriasClinicas;
import views.HistoriaClinicaView;
import views.ObservacionView;
import views.OdontogramaView;



public class HistoriaClinica {
	private Paciente paciente;
	private FichaPeriodontal ficha;
	private Collection<Odontograma> odontogramas;
	private Collection<Observacion> observaciones;
	private String descripcion;
	
	public HistoriaClinica(Paciente paciente, String descripcion) {
		this.paciente = paciente;
		this.descripcion = descripcion;
		this.odontogramas = new ArrayList<Odontograma>();
		this.observaciones = new ArrayList<Observacion>();
		AdministradorPersistenciaHistoriasClinicas.getInstancia().insert(this);
	}
	
	public HistoriaClinica() {		
	}

	public void altaFichaPeriodontal() {
	
	}
	
	public void altaOdontograma(Date fecha) {
	
	}
	
	public void altaObservacion(Odontologo odontologo, Date fecha, String descripcion) {
		this.observaciones.add(new Observacion(odontologo, fecha, descripcion, this));
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
	
	public boolean sosLaHistoria(String dni) {
		return paciente.sosElPaciente(dni);
	}

	public Collection<String> detectarSintomas(Collection<String> sintomas){
		Collection<String> sintomasDetectados = new ArrayList<String>();
		Collection<Observacion> observaciones = new ArrayList<Observacion>();
		observaciones.addAll(this.observaciones);
		observaciones.addAll(generarObservacionesOdontogramas());
		for (Observacion o : observaciones)
			for (String sintoma : sintomas)
				if (o.tenesElSintoma(sintoma) && !sintomasDetectados.contains(sintoma))
					sintomasDetectados.add(sintoma);
		return sintomasDetectados;
	}
	
	public boolean tenesElSintoma(String sintoma){
		Collection<Observacion> observaciones = new ArrayList<Observacion>();
		observaciones.addAll(this.observaciones);
		observaciones.addAll(generarObservacionesOdontogramas());
		for (Observacion o : observaciones)
			if (o.tenesElSintoma(sintoma))
				return true;
		return false;
	}
	
	public Collection<Observacion> generarObservacionesOdontogramas() {
		Collection<Observacion> observaciones = new ArrayList<Observacion>();
		for (Odontograma odontograma : odontogramas) {
			observaciones.addAll(odontograma.generarObservaciones());
		}
		return observaciones;
	}
	
	public HistoriaClinicaView generarView() {
		HistoriaClinicaView view = new HistoriaClinicaView();
		Collection<OdontogramaView> odontogramasView = new ArrayList<OdontogramaView>();
		for (Odontograma odontograma : odontogramas) {
			odontogramasView.add(odontograma.generarView());
		}
		view.setOdontogramas(odontogramasView);
		Collection<ObservacionView> observacionesView = new ArrayList<ObservacionView>();
		for (Observacion observacion : observaciones) {
			observacionesView.add(observacion.generarView());
		}
		view.setObservaciones(observacionesView);
		view.setDescripcion(descripcion);
		view.setFicha(ficha.generarView());
		view.setPaciente(paciente.generarView());
		return view;
	}
}
