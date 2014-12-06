package views;

import java.sql.Date;



public class TurnoView {
	private PacienteView paciente;
	private OdontologoView odontologo;
	private String descripcion;
	private Date fecha;
	
	public PacienteView getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteView paciente) {
		this.paciente = paciente;
	}
	public OdontologoView getOdontologo() {
		return odontologo;
	}
	public void setOdontologo(OdontologoView odontologo) {
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
}