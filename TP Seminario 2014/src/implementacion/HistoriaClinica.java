package implementacion;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import persistencia.AdministradorPersistenciaFichaPeriodontal;
import persistencia.AdministradorPersistenciaHistoriasClinicas;
import persistencia.AdministradorPersistenciaOdontograma;
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
		this.odontogramas = new ArrayList<Odontograma>();
	}

	public void asignarFichaPeriodontal(Odontologo odontologo, Collection<Seccion> secciones) {
		FichaPeriodontal ficha = new FichaPeriodontal(odontologo, this, secciones);
		this.ficha=ficha;	
	}
	
	public void agregarOdontograma(String idOdontograma, Timestamp fecha, Odontologo odontologo) {
		Odontograma odontograma = new Odontograma(idOdontograma, fecha, odontologo, this);				
		this.odontogramas.add(odontograma);
	}
	
	public void agregarObservacion(Odontologo odontologo, Timestamp fecha, String descripcion) {
		Observacion observacion = new Observacion(odontologo, fecha, descripcion, this);
		this.observaciones.add(observacion);
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
		observaciones.addAll(ficha.generarObservaciones());
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
		observaciones.addAll(ficha.generarObservaciones());
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

	public void actualizarOdontograma(String idOdontograma, Timestamp fecha, Odontologo odontologo, Collection<Diente> dientes) {
		Odontograma odontograma = obtenerOdontograma(idOdontograma);
		if (odontograma != null){
			odontograma.setDientes(dientes);
			odontograma.setOdontologo(odontologo);
			odontograma.setFecha(fecha);
			AdministradorPersistenciaOdontograma.getInstancia().update(odontograma);
		}		
	}

	private Odontograma obtenerOdontograma(String idOdontograma) {
		for (Odontograma o : odontogramas)
			if (o.sosElOdontograma(idOdontograma))
				return o;
		return null;
	}

	public void actualizarFichaPeriodontal(Odontologo odontologo, Collection<Seccion> secciones) {
		if (this.ficha!=null){
			ficha.setOdontologo(odontologo);
			ficha.setSecciones(secciones);
			AdministradorPersistenciaFichaPeriodontal.getInstancia().update(ficha,this);
		}
	}
	
	public Observacion obtenerObservacion(Odontologo odontologo, Timestamp fecha) {
		for (Observacion observacion : observaciones) {
			if (observacion.getOdontologo().equals(odontologo) && observacion.getFecha().equals(fecha)) {
				return observacion;
			}
		}
		return null;
	}
}
