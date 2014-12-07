package implementacion;

import java.sql.Date;

import persistencia.AdministradorPersistenciaTurnos;
import views.TurnoView;



public class Turno {
	private Paciente paciente;
	private Odontologo odontologo;
	private String descripcion;
	private Date fecha;
	
	public Turno() {
	}
	
	public Turno(Paciente paciente, Odontologo odontologo, String descripcion, Date fecha) {
		this.paciente = paciente;
		this.odontologo = odontologo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		AdministradorPersistenciaTurnos.getInstancia().insert(this);
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Odontologo getOdontologo() {
		return odontologo;
	}
	
	public void setOdontologo(Odontologo odontologo) {
		this.odontologo = odontologo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean sosElTurno(String dni, String matricula, Date fecha) {
		return this.fecha.compareTo(fecha) == 0 && paciente.sosElPaciente(dni) && odontologo.sosElOdontologo(matricula);
	}
	
	public TurnoView generarView() {
		TurnoView view = new TurnoView();
		view.setDescripcion(descripcion);
		view.setFecha(fecha);
		view.setOdontologo(odontologo.generarView());
		view.setPaciente(paciente.generarView());
		return view;
	}
}